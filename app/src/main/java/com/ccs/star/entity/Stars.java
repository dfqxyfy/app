package com.ccs.star.entity;

import com.example.ccs.myandriod.R;

import java.util.Date;

/**
 * Created by ccs on 2016/11/6.
 */

public enum Stars {

    //水瓶座，双鱼座，白羊座，金牛座，双子座，巨蟹座，狮子座，处女座，天秤座，天蝎座，射手座，摩羯座
    SHUIPING_STAR(1,"1.20","2.18",R.mipmap.stars_0002,"水瓶座"),
    SHUANGYU_STAR(2,"2.19","3.20",R.mipmap.stars_0003,"双鱼座"),
    BAIYANG_STAR(3,"3.21","4.19",R.mipmap.stars_0004,"白羊座"),
    JINNIU_STAR(4,"4.20","5.20",R.mipmap.stars_0005,"金牛座"),
    SHUANGZI_STAR(5,"5.21","6.21",R.mipmap.stars_0006,"双子座"),
    JUXIE_STAR(6,"6.22","7.22",R.mipmap.stars_0007,"巨蟹座"),
    SHIZI_STAR(7,"7.23","8.22",R.mipmap.stars_0008,"狮子座"),
    CHUNV_STAR(8,"8.23","9.22",R.mipmap.stars_0009,"处女座"),
    TIANPING_STAR(9,"9.23","10.23",R.mipmap.stars_0010,"天秤座"),
    TIANXIE_STAR(10,"10.24","11.22",R.mipmap.stars_0011,"天蝎座"),
    SHESHOU_STAR(11,"11.23","12.21",R.mipmap.stars_0012,"射手座"),
    MOXIE_STAR(12,"12.21","1.19",R.mipmap.stars_0001,"摩羯座"),
    ;

    private Integer num;
    private Integer pic;
    private String starDate;
    private String endDate;
    private String starName;

    private Stars(Integer num,String starDate,String endDate,Integer pic,String starName){
        this.num = num;
        this.pic = pic;
        this.starDate = starDate;
        this.endDate = endDate;
        this.starName = starName;
    }

    public String getStarName() {
        return starName;
    }

    public Integer getNum(Integer num){
        return num;
    }

    public Integer getNum() {
        return num;
    }

    public Integer getPic() {
        return pic;
    }

    public String getStarDate() {
        return starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public static Stars getStarByDate(Date d){

        Integer month = d.getMonth();
        Integer day = d.getDay();

        Stars star = getStarByNum(month);
        if(Long.valueOf(star.getStarDate().split("\\.")[1]) > day){
            return getStarByNum(month);
        }else{
            if(month-1<0)
                return getStarByNum(12);
            return getStarByNum(month-1);
        }

    }

    public static Stars getStarByNum(Integer num){
        if(num>12||num<1)
            return Stars.BAIYANG_STAR;
        Stars[] starses = Stars.values();
        for(Stars s:starses){
            if(s.getNum().equals(num)){
                return s;
            }
        }
        return Stars.BAIYANG_STAR;
    }

}
