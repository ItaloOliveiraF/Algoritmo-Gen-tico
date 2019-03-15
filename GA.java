/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author italo
 */
public class GA {

    /**
     * @param args the command line arguments
     */
    static LinkedList<Cromossomo> criarPopulacao(int n){
        LinkedList<Cromossomo> populacao = new LinkedList<>();
        for(int i=0;i<n;i++){
            populacao.add(new Cromossomo());
        }
        return populacao;
    }
    
    
    
    
    public static void main(String[] args) {
        
        float txMut = 0.01f;
        int populacaoTotal = 100;
        
        
        LinkedList<Cromossomo> populacao=criarPopulacao(populacaoTotal);
        System.out.println("População 1");
        for(int i=0;i<populacaoTotal;i++){
                System.out.println(populacao.get(i).aptidao);
            }
        
        int geracao = 1;
        while(geracao < 1000){
            System.out.println("---------------Geração " + ++geracao);
            ArrayList<Cromossomo> mattingPool = new ArrayList<>();
            for(int i=0;i<populacaoTotal;i++){
                int n= (int)populacao.get(i).aptidao;

                for(int j=0;j<n;j++){
                    mattingPool.add(populacao.get(i));
                }
            }

            for(int i=0;i<populacaoTotal;i++){
                Random gen= new Random();
                int a = gen.nextInt(mattingPool.size());
                int b = gen.nextInt(mattingPool.size());
                Cromossomo parceiroA= mattingPool.get(a);
                Cromossomo parceiroB= mattingPool.get(b);

                Cromossomo filho=parceiroA.crossover(parceiroB);
                filho.mutar(txMut);
                filho.avaliar();

                populacao.set(i, filho);
            }
            
            for(int i=0;i<populacaoTotal;i++){
                System.out.println(populacao.get(i));
            }
        }
        
        
    }
    
}
