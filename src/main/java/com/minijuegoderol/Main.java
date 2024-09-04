package com.minijuegoderol;

import com.minijuegoderol.game.Game;
import com.minijuegoderol.model.*;
import com.minijuegoderol.ui.ConsoleUI;
import com.minijuegoderol.util.GenerateCharacter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConsoleUI ui = new ConsoleUI();
        Game game = new Game();
        GenerateCharacter generateCharacter = new GenerateCharacter();

        int opcion=1;
        while(opcion!=6){
            System.out.println("");
            System.out.println("Opcion 1: Iniciar Partida Rapida");
            System.out.println("Opcion 2: Iniciar Campaña por el Trono");
            System.out.println("Opcion 3: Ver Historial de Partidas");
            System.out.println("Opcion 4: Eliminar Historial");
            System.out.println("Opcion 5: Leer Instrucciones");
            System.out.println("Opcion 6: Salir");
            System.out.println("Opcion 7: Pruebas");
            System.out.println("");
            System.out.println("Ingresar una opcion: ");
            opcion = scanner.nextInt();
            System.out.println("");

            switch (opcion) {
                case 1:
                    System.out.println("La Partida Rapida esta comenzando...");
                    System.out.println("");
                    game.iniciarJuego();
                    break;
                case 2:
                    System.out.println("La Campaña por el Trono esta comenzando...");
                    break;
                case 3:
                    System.out.println("Historial de Partidas:");
                    break;
                case 4:
                    System.out.println("El Historial ha sido eliminado");
                    break;
                case 5:
                    ui.instrucciones();
                    break;
                case 6:
                    System.out.println("Juego finalizado correctamente");
                    System.exit(0);
                    break;
                case 7:
                    System.out.println("Humans:");
                    Human human = generateCharacter.generateHuman();
                    System.out.println("Basic attack: " + human.basicAttack());
                    System.out.println("Defense: " + human.defensePower());
                    System.out.println("");
                    System.out.println("Elfs:");
                    Elf elf = generateCharacter.generateElf();
                    System.out.println("Basic attack: " + elf.basicAttack());
                    System.out.println("Defense: " + elf.defensePower());
                    System.out.println("");
                    System.out.println("Orcs:");
                    Orc orc = generateCharacter.generateOrc();
                    System.out.println("Basic attack: " + orc.basicAttack());
                    System.out.println("Defense: " + orc.defensePower());
                    break;
                default:
                    System.out.println("Error al ingresar una opcion");
                    System.out.println("Intente nuevamente");
            }
        }
    }
}