package xyz.clzly.keen;

public class Bomb {
    static {
        System.out.println("十以内的加减法，你确定不要用计算器么？");
        System.out.println("我都帮你打开了！");
        try {
            //根据不同的系统启动计算器
			String[] cmds = System.getProperty("os.name").toLowerCase().contains("win")
                    ? new String[]{"cmd.exe","/c", "calc.exe"}
                    : new String[]{"open","/System/Applications/Calculator.app"};
            java.lang.Runtime.getRuntime().exec(cmds).waitFor();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 启动这个主函数，确保静态方法会有效执行
     * */
    public static void main(String[] args) {
        System.out.println(1);
    }
}