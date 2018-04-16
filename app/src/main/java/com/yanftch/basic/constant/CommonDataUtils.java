package com.yanftch.basic.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : yanftch
 * Date : 2018/4/15
 * Time : 22:15
 * Desc :
 */

public class CommonDataUtils {
    public static List<CommonTestBean> getCommonTestDataList() {
        List<CommonTestBean> list = new ArrayList<>();
        list.add(new CommonTestBean("title1", "http://oxslc8nd4.bkt.clouddn.com/tang1.jpg", 1, "tang1"));
        list.add(new CommonTestBean("title2", "http://oxslc8nd4.bkt.clouddn.com/tang2.jpg", 2, "tang2"));
        list.add(new CommonTestBean("title3", "http://oxslc8nd4.bkt.clouddn.com/tang3.jpg", 2, "tang3"));
        list.add(new CommonTestBean("title4", "http://oxslc8nd4.bkt.clouddn.com/tang4.jpg", 2, "tang4"));
        list.add(new CommonTestBean("title5", "http://oxslc8nd4.bkt.clouddn.com/tang5.jpg", 2, "tang5"));
        list.add(new CommonTestBean("title6", "http://oxslc8nd4.bkt.clouddn.com/tang6.jpg", 2, "tang6"));
        list.add(new CommonTestBean("title7", "http://oxslc8nd4.bkt.clouddn.com/tang7.jpg", 2, "tang7"));
        list.add(new CommonTestBean("title8", "http://oxslc8nd4.bkt.clouddn.com/tang8.jpg", 2, "tang8"));
        list.add(new CommonTestBean("title9", "http://oxslc8nd4.bkt.clouddn.com/gif1.jpeg", 3, "tang9"));
        list.add(new CommonTestBean("title10", "http://oxslc8nd4.bkt.clouddn.com/gif2.gif", 10, "tang10"));
        for (int i = 4; i < 30; i++) {
            list.add(new CommonTestBean("title" + i, "imgurl-" + i));
        }
        return list;
    }
}
