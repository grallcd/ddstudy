## 责任链模式（Chain of Responsibility Pattern）


![责任链模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/chain.png)

### 定义

&emsp;&emsp;使多个对象都有机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它位置。


### 说明

&emsp;&emsp;责任链模式属于行为型模式的一种，核心在于"链"上，通过聚合自身，在HandlerRequest中根据条件判断是否需向下传递。

&emsp;&emsp;例中根据Log级别的不同，依次传递给每一种Logger处理，让正确的Logger处理对应的Log。

&emsp;&emsp;一般为了控制链上节点的数量，可以在抽象类中设置一个最大节点数量，在setNext( )方法中判断是否超过阈值。

### 优点

&emsp;&emsp;1. 降低耦合度，将请求的发送者和接收者解耦。

### 缺点

&emsp;&emsp;1. 不能保证请求一定被接收。

&emsp;&emsp;2. 系统性能会受到影响，可能会造成循环调用。


### 适用场景

- 有多个对象可以处理同一对象，具体哪个对象处理该请求由运行时刻自动确定。