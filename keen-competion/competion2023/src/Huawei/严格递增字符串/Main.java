package Huawei.严格递增字符串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // AABBA
        // 十万个
        Scanner in = new Scanner(System.in);
        String s = "AAAAAABBAAAAA";
        // String s = in.nextLine();
        // 最简单情况就是ABA，那么修改他的话就是ABB或者AAA
        int len = s.length();
        // 先统计出来ab的字符个数
        int a = 0;
        int b = 0;

        int firstB = -1;// 找到第一个B的位置
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'B') {
                firstB = i;
                break;
            }
        }
        if (firstB == -1) {
            // 证明这个字符串只有B，类似”BBBB“
            System.out.println(0);
            return;
        }

        int lastA = -1;// 找到最后一个A的位置
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == 'A') {
                lastA = i;
                break;
            }
        }
        if (lastA == -1) {
            // 证明这个字符串只有A，类似”AAAA“
            System.out.println(0);
            return;
        }

        // 如果是混杂的情况，那么此时firstB和lastA都一定是合理的
        // 那么我只需要将lastA前的所有B都改掉或者firstB之后的A都改掉就行了！
        int updateB=0;
        for (int i = 0; i < lastA; i++) {
            if (s.charAt(i) == 'B') {
                updateB++;
            }
        }

        int updateA=0;
        for (int i = firstB; i < len; i++) {
            if (s.charAt(i) == 'A') {
                updateA++;
            }
        }



        System.out.println(Math.min(updateA,updateB));

    }
}