/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        package jeumineurs;
        import java.util.*;
/**
 *
 * @author aya
 */
public class Plateau {
    
    private int nbCaseVide;
    private String[][] tab2;
    private Case[][] tab;
    private int d;
    private int nbMine;

    public Plateau(int nb,int dim){
        this.nbMine = nb;
        this.d = dim;
        this.nbCaseVide = 0;
        this.tab = new Case[d][d];
        this.tab2 = new String[d][d];
    }
    
    public int getNbMine(){
        return this.nbMine;
    }
    
    public Case getCase(int l,int c) {
        return this.tab[l][c];
    }
      
    public Case[][] getTab(){
        return this.tab;
    }
    
    public void setTab(Case[][] k){
        this.tab = k;
    }
    
    public int getD(){
        return d;
    }
      
  public void setCase(int l,int c,int val){
        switch (val) {
            case 0:
                tab2[l][c] = "{ "+" "+" }";
                break;
            case 9:
                tab2[l][c] = "{ "+"m"+" }";
                break;
            case 12:
                tab2[l][c] = "{ "+"*"+" }";
                break;
            default:
                tab2[l][c] = "{ "+val+" }";
                break;
        }
    }  
   
    public int getNbCase(){
        return this.nbCaseVide;
    }
    
    public void setNbCase(int n){
       this.nbCaseVide = n;
    }
        
   public void initPlateauCase(){
        for(int i=0;i<d;i++){
            for(int j=0;j<d;j++){
                tab[i][j] = new Vide(this,i,j,0); 
                this.nbCaseVide++;
            }
        }
    }
   
     public void initPlateau(){
        for(int i=0;i<d;i++){
            for(int j=0;j<d;j++){
                tab2[i][j] = "{"+i+";"+j+"}"; 
            }
        }
    }
        
    public void remplirMine(){
       int nb=0;
       while(nb < nbMine){
           int i = (int) (Math.random()*d);
           int j = (int) (Math.random()*d);
           if(tab[i][j].getIndCase() != 9){
           this.tab[i][j] = new Mine(this,i,j);
           nb++;
           this.nbCaseVide--;
           }
       }
       
       for(int i=0;i<d;i++){
            for(int j=0;j<d;j++){
                if(tab[i][j].getIndCase() == 9){    
                      for (int k = (i-1) ; k <= (i+1) ; k++){
                        for (int l = (j-1) ; l <= (j+1) ; l++)  {
                            if(k>=0 && k<d && l>=0 && l<d){
                                if(tab[k][l].getIndCase() != 9){
                                    tab[k][l] = new Vide(this,k,l,tab[k][l].getIndCase()+1);
                                }
                        }
            }
            }
                                                 
            }
       }
            
    }
    }
    
     public String affichePlateau(){
        String s ="";
         for(int i=0;i<d;i++){
            for(int j=0;j<d;j++){
                if(j == d-1){
                s+= tab2[i][j]+" ";
                s+="\n";
                }
                else
                s+= tab2[i][j]+" ";
            }
            }
         return s;
    }
}  
    

    
    

