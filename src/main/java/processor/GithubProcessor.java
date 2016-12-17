package processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import static processor.AttributeFetcher.*;

public class GithubProcessor implements PageProcessor {
    private static int MAX_COLUMN_NUM = 10;
    private Site site = Site.me().setSleepTime(3000);
    private CandidateFilter candidateFilter = new CandidateFilter();

    @Override
    public void process(Page page) {
        if (page.getUrl().regex("https://github\\.com/search?.*").match()) {
            String targetUrl = page.getHtml().$("#user_search_results > div.paginate-container > div > a.next_page").links().get();
            page.addTargetRequest(targetUrl);

            for (int i = 1; i <= MAX_COLUMN_NUM; i++) {
                Candidate candidate = new Candidate();
                candidate.setNickname(getNameByXpath(page, Integer.toString(i)));
                candidate.setDescription(getDesByXpath(page, Integer.toString(i)));
                candidate.setEmail(getEmailByXpath(page, Integer.toString(i)));
                candidate.setJoinedTime(getJoinedTimeByXpath(page, Integer.toString(i)));

                page.addTargetRequest(generateRequest(candidate.getNickname()));
                GithubSpider.candidates.put(candidate.getNickname(), candidate);
            }
        } else {
            String userName = page.getUrl().regex("https://github\\.com/\\w+.*").replace("https://github\\.com/", "").get();
            Candidate candidate = GithubSpider.candidates.get(userName);

            candidate.setName(getName(page));
            candidate.setRepoNumber(getRepoNum(page));
            candidate.setStarNumber(getStarNum(page));
            candidate.setFollowerNumber(getFollowerNumber(page));
            candidate.setContribution(getContribution(page));

            if (candidateFilter.isMrRight(candidate)) {
                page.putField(userName, candidate);
            } else {
                if (GithubSpider.potentialCandidates.put(userName, candidate) != null) {
                    GithubSpider.candidates.remove(userName);
                }
            }
        }
    }



    @Override
    public Site getSite() {
        return site;
    }

}
