## 适配器模式（Adapter Pattern）

![适配器模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/adapter.png)

### 定义
&emsp;&emsp;将一个类的接口变化成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起。  
  
### 说明

&emsp;&emsp;适配器模式属于结构型模式的一种，可作为两个不兼容的接口之间的桥梁。

&emsp;&emsp;主要包含3个构件：Target（目标角色）、Adaptee（源角色）、Adapter（适配器角色）。

&emsp;&emsp;原例中目标角色为IOSConnector，而源角色为OtherConnector，需要将其他电源接口转化成IOS接口，因此用到适配器模式。

### 优点
&emsp;&emsp;主要可用于接口的转化，让两个没有任何关系的类在一起运行。

### 适用场景
&emsp;&emsp;主动地修改一个正常运行的系统的接口，另需注意的是：适配器不是在初始设计时添加的
，而是需要修改已经在生产环境中的接口。

### 扩展
&emsp;&emsp;适配器有两种实现方式：
1. 类适配器（通过继承Adaptee和实现Target接口的方式）
2. 对象适配器（通过实现Target接口和组合Adaptee的方式）

&emsp;&emsp;因继承和实现的缘故，一般推荐使用第二种方式较好，通过组合，设计时可以做到比较灵活。
