package Huawei.进制转换;

import java.util.*;

public class Main {
    public static int change(String str) {
        int[] data = new int[str.length() - 2];
        int result = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            String sub = str.substring(i + 2, i + 3);
            switch (sub) {
                case "A":
                    data[i] = 10;
                    break;
                case "B":
                    data[i] = 11;
                    break;
                case "C":
                    data[i] = 12;
                    break;
                case "D":
                    data[i] = 13;
                    break;
                case "E":
                    data[i] = 14;
                    break;
                case "F":
                    data[i] = 15;
                    break;
                default:
                    data[i] = Integer.parseInt(sub);
            }
            result += data[i] * Math.pow(16, str.length() - 2 - i - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            int result = change(str);
            System.out.println(result);
        }
    }
}