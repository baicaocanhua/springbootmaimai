redis  连接
https://www.cnblogs.com/award/p/11442636.html
http://www.007song.com/article/1203
特别介绍下在2.x版本中，默认是使用lettuce；1.x版本的时候，默认使用的就是Jedis；关于两个的区别：

　　Jedis和Lettuce都是Redis Client

　　Jedis 是直连模式，在多个线程间共享一个 Jedis 实例时是线程不安全的。

　　如果想要在多线程环境下使用 Jedis，需要使用连接池。

　　每个线程都去拿Jedis 实例，当连接数量增多时，物理连接成本就较高了。

　　Lettuce 是基于 netty 的，netty 是一个多线程、事件驱动的 I/O 框架，连接实例可以在多个线程间共享，通过异步的方式可以让我们更好的利用系统资源，而不用浪费线程等待网络或磁盘I/O。

可以在pom文件加上依赖：

<dependency>
   <groupId>redis.clients</groupId>
   <artifactId>jedis</artifactId>
   <version>2.6.2</version>
</dependency>
或者：

<dependency>
   <groupId>org.apache.commons</groupId>
   <artifactId>commons-pool2</artifactId>
   <version>2.6.2</version>
</dependency>

-------------

## activeMQ
````
springboot整合activeMQ 
https://www.jianshu.com/p/0d6019f83d5f
SpringBoot整合ActiveMQ，看这篇就够了
https://www.cnblogs.com/haha12/p/11496490.html
SpringBoot 整合 ActiveMq
https://www.cnblogs.com/yufeng218/p/11509486.html
实力干货！SpringBoot JMS(ActiveMQ) 使用实践
https://blog.csdn.net/qiangcuo6087/article/details/79041997

SpringBoot（四）springboot整合ActiveMQ
https://blog.csdn.net/qq_22200097/article/details/82713261