/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoe4;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Max
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Bsp1 b = new Bsp1();
        
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("1.. Bsp1");
            System.out.println("2.. Bsp2");
            System.out.println("3.. Bsp3");

            int heingabe = Integer.parseInt(in.nextLine());
            int eingabe1;
            int eingabe2;

            switch (heingabe) {

                case 1:
                    System.out.println("Teiler?");
                    eingabe1 = Integer.parseInt(in.nextLine());
                    System.out.println("Wieviele Teile?");
                    eingabe2 = Integer.parseInt(in.nextLine());
                    
                    
                    ThreadPoolExecutor executor = (ThreadPoolExecutor) 
                     Executors.newFixedThreadPool(eingabe2);
                    
                    for(int i = 0;i<eingabe2;i++)
                    {
                    
                        Bsp1 task = new Bsp1();
                        task.readFile("numbers.csv");
                        task.cutArray(eingabe2, i, eingabe1);
                        executor.execute(task);
                    }
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;

            }

            System.out.println("Teiler?");
            eingabe1 = Integer.parseInt(in.nextLine());
            System.out.println("Wieviele Teile?");
            eingabe2 = Integer.parseInt(in.nextLine());

        } while (true);
    }

}
