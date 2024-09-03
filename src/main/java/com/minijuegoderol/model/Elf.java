package com.minijuegoderol.model;

import static java.lang.Integer.parseInt;

public class Elf extends Character{

    public Elf(String name, String raza, int age, int health, int armor, int defense, int power, int agility) {
        super(name, raza, age, health, armor, defense, power, agility);
    }

    @Override
    public int basicAttack() {
        double result = getPower() * getAgility() * getHealth() * 0.008;
        return (int) Math.round(result);
    }

    @Override
    public int specialAttack() {
        return parseInt(String.valueOf(getPower()*getAgility()*getHealth()*0.006));
    }

    @Override
    public int heal(){
        return 40;
    }

    @Override
    public int defensePower(){
        return 0;
    }

    @Override
    public int attackValue(){
        return 0;
    }

    @Override
    public int attackEffectiveness(){
        return 0;
    }
}