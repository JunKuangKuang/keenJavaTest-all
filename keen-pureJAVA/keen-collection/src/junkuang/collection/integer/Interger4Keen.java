package junkuang.collection.integer;

/**
 * Created by  魏继扩on 2021/5/18 16:01
 * <p>
 * 测试Integer128陷阱
 * 相关文档可以访问https://blog.csdn.net/MSSPLANET/article/details/122530816
 */
public class Interger4Keen {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;
        int i5 = 128;
        int i6 = 128;
        // 会返回true，原因就是常量池中自动就有0-127的数字对象，两个引用指向的是同一个对象
        System.out.println(i1 == i2);
        // 会返回false，原因就是==比较的是地址，而i1和i2引用的不是常量池中的对象，是两个新生成的对象，地址不同
        System.out.println(i3 == i4);
        // 会返回true，原因就是因为调用方法时比对数值，而不是比对地址
        System.out.println(i3.equals(i4));
        //
        System.out.println(i5 == i6);

        // Integer.IntegerCache中的范围是从-128到127共256个静态对象
    }

    /*
    * 自动拆箱装箱
    * */
    public void autoBoxed() {
        //自动装箱 下列两种写法等效
        // Integer i1 = 128;
        Integer i1 = Integer.valueOf(128);

        //自动拆箱 下列两种写法等效
        // int i2 = i1;
        int i2 = i1.intValue();

    }

}