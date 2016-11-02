package com.example.ccs.myandriod;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ccs.compute.CommStar;
import com.ccs.compute.LauarTool;
import com.ccs.compute.ZodiacTool;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

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

        //final EditText lauarText = (EditText) findViewById(R.id.lauarText);

        final Button btn = (Button) findViewById(R.id.button);
        final Button detaiBtn = (Button) findViewById(R.id.detail);
        final String[] stars = {"双鱼座","金牛座"};
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                detaiBtn.setBackgroundResource(choosePic(CommStar.star));

                //AlertDialog ad = new AlertDialog.Builder(MainActivity.this);
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this).setTitle("选择星座");
//
//                builder.setItems(stars, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                builder.show();
                Intent intent = new Intent(getMain(),SelStarActivity.class);
                startActivity(intent);
                if(true)
                    return;
                startService(intent);

                try{
                    Thread.sleep(1000);
                }catch (Exception e){

                }

                stopService(intent);
            }
        });


        detaiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final GridLayout layout = (GridLayout)findViewById(R.id.ccsgridLayout);
                layout.removeAllViews();
                //final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.detailText);
                for(int i = 0 ;i< CommStar.getLsDetail().size();i++){
                    StarDescText sdt = new StarDescText(getMain(),CommStar.getLsDetail().get(i).getType(),CommStar.getLsDetail().get(i).getDes());
                    layout.addView(sdt);

                }
                layout.refreshDrawableState();
                final TextView et = (TextView)findViewById(R.id.starDetail);
                et.setSingleLine(false);
                et.setText("\t\t\t\t白羊座有一种让人看见就觉得开心的感觉，因为总是看起来都是那么地热情、阳光、乐观、坚强，对朋友也慷概大方，性格直来直往，就是有点小脾气。白羊男有大男人主义的性格，而白羊女就是女汉子的形象。");
            }
        });

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private final MainActivity getMain(){
        return this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.ccs.myandriod/http/host/path")
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
                Uri.parse("android-app://com.example.ccs.myandriod/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    private int choosePic(Integer star) {
        switch (star) {
            case 0:
                return R.mipmap.stars_0001;
            case 1:
                return R.mipmap.stars_0002;
            case 2:
                return R.mipmap.stars_0003;
            case 3:
                return R.mipmap.stars_0004;
            case 4:
                return R.mipmap.stars_0005;
            case 5:
                return R.mipmap.stars_0006;
            case 6:
                return R.mipmap.stars_0007;
            case 7:
                return R.mipmap.stars_0008;
            case 8:
                return R.mipmap.stars_0009;
            case 9:
                return R.mipmap.stars_0010;
            case 10:
                return R.mipmap.stars_0011;
            case 11:
                return R.mipmap.stars_0012;
            case 12:
                return R.mipmap.stars_0001;
        }
        return 0;
    }
}
