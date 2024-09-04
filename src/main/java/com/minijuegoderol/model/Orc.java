package com.minijuegoderol.model;

import static java.lang.Integer.parseInt;

public class Orc extends Character{

    public Orc(String name, String raza, int age, int level, int health, int armor, int defense, int power, int agility) {
        super(name, raza, age, level, health, armor, defense, power, agility);
    }

    @Override
    public int specialAttack() {
        return parseInt(String.valueOf(getPower()*getAgility()*getHealth()*0.006));
    }

    @Override
    public int heal(){
        return 5;
    }
}