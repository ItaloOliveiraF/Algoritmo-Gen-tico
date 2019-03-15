/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga;

import java.util.Random;

/**
 *
 * @author italo
 */
public final class Cromossomo {
    float x1;
    float x2;
    float aptidao;
    
    Cromossomo(){
        Random g = new Random();
        x1=10*g.nextFloat()-5;
        x2=10*g.nextFloat()-5;
        avaliar();
    }
    
    Cromossomo(float x1, float x2){
        this.x1=x1;
        this.x2=x2;
        avaliar();
    }
    
    public void avaliar(){
        aptidao = (float)Math.pow(Math.pow((Math.pow(x1,2)+x2-11),2)+Math.pow((x1+Math.pow(x2,2)-7),2)+10, -1)*10000000;
        //aptidao = (float)Math.pow((-(x2+47)*((float)Math.sin(Math.sqrt(Math.abs(x2+x1/2+47))))-x1*((float)Math.sin(Math.sqrt(Math.abs(x1-(x2+47))))) + 1000), -1)*100000;
    }
    
    public Cromossomo crossover(Cromossomo parceiro){
        Cromossomo filho = new Cromossomo(x1, parceiro.x2);
        return filho;
    }
    
    public void mutar(float txMut){
        Random g = new Random();
        if(g.nextFloat()<txMut){
            if(g.nextInt(2)==0){
                x1=x1+(10*g.nextFloat()-5);
                if(x1>5)
                    x1=5;
                else if(x1<-5){
                    x1=-5;
                }
            }
            else{
                x2=x2+(10*g.nextFloat()-5);
                
                if(x1>5)
                    x2=5;
                else if(x1<-5){
                    x2=-5;
                }
            }
        }
        
    }
    
    
    @Override
    public String toString(){
        
        return "("+x1+','+x2+')';
    }
}
