使用打包插件maven-shade-plugin

为了避免碰到**同名的类相互覆盖**的情况，可以使用`AppendingTransformer`标签来对文件内容追加合并。

可以一定程度上避免**同名的类相互覆盖**的情况。

最终`FatJar`也不会带入传递依赖冲突问题给下游。