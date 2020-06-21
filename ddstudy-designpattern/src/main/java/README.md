

## 简介

&emsp;&emsp;在学习设计模式的过程中，一般都要先看UML图，了解各个类之间的关系，清楚整个结构，这样学起来事半功倍。  

&emsp;&emsp;其中，工厂模式、策略模式及状态模式的UML图都差不多，学习时很容易混淆。但实际应用过程中还是有区别的，故将其中区别总结出来以供学习。  

&emsp;&emsp;首先,为了帮助理解，三种模式都取同一个例子，以计算器为例，分为加法和乘法，以下为公共代码。

```java
public interface Operation{
    void execute();
}
public class AddOperation implements Operation{
    @Override
        public void execute() {
            System.out.println("Add");
        }   
}

public class MultiplyOperation implements Operation {
    @Override
    public void execute() {
        System.out.println("Multiply");
    }
}
```

## 工厂模式（Factory Pattern）

![工厂模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/factory.png)

&emsp;&emsp;工厂模式属于创建型模式的一种，简单来说，就是将创建对象的过程封装在一个工厂里，用户无需知道该对象具体是如何创建的，当需要时，只要从工厂里取就行。  

&emsp;&emsp;此例中，用户如果要用一个特定种类的计算器，直接利用factory的静态方法创建就行，此处用了内部枚举，还有一种形式是用户输入String，内部再选择的方式。

&emsp;&emsp;另用户其实并不知道工厂里具体有哪些产品，只知道是制作计算器的，因此有可能产出null。（即用户想创建一个减法计算器，可工厂里面没有）。

```java
public class OperationFactory {

    public static Operation createOperation(Type type){
        switch (type) {
            case ADD:
                return new AddOperation();
            case MULTIPLY:
                return new MultiplyOperation();
            default:
                return null;
        }
    }
    enum Type{
        ADD,MULTIPLY
    }
}

public class Client{
    public static void main(String[] args){
        Operation addOperation = OperationFactory.createOperation(OperationFactory.Type.ADD);
        
        Operation mulOperation = OperationFactory.createOperation(OperationFactory.Type.MULTIPLY);

        addOperation.execute();
        mulOperation.execute();
    }
}
```
 

## 策略模式（Strategy Pattern）

![策略模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/strategy.png)

&emsp;&emsp;策略模式：定义一系列的算法。并创建一个随各种策略改变而改变的context对象，策略改变context，属于行为型模式的一种。


&emsp;&emsp;如下可以明显看到，Operation是作为一个Context类(上下文)的成员变量，类似于工厂类，不过不是用的工厂的静态方法。  

&emsp;&emsp;在实际使用过程中，用户需要根据实际需求，在context的构造方法里new 具体的算法类。  

```java

public class Context{
    private Operation operation;
    
    Context(Operation operation){
    this.operation = operation;
    }
    
    public void execute(){
    operation.execute();
    }
}

public class Client{
    public static void main(String[] args){
        Context context;

        context = new Context(new AddOperation());
        context.execute();

        context = new Context(new MultiplyOperation());
        context.execute();
    }
}
```


## 状态模式（State Pattern）

![状态模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/state.png)

&emsp;&emsp;状态模式：类的行为是基于他的状态改变的，该模式属于行为型模式的一种。  

&emsp;&emsp;状态模式略有不同，其实用此例略有不适，我们假设：该计算器有2个状态（1.加法状态 2.乘法状态），对应状态进行对应的动作，且进行相应动作后，在类的内部状态会进行改变。  

&emsp;&emsp;此处代码需进行部分修改：
1.多了一个set方法，用来修改状态。 
2.可以设置一个计算器的初始状态 。
3.注意到对应的具体状态类中用到setOperation方法，此方法表示进行相应操作后，状态会进行改变，有时该修改状态方式也可以写在Context中。
```java
public class Context {

    private Operation operation;
    private final Operation ADD = new AddOperation(this);
    private final Operation MULTIPLY = new MultiplyOperation(this);

    public Context(){
        //初始状态为Add状态
        this.operation = ADD;
    }

    public Context(Operation operation) {
        this.operation = operation;
    }
    public void execute() {
        operation.execute();
    }
    //设置状态的方法
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
    public Operation getAdd() {
        return Add;
    }

    public Operation getMULTIPLY() {
        return MULTIPLY;
    }
        
}

public class AddOperation implements Operation {

    private Context context;
    
    public AddOperation(Context context) {
        this.context = context;
    }

    @Override
    public void execute() {
        System.out.println("Add");
        context.setOperation(context.getMULTIPLY());
    }
    
}

```


## 优缺点
- 工厂模式：  
 1.创建对象简单，只需要知道其名称就行。  
 2.如果新增一个对象时，需要改动具体工厂类。
  
&emsp;&emsp;适用于各种需生产复杂对象的情况，如果简单对象则可以直接new，不必再维护一个工厂类而给系统带来不必要的复杂性。
  
- 策略模式：  
1.封装了一些列的公共算法，并且可以互换，避免了多重条件判断带来的复杂和难以维护。  
2.所有的策略类都需要对外暴露，用户需知道所有具体策略。  

&emsp;&emsp;适用于那种区别只是不同的行为的类，可以用策略模式让用户选择其中一种行为。如支付可以是微信、现金or支付宝，本质都是支付，用户可以自行选择。
  
- 状态模式：  
1.封装了状态转换规则，用户可以不用知道具体状态是如何转化的，  
2.通常具体状态中可能有多个方法，因此实际结构与实现可能会比较复杂。  
3.违反开闭原则，如果新增一个状态，可能要改动涉及状态转化的类。 

&emsp;&emsp;适用于不用状态可对应不同操作的类，如红绿灯的红灯、绿灯状态，可以停车等待或通行。  

## 异同点

- 工厂模式主要用来创建对象，创建的具体过程封装到了工厂中，用户只需根据名称去创建，而策略模式中的所有策略则对用户开放，用户需知道所有的策略，再根据不同情况进行选择。  
可以理解为工厂模式是**创建**对象，而策略模式是**选择**不同的策略。

- 状态模式主要涉及到一个状态的改变（在状态类或上下文中），对象根据不同的状态进行不同的动作，且状态的转化过程应该对用户是关闭的，即用户不能直接new各种状态，而是通过调用对象不同的方法，在内部进行一个状态的改变。




