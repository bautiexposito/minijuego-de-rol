package com.minijuegoderol.game;

import com.minijuegoderol.model.*;
import com.minijuegoderol.model.Character;
import com.minijuegoderol.util.GenerateCharacter;
public class Game {

    private Character jugador1;
    private Character jugador2;
    private GenerateCharacter generateCharacter;
    Round round = new Round();

    public Game() {
        this.generateCharacter = new GenerateCharacter();
    }

    public void iniciarJuego(){
        System.out.println("gaming");

        jugador1 = generateCharacter.generateElf();
        jugador2 = generateCharacter.generateHuman();

        round.iniciarCombate(jugador1,jugador2);
    }

}