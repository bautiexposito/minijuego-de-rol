package com.minijuegoderol.game;

import com.minijuegoderol.model.Character;

public class Round {

    public void iniciarCombate(Character jugador1, Character jugador2){
        System.out.println(jugador1.getName()+" VS "+jugador2.getName());
        System.out.println("");
        while(jugador1.getHealth()>0 && jugador2.getHealth()>0){
            iniciarRound(jugador1,jugador2);
            if (jugador2.getHealth() <= 0) {break;}
            iniciarRound(jugador2,jugador1);
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