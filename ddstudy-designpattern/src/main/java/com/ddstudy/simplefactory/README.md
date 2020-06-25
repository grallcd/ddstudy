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

### 扩展
&emsp;&emsp;可以看到，该模式中用到了FruitType枚举类，将new对象的过程放在了枚举中，从而取代如下的用if-else或switch的判断。

```java
public class FruitFactory{

    public static Fruit getFruit(String type){
        switch (type) {
            case "apple":
                return new Apple();
            case "banana":
                return new Banana();
            case "lemon":
                return new Lemon();
            default:
                return null;
        }
    }
}
```
&emsp;&emsp;如果用枚举new 对象，新增对象则改动枚举类，如果用上述方法，新增对象则改动工厂类。  

&emsp;&emsp;个人认为用枚举的话，可以让用户直接选择，更加方便一点，if-else或switch看起来终究还是臃肿了些
，且可能发生输入错误而带来的不好的影响。（如上，输入"Apple"则会返回null的情况）。


