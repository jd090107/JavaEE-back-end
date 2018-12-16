# 一个开源的压测工具

_**Define user behaviour with Python code, and swarm your system with millions of simultaneous users**._



![LocustIcon](images/other/LocustIcon.png)





# 特征

1. **Write user test scenarios in plain-old**
2. **Distributed & Scalable         —— supports hundreds of thousands of users**
3. **Can run tests in any system**



# 压测工具比较

![TestingTools](images/other/TestingTools.png)



| 工具名称     | loadrunner | jmeter   | locust   |
| ------------ | ---------- | -------- | -------- |
| 分布式压力   | 支持       | 支持     | 支持     |
| 单机并发能力 | 低         | 低       | 高       |
| 并发机制     | 进程/线程  | 线程     | 协程     |
| 开发语言     | C/Java     | Java     | Python   |
| 报告与分析   | 完善       | 简单图标 | 简单图表 |
| 授权方式     | 商业收费   | 开源免费 | 开源免费 |
| 测试脚本形式 | C/Java     | GUI      | Python   |
| 资源监控     | 支持       | 不支持   | 不支持   |



_协程定义 ：**协程**，又称微线程，纤程。英文名Coroutine。与子例程一样，**协程**也是一种程序组件。_

**Locust并发机制摈弃了进程和线程，采用协程（gevent）机制。协程避免了系统级资源调度，可以大大提高单机并发能力。**



​              



