package com.ccs.star.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridLayout;
import android.widget.TextView;

import com.ccs.compute.CommStar;
import com.example.ccs.myandriod.R;

/**
 * Created by ccs on 2016/10/10.
 */

public class StarDetailActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.star_detail_main);

        if(true)
            return;
        final GridLayout layout = (GridLayout)findViewById(R.id.ccsgridLayout);
        //final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.detailText);
        for(int i = 0 ;i< CommStar.getLsDetail().size();i++){
            StarDescText sdt = new StarDescText(this,CommStar.getLsDetail().get(i).getType(),CommStar.getLsDetail().get(i).getDes());
            layout.addView(sdt);

        }
        final TextView et = (TextView)findViewById(R.id.starDetail);
        et.setSingleLine(false);
        et.setText("\t\t\t\t白羊座有一种让人看见就觉得开心的感觉，因为总是看起来都是那么地热情、阳光、乐观、坚强，对朋友也慷概大方，性格直来直往，就是有点小脾气。白羊男有大男人主义的性格，而白羊女就是女汉子的形象。");
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
