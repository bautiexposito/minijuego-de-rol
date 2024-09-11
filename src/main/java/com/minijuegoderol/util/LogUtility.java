package com.minijuegoderol.util;

import java.io.*;
import java.time.LocalDateTime;

public class LogUtility {
    private static final String LOG_FILE = "game_logs.txt";
    private static PrintStream originalOut;
    private static PrintStream logPrintStream;
    private static boolean loggingEnabled = false;

    public static void initializeLogging() {
        try {
            originalOut = System.out;
            FileOutputStream fileOutputStream = new FileOutputStream(LOG_FILE, true);
            logPrintStream = new PrintStream(fileOutputStream);

            LocalDateTime fecha = LocalDateTime.now();
            logPrintStream.println("Partida del dia: " + fecha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void enableLogging() {
        if (logPrintStream != null) {
            System.setOut(new PrintStream(new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    originalOut.write(b);
                    logPrintStream.write(b);
                }
            }));
            loggingEnabled = true;
        }
    }

    public static void disableLogging() {
        if (originalOut != null) {
            System.setOut(originalOut);
            loggingEnabled = false;
        }
    }

    public static void clearLogFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(LOG_FILE, false);
            fileOutputStream.close();
            System.out.println("Archivo de log vaciado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                originalOut.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}