package com.minijuegoderol.model;

import java.util.Random;

public abstract class Character {

    private Random random = new Random();

    private String name;
    private String raza;
    private int age;
    private int level;
    private int health;
    private int armor;
    private int defense;
    private int power;
    private int agility;

    public Character(String name, String raza, int age, int level, int health, int armor, int defense, int power, int agility) {
        this.name = name;
        this.raza = raza;
        this.age = age;
        this.level = level;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void getInfo(){
        System.out.println("================================");
        System.out.println("       "+name+" el "+raza);
        System.out.println("================================");
        System.out.printf("Edad        : %d años%n", age);
        System.out.printf("Nivel       : %d%n", level);
        System.out.printf("Salud       : %d HP%n", health);
        System.out.printf("Armadura    : %d%n", armor);
        System.out.printf("Defensa     : %d%n", defense);
        System.out.printf("Poder       : %d%n", power);
        System.out.printf("Agilidad    : %d%n", agility);
        System.out.println("================================\n");
    }

    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) this.health = 0;
    }

    public int basicAttack(){
        if (powerAttack()+attackEffectiveness()+attackValue()>98){
            return 99;
        } else if (powerAttack()+attackEffectiveness()+attackValue()<2){
            return 1;
        } else{
            return powerAttack()+attackEffectiveness()+attackValue();
        }
    }

    public int powerAttack(){
        return agility*power*level;
    }

    public int attackEffectiveness(){
        int num = random.nextInt(100)+1;
        return (int) Math.round(num*0.01);
    }

    public int attackValue(){
        return powerAttack()*attackEffectiveness();
    }

    public int defensePower(){
        return armor+agility;
    }

    public abstract int specialAttack();

    public abstract int heal();
}