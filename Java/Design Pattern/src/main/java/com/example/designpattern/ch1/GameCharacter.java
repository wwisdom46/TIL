package com.example.designpattern.ch1;

public class GameCharacter {
    private Weapon weapon;

    // 교환 가능
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack() {
        if (weapon == null) {
            System.out.println("맨손 공격");
        } else {
            // 위임
            weapon.attack();
        }

    }

}
