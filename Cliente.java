/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author informatica
 */
public class Cliente extends Thread{
    private int hamburger;
    private Bancone banco;
    
    public Cliente(Bancone b){
        banco = b;
    }
    
    @Override
    public void run(){
        
        hamburger = banco.prendiHamburger();//Il cliente prende e consuma il suo Hamburger
        
    }
}
