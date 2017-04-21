package com.test.observer;

/**
 * 可以看做业务po，业务逻辑的处理应该在此类中完成
 * 需要继承Observable是因为我们用到了java提供的功能
 */
public class EventObserveable extends java.util.Observable{

    public void action(Object arg) {
        super.setChanged();// setChanged 是protected方法，必须由本来来调用。。。
        super.notifyObservers(arg);
    }

    public void logicHandler(String name) {
        // ... logic handle here , like :
        System.out.println("Object arg is :" + name);
    }
}