package Didi;

import java.util.ArrayList;

/*
* 顺时针旋转读取二维数组
*
* */

public class Main {
    public static void main(String[] args) {
        /*
        *
        *   1   2   3   4
            12  13  14  5
            11  16  15  6
            10  9   8   7
        * */
        // 顺时针遍历数组
        // 边界层数

        int[][] a={
                {1,   2,   3  , 4},
                {12,  13,  14  ,5},
                {11,  16 , 15 , 6},
                {10,  9  , 8 ,  7}
        };
        int size=a.length;
        ArrayList<Integer> temp=new ArrayList<>();
        int l=0,r=size-1,t=0,b=size-1;


        // 逻辑判断条件
        while(true){
            // 分别对上下左右进行循环
            // 上
            for (int i = l; i <= r; i++) {
                temp.add(a[t][i]);
            }
            t++;
            // 跳出
            if(t>b){
                break;
            }
            // 右
            for (int i = t; i <= b; i++) {
                temp.add( a[i][r]);
            }
            r--;
            if(l>r){
                break;
            }
            // 下
            for (int i = r; i >= l; i--) {
                temp.add(a[b][i]);
            }
            b--;
            if(t>b){
                break;
            }
            // 左
            for (int i = b; i >=t; i--) {
                temp.add(a[i][l]);
            }
            l++;
            if(l>r){
                break;
            }
        }
        System.out.println(temp);
    }
}