中兴之主slf4j，将log4j2的实现和slf4j的门面结合在一起使用。

毕竟大家都已经熟悉slf4j的规则很久了，虽然真正使用Log4j2的门面区别也不大，但是人家就是用的slf4j顺手嘛～

这个配置是较简单的，复杂配置的话可以去看log4j2模块的配置。

在该模块中还新引入了一个日志工具类，可以简化开发。不过也是有一个小缺点的，那就是在打开`includeLocation`属性后，
打印日志的方法名和行数固定为了工具类的打印日志行数，当然如果发生异常了在打印堆栈内容时不受此影响。