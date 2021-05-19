/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author informatica
 */
public class Commesso extends Thread{
    private int ordine;
    private Bancone banco = new Bancone();
    private Scaffale scaf = new Scaffale();
    private int numClienti;

    public Commesso(Bancone b, Scaffale s, int clienti) {
        banco = b;
        scaf = s;
        numClienti = clienti;
    }
    
    @Override
    public void run(){
        
        while(numClienti > 0){//Il commesso prende ordinazioni fin quando ci sono clienti da servire
            
            banco.prendiOrdinazione();//Il commesso prendere l'ordinazione dal banco
            ordine = scaf.prelevaHamburger();//la porta in cucina e ritira l'hamburger preparato dal cuoco
            banco.depositaHamburger(ordine);//infine consegna al cliente l'hamburger ordinato
            
            ordine++;
            
            numClienti--; //un cliente è stato servito, possiamo passare all'altro
        }
    }
}
