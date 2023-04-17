package Huawei.字符串重新排列;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // String strBegin = sc.nextLine();
        String strBegin = "This is an apple";
        String[] sBuffer = strBegin.split(" ");

        ArrayList<String> strWords = new ArrayList<>();

        // 第一步先把单词的字符顺序进行调整，注意是正序还是逆序
        for (String s : sBuffer) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            //     char temp = chars[i];
            //     chars[i] = chars[j];
            //     chars[j] = temp;
            // }

            strWords.add(String.valueOf(chars));
        }

        HashMap<String, Integer> strMap = new HashMap<String, Integer>();
        // 计算每个单词出现的次数
        for (String s : strWords) {
            if (strMap.containsKey(s)) {
                strMap.put(s, strMap.get(s) + 1);
            } else {
                strMap.put(s, 1);
            }
        }


        // 转换成为列表才能排序
        List<Map.Entry<String, Integer>> strList = new ArrayList<>(strMap.entrySet());
        Collections.sort(strList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else if (o1.getKey().length() > o2.getKey().length()) {
                    return 1;
                } else if (o1.getKey().length() < o2.getKey().length()) {
                    return -1;
                } else
                    return o1.getKey().compareTo(o2.getKey());
            }
        });

        // 输出结果
        for (int i = 0; i < strList.size(); i++) {
            for (int j = 0; j < strList.get(i).getValue(); j++) {
                System.out.print(strList.get(i).getKey()+" ");
            }
        }

    }
}