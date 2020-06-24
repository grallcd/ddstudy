## 装饰模式（Decorator Pattern）

![装饰模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/decorator.png)

### 定义
&emsp;&emsp;动态地给一个对象添加一些额外的职责。就增加功能来说，装饰模式相比生成子类更为灵活。  

### 说明  
&emsp;&emsp;装饰模式属于结构型模式的一种，主要包含4个组件：Component、ConcreteComponent、AbstractDecorator、ConcreteDecorator。  

&emsp;&emsp;原例中Drink为抽象接口，具体实现为Milk，为了给奶茶添加一些配料，新增了糖、珍珠装饰类，可以给原有的Milk添加一些别的特性。

### 优点
&emsp;&emsp;该优点即是装饰模式的特性，可以动态地扩展一个实现类的功能。另装饰类和被装饰的类可以各自扩展，且不会耦合。

### 缺点
&emsp;&emsp;其实也不太算缺点，就是多重嵌套装饰的情况下，结构可能比较复杂。

### 实际场景
&emsp;&emsp;最常见的就是Java IO中，InputStream和BufferedInputStream等，通过装饰模式，给InputStream增加缓冲的功能。



