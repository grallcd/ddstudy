## 观察者模式（Observer Pattern）

![观察者模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/observer.png)

### 定义
&emsp;&emsp;定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖它的对象都会得到通知并自动更新。  
  
### 说明
&emsp;&emsp;观察者模式属于行为型模式的一种，类似于发布/订阅模式，包含被观察者和观察者，且被观察者内部维护了一个List来存储观察者。

&emsp;&emsp;例中：学生A、B、C都订阅了邮件，当有新邮件产生时，A、B、C会自动收到通知。

### 优点
&emsp;&emsp;1. 两边解耦，增加观察者或被观察者都易扩展。  

&emsp;&emsp;2. 相当于产生了一个Trigger，可用作事件触发机制。

### 缺点
&emsp;&emsp;1. 触发通知时默认是同步顺序通知的，当观察者较多时可能会影响运行效率。

&emsp;&emsp;2. 需要注意到引用链及循环引用的问题，避免消息的多级传递且避免观察者和被观察者之间的循环引用。

### 实际场景
&emsp;&emsp;1. Spring中有用到观察者模式作为事件监听机制。  

&emsp;&emsp;2. Java util包中也为我们提供了Observable接口。

### 扩展
&emsp;&emsp;实际使用过程中，观察者模式可能会比较复杂，类比MQ，消息传递后需要做到异步处理，以及观察者做出对应的响应等。
