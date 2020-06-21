## 简单工厂模式

![简单工厂模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/simpleFactory.png)

### 简介
&emsp;&emsp;简单工厂模式属于创建型模式的一种，主要是讲创建对象的过程封装起来，用户只需要知道产品名字即可调用工厂生产对象。  
&emsp;&emsp;原例中通过将水果抽象成单独接口，各种具体水果实现该接口。而生产具体水果的逻辑封装在了水果工厂类中，用户可以调用该工厂类生产不同的水果。

### 适用场景
&emsp;&emsp;可用于需要大量创建复杂对象的情况，多数简单的对象直接new即可，不必再维护一个工厂类。

### 优点
&emsp;&emsp;将new 对象的过程统一封装起来，与用户解耦。

### 缺点
&emsp;&emsp;违反了开闭原则，因为如果要为工厂新增一种产品，则需要修改该工厂类里的方法。


