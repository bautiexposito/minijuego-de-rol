package com.minijuegoderol.game;

import com.minijuegoderol.model.Character;
import com.minijuegoderol.util.GenerateCharacter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private GenerateCharacter generateCharacter;
    private Round round;
    private ArrayList<Character> raza1;
    private ArrayList<Character> raza2;
    private ArrayList<Character> raza3;
    private Random random = new Random();

    CombatSystem combatSystem = new CombatSystem();

    public Game() {
        this.generateCharacter = new GenerateCharacter();
        this.raza1 = new ArrayList<>();
        this.raza2 = new ArrayList<>();
        this.raza3 = new ArrayList<>();
        CombatSystem combatSystem = new CombatSystem();
        this.round = new Round(combatSystem);
    }

    public void iniciarJuego(){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while(true){
            System.out.println("Seleccione una raza:");
            System.out.println("Opcion 1: Humanos");
            System.out.println("Opcion 2: Elfos");
            System.out.println("Opcion 3: Orcos");
            opcion = scanner.nextInt();
            int numeroAleatorio;

            switch(opcion){
                case 1:
                    System.out.println("Personajes del Jugador 1:");
                    raza1.add(generateCharacter.generateHuman());
                    raza1.add(generateCharacter.generateHuman());
                    raza1.add(generateCharacter.generateHuman());
                    raza1.get(0).getInfo();
                    raza1.get(1).getInfo();
                    raza1.get(2).getInfo();

                    System.out.println("Personajes del Jugador 2:");
                    raza2.add(generateCharacter.generateElf());
                    raza2.add(generateCharacter.generateElf());
                    raza2.add(generateCharacter.generateElf());
                    raza2.get(0).getInfo();
                    raza2.get(1).getInfo();
                    raza2.get(2).getInfo();

                    System.out.println("El sistema esta realizando el sorteo...\n");
                    numeroAleatorio = random.nextInt(2);
                    if (numeroAleatorio==0){
                        System.out.println("Comienzan atacando los Humanos\n");
                        System.out.println(" - - - - Humanos VS Elfos - - - -\n");
                        round.iniciarCombate(raza1,raza2);
                    } else{
                        System.out.println("Comienzan atacando los Elfos\n");
                        System.out.println(" - - - - Elfos VS Humanos - - - -\n");
                        round.iniciarCombate(raza2,raza1);
                    }
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("Personajes del Jugador 1:");
                    raza2.add(generateCharacter.generateElf());
                    raza2.add(generateCharacter.generateElf());
                    raza2.add(generateCharacter.generateElf());
                    raza2.get(0).getInfo();
                    raza2.get(1).getInfo();
                    raza2.get(2).getInfo();

                    System.out.println("Personajes del Jugador 2:");
                    raza3.add(generateCharacter.generateOrc());
                    raza3.add(generateCharacter.generateOrc());
                    raza3.add(generateCharacter.generateOrc());
                    raza3.get(0).getInfo();
                    raza3.get(1).getInfo();
                    raza3.get(2).getInfo();

                    System.out.println("El sistema esta realizando el sorteo...\n");
                    numeroAleatorio = random.nextInt(2);
                    if (numeroAleatorio==0){
                        System.out.println("Comienzan atacando los Elfos\n");
                        System.out.println(" - - - - Elfos VS Orcos - - - -\n");
                        round.iniciarCombate(raza2,raza3);
                    } else{
                        System.out.println("Comienzan atacando los Orcos\n");
                        System.out.println(" - - - - Orcos VS Elfos - - - -\n");
                        round.iniciarCombate(raza3,raza2);
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Personajes del Jugador 1:");
                    raza3.add(generateCharacter.generateOrc());
                    raza3.add(generateCharacter.generateOrc());
                    raza3.add(generateCharacter.generateOrc());
                    raza3.get(0).getInfo();
                    raza3.get(1).getInfo();
                    raza3.get(2).getInfo();

                    System.out.println("Personajes del Jugador 2:");
                    raza2.add(generateCharacter.generateElf());
                    raza2.add(generateCharacter.generateElf());
                    raza2.add(generateCharacter.generateElf());
                    raza2.get(0).getInfo();
                    raza2.get(1).getInfo();
                    raza2.get(2).getInfo();

                    System.out.println("El sistema esta realizando el sorteo...\n");
                    numeroAleatorio = random.nextInt(2);
                    if (numeroAleatorio==0){
                        System.out.println("Comienzan atacando los Orcos\n");
                        System.out.println(" - - - - Orcos VS Elfos - - - -\n");
                        round.iniciarCombate(raza3,raza2);
                    } else{
                        System.out.println("Comienzan atacando los Orcos\n");
                        System.out.println(" - - - - Elfos VS Orcos - - - -\n");
                        round.iniciarCombate(raza2,raza3);
                    }
                    System.out.println("");
                    break;

                default:
                    System.out.println("Error al ingresar una opcion");
                    System.out.println("Intente nuevamente");
                    continue;
            }
            break;
        }
        System.out.println("");
    }
}