package com.example.designpattern.ch07;

public class Main {
    public static void main(String[] args) {

        ComputerFactory factory = new ComputerFactory();
        factory.setBluePrint(new LgGramBluePrint());
        Computer computer = factory.makeAndGet();
        Computer computer  = factory.make();
        Computer computer  = factory.getComputer();



        Computer computer = new Computer("i7", "16g", "256g ssd");

        System.out.println(computer.toString());

    }

}
