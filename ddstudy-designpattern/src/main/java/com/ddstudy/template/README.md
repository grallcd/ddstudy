## 模板方法模式（Template Pattern）

![模板方法模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/template.png)


### 定义
&emsp;&emsp;定义一个操作中的算法框架，将一些步骤延迟到子类中，使得子类可以不改变一个**算法的结构**即可重定义该算法的**某些特定步骤**。

### 说明
&emsp;&emsp;

&emsp;&emsp;

### 注意
&emsp;&emsp;一般都将模板方法用**final修饰**，以防止子类更改；且抽象模板中的方法尽量设置成protected类型，符合迪米特法则。

### 优点
&emsp;&emsp;1. 封装不变，扩展可变，提取公共代码，便于维护。  

&emsp;&emsp;2. 行为由父类控制，子类实现。

### 缺点
&emsp;&emsp;子类的执行结果会影响到父类。

### 适用场景
&emsp;&emsp;一般用于重要的、复杂的算法，可以把核心算法设计为模板方法。




