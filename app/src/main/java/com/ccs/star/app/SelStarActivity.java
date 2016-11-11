package com.ccs.star.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccs.star.entity.Stars;
import com.example.ccs.myandriod.R;

public class SelStarActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sel_star_main);

        GridLayout gridLayout = (GridLayout)findViewById(R.id.starsList);
        gridLayout.setColumnCount(2);
        gridLayout.setRowCount(6);

        for(int i = 0;i<12;i++){
            LinearLayout cellLayout=new LinearLayout(this);
            cellLayout.setHorizontalGravity(LinearLayout.VERTICAL);
            cellLayout.setTag(i+1);

            cellLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SelStarActivity.this, MainActivity.class);
                    Bundle b = new Bundle();
                    b.putString("str", v.getTag().toString());
                    Log.e("str",v.getTag().toString());
                    intent.putExtras(b);
                    SelStarActivity.this.setResult(RESULT_OK, intent);
                    SelStarActivity.this.finish();
                }
            });

            LinearLayout icoLayout=new LinearLayout(this);
            TextView icoText = new TextView(this);
            icoText.setBackgroundResource(Stars.getStarByNum(i+1).getPic());
            icoLayout.addView(icoText);

            LinearLayout descLayout=new LinearLayout(this);
            //descLayout.setHorizontalGravity(LinearLayout.VERTICAL);
            descLayout.setOrientation(LinearLayout.VERTICAL);
            //descLayout.setVerticalGravity(LinearLayout.VERTICAL);
            TextView tvName = new TextView(this);
            tvName.setText(Stars.getStarByNum(i+1).getStarName());
            TextView tvDate = new TextView(this);
            tvDate.setText(Stars.getStarByNum(i+1).getStarDate()+"--"+Stars.getStarByNum(i+1).getEndDate());
            descLayout.addView(tvName);
            descLayout.addView(tvDate);

            cellLayout.addView(icoLayout);
            cellLayout.addView(descLayout);

            gridLayout.addView(cellLayout);
        }
    }
}
