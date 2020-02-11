package com.company;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        generaCartonBingo("bingo1a.bingo");
        generaCartonBingo("bingo2a.bingo");
        generaCartonBingo("bingo3a.bingo");
    }

    public static void generaCartonBingo(String filename) {
        Random r = new Random();
        List<Integer> carton = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            int numero = r.nextInt(90) + 1;
            while (carton.contains(numero)) {
                numero = r.nextInt(90) + 1;
            }
            carton.add(numero);
        }
        try {
                FileOutputStream fos = new FileOutputStream(filename);
                DataOutputStream dos = new DataOutputStream(fos);
                dos.writeUTF("BINGO");
                for (int i = 0; i < carton.size(); i++) {
                    dos.writeInt(carton.get(i));
                }
                //ordena
                Collections.sort(carton);
                System.out.println("Creado Carton: " + filename);
                dos.close();
                fos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    