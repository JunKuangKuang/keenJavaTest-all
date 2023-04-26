package Huawei.词典中最长的单词;

import java.util.*;

public class Test1 {
    public static Set<String> s;
    public static String longestWord(String[] words) {
        s = new HashSet<>(Arrays.asList(words));
        int nums = 0;
        String res = "";
        for (String str : s) {
            int temp = str.length();
            // 如果str是满足条件的就更新长度
            if (judge(str)) {
                if (nums < temp) {
                    nums = temp;
                    res = str;
                } else if (nums == temp && str.compareTo(res) < 0) {
                    res = str;
                }

            }
        }
        return res;
    }

    //其他单词逐步添加一个字母，所以转移一个
    public static Boolean judge(String str) {
        int len = str.length();
        for (int i = 1; i < len; i++) {
            if (!s.contains(str.substring(0, i))) {
                return false;
            }
        }
        return true;
    }

    // public static Set<String> s = new HashSet<>();

    public static void main(String[] args) {
        // String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words = {"w","wo","wor","worl", "world"};
        System.out.println(longestWord(words));
        // System.out.println("123");
    }

}
