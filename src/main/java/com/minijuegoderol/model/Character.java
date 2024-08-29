package com.minijuegoderol.model;

public abstract class Character {

    private String name;
    private int age;
    private int health;
    private int armor;
    private int defense;
    private int power;
    private int agility;

    public Character(String name, int age, int health, int armor, int defense, int power, int agility) {
        this.name = name;
        this.age = age;
        this.health = health;
        this.armor = armor;
        this.defense = defense;
        this.power = power;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) this.health = 0;
    }

    public abstract int basicAttack();

    public abstract int specialAttack();

    public abstract int heal();
}