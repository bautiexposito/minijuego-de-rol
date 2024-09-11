package com.minijuegoderol.game;

import com.minijuegoderol.util.LogUtility;
import com.minijuegoderol.model.Character;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private GenerateCharacter generateCharacter;
    private Round round;
    private ArrayList<Character> raza1;
    private ArrayList<Character> raza2;
    private ArrayList<Character> raza3;

    public Game() {
        LogUtility.initializeLogging();
        this.generateCharacter = new GenerateCharacter();
        this.raza1 = new ArrayList<>();
        this.raza2 = new ArrayList<>();
        this.raza3 = new ArrayList<>();
        CombatSystem combatSystem = new CombatSystem();
        this.round = new Round(combatSystem);
    }

    public void iniciarPartida(){
        LogUtility.enableLogging();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while(true){
            System.out.println("Seleccione una raza:");
            System.out.println("Opcion 1: Humanos");
            System.out.println("Opcion 2: Elfos");
            System.out.println("Opcion 3: Orcos");
            opcion = scanner.nextInt();
            int numeroAleatorio;

            switch(opcion){
                case 1:
                    System.out.println("Personajes del Jugador 1:");
                    crearPersonajes("Humano");
                    imprimirPersonajes(raza1);

                    System.out.println("Personajes del Jugador 2:");
                    crearPersonajes("Elfo");
                    imprimirPersonajes(raza2);

                    System.out.println(" - - - - Humanos VS Elfos - - - -\n");
                    round.iniciarCombate(raza1,raza2);

                    System.out.println("");
                    imprimirFinalPartida(raza1,"Elfos");
                    break;

                case 2:
                    System.out.println("Personajes del Jugador 1:");
                    crearPersonajes("Elfo");
                    imprimirPersonajes(raza2);

                    System.out.println("Personajes del Jugador 2:");
                    crearPersonajes("Orco");
                    imprimirPersonajes(raza3);

                    System.out.println(" - - - - Elfos VS Orcos - - - -\n");
                    round.iniciarCombate(raza2,raza3);

                    System.out.println("");
                    imprimirFinalPartida(raza2,"Orcos");
                    break;

                case 3:
                    System.out.println("Personajes del Jugador 1:");
                    crearPersonajes("Orco");
                    imprimirPersonajes(raza3);

                    System.out.println("Personajes del Jugador 2:");
                    crearPersonajes("Elfo");
                    imprimirPersonajes(raza2);

                    System.out.println(" - - - - Orcos VS Elfos - - - -\n");
                    round.iniciarCombate(raza3,raza2);

                    System.out.println("");
                    imprimirFinalPartida(raza3,"Elfos");
                    break;

                default:
                    System.out.println("Error al ingresar una opcion");
                    System.out.println("Intente nuevamente");
                    continue;
            }
            raza1.clear();
            raza2.clear();
            raza3.clear();
            break;
        }
        System.out.println("");
        LogUtility.disableLogging();
    }

    public void iniciarGuerra(){
        LogUtility.enableLogging();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String nombre;
        int edad;

        while(true) {
            System.out.println("Seleccione una raza:");
            System.out.println("Opcion 1: Humanos");
            System.out.println("Opcion 2: Elfos");
            System.out.println("Opcion 3: Orcos");
            opcion = scanner.nextInt();
            int numeroAleatorio;

            switch (opcion) {

                // Humanos POV:
                case 1:
                    System.out.println("Ha seleccionado los Humanos para comenzar esta guerra:\n");
                    for(int i=1; i<=3; i++){
                        System.out.println("Ingrese los atributos del personaje numero "+i+":");
                        System.out.println("Ingrese el nombre: ");
                        nombre = scanner.next();
                        System.out.println("Ingrese la edad: ");
                        edad = scanner.nextInt();
                        raza1.add(generateCharacter.generateHumanWithParameters(nombre,edad));
                        System.out.println("");
                    }

                    System.out.println("Humanos:");
                    sanarPersonajes(raza1);
                    imprimirPersonajes(raza1);
                    scanner.nextLine();
                    System.out.println("Elfos:");
                    crearPersonajes("Elfo");
                    imprimirPersonajes(raza2);
                    scanner.nextLine();
                    round.iniciarCombate(raza1,raza2);

                    if(raza1.size()==0){
                        System.out.println("");
                        System.out.println("Has sido derrotado por los Elfos");
                        System.out.println("GAME OVER");
                        scanner.nextLine();
                        break;
                    }

                    System.out.println("");
                    System.out.println("Has vencido a los Elfos, para ganar el trono debes vencer a los Orcos");
                    scanner.nextLine();
                    sanarPersonajes(raza1);
                    levelUp(raza1);
                    System.out.println("Humanos vivos:");
                    imprimirPersonajes(raza1);

                    System.out.println("Orcos:");
                    crearPersonajes("Orco");
                    imprimirPersonajes(raza3);
                    scanner.nextLine();
                    round.iniciarCombate(raza1,raza3);

                    imprimirFinalGuerra(raza1,"Orcos");
                    scanner.nextLine();
                    break;

                // Elfos POV:
                case 2:
                    System.out.println("Ha seleccionado los Elfos para comenzar esta guerra:\n");
                    for(int i=1; i<=3; i++){
                        System.out.println("Ingrese los atributos del personaje numero "+i+":");
                        System.out.println("Ingrese el nombre: ");
                        nombre = scanner.next();
                        System.out.println("Ingrese la edad: ");
                        edad = scanner.nextInt();
                        raza2.add(generateCharacter.generateElfWithParameters(nombre,edad));
                        System.out.println("");
                    }

                    System.out.println("Elfos:");
                    imprimirPersonajes(raza2);
                    scanner.nextLine();
                    System.out.println("Orcos:");
                    crearPersonajes("Orco");
                    imprimirPersonajes(raza3);
                    scanner.nextLine();
                    round.iniciarCombate(raza2,raza3);

                    if(raza2.size()==0){
                        System.out.println("");
                        System.out.println("Has sido derrotado por los Orcos");
                        System.out.println("GAME OVER");
                        scanner.nextLine();
                        break;
                    }

                    System.out.println("");
                    System.out.println("Has vencido a los Orcos, para ganar el trono debes vencer a los Humanos");
                    scanner.nextLine();
                    sanarPersonajes(raza2);
                    levelUp(raza2);
                    System.out.println("Elfos vivos:");
                    imprimirPersonajes(raza2);

                    System.out.println("Humanos:");
                    crearPersonajes("Humano");
                    imprimirPersonajes(raza1);
                    scanner.nextLine();
                    round.iniciarCombate(raza1,raza3);

                    imprimirFinalGuerra(raza2,"Humanos");
                    scanner.nextLine();
                    break;

                // Orcos POV:
                case 3:
                    System.out.println("Ha seleccionado los Orcos para comenzar esta guerra:\n");
                    for(int i=1; i<=3; i++){
                        System.out.println("Ingrese los atributos del personaje numero "+i+":");
                        System.out.println("Ingrese el nombre: ");
                        nombre = scanner.next();
                        System.out.println("Ingrese la edad: ");
                        edad = scanner.nextInt();
                        raza3.add(generateCharacter.generateOrcWithParameters(nombre,edad));
                        System.out.println("");
                    }

                    System.out.println("Orcos:");
                    imprimirPersonajes(raza3);
                    scanner.nextLine();
                    System.out.println("Elfos:");
                    crearPersonajes("Elfo");
                    imprimirPersonajes(raza2);
                    scanner.nextLine();
                    round.iniciarCombate(raza3,raza2);

                    if(raza3.size()==0){
                        System.out.println("");
                        System.out.println("Has sido derrotado por los Elfos");
                        System.out.println("GAME OVER");
                        scanner.nextLine();
                        break;
                    }

                    System.out.println("");
                    System.out.println("Has vencido a los Elfos, para ganar el trono debes vencer a los Humanos");
                    scanner.nextLine();
                    sanarPersonajes(raza3);
                    levelUp(raza3);
                    System.out.println("Orcos vivos:");
                    imprimirPersonajes(raza3);

                    System.out.println("Humanos:");
                    crearPersonajes("Humano");
                    imprimirPersonajes(raza1);
                    scanner.nextLine();
                    round.iniciarCombate(raza3,raza1);

                    imprimirFinalGuerra(raza3,"Humanos");
                    scanner.nextLine();
                    break;


                default:
                    System.out.println("Error al ingresar una opcion");
                    System.out.println("Intente nuevamente");
                    continue;
            }
            raza1.clear();
            raza2.clear();
            raza3.clear();
            break;
        }
        LogUtility.disableLogging();
    }

    private void crearPersonajes(String razaNombre){
        if (razaNombre=="Humano"){
            raza1.add(generateCharacter.generateHuman());
            raza1.add(generateCharacter.generateHuman());
            raza1.add(generateCharacter.generateHuman());
        } else if (razaNombre=="Elfo"){
            raza2.add(generateCharacter.generateElf());
            raza2.add(generateCharacter.generateElf());
            raza2.add(generateCharacter.generateElf());
        } else if (razaNombre=="Orco"){
            raza3.add(generateCharacter.generateOrc());
            raza3.add(generateCharacter.generateOrc());
            raza3.add(generateCharacter.generateOrc());
        }
    }

    private void imprimirPersonajes (ArrayList<Character> raza){
        System.out.println("");
        for(Character pj: raza){
            pj.getInfo();
        }
    }

    private void sanarPersonajes(ArrayList<Character> raza){
        int health=0;

        if(raza.get(0).getRaza()=="Humano"){
            health = 100;
        } else if(raza.get(0).getRaza()=="Elfo"){
            health = 200;
        } else if (raza.get(0).getRaza()=="Orco"){
            health = 250;
        }

        for(Character pj: raza){
            pj.setHealth(health);
        }
    }

    private void levelUp(ArrayList<Character> raza){
        for(Character pj: raza){
            pj.setLevel(2);
        }
        System.out.println("Tus personajes han subido al nivel 2\n");
    }

    private void imprimirFinalPartida(ArrayList<Character> raza, String razaEnemiga){
        if(raza.size()==0){
            System.out.println("");
            System.out.println("Has sido derrotado por los "+razaEnemiga);
            System.out.println("GAME OVER");
        }else{
            System.out.println("");
            System.out.println("Has ganado la partida!");
            System.out.println("Felicitaciones a los guerreros vivos:");
            imprimirPersonajes(raza);
            System.out.println("");
            System.out.println("Veamos si puedes conseguir el trono en el 'Modo Campaña'...");
        }
    }

    private void imprimirFinalGuerra(ArrayList<Character> raza, String razaEnemiga){
        if(raza.size()==0){
            System.out.println("");
            System.out.println("Has sido derrotado por los "+razaEnemiga);
            System.out.println("GAME OVER");
        }else{
            System.out.println("");
            System.out.println("Felicitaciones! Has ganado la guerra");
            System.out.println("Coronamos a los guerreros vivos:");
            imprimirPersonajes(raza);
            System.out.println("");
            System.out.println("El trono es suyo!");
        }
    }

}