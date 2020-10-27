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
   
    public void berechneTeil(int von,int bis)
    {
    
       int perg = 0;
       for(int i = von;i<=bis;i++)
       {
       
           perg += i;
       
       }
       erg = perg;
    
    }

    @Override
    public Integer call(){
        return erg;
    }
}
