package com.minijuegoderol.model;

import static java.lang.Integer.parseInt;

public class Human extends Character{

    public Human(String name, String raza, int age, int level, int health, int armor, int defense, int power, int agility) {
        super(name, raza, age, level, health, armor, defense, power, agility);
    }

    @Override
    public int specialAttack() {
        return (int) (basicAttack()*1.8);
    }

    @Override
    public int heal(){
        return 25;
    }
}