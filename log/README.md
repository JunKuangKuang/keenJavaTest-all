JK的日志尝试

故意将依赖分到单个module里面，保证单个module的依赖是独立的，依赖需要单个修改！

在每一个模块中，我都写明了需要的全部依赖。引用依赖的数量并没有优劣之分，只要不发生版本冲突且可以实现预期效果都是没问题的。

**升级日志依赖**
log4j-core 升到2.16.0
disruptor 升到3.4.4

https://cf.jd.com/pages/viewpage.action?pageId=647695494