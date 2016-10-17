package com.example.ccs.myandriod;

import android.content.Context;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by ccs on 2016/10/12.
 */

public class StarDescText extends TextView {

    private String type;
    private String desc;
    public StarDescText(Context context) {
        super(context);
    }
    public StarDescText(Context context,String type,String desc) {
        super(context);
        this.type = type;
        this.desc = desc;
        this.init();
    }

    public void init(){

        this.setText(Html.fromHtml(type+":"+"<font color='#FF0000'>"+desc+"</font>"));
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
