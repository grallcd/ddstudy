## 代理模式（Proxy Pattern）

![代理模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/proxy.png)

### 定义
&emsp;&emsp;为其他对象提供一种代理以控制对这个对象的访问。  
  
### 说明

&emsp;&emsp;代理模式属于结构型模式的一种，主要起到以下两点作用：

&emsp;&emsp;1. 代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用。

&emsp;&emsp;2. 代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度。

### 优点
&emsp;&emsp;1. 职责清晰，真实的角色实现具体的业务逻辑。

&emsp;&emsp;2. 高扩展性，只要实现了接口，不管如何变化，都能通过代理类。


### 缺点
&emsp;&emsp;1. 在客户端和目标对象之间增加了一个代理对象，会造成处理请求速度变慢。


### 适用场景
&emsp;&emsp;1. 相同的方法可以有不同的执行顺序，且会产生不同的结果时。

&emsp;&emsp;2. 一个对象包含多个组件，且一些基本组件不变，组合又经常变化时。

### 扩展
&emsp;&emsp;1. 代理可分为静态代理和动态代理：

&emsp;&emsp;静态代理如类图所示，在编译之前就已经确定了要代理的具体对象。

&emsp;&emsp;而动态代理可实现JDK自带的InvocationHandler接口，通过reflect包的Proxy，在程序运行期间通过反射创建代理对象。
即在实现阶段不同关心代理谁，而在运行阶段才指定代理哪一个对象。这即是JDK动态代理。另JDK动态代理只能代理实现了接口类(有兴趣可以看看reflect包下，Proxy的newProxyInstance()方法)。





