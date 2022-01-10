package com.example.designpattern.ch01;

public class AObj {
    AInterface aInterface;

    public AObj() {
        aInterface = new AInterfaceImpl();
    }

    public void funcAA() {
        // 위임
        aInterface.funcA();
        aInterface.funcA();
    }
}
