package com.example.ccs.myandriod;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ccs on 2016/10/12.
 */

public class StarDescText extends EditText{

    private String type;
    private String desc;
    public StarDescText(Context context) {
        super(context);
    }

    public void init(){
        this.setText(type+" "+desc);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
