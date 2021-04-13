package com.crawling.rank.Service;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainServiceTest {

    @Autowired
    MainService mainService;

    @Test
    public void getRankData_동작테스트() throws IOException {

        // given
        JSONObject coronaList = new JSONObject();

        // when
        coronaList = mainService.getRankData();

        // then
        assertThat(coronaList.get(0)).toString().equals("서예지"); // 실시간 검색어기 때문에 테스트시 확인 필요 ( 21-04-14 00:34 기준 )

    }
}
