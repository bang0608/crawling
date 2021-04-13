package com.crawling.rank.Controller;

import com.crawling.rank.Service.MainService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping(value = "/")
    public ResponseEntity<JSONObject> getMainPage() throws IOException {
        JSONObject response = mainService.getRankData();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
