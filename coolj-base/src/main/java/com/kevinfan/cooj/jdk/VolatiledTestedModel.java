package com.kevinfan.cooj.jdk;

public class VolatiledTestedModel implements SimpleTestedModel {
    private volatile int num;

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int getAndInc() {
        return num++;
    }
}
