package com.hysing.spider;

import com.hysing.model.Candidate;
import com.hysing.processor.GithubProcessor;
import com.hysing.processor.JsonPipeline;
import us.codecraft.webmagic.Spider;

import java.util.HashMap;

public class GithubSpider {

    public static String LANGUAGE = "Java";
    public static HashMap<String, Candidate> candidates = new HashMap<>();
    public static HashMap<String, Candidate> potentialCandidates = new HashMap<>();
    private static String START_URL_HEAD = "https://github.com/search?l=" + LANGUAGE + "&p=";
    private static String START_URL_TAIL = "&q=location%3A%22Chengdu%22&ref=searchresults&type=Users&utf8=%E2%9C%93";
    private static String START_PAGE_NUM = "1";
    private static String START_URL = START_URL_HEAD + START_PAGE_NUM + START_URL_TAIL;
    private static String ASSET_LOCATION = "/Users/cwzeng/Documents/WorkSpace/SpiderData/Json/" + LANGUAGE;


    public void spiderRun() {
        Spider.create(new GithubProcessor()).addUrl(START_URL).clearPipeline().addPipeline(new JsonPipeline(ASSET_LOCATION))
                .thread(5).run();
    }
}
