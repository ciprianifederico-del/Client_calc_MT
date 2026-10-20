package com.example;

import com.Client;

public class Main {
   public static void main(String[] args) {
        Thread threadClient = new Thread(new Client("127.0.0.1", 3000));
        threadClient.start();
    }
}