package com.example.designpattern.ch1;

public class Main {
    public static void main(String[] args) {
//        AInterface aInterface = new AInterfaceImpl();
//
//        // 통로
//        aInterface.funcA();
//
//        AObj aObj = new AObj();
//        aObj.funcAA();

        GameCharacter gameCharacter = new GameCharacter();
        gameCharacter.attack();

        gameCharacter.setWeapon(new Knife());
        gameCharacter.attack();

        gameCharacter.setWeapon(new Sword());
        gameCharacter.attack();

        gameCharacter.setWeapon(new Ax());
        gameCharacter.attack();
    }
}
