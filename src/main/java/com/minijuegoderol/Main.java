package com.minijuegoderol;

import com.minijuegoderol.game.Game;
import com.minijuegoderol.ui.ConsoleUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConsoleUI ui = new ConsoleUI();
        Game game = new Game();

        int opcion=1;
        while(opcion!=3){
            System.out.println("");
            System.out.println("Opcion 1: Comenzar Partida");
            System.out.println("Opcion 2: Leer Instrucciones");
            System.out.println("Opcion 3: Salir");
            System.out.println("");
            System.out.println("Ingresar una opcion: ");
            opcion = scanner.nextInt();
            System.out.println("");
            switch (opcion){
                case 1:
                    System.out.println("La partida esta comenzando");
                    System.out.println("");
                    game.iniciarJuego();
                    break;
                case 2:
                    ui.instrucciones();
                    break;
                case 3:
                    System.out.println("Juego finalizado correctamente");
                    System.exit(0);
                default:
                    System.out.println("Error al ingresar una opcion");
                    System.out.println("Intente nuevamente");
            }
        }
    }
}