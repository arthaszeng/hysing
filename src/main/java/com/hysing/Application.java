package com.hysing;

import com.hysing.spider.GithubSpider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static GithubSpider githubSpider;

    public static void main(String[] args) {
        System.out.println("App starts\n\n\n\n\n\n\n");
        githubSpider = new GithubSpider();

        try {
//            githubSpider.spiderRun();
            System.out.println("Skip spider..............................");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SpringApplication.run(Application.class);
    }
}
