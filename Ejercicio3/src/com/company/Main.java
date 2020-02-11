package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array1 = {1,2,3,3,3,1,2,4,4,4,4,4,1,2,3,3,3,3,2,1,1,1};
        escribeArray(array1);
        escribeArray(detectaConsecutivos(array1));
        int[] array2 = {1,2,3,8,8,8,8,8,8,8,8,5,5,6,6,6,3,3,3,2,2,1,1};
        escribeArray(array2);
        escribeArray(detectaConsecutivos(array2));

    }

    private static int[] detectaConsecutivos(int[] array)
    {
        int i, cont = 0, cont2 = 0;
        List<Integer> lista = new ArrayList<>();

        for(i = 1; i < array.length; i++)
        {
            if(array[i] == array[i - 1])
            {
                cont++;
                if(cont == 2)
                {
                    lista.add(array[i]);
                    cont2++;
                }
            }
            else
            {
                cont = 0;
            }
        }
        int[] devuelve = new int[cont2];
        for(i=0;i < lista.size(); i++)
        {
            devuelve[i] = lista.get(i);
        }
        return devuelve;
    }

    public static void escribeArray(int[] a) {
        int i;
        System.out.print("[");
        for (i = 0; i < a.length - 1; i++) {
            System.out.print(a[i]);
            System.out.print(", ");
        }
        System.out.print(a[a.length - 1]);
        System.out.println("]");
    }
}
