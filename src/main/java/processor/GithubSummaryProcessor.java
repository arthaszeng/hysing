package processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;
import java.util.List;

import static processor.Fetcher.*;
import static processor.GithubSpider.users;

public class GithubSummaryProcessor implements PageProcessor {
    private static int MAX_COLUMN_NUM = 10;
    private Site site = Site.me().setSleepTime(3000);

    @Override
    public void process(Page page) {
        if (page.getUrl().regex("https://github\\.com/search?.*").match()) {
            String targetUrl = page.getHtml().$("#user_search_results > div.paginate-container > div > a.next_page").links().get();
            page.addTargetRequest(targetUrl);

            for (int i = 1; i <= MAX_COLUMN_NUM; i++) {
                User user = new User();
                user.setName(getNameByXpath(page, Integer.toString(i)));
                user.setDescription(getDesByXpath(page, Integer.toString(i)));
                user.setEmail(getEmailByXpath(page, Integer.toString(i)));
                user.setJoinedTime(getJoinedTimeByXpath(page, Integer.toString(i)));

                page.addTargetRequest(generateRequest(user.getName()));
                users.put(user.getName(), user);
            }
        } else {
            String userName = page.getUrl().regex("https://github\\.com/\\w+.*").replace("https://github\\.com/", "").get();
            User user = users.get(userName);

            user.setRepoNumber(getRepoNum(page));

            page.putField(userName, user);
        }
    }



    @Override
    public Site getSite() {
        return site;
    }

}
