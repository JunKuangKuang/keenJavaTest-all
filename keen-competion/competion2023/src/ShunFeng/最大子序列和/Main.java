package ShunFeng.最大子序列和;

import java.util.ArrayList;


public class Main {
    public static int max_machine = 0;

    public static void main(String[] args) {
        // 一维数组，获取连续子序列和最大值
        ArrayList<Integer> a = new ArrayList<Integer>() {
        };
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(-1);
        a.add(-4);
        a.add(6);


        System.out.println(maxSum1(a));
    }

    /*
     * 时间复杂度是O(n^2)
     * */
    static private int maxSum1(ArrayList<Integer> a) {
        Integer sum = 0;
        for (int i = 0; i < a.size(); i++) {
            Integer temp = 0;
            for (int j = i; j < a.size(); j++) {
                temp += a.get(j);
                if (temp > sum) {
                    sum = temp;
                }
            }
        }

        return sum;
    }

    /*
     * 动态规划
     * 时间复杂度是O(n)
     * */
    public static int maxSum2(ArrayList<Integer> a) {
        Integer sum = 0;
        int max = 0, temp = 0;
        for (int i = 0; i < a.size(); i++) {
            temp += a.get(i);
            if (temp < 0)
                temp = 0;
            if (max < temp)
                max = temp;
        }
        return max;
    }

    /*
    * 如果是循环的最大子序列和，那么就要用逆向思维
    * 循环的最大子序列和=所有元素的和-循环的最小子序列和
    *
    * */
}