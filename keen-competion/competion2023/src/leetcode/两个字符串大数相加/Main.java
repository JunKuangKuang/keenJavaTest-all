package leetcode.两个字符串大数相加;

/*
实现任意两个正整数的求和(不限位数！！！）
* */
public class Main {
    public static void main(String[] args) {
        System.out.println(Add("123", "9997"));
    }

    public static String Add(String a, String b) {
        char[] charA = new StringBuffer(a)
                .reverse()
                .toString()
                .toCharArray();
        char[] charB = new StringBuffer(b)
                .reverse()
                .toString()
                .toCharArray();

        int maxLength =1;
        if(charA.length> charB.length){
            maxLength=charA.length;
        }else{
            maxLength=charB.length;
        }

        // 进位数加一，比如9+9=18
        int[] result = new int[maxLength + 1];

        int temp = 0;
        for (int i = 0; i <= maxLength; i++) {
            temp = result[i];

            if (i < charA.length) {
                temp += charA[i] - '0';
            }

            if (i < charB.length) {
                temp += charB[i] - '0';
            }
            // 如果发生了进位，那么就要多存一下
            if (temp >= 10) {
                temp -= 10;
                result[i + 1] = 1;
            }

            result[i] = temp;
        }

        StringBuffer resultStringBuffer = new StringBuffer();
        for (int i = result.length-1; i >= 0; i--) {
            resultStringBuffer.append(result[i]);
        }

        return resultStringBuffer.toString();
    }

}
