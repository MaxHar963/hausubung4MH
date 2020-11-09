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

/**
 *
 * @author Max
 */
public class Bsp1 implements Runnable{

    ArrayList<Integer> list;
    ArrayList<Integer> cutList = new ArrayList<>();
    int teiler = 0;

    public Bsp1(ArrayList<Integer> list) {
        this.list = list;
    }

    

  
    public void printList() {

        list.forEach(System.out::println);

    }

    @Override
    public void run() {
       
        for(int i = 0;i<cutList.size();i++)
        {
        
               if(cutList.get(i) % teiler == 0)
               {
               
                     System.out.println(cutList.get(i));
               
               
               
               }
        
        }
        
        
        
    }
    
    
    public void cutArray(int anzahlTeile,int numteil,int pteiler)
    {
    
           int x = list.size() / anzahlTeile;
           int y = x * numteil;
           for(int i = y;i<y+x;i++)
           {
           
               cutList.add(list.get(i));
           
           
           
           
           }
           
           this.teiler = pteiler;
    
    }

}
