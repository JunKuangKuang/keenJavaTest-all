package junkuang.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List4Keen {


    public static void main(String[] args) {
        // Create a list of parts.
        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("32421");
        // List<String> s = Arrays.asList();

        // 如果传入null会报空指针异常
        // list.addAll(null);

        // 用迭代器遍历列表
        Iterator it = list.iterator();
        while (it.hasNext()) {
            // String str = (String) it.next();
            System.out.println(it.next());
        }
        System.out.println(list.getClass());

    }


}