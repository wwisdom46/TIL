package com.example.designpattern.ch02;

public class AdapterImpl implements Adapter{

    //Math math;

    @Override
    public Float twiceOf(Float f) {
        return Math.doubled(f.doubleValue()).floatValue();
    }

    @Override
    public Float halfOf(Float f) {
        System.out.println("half 함수 호출 시작");
        return (float) Math.halfOf(f.doubleValue());
    }
}
