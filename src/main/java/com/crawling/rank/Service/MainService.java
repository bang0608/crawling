package com.crawling.rank.Service;

import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class MainService {
    private final Logger logger = LoggerFactory.getLogger(MainService.class);

    private static String SITE_URL = "https://zum.com/#!/home";

//    @PostConstruct
    public JSONObject getRankData() throws IOException {
        JSONObject json = new JSONObject();
        Document doc = Jsoup.connect(SITE_URL).get();
        Elements contents = doc.select("div[class=issue_keyword_total]").select("a[class=d_btn_keyword d_ready]").select("span[class=keyword d_keyword]");

        if(!contents.isEmpty()){
            for(int i=0; i<10; i++){
                json.put(i+1, contents.get(i).text());
            }
        }

//        logger.info(json.toJSONString());

        return json;
    }

}
