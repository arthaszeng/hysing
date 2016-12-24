package com.hysing.processor;

import com.google.gson.Gson;
import com.hysing.spider.GithubSpider;
import com.hysing.exception.CannotCreateAccountException;
import com.hysing.model.Candidate;
import com.hysing.service.CandidateService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static com.hysing.processor.AttributeFetcher.*;
import static com.hysing.processor.CandidateFilter.isInBlanklist;

public class GithubProcessor implements PageProcessor {
    private static int MAX_COLUMN_NUM = 10;
    private Site site = Site.me().setSleepTime(8000);
    private CandidateFilter candidateFilter = new CandidateFilter();
    private CandidateService candidateService;

    public GithubProcessor() {
        candidateService = new CandidateService();
    }

    @Override
    public void process(Page page) {
        if (page.getUrl().regex("https://github\\.com/search?.*").match()) {
            String targetUrl = page.getHtml().$("#user_search_results > div.paginate-container > div > a.next_page").links().get();

            if (targetUrl == null) {
                page.putField("Candidates", GithubSpider.candidates);
                page.putField("Potential Candidates", GithubSpider.potentialCandidates);
                saveSummaryJsonFile();
                System.out.println(+GithubSpider.candidates.size());
            }

            page.addTargetRequest(targetUrl);

            for (int i = 1; i <= MAX_COLUMN_NUM; i++) {
                Candidate candidate = new Candidate();

                setAttributeFromSummarizedSite(candidate, page, Integer.toString(i));

                page.addTargetRequest(generateRequest(candidate.getNickname()));
                GithubSpider.candidates.put(candidate.getNickname(), candidate);
            }

        } else {
            String nickname = page.getUrl().regex("https://github\\.com/\\w+.*").replace("https://github\\.com/", "").get();
            Candidate candidate = GithubSpider.candidates.get(nickname);

            if (isInBlanklist(nickname)) {
                page.setSkip(true);
            } else {
                setAttributeFromDetailedSite(candidate, page);
            }

            if (candidateFilter.isMrRight(candidate)) {
                try {
                    candidateService.create(candidate);
                } catch (CannotCreateAccountException e) {
                    e.printStackTrace();
                }
                page.putField(nickname, candidate);
            } else {
                GithubSpider.potentialCandidates.put(nickname, candidate);
                GithubSpider.candidates.remove(nickname);
                System.out.println("Oh Oh, " + nickname + " died");
            }
        }
    }

    private void setAttributeFromSummarizedSite(Candidate candidate, Page page, String columnId) {
        candidate.setNickname(getNameByXpath(page, columnId));
        candidate.setDescription(getDesByXpath(page, columnId));
        candidate.setEmail(getEmailByXpath(page, columnId));
        candidate.setJoinedTime(getJoinedTimeByXpath(page, columnId));
    }

    private void setAttributeFromDetailedSite(Candidate candidate, Page page) {
        candidate.setName(getName(page));
        candidate.setRepoNumber(getRepoNum(page));
        candidate.setStarNumber(getStarNum(page));
        candidate.setFollowerNumber(getFollowerNumber(page));
        candidate.setContribution(getContribution(page));
        candidate.setBlog(getBlogByCss(page));
    }

    private void saveSummaryJsonFile() {
        Gson gson = new Gson();
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File("/Users/cwzeng/Documents/WorkSpace/SpiderData/Json/" + GithubSpider.LANGUAGE + "super.json")));
            printWriter.write(gson.toJson(GithubSpider.candidates));
            printWriter.close();
        } catch (IOException e) {
            System.out.println("write file error");
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

}
