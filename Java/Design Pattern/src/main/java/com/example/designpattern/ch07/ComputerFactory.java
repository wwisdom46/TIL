package com.example.designpattern.ch07;

public class ComputerFactory {

    private BluePrint print;

    public void setBluePrint(BluePrint print) {
        this.print = print;
    }

    public Computer makeAndGet() {

    }

    public void Computer make() {
        print.setRam();
        print.setCpu();
        print.setStorage();
    }

    public Computer getComputer() {
        return print.getComputer();
    }
}
