## 设计模式(Design Pattern)

&emsp;&emsp;设计模式在代码中随处可见，总的来说，设计模式是一套经验、理念，它可以帮助我们优化代码结构，让我们写出更加高效、优雅的代码。通过设计模式，我们可以
设计出更加健壮、稳定的系统。话不多说，直接进入正题：

&emsp;&emsp;要想学习设计模式，必须先了解六大设计原则，这有助于后期帮助理解具体模式的设计及优缺点，为啥要这么设计、适用场景及后期是否易扩展等。

### 六大设计原则

#### 单一职责原则（Single Responsibility Principle）

&emsp;&emsp;单一职责：意味着一个类应该只负责做一类事情，即应该有且仅有一个原因引起类的变更。

&emsp;&emsp;一个类如果符合单一职责原则，因可变的原因少了，类的复杂性会降低，可读性就会提高，可维护性也高了。

#### 里氏替换原则（Liskov Substitution Principle）

&emsp;&emsp;所有引用基类的地方必须能透明地使用其子类的对象。即只要父类能出现的地方子类就可以出现，并且将父类替换为子类也不会产生任何错误或异常。

&emsp;&emsp;Java中因为单继承缘故，大多都是实现接口，然而还是有必须继承的地方，而里氏替换原则则为良好的继承定义了一个规范，其包含以下4个含义：

- 子类必须完全实现父类的方法。
- 子类可以有自己的个性。
- 覆盖或实现父类的方法时参数可以被放大。
- 覆写或实现父类的方法时输出结果可以被缩小。

#### 依赖倒置原则（Dependence Inversion Principle）

&emsp;&emsp;依赖倒置原则主要包含三点：  
1. 高层模块不应该依赖底层模块，两者都应该依赖其抽象。
2. 抽象不应该依赖细节。
3. 细节应该依赖抽象。

&emsp;&emsp;该原则主要用于减少类之间的耦合性，提高系统的稳定性，提高代码的可读性和可维护性。

#### 接口隔离原则（Interface Segregation Principle）

&emsp;&emsp;1.客户端不应该依赖于它不需要的接口，同时类间的依赖关系应该建立在最小的接口上。

&emsp;&emsp;通俗的说，接口应该尽量细化，同时接口中的方法应该尽量少。也包含以下4点：

1. 接口尽量要小，不要出现臃肿的接口。注意前提得需满足单一职责原则。 
2. 接口要高内聚。
3. 定制服务，即为客户端定制所需要的接口。
4. 接口设计是有限度的：设计粒度越小系统越灵活，然而也带来了结构的复杂性，因此要注意适度。


#### 迪米特法则（Law of Demeter）

&emsp;&emsp;一个对象应该对其他对象有最少的了解，该法则的核心就是为了保证类之间的低耦合性。


#### 开闭原则（Open Closed Principle）

&emsp;&emsp;一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。即一个类应该通过扩展来是实现变化，而不是通过修改已有的代码来实现变化。


---------------------------

&emsp;&emsp;以上六大原则，结合起来，简称SOLID，即稳定的，将这6个原则结合起来使用，建立稳定、灵活、健壮的设计。

&emsp;&emsp;接下来，就开始进入23种设计模式的深入学习了。

---------------------------


### [简单工厂模式(Simple Factory)](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/java/com/ddstudy/simplefactory/README.md)

### [工厂方法模式(Factory Method Pattern)](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/java/com/ddstudy/factorymethod/README.md)

### [抽象工厂模式(AbstractFactory Pattern)](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/java/com/ddstudy/abstractfactory/README.md)

### [适配器模式(Adapter Pattern)](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/java/com/ddstudy/adapter/README.md)

### 装饰者模式(Decorator Pattern)

### 外观模式(Facade Pattern)

### 观察者模式(Observer Pattern)

### 代理模式(Proxy Pattern)

### 单例模式(Singleton Pattern)

### 状态模式(State Pattern)

### 策略模式(Strategy Pattern)

### 模板方法模式(Template Pattern)


