package com.test.observer;

/**
 * Created by Licca on 17/3/1.
 */
public class Test{
    /**
     * @param args
     */
    public static void main(String[] args) {
        EventSource ds = new EventSource();
        ds.addEventListener(new EventObserver());
        ds.notifyEvent("Hello LuK ! ");
    }

    public String method2(int t1, int t2) {
        return null;
    }
}
