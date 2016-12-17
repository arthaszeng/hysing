package processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

import static processor.Fetcher.*;

public class GithubProcessor implements PageProcessor {
    private static int MAX_COLUMN_NUM = 10;
    private Site site = Site.me().setSleepTime(8000);

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
