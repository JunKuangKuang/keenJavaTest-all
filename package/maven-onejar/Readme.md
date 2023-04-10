使用onejar-maven插件（失败）

在 jar 包里嵌套其他 jar，这个方法可以彻底避免解压同名覆盖的问题！

唯独可惜的是这个方法不被 JVM 原生支持，因为 JDK 提供的 ClassLoader 仅支持装载嵌套 jar 包的 class 文件。需要自定义 ClassLoader 以支持嵌套 jar。

令人遗憾的是，即使是最新版的也是2011年十二月份的了，我暂时还没自定义ClassLoader的打算。