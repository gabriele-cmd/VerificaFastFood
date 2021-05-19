
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author informatica
 */
public class Bancone {
    private int ordinazione = 1;
    private int hamburgerBancone = 1;
    
    private Semaphore semVuoto = new Semaphore(1);
    private Semaphore semPieno = new Semaphore(0);
    
    public void depositaOrdinazione(int ordine){
        
        try{
            semVuoto.acquire();//Il cliente deposita l'ordine sul bancone in attesa che il commesso lo porti in cucina
        }catch(InterruptedException e) {  }
        
        try{
            Thread.sleep((int) Math.random() * 300);//Tempo randomico che il cliente impiega a fare l'ordinazione
        }catch(InterruptedException e) {  }
        
        ordinazione = ordine;
        System.out.println("Il cliente n." + ordine + "ha depositato il suo ordine sul Bancone.");
        semPieno.release();
        
    }
    
    public int prendiOrdinazione(){
        
        try{
            semPieno.acquire();//Il commesso prende l'ordinazione dal bancone
        }catch(InterruptedException e) {  }
        
        int o = ordinazione;
        System.out.println("L'ordinazione del cliente n." + o + "è stata portata in cucina.");
        
        try{
            Thread.sleep((int) Math.random() * 100);//Tempo che ci impiega il commesso ad arrivare al bancone e prenderel'ordine
        }catch(InterruptedException e) {  }
        
        
        semVuoto.release();
        
        return o;
    }
    
    public void depositaHamburger(int hamburger){
        
        try{
            semVuoto.acquire();//Il commesso porta al cliente il suo hamburger
        }catch(InterruptedException e)  {  }
        
        try{
            Thread.sleep((int) Math.random() * 200);//Tempo che ci impiega il commesso a consegnare al cliente l'hamburger ordinato
        }catch(InterruptedException e)  {  }
        
        hamburgerBancone = hamburger;
        System.out.println("L'hamburger n. " + hamburger + " è stato consegnato al cliente");
        semPieno.release();
        
    }
    
     public int prendiHamburger(){
        
        try{
            semPieno.acquire();//Il cliente aspetta l'hamburger e lo prende dal bancone
        }catch(InterruptedException e)  {  }
        
        int h = hamburgerBancone;
        System.out.println("L'hamburger n. " + h + " è stato consumato dal cliente");
        
        try{
            Thread.sleep((int) Math.random() * 100);//Tempo che impiega il cliente a consumare il piatto
        }catch(InterruptedException e)  {  }
        
        semVuoto.release();//Il commesso può ora ricevere un altro ordine e il cuoco può cucinare un altro hamburger
        
        return h;
    }
}
