package com.ccs.star.app;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;

import com.alibaba.fastjson.JSON;
import com.ccs.star.entity.Star;
import com.ccs.star.entity.Stars;
import com.ccs.star.util.HttpClient;
import com.ccs.star.app.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final Button btn = (Button) findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("选星座");
                Intent intent = new Intent(MainActivity.this,SelStarActivity.class);
                try {
                    startActivityForResult(intent,0);
                }catch (Throwable e){
                    Log.e("ttttttteeeeeeee debug","test",e);
                }

            }
        });

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        String str = bundle.getString("str");
        final Button detaiBtn = (Button) findViewById(R.id.detail);
        detaiBtn.setText("");
        Log.e("eee",str);
        detaiBtn.setBackgroundResource(Stars.getStarByNum(Integer.valueOf(str)).getPic());
        try {
            new initDetailThread(this,Integer.valueOf(str)).start();            //init(Integer.valueOf(str));
        }catch (Exception e){
            Log.e("错误","msg",e);
        }
    }

    private  class initDetailThread extends Thread{
        private Integer num;
        private Context context;
        public initDetailThread(Context context,Integer num){
            this.num = num;
            this.context = context;
        }
        public void run() {
            Map<String, Object> map = new HashMap<>();
            map.put("num", num);
            String result = HttpClient.get("http://localhost:8080/star/findStar", map);
            Log.v("vvvvvvvvvvvvvv:", result + "");

            if(result == null)
                return;
            Star star = JSON.parseObject(result, Star.class);
            final GridLayout layout = (GridLayout) findViewById(R.id.ccsgridLayout);
            for (int i = 0; i < star.getStarDetail().size(); i++) {
                StarDescText sdt = new StarDescText(context,star.getStarDetail().get(i).getAttr(), star.getStarDetail().get(i).getDesc());
                layout.addView(sdt);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page",
                Uri.parse("http://host/path"),
                Uri.parse("android-app://com.ccs.star.app/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.ccs.star.app/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

}
