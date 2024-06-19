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
public class Mine extends Case {
//Constructeur :

    public Mine(Plateau p,int l,int c){
        super(p,l,c);
        this.indCase = 9;
        this.estFinie = true;
        this.isAf = 0;
    }
    
  public int getIsAf(){
     return this.isAf;
    } 
  
     public void setIsAf(){
        this.isAf = 1;
    }
        
     public int getIndCase(){
        return this.indCase;
    }
       
    public boolean getEstFinie(){
        return this.estFinie;
    }
       
    public void activation(){
        this.indCase = 12;
         for(int i=0;i<pt.getD();i++){
            for(int j=0;j<pt.getD();j++){
                if(pt.getCase(i,j).getIndCase() == 9)
                    pt.setCase(i,j,9);
                if(pt.getCase(i,j).getIndCase() == 12)
                    pt.setCase(i,j,12);
            }
         }
        System.out.println(this.pt.affichePlateau());
    }
}
