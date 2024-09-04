package com.minijuegoderol.util;

import com.minijuegoderol.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenerateCharacter {

    private Random random = new Random();

    private static final List<String> nombresElf = Arrays.asList("Amarïe", "Éowyn", "Lúthien","Fadabiða","Aredhel","Earendil","Idril","Lia","Nienna");
    private static final List<String> nombresHuman = Arrays.asList("Batista", "Romeo","Hermes","Diodoro","Spartacus","Marcus","Columbus","Kalendio","Doménico","Isidoro","Leónidas","Teodoro");
    private static final List<String> nombresOrc = Arrays.asList("Grom","Thrum","Gorrum","Rok","Naznob","Jughog","Sniknob","Homraz","Snak","Badbog");

    public Elf generateElf(){
        int numeroAleatorio = random.nextInt(nombresElf.size());
        String nombre = nombresElf.get(numeroAleatorio);
        String raza = "Elfo";
        int edad = random.nextInt(200)+100;
        int armadura = random.nextInt(55) + 10;
        int defensa = random.nextInt(6)+2;
        int poder = random.nextInt(4)+2;

        Elf elf = new Elf(nombre, raza, edad, 1, 200, armadura, defensa, poder, 10);
        return elf;
    }

    public Human generateHuman(){
        int numeroAleatorio = random.nextInt(nombresHuman.size());
        String nombre = nombresHuman.get(numeroAleatorio);
        String raza = "Humano";
        int edad = random.nextInt(45)+21;
        int armadura = random.nextInt(100) + 50;
        int defensa = random.nextInt(10)+5;
        int poder = random.nextInt(10)+6;

        Human human = new Human(nombre, raza, edad, 1, 100, armadura, defensa, poder, 7);
        return human;
    }

    public Orc generateOrc(){
        int numeroAleatorio = random.nextInt(nombresOrc.size());
        String nombre = nombresOrc.get(numeroAleatorio);
        String raza = "Orco";
        int edad = random.nextInt(600)+300;
        int armadura = random.nextInt(20) + 5;
        int defensa = random.nextInt(7)+3;

        Orc orc = new Orc(nombre, raza, edad, 1, 300, armadura, defensa, 10, 4);
        return orc;
    }

}