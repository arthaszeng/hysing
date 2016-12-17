package processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

import static processor.fetcher.*;

public class SinaBlogProcessor implements PageProcessor {
    private static int MAX_COLUMN_NUM = 10;
    private static String START_URL_HEAD = "https://github.com/search?p=";
    private static String START_URL_TAIL = "&q=location%3A%22Chengdu%22&ref=searchresults&type=Users&utf8=%E2%9C%93";
    private static String START_PAGE_NUM = "1";
    private static String START_URL = START_URL_HEAD + START_PAGE_NUM + START_URL_TAIL;
    private static String ASSET_LOCATION = "/Users/cwzeng/Documents/WorkSpace/SpiderData";



    public static void main(String[] args) {
        Spider.create(new SinaBlogProcessor()).addUrl(START_URL).addPipeline(new JsonFilePipeline(ASSET_LOCATION))
                .thread(5).run();
    }


    private Site site = Site.me().setSleepTime(100);

    @Override
    public void process(Page page) {
        List<String> targetUrls = page.getHtml().$("#user_search_results > div.paginate-container > div > a.next_page").links().all();
        page.addTargetRequests(targetUrls);

        List<User> userList = new ArrayList<>();

        for (int i = 1; i <= MAX_COLUMN_NUM; i++) {
            User user = new User();
            user.setName(getNameByXpath(page, Integer.toString(i)));
            user.setDescription(getDesByXpath(page, Integer.toString(i)));
            user.setEmail(getEmailByXpath(page, Integer.toString(i)));
            user.setJoinedTime(getJoinedTimeByXpath(page, Integer.toString(i)));
            userList.add(i - 1, user);
        }

        page.putField("page" + getPageNumber(page), userList);
    }


    @Override
    public Site getSite() {
        return site;
    }
}
