package com.example.ccs.myandriod;

import com.ccs.star.entity.Stars;

import org.junit.Test;

import java.util.Date;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void stars() {
        Stars s = Stars.getStarByDate(new Date());
        System.out.println(s.getStarName());
    }

}