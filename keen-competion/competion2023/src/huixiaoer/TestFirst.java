package huixiaoer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/*
* 输入一个已经按升序排序过的数组和一个数字
* 在数组中查找两个数，使得它们的和正好是输入的那个数字。
* 要求时间复杂度是O(n)。
* 如果有多对数字的和等于输入的数字，输出任意一对即可。
如 输入15， 数组为：{1， 2， 3， 6， 7,  8，10}， 输出为 {7,8}
*
*
15
1 2 3 6 7 8 10
* */
public class TestFirst {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum = sc.nextInt();
        Vector<Integer> nums=new Vector<>();
        while(sc.hasNextInt()){
            nums.add(sc.nextInt());
        }
        func(sum,nums);

        // System.out.println(nums);

    }

    /*15
    1 2 3 6 7 8 10*/
    public static void func(Integer sum,Vector<Integer> nums){
        if(nums.size()==2&& nums.get(0)+nums.get(1)==sum){
            System.out.println(nums);
            return;
        }

        Integer last=nums.size()-1;
        Integer first=nums.size()-2;

        for (int i = 0; i < nums.size()-1; i++) {
            if(nums.get(first)+nums.get(last)>sum && first>0){
                first--;
            } else if (nums.get(first)+nums.get(last)<sum && last>1) {
                last--;
                first=last-1;
            } else if (nums.get(first)+nums.get(last)==sum) {
                System.out.println(nums.get(first)+","+nums.get(last));
                return;
            }
        }

    }
}
