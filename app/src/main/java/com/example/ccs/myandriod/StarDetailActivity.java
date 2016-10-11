package com.example.ccs.myandriod;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.widget.GridLayout;

/**
 * Created by ccs on 2016/10/10.
 */

public class StarDetailActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        //this.setTitle("aaaaaaaaaaaaaaaaaaaaaaa");
        setContentView(R.layout.star_detail_main);

        StarDescText sdt = new StarDescText(this);
        sdt.setType("333");
        sdt.setDesc("aaaaaDesc");
        sdt.init();
        final GridLayout layout = (GridLayout)findViewById(R.id.ccsgridLayout);
        layout.addView(sdt);
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
