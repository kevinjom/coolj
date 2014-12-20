package com.kevinfan.cooj.jdk;

public class GeneralTestedModel implements SimpleTestedModel {
    private int num;

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
