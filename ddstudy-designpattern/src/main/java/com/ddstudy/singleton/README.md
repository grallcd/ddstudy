## 单例模式（Singleton Pattern）

![单例模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/singleton.png)

### 定义
&emsp;&emsp;确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。

### 说明
&emsp;&emsp;单例情况也分几种，如饿汉单例，懒汉单例等。

### 优点
&emsp;&emsp;因内存中只有一个实例，可减少内存开支及性能开销，同时可以优化和共享该资源的访问。

### 缺点
&emsp;&emsp;无接口，扩展比较困难，如扩展必须修改代码，违反了开闭原则。

### 适用场景
&emsp;&emsp;1. 在整个项目中，需要共享一个对象。  
  
&emsp;&emsp;2. 重复创建对象需要消耗的资源过多时，可以使用单例，如数据库连接。

### 实际场景
&emsp;&emsp;1. 如Spring中自动装配的Bean，默认都是单例的，方便Spring容器管理它们的生命周期。
  
&emsp;&emsp;2. HttpClient中的Http连接可以设置成单例，无需频繁建立连接。



