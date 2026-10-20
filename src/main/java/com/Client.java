package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

    private final String host;
    private final int porta;

    public Client(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }

    @Override
    public void run() {
        try (Socket s = new Socket(host, porta);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connesso al server " + host + ":" + porta);

            System.out.println("Inserisci il primo numero:");
            String num1 = scanner.nextLine();
            out.println(num1);

            System.out.println("Inserisci il secondo numero:");
            String num2 = scanner.nextLine();
            out.println(num2);

            System.out.println("Inserisci l'operatore:");
            String op = scanner.nextLine();
            out.println(op);

            String risposta = in.readLine();
            System.out.println("Risultato dal server: " + risposta);

        } catch (IOException e) {
            System.err.println("[Client] Errore: " + e.getMessage());
        }
    }
}