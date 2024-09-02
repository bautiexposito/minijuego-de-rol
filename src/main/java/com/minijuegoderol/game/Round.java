package com.minijuegoderol.game;

import com.minijuegoderol.model.Character;

import java.util.ArrayList;

public class Round {

    public void iniciarCombate(ArrayList<Character> raza1, ArrayList<Character> raza2){
        Character pj11 = raza1.get(0);
        Character pj12 = raza1.get(1);
        Character pj13 = raza1.get(2);
        Character pj21 = raza2.get(0);
        Character pj22 = raza2.get(1);
        Character pj23 = raza2.get(2);
        System.out.println(pj11.getRaza()+"s VS "+pj21.getRaza()+"s");
        System.out.println("");

        while(raza1.size()>0 && raza2.size()>0){
            iniciarRound(raza1.get(0),raza2.get(0));
            if(raza2.get(0).getHealth()<=0){
                raza2.remove(0);
            }
            iniciarRound(raza2.get(0),raza1.get(0));
            if(raza1.get(0).getHealth()<=0){
                raza1.remove(0);
            }
        }

        if(raza1.size()>0){
            System.out.println(pj11.getRaza()+"s han ganado");
            System.out.println("");
        } else{
            System.out.println(pj21.getRaza()+"s han ganado");
            System.out.println("");
        }
    }

    public void iniciarRound(Character jugador1, Character jugador2){
        System.out.println(jugador1.getName()+" esta atacando");
        int ataque = jugador1.basicAttack();
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