## 适配器模式

![适配器模式](https://github.com/GRain-long/ddstudy/blob/dev/ddstudy-designpattern/src/main/resources/image/adapter.png)

### 简介
&emsp;&emsp;适配器模式可以  
  
&emsp;&emsp;原例中有两类产品：衣服和裤子，组成了一个产品族，接着有一个抽象工厂接口，有两个具体工厂实现该接口。
可以认为A工厂生产A类套装(外套+裙子)，B工厂生产B类套装（T恤+牛仔裤）。

### 适用场景
&emsp;&emsp;适用于有一个产品族的情况。例如商务装工厂生产西服和西裤，休闲装工厂生产牛仔和T恤。之前QQ秀的换肤也类似，可以一整套一整套的换。

### 优点
&emsp;&emsp;可将工厂分离开来，每个具体工厂负责各自生产的产品。

### 缺点
&emsp;&emsp;纵向扩展容易，横向扩展比较困难。比如要再增加新的产品（鞋子）的话，需要新增一个接口，且各工厂类都需修改，而新增一套风格则只需新加一个工厂及新的产品实现类即可。  

&emsp;&emsp;可以这样理解，一个衣柜是一个工厂，现有衣柜1（衣服1+裤子1），衣柜2（衣服2+裤子2），如果加鞋子，则需在每个衣柜里都加（意味着需要修改每个工厂类）。如果新加衣柜3，
则原来的2个衣柜可以不用变，不用违反开闭原则。


