package com.minijuegoderol.ui;

import java.util.Scanner;

import com.minijuegoderol.game.Game;
import com.minijuegoderol.util.LogUtility;

public class ConsoleUI {

    Scanner scanner = new Scanner(System.in);
    Game game = new Game();

    public void menu() {
        historia();
        int opcion = 1;
        while (opcion != 6) {
            System.out.println("");
            System.out.println("- - - - - MENU - - - - -");
            System.out.println("Opcion 1: Iniciar Partida Rapida");
            System.out.println("Opcion 2: Iniciar Modo Campaña");
            System.out.println("Opcion 3: Ver Historial de Partidas");
            System.out.println("Opcion 4: Eliminar Historial de Partidas");
            System.out.println("Opcion 5: Leer Instrucciones");
            System.out.println("Opcion 6: Salir");
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
                    System.out.println("Historial de Partidas:\n");
                    LogUtility.readFile();
                    break;
                case 4:
                    LogUtility.clearLogFile();
                    break;
                case 5:
                    instrucciones();
                    break;
                case 6:
                    System.out.println("Juego finalizado correctamente\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error al ingresar una opcion");
                    System.out.println("Intente nuevamente");
            }
        }
    }

    private void historia(){
        System.out.println("");
        System.out.println("En el corazón del continente de Eldoria, tres grandes razas han coexistido durante siglos:");
        System.out.println("Los orgullosos Elfos de Lunaris, los valientes Humanos del Reino de Arvendor, y los feroces Orcos de Gorgath.");
        System.out.println("Cada una de estas civilizaciones ha construido su poder y legado a través de incontables generaciones, pero la paz entre ellas siempre fue frágil.");
        System.out.println("El equilibrio comenzó a romperse cuando el Rey de Arvendor, el único capaz de mediar entre los reinos, murió sin dejar heredero.");
        System.out.println("El trono ha quedado vacío y con él, la promesa de estabilidad ha desaparecido.");
        System.out.println("");
        System.out.println("Las tensiones han crecido a medida que los líderes de cada raza buscan imponer su dominio sobre los demás.");
        System.out.println("Los Elfos, guiados por su longevidad y sabiduría, creen que son los verdaderos guardianes de la tierra y que solo ellos pueden traer la paz.");
        System.out.println("Los Humanos, forjados en batallas y estrategias, sienten que el trono les pertenece por derecho y por su esfuerzo en la unificación del continente.");
        System.out.println("Los Orcos, impulsados por su fuerza brutal y honor, ven en el conflicto una oportunidad para finalmente destruir a sus enemigos ancestrales y reclamar la gloria.");
        System.out.println("");
        System.out.println("Ahora, los guerreros más poderosos de cada raza se alistan para la guerra.");
        System.out.println("Las batallas decidirán no solo quién se sentará en el trono, sino también el futuro de Eldoria.");
        System.out.println("Entre pactos rotos, alianzas traicioneras y una historia marcada por el conflicto, el destino del continente está en manos de aquellos que luchen por el poder absoluto.");
        System.out.println("¡Elige a tu campeón y entra en la lucha por 'EL TRONO' de Eldoria!");
        System.out.println("");
        System.out.println("Insert Coin...\n");
        scanner.nextLine();
    }    

    private void instrucciones(){
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("          Instrucciones          ");
        System.out.println("---------------------------------\n");
        System.out.println("El objetivo del juego es derrotar a todas las aldeas hasta conseguir el Trono de Eldoria.\n");
        System.out.println("Selecciona una de las 3 razas disponibles:");
        System.out.println("1.Humanos: Poseen atributos equilibrados, pero se vuelven muy fuertes al subir de nivel.");
        System.out.println("2.Elfos: Se destacan por poseer el maximo de agilidad, una buena defensa, pero muy poca fuerza.");
        System.out.println("3.Orcos: Son los personajes con mas fuerza del juego, pero no son nada defensivos.\n");
        System.out.println("Los civilizaciones combaten entre si, mediante enfrentamientos de personajes 3 vs 3 ");
        System.out.println("Cada enfrentamiento esta basado en un sistema de turnos,");
        System.out.println("donde se juegan 7 rondas como maximo por enfrentamiento, o hasta que algun personaje muera.");
        System.out.println("Los ataques estan generados automaticamente por una formula generada por los atributos de los personajes.\n");
        System.out.println("¡La guerra te espera! ¿Estás preparado para el combate?");
        System.out.println("¡Buena suerte!\n");
    }
}