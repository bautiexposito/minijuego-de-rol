package com.minijuegoderol.game;

import com.minijuegoderol.model.*;
import com.minijuegoderol.model.Character;
import com.minijuegoderol.util.GenerateCharacter;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private GenerateCharacter generateCharacter;
    private Character jugador11;
    private Character jugador12;
    private Character jugador13;
    private Character jugador21;
    private Character jugador22;
    private Character jugador23;
    private Character jugador31;
    private Character jugador32;
    private Character jugador33;
    private ArrayList<Character> raza1;
    private ArrayList<Character> raza2;
    private ArrayList<Character> raza3;

    Round round = new Round();

    public Game() {
        this.generateCharacter = new GenerateCharacter();
        this.raza1 = new ArrayList<>();
        this.raza2 = new ArrayList<>();
        this.raza3 = new ArrayList<>();
    }

    public void iniciarJuego(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while(true){
            System.out.println("Seleccione una raza:");
            System.out.println("Opcion 1: Humanos");
            System.out.println("Opcion 2: Elfos");
            System.out.println("Opcion 3: Orcos");
            opcion = scanner.nextInt();

            switch(opcion){
                case 1:
                    jugador11 = generateCharacter.generateHuman();
                    jugador12 = generateCharacter.generateHuman();
                    jugador13 = generateCharacter.generateHuman();
                    raza1.add(jugador11);
                    raza1.add(jugador12);
                    raza1.add(jugador13);
                    jugador21 = generateCharacter.generateElf();
                    jugador22 = generateCharacter.generateElf();
                    jugador23 = generateCharacter.generateElf();
                    raza2.add(jugador21);
                    raza2.add(jugador22);
                    raza2.add(jugador23);
                    round.iniciarCombate(raza1,raza2);
                    break;
                case 2:
                    //
                    break;
                case 3:
                    //
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