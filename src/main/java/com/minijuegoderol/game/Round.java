package com.minijuegoderol.game;

import com.minijuegoderol.model.Character;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Round {

    private CombatSystem combatSystem;
    private ArrayList<Character> razaMuertos = new ArrayList<>();

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public Round (CombatSystem combatSystem){
        this.combatSystem = combatSystem;
    }

    public void iniciarCombate(ArrayList<Character> raza1, ArrayList<Character> raza2){
        System.out.println("El sistema esta realizando el sorteo...\n");
        int numeroAleatorio = random.nextInt(2);
        if (numeroAleatorio==0){
            System.out.println("Comienzan atacando los "+raza1.get(0).getRaza()+"s\n");
            System.out.println(" - - - - "+raza1.get(0).getRaza()+"s VS "+raza2.get(0).getRaza()+"s - - - -\n");
            realizarCombate(raza1,raza2);
        } else{
            System.out.println("Comienzan atacando los "+raza2.get(0).getRaza()+"s\n");
            System.out.println(" - - - - "+raza2.get(0).getRaza()+"s VS "+raza1.get(0).getRaza()+"s - - - -\n");
            realizarCombate(raza2,raza1);
        }
    }

    private void realizarCombate(ArrayList<Character> raza1, ArrayList<Character> raza2){
        int contador =1;

        while(raza1.size()>0 && raza2.size()>0){
            Character pj1 = raza1.get(random.nextInt(raza1.size()));
            Character pj2 = raza2.get(random.nextInt(raza2.size()));

            System.out.println(pj1.getName()+" el "+ pj1.getRaza()+" VS "+pj2.getName()+" el "+pj2.getRaza()+"\n");
            contador = 1;

            while (contador<=7 && pj1.getHealth()>0 && pj2.getHealth()>0) {
                System.out.println("- - - - Round " + contador + " - - - -");
                scanner.nextLine();

                iniciarRound(pj1, pj2);
                if (pj2.getHealth() <= 0) {
                    System.out.println("");
                    System.out.println("*** "+pj2.getName() + " ha muerto ***\n");
                    razaMuertos.add(pj2);
                    raza2.remove(pj2);
                    break;
                }

                scanner.nextLine();
                iniciarRound(pj2, pj1);
                if (pj1.getHealth() <= 0) {
                    System.out.println("");
                    System.out.println("*** "+pj1.getName() + " ha muerto ***\n");
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
            System.out.println("Los "+raza1.get(0).getRaza()+"s han ganado!");
        } else{
            System.out.println("Los "+raza2.get(0).getRaza()+"s han ganado!");
        }
        System.out.println("");

        imprimirMuertos();
    }

    private void iniciarRound(Character jugador1, Character jugador2) {
        System.out.println(jugador1.getName() + " el " + jugador1.getRaza() + " esta atacando");
        int ataque = combatSystem.damageCaused(jugador1, jugador2);
        System.out.println("Inflige " + ataque + " de daño");
        jugador2.takeDamage(ataque);
        if (jugador2.getHealth() > 0) {
            System.out.println(jugador2.getName() + " queda con " + jugador2.getHealth() + " de vida\n");
        }
    }

    private void imprimirMuertos () {
        System.out.println("A continuacion, mencionamos a los muertos en combate:");
        scanner.nextLine();
        System.out.println("");
        scanner.nextLine();
        for (Character personaje : razaMuertos) {
            personaje.getInfo();
            System.out.println("");
        }
    }

    public void clearListaRazaMuertos(){
        razaMuertos.clear();
    }
}