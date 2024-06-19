/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeumineurs;

/**
 *
 * @author aya
 */
public abstract class Case {

    
    
    
   
    protected int indCase;
    protected int Ligne;
    protected int Colonne;
    protected boolean estFinie;
    protected int isAf;
    protected Plateau pt;
    
    public Case(Plateau plt, int l, int c){  
            this.pt = plt;
            this.Ligne = l;
            this.Colonne = c;
    }
    
    public abstract boolean getEstFinie();
         
    public abstract int getIndCase();
    
    public abstract void activation();

   public int getIsAf(){
        return this.isAf;
    }
   
   public void setIsAf(){
        this.isAf = 1;
    }
         

}
