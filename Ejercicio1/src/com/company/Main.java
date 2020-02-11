package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        escribeArrayBi(leeSopaLetras("sopa1.txt"));
        System.out.println();
        escribeArrayBi(leeSopaLetras("sopa2.txt"));
        System.out.println();
        escribeArrayBi(leeSopaLetras("sopamal.txt"));
    }

    private static char[][] leeSopaLetras(String filename)
    {
        String texto;
        int longitud;
        try
        {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Leyendo archivo: " + filename);
            texto = br.readLine();
            longitud = texto.length();
            int i = 0, j = 0;
            List<String> lista = new ArrayList<>();
            while(texto != null)
            {
                if (texto.length() != longitud)
                {
                    System.out.println("Archivo no valido: Las líneas no son iguales");
                    return new char[0][0];
                }
                lista.add(texto);
                texto = br.readLine();
            }
            //
            char[][] sopa = new char[lista.size()][longitud];
            for (i = 0; i < lista.size(); i++)
            {
                for (j = 0; j < longitud; j++)
                {
                    sopa[i][j] = lista.get(i).charAt(j);
                }
            }
            br.close();
            fr.close();
            return sopa;
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return new char[0][0];
    }

    public static void escribeArrayBi(char[][] array) {
        int i, j;
        int numFilas = array.length;
        // Si el array es [0] no imprimir nada
        if(numFilas==0) return;

        int numCols = array[0].length;
        for (i = 0; i < numFilas; i++) {
            for (j = 0; j < numCols; j++) {
                if (i == 0 && j == 0) // primera fila
                {
                    System.out.print("╔");
                } else if (i == numFilas - 1 && j == 0) // ultima fila
                {
                    System.out.print("╚");
                } else if (j == 0) {
                    System.out.print("║");
                }
                if (array[i][j] < 100 && array[i][j] > -100) System.out.print(" ");
                if (array[i][j] < 10 && array[i][j] > -10) System.out.print(" ");
                if (array[i][j] >= 0) System.out.print(" ");
                System.out.print(array[i][j]);
                System.out.print(" ");

                if (i == 0 && j == numCols - 1) // ultima fila
                {
                    System.out.print("╗");
                } else if (i == numFilas - 1 && j == numCols - 1) // ultima fila
                {
                    System.out.print("╝");
                } else if (j == numCols - 1) {
                    System.out.print("║");
                }
            }
            System.out.println();
        }
    }
}
