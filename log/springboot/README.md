spingBoot的版本内核是spring5，所以仍然是和spring5的demo差不多的。

有两个小点需要多加注意：

1. 在spring-boot-starter-web中，是存在着spring-boot-starter-logging的传递依赖的，
之所以将他排除是因为自带的slf4j和log4j2版本过低，使用的logBack日志实现也不是预期的Log4j2

2. 也不要使用spring-boot-starter-log4j2，因为内部使用的传递依赖版本很低，
加入了的话还需要排除掉他的传递依赖，费时费力，不如直接引用日志依赖。

现在demo中的示例是同时用三种门面适配Log4j2的实现来完成打印日志的。