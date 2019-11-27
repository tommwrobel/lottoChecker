package com.tom;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {

    private ArrayList<List<Integer>> winNumbers = new ArrayList<List<Integer>>();
    private ArrayList<String> winDates = new ArrayList<String>();

    public Data(String dataFile) throws FileNotFoundException
    {
        //reading data from file
        File file = new File(dataFile);
        Scanner scan = new Scanner(file);
        int index = 0;

        while(scan.hasNextLine()) {
            String lines = scan.nextLine();
            String[] fSplit = lines.split(";");

            winNumbers.add(new ArrayList<Integer>());
            winDates.add(fSplit[1] + "." + fSplit[2] + "." + fSplit[3]);

            for(int i = 4; i < 10; i++) {
                winNumbers.get(index).add(Integer.parseInt(fSplit[i]));
            }

            index++;
        }
    }

    public int[] checkNumbers(int[] checkNum)
    {
        int[] result = {0, 0, 0, 0, 0, 0};
        int res = 0;

        for (List<Integer> winNum : winNumbers) {
            res = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (winNum.get(i) == checkNum[j]) res++;
                }
            }
            if (res > 0) {
                result[res-1]++;
            }
        }
        return result;
    }
}
