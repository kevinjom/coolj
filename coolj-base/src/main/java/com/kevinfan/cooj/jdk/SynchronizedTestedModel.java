package com.kevinfan.cooj.jdk;

public class SynchronizedTestedModel implements SimpleTestedModel {
    private int num;

    @Override
    public synchronized int getNum() {
        return num;
    }

    @Override
    public synchronized void setNum(int num) {
        this.num = num;
    }

    @Override
    public synchronized int getAndInc() {
        return num++;
    }
}
