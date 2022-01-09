package com.example.designpattern.ch1;

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
