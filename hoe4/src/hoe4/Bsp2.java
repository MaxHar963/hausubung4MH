/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoe4;

import java.util.concurrent.Callable;

/**
 *
 * @author Max
 */
public class Bsp2 implements Callable<Integer>{
    
    int erg = 0; 
    int von = 0;
    int bis = 0;
    

    @Override
    public Integer call(){
        int perg = 0;
       for(int i = von;i<=bis;i++)
       {
       
           perg += i;
       
       }
       return perg;
    }
}
