package com.hysing;

import com.hysing.spider.GithubSpider;

public class Application {
    private static GithubSpider githubSpider;

    public static void main(String[] args) {
        System.out.println("App starts\n\n\n\n\n\n\n");
        githubSpider = new GithubSpider();

        try {
            githubSpider.spiderRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
