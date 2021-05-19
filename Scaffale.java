
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
public class Scaffale {
    private int hamburgerScaffale = 1;

    
    private Semaphore semVuoto = new Semaphore(1);
    private Semaphore semPieno = new Semaphore(0);
    
    public void depositaHamburger(int hamburger){
        
        try{
            semVuoto.acquire();//Il cuoco, ricevuta l'ordinazione, mette sullo scaffale l'hamburger
        }catch(InterruptedException e)  {  }
        
        try{
            Thread.sleep((int) Math.random() * 500);//Tempo che ci impiega il cuoco a cucinare l'hamburger
        }catch(InterruptedException e)  {  }
        
        hamburgerScaffale = hamburger;
        System.out.println("Il " + hamburger + "° hamburger è pronto!");
        semPieno.release();
        
    }
    
    public int prelevaHamburger(){
        
        try{
            semPieno.acquire();//Il commesso prende l'hamburger dallo scaffale e lo consegna al cliente
        }catch(InterruptedException e)  {  }
        
        int h = hamburgerScaffale;
        System.out.println("Il " + h + "° hamburger è stato preso dal commesso.");
        
        try{
            Thread.sleep((int) Math.random() * 100);//Tempo che impiega il commesso a prendere l'hamburger e a portarlo dal cliente
        }catch(InterruptedException e)  {  }
        
        semVuoto.release();
        
        return h;
    }
}
