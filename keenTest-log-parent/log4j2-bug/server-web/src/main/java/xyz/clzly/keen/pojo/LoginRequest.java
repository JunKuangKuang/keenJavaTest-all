package xyz.clzly.keen.pojo;

/**
 * 定义请求参数
 * 接收的参数为username和password，分别表示用户名和密码
 */
public class LoginRequest {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
