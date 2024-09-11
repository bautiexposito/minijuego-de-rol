package com.minijuegoderol.model;

public class Elf extends Character{

    public Elf(String name, String raza, int age, int level, int health, int armor, int defense, int power, int agility) {
        super(name, raza, age, level, health, armor, defense, power, agility);
    }

    @Override
    public int specialAttack() {
        return (int) (basicAttack()*1.4);
    }

    @Override
    public int heal(){
        return 40;
    }
}