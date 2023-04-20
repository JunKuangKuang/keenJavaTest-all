package huixiaoer;

import java.util.Scanner;
import java.util.Vector;

/*
 * 输入一个正数n，输出所有和为n 连续正数序列。
 * 例如输入15，输出为：{1，2，3，4，5}、{4，5，6}、{7，8}
 * */
public class TestThird {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        if(sum==1){
            System.out.println(1);
            return;
        }
        // if(sum==3){
        //     System.out.println(1+","+2);
        //     return;
        // }

        Vector<Integer> nums = new Vector<>();
        int nSum = 3;
        int temp=2;
        for (int i = 1; i <= sum/2+1; ) {
            if(nSum==sum){
                for (int j = i; j <= temp; j++) {
                    if(j==temp){
                        System.out.println(j);
                    }else{
                        System.out.print(j+",");
                    }
                }
                temp++;
                nSum=nSum+temp;

            } else if (nSum<sum) {
                temp++;
                nSum=temp+nSum;
            }else{
                nSum=nSum-i;
                i++;
            }

        }


    }

}
