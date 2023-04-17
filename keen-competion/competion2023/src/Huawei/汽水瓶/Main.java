package Huawei.汽水瓶;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int bottleNum = in.nextInt();
            if(bottleNum==0)
                return;
            System.out.println(calm(bottleNum));
        }
    }

    // 递归实现
    public static int calm(int bottleNum) {
        int result = 0;
        // result += bottleNum;
        while (bottleNum > 3) {
            int temp = bottleNum / 3;
            result += temp;
            bottleNum = bottleNum % 3 + temp;
        }

        if (bottleNum == 1 || bottleNum == 0)
            return result;
        return result + 1;
    }

}