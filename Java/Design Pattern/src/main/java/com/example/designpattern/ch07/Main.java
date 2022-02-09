package com.example.designpattern.ch07;

public class Main {
    public static void main(String[] args) {

        //Computer computer = new Computer("i7", "16g", "256g ssd");

        ComputerFactory factory = new ComputerFactory();
        
        factory.setBluePrint(new LgGramBluePrint());
        factory.make();

        Computer computer  = factory.getComputer();

        System.out.println(computer.toString());

    }

}
