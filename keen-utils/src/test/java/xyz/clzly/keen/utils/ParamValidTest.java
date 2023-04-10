package xyz.clzly.keen.utils;

import org.junit.Test;
import xyz.clzly.keen.domain.Demo;

public class ParamValidTest {
    private static Demo demoObject = new Demo(3, "demoName");

    /**
     * 只要有一个参数校验失败就会抛出异常，但是成功调用的
     */
    @Test
    public void validDemoParam() {
        try {
            ParamValid.init(demoObject)
                    .valid(param -> !"demoNameNew".equals(demoObject.getName()), "姓名错误")
                    .valid(param -> 3 == demoObject.getNum(), "数字正确")
            ;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

}