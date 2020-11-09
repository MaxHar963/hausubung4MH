/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoe4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Max
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
       
        Bsp3 b3 = new Bsp3();
        ArrayList<Integer> list = new ArrayList<>(); 
        Main m = new Main();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("1.. Bsp1");
            System.out.println("2.. Bsp2");
            System.out.println("3.. Bsp3");

            int heingabe = Integer.parseInt(in.nextLine());
            int eingabe1 = 0;
            int eingabe2 = 0;

            switch (heingabe) {

                case 1:
                    System.out.println("Teiler?");
                    eingabe1 = Integer.parseInt(in.nextLine());
                    System.out.println("Wieviele Teile?");
                    eingabe2 = Integer.parseInt(in.nextLine());

                    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(eingabe2);
                    list.clear();
                    list = m.readFile("numbers.csv");
                    for (int i = 0; i < eingabe2; i++) {

                        Bsp1 task = new Bsp1(list);
                        
                        task.cutArray(eingabe2, i, eingabe1);
                        executor.execute(task);
                    }

                    break;
                case 2:
                    System.out.println("n?");
                    eingabe1 = Integer.parseInt(in.nextLine());
                    if (eingabe1 > 100) {

                        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

                        ArrayList<Integer> results = new ArrayList<>();
                        ArrayList<String> presults = new ArrayList<>();
                        int counter = 0;

                        for (int i = 0; i <= eingabe1; i++) {

                            if (counter == 100) {
                                Bsp2 task = new Bsp2();
                                task.von = i - 99;
                                task.bis = i;
                                Future<Integer> result = executor.submit(task);
                                results.add(result.get());
                                presults.add("Summe der Zahlen " + (i - 100) + "-" + i + ": " + result.get());
                                counter = 0;

                            }

                            counter++;

                        }
                        if (eingabe1 % 100 != 0) {

                            int y = eingabe1 % 100;

                            Bsp2 task = new Bsp2();
                            task.von = eingabe1 - y;
                            task.bis = eingabe1;
                            Future<Integer> result = executor.submit(task);
                            results.add(result.get());
                            presults.add("Summe der Zahlen " + (eingabe1 - y) + "-" + eingabe1 + ": " + result.get());

                        }

                        for (int i = 0; i < results.size(); i++) {

                            System.out.println(presults.get(i));

                        }
                        System.out.print("Gesamtsumme: ");
                        int sum = 0;
                        for (int i = 0; i < results.size(); i++) {
                            sum = +results.get(i);
                            System.out.print(" " + results.get(i));
                            if (i != results.size() - 1) {

                                System.out.print(" +");

                            }

                        }
                        System.out.print(" = " + sum + "\n");

                    } else {

                        System.out.println("! i -> (>100)");

                    }

                    break;
                case 3:

                   b3.run();

                    break;

            }

        } while (true);
    }
    
    public ArrayList<Integer> readFile(String filename) throws FileNotFoundException, IOException {
         ArrayList<Integer> list = new ArrayList<>();
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
        while ((line = br.readLine()) != null) {

            String[] arr = line.split(":");
            for (int i = 0; i < arr.length; i++) {

                if (checkIfnull(arr[i])) {

                        try {
                        list.add(Integer.parseInt(arr[i]));
                    } catch (Exception e) {
                        
                        
                    }
                        

                    

                }

            }

        }
        
        return list;

    }
      public boolean checkIfnull(String x) {

        if (x == null || x == "") {

            return false;

        }


        return true;
    }


}
