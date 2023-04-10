sping5版本有多个升级，其中有一点就是，将原来的JCL替换成为自己开发的一款spring-jcl

里面的核心类就是`org.apache.commons.logging.LogFactory` 根据当前项目中存在日志的依赖
来决定初始化哪种日志

1. Log4j2
2. SLF4J_LAL(slf4j的变种？还没深入了解)
3. SLF4J
4. 都没有的话默认JUL兜底

