package Huawei.明明的随机数;

import java.util.*;
import java.util.stream.Collectors;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dataNum = in.nextInt();
        int[] nums = new int[dataNum];


        for (int i = 0; i < dataNum; i++) {
            nums[i] = in.nextInt();
        }

        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        TreeSet<Integer> res = new TreeSet<>(s);
        res.forEach(System.out::println);
    }
}