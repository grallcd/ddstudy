## 工厂方法模式

![工厂方法模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/factoryMethod.png)

### 简介
&emsp;&emsp;工厂方法模式类似于抽象工厂模式，也属于创建型模式的一种，它可以用来生产具体的工厂，再通过工厂生产具体的产品。  
  
&emsp;&emsp;原例中只有一类产品：衣服，有不同的工厂生产不同类型的衣服。所以相当于是抽象工厂模式的特例。


### 适用场景
&emsp;&emsp;适用于产品较多的情况。例如工厂A只生产T恤，工厂B只生产外套。

### 优缺点
&emsp;&emsp;同抽象工厂差不多，因为是抽象工厂的特例，另可以保证一类工厂只能生产一类对象，各具体对象之间不会交叉。




