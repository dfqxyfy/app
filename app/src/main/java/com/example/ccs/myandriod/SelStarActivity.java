package com.example.ccs.myandriod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SelStarActivity extends Activity {


//    private Button returnButton;
//    private EditText inputEditor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.textdialog);
        setContentView(R.layout.sel_star_main);
//        returnButton = (Button)findViewById(R.id.returnButton);
//        inputEditor = (EditText)findViewById(R.id.et);
//
//        //和前面一样，只是用到了返回式Activity的基本方法，虽然这里已经是个Dialog了，但却和普通Activity无异
//        returnButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                String input = inputEditor.getText().toString();
//                Intent i = new Intent(SelStarActivity.this, MainActivity.class);
//                Bundle b = new Bundle();
//                b.putString("str", input);
//                i.putExtras(b);
//                SelStarActivity.this.setResult(RESULT_OK, i);
//                SelStarActivity.this.finish();
//            }
//        });
    }
    private static Integer count = 0;
    @Override
    public void finalize(){
        Log.e("asss","aaaaaaaaaaaaa:"+ ++count);
    }
}
