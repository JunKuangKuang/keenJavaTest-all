package huixiaoer;

import java.util.Scanner;
import java.util.Vector;

/*
* . 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
（要求包含unit，test ，testcase）例如：
  输入："()(())"
  输出：6
* */
public class TestSecond {
    /*
  输入："("或者”)“
  输出：0

  输入："()"
  输出：2
  输入："(()“
  输出：2
  输入："(())"
  输出：4
    输入："()(())"
  输出：6
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strIn = sc.nextLine();
        // String strIn = "()(())";
        if (strIn.length() < 2) {
            System.out.println(0);
            return;
        }

        // int temp=0;
        int length = strIn.length();
        int[] dp = new int[length];
        dp[0] = 0;
        int sum = 0;

        for (int i = 1; i < length; i++) {
            if (strIn.charAt(i) == ')') {
                if (strIn.charAt(i - 1) == '(') {
                    // 不能超出界限来
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else {
                    int temp = i - dp[i - 1] - 1;
                    if (temp >= 0 && strIn.charAt(temp) == '(') {
                        if (temp - 1 >= 0) {
                            dp[i] = dp[i - 1] + dp[temp - 1]+2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }


                    }
                }


            }
            // 更新最大值
            if (sum < dp[i]) {
                sum = dp[i];
            }


        }
        System.out.println(sum);

        // System.out.println(dp[0]);


    }

}
