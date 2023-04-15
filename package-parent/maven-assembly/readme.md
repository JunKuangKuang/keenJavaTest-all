使用maven-assembly-plugin插件打包内容，对于复杂应用很可能会碰到**同名的类相互覆盖**的情况。

比如多个jar包中包含相同的文件`spring.handlers`和`spring.schemas`，但是内容又不相同，在打包过程中会互相覆盖。

解决方法就是将他们合并、追加成为一个文件，建议了解一下maven-shade-plugin