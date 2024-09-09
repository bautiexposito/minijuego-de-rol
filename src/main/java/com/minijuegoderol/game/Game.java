package com.minijuegoderol.game;

import com.minijuegoderol.model.Character;
import com.minijuegoderol.util.GenerateCharacter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private GenerateCharacter generateCharacter;
    private Round round;
    private ArrayList<Character> raza1;
    private ArrayList<Character> raza2;
    private ArrayList<Character> raza3;
    private Random random = new Random();

    CombatSystem combatSystem = new CombatSystem();

    public Game() {
        this.generateCharacter = new GenerateCharacter();
        this.raza1 = new ArrayList<>();
        this.raza2 = new ArrayList<>();
        this.raza3 = new ArrayList<>();
        CombatSystem combatSystem = new CombatSystem();
        this.round = new Round(combatSystem);
    }

    public void iniciarPartida(){
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
                    crearEImprimirPersonajes(raza1,"Humano");

                    System.out.println("Personajes del Jugador 2:");
                    crearEImprimirPersonajes(raza2,"Elfo");

                    System.out.println("El sistema esta realizando el sorteo...\n");
                    numeroAleatorio = random.nextInt(2);
                    if (numeroAleatorio==0){
                        System.out.println("Comienzan atacando los Humanos\n");
                        System.out.println(" - - - - Humanos VS Elfos - - - -\n");
                        round.iniciarCombate(raza1,raza2);
                    } else{
                        System.out.println("Comienzan atacando los Elfos\n");
                        System.out.println(" - - - - Elfos VS Humanos - - - -\n");
                        round.iniciarCombate(raza2,raza1);
                    }

                    System.out.println("");
                    imprimirFinalPartida(raza1,"Elfos");
                    break;

                case 2:
                    System.out.println("Personajes del Jugador 1:");
                    crearEImprimirPersonajes(raza2,"Elfo");

                    System.out.println("Personajes del Jugador 2:");
                    crearEImprimirPersonajes(raza3,"Orco");

                    System.out.println("El sistema esta realizando el sorteo...\n");
                    numeroAleatorio = random.nextInt(2);
                    if (numeroAleatorio==0){
                        System.out.println("Comienzan atacando los Elfos\n");
                        System.out.println(" - - - - Elfos VS Orcos - - - -\n");
                        round.iniciarCombate(raza2,raza3);
                    } else{
                        System.out.println("Comienzan atacando los Orcos\n");
                        System.out.println(" - - - - Orcos VS Elfos - - - -\n");
                        round.iniciarCombate(raza3,raza2);
                    }

                    System.out.println("");
                    imprimirFinalPartida(raza2,"Orcos");
                    break;

                case 3:
                    System.out.println("Personajes del Jugador 1:");
                    crearEImprimirPersonajes(raza3,"Orco");

                    System.out.println("Personajes del Jugador 2:");
                    crearEImprimirPersonajes(raza2,"Elfo");

                    System.out.println("El sistema esta realizando el sorteo...\n");
                    numeroAleatorio = random.nextInt(2);
                    if (numeroAleatorio==0){
                        System.out.println("Comienzan atacando los Orcos\n");
                        System.out.println(" - - - - Orcos VS Elfos - - - -\n");
                        round.iniciarCombate(raza3,raza2);
                    } else{
                        System.out.println("Comienzan atacando los Orcos\n");
                        System.out.println(" - - - - Elfos VS Orcos - - - -\n");
                        round.iniciarCombate(raza2,raza3);
                    }

                    System.out.println("");
                    imprimirFinalPartida(raza3,"Elfos");
                    break;

                default:
                    System.out.println("Error al ingresar una opcion");
                    System.out.println("Intente nuevamente");
                    continue;
            }
            break;
        }
        System.out.println("");
    }

    public void iniciarGuerra(){
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
                    imprimirPersonajes("Humano");
                    scanner.nextLine();
                    System.out.println("Elfos:");
                    crearEImprimirPersonajes(raza2,"Elfos");
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
                    System.out.println("Humanos vivos:");
                    imprimirPersonajes("Humano");
                    System.out.println("Orcos:");
                    crearEImprimirPersonajes(raza3,"Orcos");
                    scanner.nextLine();
                    round.iniciarCombate(raza1,raza3);

                    imprimirFinalGuerra(raza1,"Orcos");
                    scanner.nextLine();
                    break;

                // Elfos POV:
                case 2:
                    System.out.println("Ha seleccionado los Elfos para comenzar esta guerra:\n");
                    for(int i=1; i>=3; i++){
                        System.out.println("Ingrese los atributos del personaje numero "+i+":");
                        System.out.println("Ingrese el nombre: ");
                        nombre = scanner.next();
                        System.out.println("Ingrese la edad: ");
                        edad = scanner.nextInt();
                        raza2.add(generateCharacter.generateElfWithParameters(nombre,edad));
                    }

                    System.out.println("Elfos:");
                    imprimirPersonajes("Elfo");
                    scanner.nextLine();
                    System.out.println("Orcos:");
                    crearEImprimirPersonajes(raza3,"Orcos");
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
                    System.out.println("Elfos vivos:");
                    imprimirPersonajes("Elfo");
                    System.out.println("Humanos:");
                    crearEImprimirPersonajes(raza1,"Humanos");
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
                        raza3.add(generateCharacter.generateHumanWithParameters(nombre,edad));
                        System.out.println("");
                    }

                    System.out.println("Orcos:");
                    imprimirPersonajes("Orco");
                    scanner.nextLine();
                    System.out.println("Elfos:");
                    crearEImprimirPersonajes(raza2,"Elfos");
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
                    System.out.println("Orcos vivos:");
                    imprimirPersonajes("Orco");
                    System.out.println("Humanos:");
                    crearEImprimirPersonajes(raza1,"Humanos");
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
            break;
        }
    }

    public void crearEImprimirPersonajes (ArrayList<Character> razaLista, String razaNombre){
        if (razaNombre=="Humano"){
            raza1.add(generateCharacter.generateHuman());
            raza1.add(generateCharacter.generateHuman());
            raza1.add(generateCharacter.generateHuman());
            raza1.get(0).getInfo();
            raza1.get(1).getInfo();
            raza1.get(2).getInfo();
        } else if (razaNombre=="Elfo"){
            raza2.add(generateCharacter.generateElf());
            raza2.add(generateCharacter.generateElf());
            raza2.add(generateCharacter.generateElf());
            raza2.get(0).getInfo();
            raza2.get(1).getInfo();
            raza2.get(2).getInfo();
        } else if (razaNombre=="Orco"){
            raza3.add(generateCharacter.generateOrc());
                raza3.add(generateCharacter.generateOrc());
                raza3.add(generateCharacter.generateOrc());
                raza3.get(0).getInfo();
                raza3.get(1).getInfo();
                raza3.get(2).getInfo();
        }
    }

    public void imprimirPersonajes (String razaNombre){
        if (razaNombre=="Humano")
        for(Character pj: raza1){
            pj.getInfo();
        } else if (razaNombre=="Elfo")
        for(Character pj: raza2){
            pj.getInfo();
        } else if (razaNombre=="Orco")
        for(Character pj: raza3){
            pj.getInfo();
        }
    }

    public void imprimirFinalPartida(ArrayList<Character> raza, String razaEnemiga){
        if(raza.size()==0){
            System.out.println("");
            System.out.println("Has sido derrotado por los "+razaEnemiga);
            System.out.println("GAME OVER");
        }else{
            System.out.println("");
            System.out.println("Has ganado la partida!");
            System.out.println("Felicitaciones a los guerreros vivos:");
            for(Character pj: raza){
                pj.getInfo();
            }
            System.out.println("");
            System.out.println("Veamos si puedes conseguir el trono en el 'Modo Campaña'...");
        }
    }

    public void imprimirFinalGuerra(ArrayList<Character> raza, String razaEnemiga){
        if(raza.size()==0){
            System.out.println("");
            System.out.println("Has sido derrotado por los "+razaEnemiga);
            System.out.println("GAME OVER");
        }else{
            System.out.println("");
            System.out.println("Felicitaciones! Has ganado la guerra");
            System.out.println("Coronamos a los guerreros vivos:");
            for(Character pj: raza){
                pj.getInfo();
            }
            System.out.println("");
            System.out.println("El trono es suyo!");
        }
    }

}