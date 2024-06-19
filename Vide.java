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
public class Vide extends Case {
    public Vide(Plateau p,int l,int c,int i){ 
        super(p,l,c);
        this.indCase = i;
        this.estFinie = false;
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
        voisinage(pt,Ligne,Colonne,pt.getCase(Ligne,Colonne).getIsAf(),1);
        if(pt.getNbCase() !=0){
        System.out.println(this.pt.affichePlateau());
        }
        else{
        for(int i=0;i<pt.getD();i++){
            for(int j=0;j<pt.getD();j++){
                if(pt.getCase(i,j).getIndCase() == 9)
                    pt.setCase(i,j,9);
            }
         }
        System.out.println(this.pt.affichePlateau());
        System.out.println("Vous avez gagné !");
        }
    }
    
    public void voisinage(Plateau  tab,int l, int c,int avant,int nouveau){  //
       if(l<0 || l >=tab.getD() || c<0  || c>=tab.getD())
           return;
      if(tab.getCase(l,c).getIsAf() != avant)
          return;
      if(tab.getCase(l,c).getIndCase() == 9)
          return;
      
        tab.setNbCase(tab.getNbCase()-1);
        tab.getCase(l,c).setIsAf();
        tab.setCase(l,c,tab.getCase(l,c).getIndCase());
        
        if(l+1<tab.getD() && tab.getCase(l+1,c).getIndCase() != 9){
           voisinage(tab,l+1,c,avant,nouveau);
        }
        else
            return;
        if(l-1>=0 && tab.getCase(l-1,c).getIndCase() != 9){ 
            voisinage(tab,l-1,c,avant,nouveau);
        }
        else
            return;
        if(c+1<tab.getD() && tab.getCase(l,c+1).getIndCase() != 9){
            voisinage(tab,l,c+1,avant,nouveau);
        }
        else
            return;
        if(c-1>=0 && tab.getCase(l,c-1).getIndCase() != 9) {
            voisinage(tab,l,c-1,avant,nouveau);     
        }
        else
            return;
    }

}