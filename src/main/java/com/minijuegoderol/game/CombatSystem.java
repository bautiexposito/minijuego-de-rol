package com.minijuegoderol.game;

import com.minijuegoderol.model.Character;

public class CombatSystem {

    public int damageCaused(Character p1, Character p2){
        if (p1.basicAttack()-p2.defensePower()<2){
            return 1;
        } else{
            return p1.basicAttack()-p2.defensePower();
        }
    }
}