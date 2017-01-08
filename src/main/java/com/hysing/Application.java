package com.hysing;

import com.hysing.spider.GithubSpider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static GithubSpider githubSpider;

    public static void main(String[] args) {
//        spiderRun();
        springRun();
    }

    private static void spiderRun() {
        try {
            githubSpider = new GithubSpider();
            githubSpider.spiderRun();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void springRun() {
        System.out.println("Skip spider..............................");
        SpringApplication.run(Application.class);
    }
}
