## 外观模式（Facade Pattern）

![外观模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/facade.png)

### 定义
&emsp;&emsp;要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。外观模式提供了一个高层次的接口，使得子系统更易于使用。

### 说明

&emsp;&emsp;外观模式属于结构型的一种，为复杂的模块提供外界访问的模块。

&emsp;&emsp;我们知道计算机由CPU、内存、磁盘组成，而外观模式将各子系统组合起来，为我们提供了一个系统的总入口，
当我们开启计算机时，不必单独去开启各个模块。

&emsp;&emsp;另一个系统可以有好几个门面，可能不止一个外观。

### 优点

&emsp;&emsp;可减少系统间的相互依赖，提高了安全性，防止外界直接调用内部系统，


#### 适用场景
&emsp;&emsp;子系统相互独立，通过封装各个子模块，而客户端不用熟知各个系统怎么运转，类似于黑箱操作。


