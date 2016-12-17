package processor;

import us.codecraft.webmagic.Page;

public class fetcher {
    public static String getEmailByXpath(Page page, String orderNumber) {
        String xpath = "//*[@id=\"user_search_results\"]/div[1]/div[" + orderNumber + "]/div[2]/ul/li[2]/a";

        return page.getHtml().xpath(xpath)
                .replace("<a class=\"email\" href=\"mailto:&amp;\">", "")
                .replace("</a>", "")
                .get();
    }

    public static String getDesByXpath(Page page, String orderNumber) {
        String xpath = "//*[@id=\"user_search_results\"]/div[1]/div[" + orderNumber + "]/div[2]/div";

        return page.getHtml().xpath(xpath)
                .replace("<div class=\"user-list-bio text-small text-gray\">\n", "")
                .replace("\n</div>", "")
                .get();
    }

    public static String getNameByXpath(Page page, String orderNumber) {
        String xpath = "//*[@id=\"user_search_results\"]/div[1]/div[" + orderNumber + "]/div[2]/a";

        return page.getHtml().xpath(xpath)
                .replace("<a href=\"https://github.com/", "")
                .replace(".*\">", "")
                .replace("</a>", "")
                .get();
    }

    public static String getPageNumber(Page page) {
        return page.getUrl().get()
                .replace("https://github.com/search?p=", "").replace("&q=location%3A%22Chengdu%22&ref=searchresults&type=Users&utf8=%E2%9C%93", "");
    }
}
