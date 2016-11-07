package com.example.ccs.myandriod;

import android.util.Log;

import com.example.ccs.entity.Stars;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

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