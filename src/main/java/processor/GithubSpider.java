package processor;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;

import java.util.HashMap;

public class GithubSpider {

    static HashMap<String, Candidate> candidates = new HashMap<>();
    static HashMap<String, Candidate> potentialCandidates = new HashMap<>();
    public static String LANGUAGE = "Java";
    private static String START_URL_HEAD = "https://github.com/search?l=" + LANGUAGE + "&p=";
    private static String START_URL_TAIL = "&q=location%3A%22Chengdu%22&ref=searchresults&type=Users&utf8=%E2%9C%93";
    private static String START_PAGE_NUM = "1";
    private static String START_URL = START_URL_HEAD + START_PAGE_NUM + START_URL_TAIL;
    private static String ASSET_LOCATION = "/Users/cwzeng/Documents/WorkSpace/SpiderData/" + LANGUAGE;

    public static void main(String[] args) {
        Spider.create(new GithubProcessor()).addUrl(START_URL).clearPipeline().addPipeline(new FilePipeline(ASSET_LOCATION))
                .thread(5).run();

    }
}
