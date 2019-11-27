package com.tom;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class lottoChecker {

    public static void main(String[] args) throws FileNotFoundException

    {
        String dec = "Y";
        int[] checkNum = new int[6];
        int[] result;
        Data data = new Data("src/main/resources/wyniki-lotto-sortowane.csv");
        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("Podaj liczby do sprawdzenia: ");

            for (int i = 0; i < 6; i++) {
                checkNum[i] = scan.nextInt();
                if(checkNum[i] < 1 || checkNum[i] > 49) {
                    checkNum[i] = 0;
                }
            }

            result = data.checkNumbers(checkNum);

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Ilość trafień dla numerów " + Arrays.toString(checkNum) + ":");
            System.out.println((result[0] > 0) ? "- trafionych jedynek: " + result[0] : "- nie padła żadna jedynka");
            System.out.println((result[1] > 0) ? "- trafionych dwójek: " + result[1] : "- nie padła żadna dwójka");
            System.out.println((result[2] > 0) ? "- trafionych trójek: " + result[2] : "- nie padła żadna trójka");
            System.out.println((result[3] > 0) ? "- trafionych czwórek: " + result[3] : "- nie padła żadna czwórka");
            System.out.println((result[4] > 0) ? "- trafionych piątek: " + result[4] : "- nie padła żadna piątka");
            System.out.println((result[5] > 0) ? "- trafionych szóstek: " + result[5] : "- nie padła żadna szóstka");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.print("Sprawdzić kolejne liczby? [T/N]: ");
            dec = scan.next();
        }
        while(dec.equals("T"));
    }
}
