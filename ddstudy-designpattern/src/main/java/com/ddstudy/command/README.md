## 命令模式（Command Pattern）

![命令模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/command.png)

### 定义
&emsp;&emsp;将一个请求封装成对象，从而让你使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。  
  
### 说明

&emsp;&emsp;命令模式属于行为型模式的一种，包含4个组件，抽象命令（AbstractCommand）、命令接收者（Receiver）、命令调用者（Invoker）、及客户端（Client）。

&emsp;&emsp;原例中将命令抽象出接口，具体有TextFile表示命令的实际接收者，TextFileExecutor则相当于传递命令的角色，用来解耦客户端及TextFile。

### 优点
&emsp;&emsp;1. 调用者与接收者解耦，不用管谁执行命令，只需调用抽象命令的execute方法即可。

&emsp;&emsp;2. 可扩展性高，新增一种命令只需新增一个实现类即可。

### 缺点
&emsp;&emsp;1. 有N个命令就有N个实现类，类易膨胀。


### 适用场景

&emsp;&emsp;1. 系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。

&emsp;&emsp;2. 在需要支持撤销和恢复撤销的地方，如文本编辑器等。

&emsp;&emsp;3. 需要用到日志请求和队列请求的地方。

### 扩展
&emsp;&emsp;1. 可以利用组合实现宏命令的形式。

&emsp;&emsp;2. 可以利用反射，让用户自定义命令。

&emsp;&emsp;3. 可以在抽象命令中加个逆向操作，或者通过保存对象的历史状态来实现撤销，后者即与备忘录模式相结合。





