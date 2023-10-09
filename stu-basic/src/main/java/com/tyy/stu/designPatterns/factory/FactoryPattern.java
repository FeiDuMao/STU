package com.tyy.stu.designPatterns.factory;


/**
 * 工厂模式：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 * 根据传入的类型，返回不同的对象 和策略模式的区别在于： 工厂模式是一个创建模式（关注重点是对象），而策略模式是一个行为模式（关注重点是方法）,
 */
public class FactoryPattern {


    public void simpleFactoryDemo() {
        Shape shape = getShape("circle");
        shape.draw();

    }

    private Shape getShape(String shape) {
        if (shape.equals("circle")) {
            return new Circle();
        }
        if (shape.equals("square")) {
            return new Square();
        }
        if (shape.equals("rectangle")) {
            return new Rectangle();
        }
        throw new IllegalArgumentException();

    }

    /**
     * 抽象工厂模式：和工厂模式类型，但是它获取到的是工厂的工厂
     *
     */


}
