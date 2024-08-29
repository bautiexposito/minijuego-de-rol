package com.minijuegoderol.model;

import static java.lang.Integer.parseInt;

public class Elf extends Character{

    public Elf(String name, int age, int health, int armor, int defense, int power, int agility) {
        super(name, age, health, armor, defense, power, agility);
    }

    @Override
    public int basicAttack() {
        return parseInt(String.valueOf(getPower()*getAgility()*getHealth()*0.002));
    }

    @Override
    public int specialAttack() {
        return parseInt(String.valueOf(getPower()*getAgility()*getHealth()*0.006));
    }

    @Override
    public int heal(){
        return 40;
    }
}