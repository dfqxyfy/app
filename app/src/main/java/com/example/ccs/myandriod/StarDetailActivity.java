package com.example.ccs.myandriod;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.ccs.compute.CommStar;

/**
 * Created by ccs on 2016/10/10.
 */

public class StarDetailActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.star_detail_main);

        final GridLayout layout = (GridLayout)findViewById(R.id.ccsgridLayout);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.detailText);
        for(int i = 0 ;i< CommStar.getLsDetail().size();i++){
            StarDescText sdt = new StarDescText(this,CommStar.getLsDetail().get(i).getType(),CommStar.getLsDetail().get(i).getDes());
            layout.addView(sdt);

        }
        final EditText et = (EditText)findViewById(R.id.editText3);
        et.setText("aaaaaaaaaaaaaa");

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
