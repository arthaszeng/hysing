package processor;

import us.codecraft.webmagic.Page;

class AttributeFetcher {
    static String getEmailByXpath(Page page, String orderNumber) {
        String xpath = "//*[@id=\"user_search_results\"]/div[1]/div[" + orderNumber + "]/div[2]/ul/li[2]/a";

        return page.getHtml().xpath(xpath)
                .replace("<a class=\"email\" href=\"mailto:&amp;\">", "")
                .replace("</a>", "")
                .get();
    }

    static String getBlogByCss(Page page) {
        String result = page.getHtml().css("#js-pjax-container > div > div.col-3.float-left.pr-3 > ul > li:nth-child(3) > a").regex("(?i)\\b((?:[a-z][\\w-]+:(?:/{1,3}|[a-z0-9%])|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:\\'\".,<>?«»“”‘’]))").get();

        return result == null ? "" : result;
    }


    static String getContribution(Page page) {
        return page.getHtml().css("#js-pjax-container > div > div.col-9.float-left.pl-2 > div.js-repo-filter.position-relative > div.mt-4 > div.js-contribution-graph > h2").get()
                .replace("<h2 class=\"f4 text-normal mb-2\"> ", "")
                .replace(" contributions in the last year </h2>", "")
                .replace(" contribution in the last year </h2>", "")
                .replace(",", "");
    }

    static String getName(Page page) {
        return page.getHtml().css("#js-pjax-container > div > div.col-3.float-left.pr-3 > div.vcard-names-container.py-3.js-sticky.js-user-profile-sticky-fields > h1 > span.vcard-fullname.d-block").get()
                .replace("<span class=\"vcard-fullname d-block\" itemprop=\"name\">", "")
                .replace("</span>", "");
    }

    static String getDesByXpath(Page page, String orderNumber) {
        String xpath = "//*[@id=\"user_search_results\"]/div[1]/div[" + orderNumber + "]/div[2]/div";

        return page.getHtml().xpath(xpath)
                .replace("<div class=\"user-list-bio text-small text-gray\">\n", "")
                .replace("\n</div>", "")
                .get();
    }

    static String getNameByXpath(Page page, String orderNumber) {
        String xpath = "//*[@id=\"user_search_results\"]/div[1]/div[" + orderNumber + "]/div[2]/a";

        return page.getHtml().xpath(xpath)
                .replace("<a href=\"https://github.com/", "")
                .replace(".*\">", "")
                .replace("</a>", "")
                .get();
    }

    static String generateRequest(String name) {
        return "https://github.com/" + name;
    }

    static String getPageNumber(Page page) {
        return page.getUrl().get()
                .replace("https://github.com/search?l=Java&p=", "").replace("&q=location%3A%22Chengdu%22&ref=searchresults&type=Users&utf8=%E2%9C%93", "");
    }


    static String getRepoNum(Page page) {
        return page.getHtml().css("#js-pjax-container > div > div.col-9.float-left.pl-2 > div.user-profile-nav.js-sticky.top-0 > nav > a:nth-child(2) > span").get()
                .replace("<span class=\"counter\"> ", "")
                .replace(" </span>", "");
    }


    static String getFollowerNumber(Page page) {
        return page.getHtml().css("#js-pjax-container > div > div.col-9.float-left.pl-2 > div.user-profile-nav.js-sticky.top-0 > nav > a:nth-child(4) > span").get()
                .replace("<span class=\"counter\"> ", "")
                .replace(" </span>", "");
    }

    static String getStarNum(Page page) {
        return page.getHtml().css("#js-pjax-container > div > div.col-9.float-left.pl-2 > div.user-profile-nav.js-sticky.top-0 > nav > a:nth-child(3) > span").get()
                .replace("<span class=\"counter\"> ", "")
                .replace(" </span>", "");
    }

    static String getJoinedTimeByXpath(Page page, String orderNumber) {
        String xpath = "//*[@id=\"user_search_results\"]/div[1]/div[" + orderNumber + "]/div[2]/ul/li[3]/span/local-time";

        return page.getHtml().xpath(xpath).replace("<.*>", "").replace("\n", "").get();
    }

}
