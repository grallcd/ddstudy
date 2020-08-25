## 策略模式（Strategy Pattern）

![策略模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/strategy.png)

### 定义
&emsp;&emsp;定义**一组算法**，将每个算法都封装起来，并且使它们之间可以**互换**。  

### 说明  
&emsp;&emsp;策略模式属于行为型模式的一种，主要包含三个构件：Context（上下文环境）、Strategy（抽象策略角色）、ConcreteStrategy（具体策略角色）。  

&emsp;&emsp;原例中将支付算法抽象出来，具体策略可分为支付宝支付、现金支付和微信支付，同时还有一个环境对象，用来包装具体的支付策略。  

### 优点
&emsp;&emsp;算法可以自由切换，有点类似于工厂模式，但还是有区别的。

### 缺点
&emsp;&emsp;1. 新增一种策略就会新增一个类，可能出现策略类膨胀的问题。这时需考虑能否用别的模式替代。  

&emsp;&emsp;2. 所有策略都要暴露给客户端，因为客户端需要根据不同的环境选择不同的策略，一定程度上有违迪米特法则。

### 适用场景
&emsp;&emsp;多个类只在算法的实现上不同是，可以将算法抽象出来，不同实现代表不同策略。

### 扩展
&emsp;&emsp;策略类可以和枚举结合在一起使用：

```java
public enum PayType{
    //支付宝支付
    ALIPAY {
        @Override
        public void pay() {
            System.out.println("Pay by AliPay");
        }
    },

    //微信支付    
    WXPAY {
        @Override
        public void pay() {
            System.out.println("Pay by WxPay");
        }
    },
    //现金支付
    CASHPAY {
        @Override
        public void pay() {
            System.out.println("Pay by Cash");
        }
    };    
    //声明一个抽象支付方法
    public abstract void pay();
}
```



