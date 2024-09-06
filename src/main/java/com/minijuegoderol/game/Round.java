package com.minijuegoderol.game;

import com.minijuegoderol.model.Character;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Round {

    private CombatSystem combatSystem;
    private ArrayList<Character> razaMuertos = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Round (CombatSystem combatSystem){
        this.combatSystem = combatSystem;
    }

    public void iniciarCombate(ArrayList<Character> raza1, ArrayList<Character> raza2){
        Random random = new Random();
        int contador =1;

        while(raza1.size()>0 && raza2.size()>0){
            Character pj1 = raza1.get(random.nextInt(raza1.size()));
            Character pj2 = raza2.get(random.nextInt(raza2.size()));

            System.out.println(pj1.getName()+" el "+ pj1.getRaza()+" VS "+pj2.getName()+" el "+pj2.getRaza());
            System.out.println("");
            contador = 1;

            while (contador<=7 && pj1.getHealth()>0 && pj2.getHealth()>0) {
                System.out.println("- - - - Round " + contador + " - - - -");
                scanner.nextLine();

                iniciarRound(pj1, pj2);
                if (pj2.getHealth() <= 0) {
                    System.out.println(pj2.getName() + " ha muerto");
                    razaMuertos.add(pj2);
                    raza2.remove(pj2);
                    break;
                }

                iniciarRound(pj2, pj1);
                if (pj1.getHealth() <= 0) {
                    System.out.println(pj1.getName() + " ha muerto");
                    razaMuertos.add(pj1);
                    raza1.remove(pj1);
                    break;
                }

                contador++;
            }

            if (contador > 7) {
                System.out.println("Ambos personajes sobrevivieron al enfrentamiento,");
                System.out.println("y pueden volver a salir sorteados");
            }
        }

        if(raza1.size()>0){
            System.out.println(raza1.get(0).getRaza()+"s han ganado");
        } else{
            System.out.println(raza2.get(0).getRaza()+"s han ganado");
        }
        System.out.println("");

        System.out.println("A continuacion, mencionamos a los muertos en combate:");
        System.out.println("");
        scanner.nextLine();
        for(Character personaje: razaMuertos){
            personaje.getInfo();
            System.out.println("");
        }
    }

    public void iniciarRound(Character jugador1, Character jugador2){
        System.out.println(jugador1.getName()+" el "+jugador1.getRaza()+" esta atacando");
        int ataque = combatSystem.damageCaused(jugador1, jugador2);
        System.out.println("Inflige "+ataque+" de daño");
        jugador2.takeDamage(ataque);
        if(jugador2.getHealth()<=0){
            System.out.println(jugador2.getName()+" ha muerto");
        } else{
            System.out.println(jugador2.getName()+" queda con "+jugador2.getHealth()+" de vida");
        }
        System.out.println("");
    }

}