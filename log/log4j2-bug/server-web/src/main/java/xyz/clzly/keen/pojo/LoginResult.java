
package xyz.clzly.keen.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 定义返回值类型
 * 返回的参数为code表示成功或者失败，info代表错误提示信息。
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResult {
    private int code;
    private String info;
    public String getInfo(){return info;}
    public void setInfo(String info){
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
