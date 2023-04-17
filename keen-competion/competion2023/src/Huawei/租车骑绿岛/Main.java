package Huawei.租车骑绿岛;

import java.util.Scanner;
import java.util.*;


public class Main {
    public static int max_machine=0;

    public static void main(String[] args) {
        // 处理输入
        Scanner in=new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        ArrayList<Integer> weights = new ArrayList<Integer>();
        for (int i=0;i<n;i++) {
            int a = in.nextInt();
            weights.add(a);
            // System.out.println(s);
        }
        Collections.sort(weights);

        // 第二步，左右指针向中间移动
        int left=0;
        int right = weights.size()-1;

        // 结果
        int result = 0;

        // 当前重量
        int temp_weight = weights.get(right) + weights.get(left);

        // 题目中有两个隐含的条件
        // 1: 一辆车最多骑两个人
        // 2：人的重量不可能大于车的载重

        while(left<right) {
            if (temp_weight > m) {
                right --;
                result += 1;
                temp_weight = weights.get(right) + weights.get(left);
            } else{
                right --;
                left ++;
                result += 1;
                temp_weight = weights.get(right) + weights.get(left);
            }
        }

        // 感谢评论区老铁点拨
        if (left == right) {
            result++;
        }

        System.out.println(result);
    }
}