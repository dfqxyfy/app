package com.ccs.compute;

import com.example.ccs.entity.Detail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccs on 2016/10/9.
 */

public class CommStar {
    public static Integer star = 0;

    private static List<Detail> lsDetail = new ArrayList<>();

    static {
        lsDetail.add(new Detail("特点","花心多变"));
        lsDetail.add(new Detail("掌管宫位","第三宫"));
        lsDetail.add(new Detail("阴阳性","阳性"));
        lsDetail.add(new Detail("最大特征","思想"));
        lsDetail.add(new Detail("主管星","水星"));
        lsDetail.add(new Detail("颜色","黄色"));
        lsDetail.add(new Detail("珠宝","猫眼石"));
        lsDetail.add(new Detail("幸运号码","7"));
        lsDetail.add(new Detail("金属","水银"));
    }

    public static List<Detail> getLsDetail() {
        return lsDetail;
    }


}
