/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author informatica
 */
public class Cuoco extends Thread{
    private Scaffale s;
    private int hamburger = 1;
    
    public Cuoco(Scaffale s){
        this.s = s;
    }
    
    @Override
    public void run(){
        s.depositaHamburger(hamburger);
        hamburger++;
    }
}
