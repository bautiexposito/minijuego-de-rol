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
            historia();
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

    public void historia(){
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
        System.out.println("\n");
        scanner.nextLine();
    }    

    public void instrucciones(){
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("          Instrucciones          ");
        System.out.println("---------------------------------");
        System.out.println("");
        System.out.println("Modos de Juego:");
        System.out.println("- Partida Rapida: Elije una raza y batalla en una partida de pocos minutos");
        System.out.println("-'La Guerra por el Trono': El plato principal, enfrentate contra todas las razas de Eldoria e intenta obtener el trono.");
        System.out.println("");
        System.out.println("Habilidad de los personajes:");
        System.out.println("");
    }
}