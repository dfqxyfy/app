package com.example.ccs.myandriod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ccs on 2016/11/6.
 */

public class TestDialog extends Activity {

    private Button returnButton;
    private EditText inputEditor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textdialog);

        returnButton = (Button)findViewById(R.id.returnButton);
        inputEditor = (EditText)findViewById(R.id.et);

        //和前面一样，只是用到了返回式Activity的基本方法，虽然这里已经是个Dialog了，但却和普通Activity无异
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = inputEditor.getText().toString();
                Intent i = new Intent(TestDialog.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putString("str", input);
                i.putExtras(b);
                TestDialog.this.setResult(RESULT_OK, i);
                TestDialog.this.finish();
            }
        });
    }
}
