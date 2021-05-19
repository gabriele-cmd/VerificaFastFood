
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author informatica
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Bancone banco = new Bancone();
        Scaffale scaffale = new Scaffale();
        ArrayList<Cliente> clientiTotali = new ArrayList<>();
        
        Cuoco cuoco = new Cuoco(scaffale);
        
        for(int i = 0; i < 10; i++)
            clientiTotali.add(new Cliente(banco));
        
        Commesso commesso = new Commesso(banco, scaffale, clientiTotali.size());
        
        commesso.start();
        cuoco.start();
        
        for(Cliente c: clientiTotali){
            
            c.start();

        }
    }
    
}
