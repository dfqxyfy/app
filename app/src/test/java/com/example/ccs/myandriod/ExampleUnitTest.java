package com.example.ccs.myandriod;

import com.ccs.star.entity.Stars;
import com.ccs.star.util.HttpClient;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void stars() {
        Stars s = Stars.getStarByDate(new Date());
        System.out.println(s.getStarName());
    }

    @Test
    public void stars2() {


        String url = "http://localhost:8080/star/findStar";
        Map<String, Object> map = new HashMap<>();
        map.put("num", 1);
        //String s = get(url,map);
        String s = HttpClient.get(url, map);
        System.out.println(s);
        // post();

    }

}