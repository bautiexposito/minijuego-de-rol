package com.minijuegoderol.ui;

import java.util.Scanner;

import com.minijuegoderol.game.Game;
import com.minijuegoderol.model.Elf;
import com.minijuegoderol.model.Human;
import com.minijuegoderol.model.Orc;
import com.minijuegoderol.util.GenerateCharacter;

public class ConsoleUI {

    Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        GenerateCharacter generateCharacter = new GenerateCharacter();

        public void menu(){
            int opcion=1;
            while(opcion!=6){
                System.out.println("");
                System.out.println("- - - - - MENU - - - - -");
                System.out.println("Opcion 1: Iniciar Partida Rapida");
                System.out.println("Opcion 2: Iniciar la Guerra por el Trono");
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
                        game.iniciarPartida();
                        break;
                    case 2:
                        System.out.println("La Guerra por el Trono esta comenzando...");
                        System.out.println("");
                        game.iniciarGuerra();
                        break;
                    case 3:
                        System.out.println("Historial de Partidas:");
                        break;
                    case 4:
                        System.out.println("El Historial ha sido eliminado");
                        break;
                    case 5:
                        instrucciones();
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

    public void instrucciones(){
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("|         Instrucciones         |");
        System.out.println("---------------------------------");
        System.out.println("| Bienvenidos a 'La ULTIMA Guerra'");
        System.out.println("| Donde Elfos, Orcos, y Humanos batallan dejando su vida por el trono");
        System.out.println("| Elije tu propia aventura y selecciona una raza para ir a combatir");
        System.out.println("| Juego de rol generado por un sistema de turnos");
        System.out.println("| Que las fuerzas del cielo lo acompañen!");
        System.out.println("---------------------------------");
    }
}