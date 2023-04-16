package junkuang.collection.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by  魏继扩on 2021/10/19 17:55
 *
 * 在做题的时候有遇到过需要转成list然后排序的情况，以后补充
 */
public class HashMap4Keen {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>();
        m.put("keen",1);
        m.put("keen",2);
        System.out.println(m.get("keen"));

    }
}