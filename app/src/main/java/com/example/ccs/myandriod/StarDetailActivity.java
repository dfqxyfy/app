package com.example.ccs.myandriod;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ccs on 2016/10/10.
 */

public class StarDetailActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        //this.setTitle("aaaaaaaaaaaaaaaaaaaaaaa");
        setContentView(R.layout.star_detail_main);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
