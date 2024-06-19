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
public class Jeu {
    private int coup;
    private boolean etat;
    private Plateau pt;
        
    public Jeu(){
        this.etat = false;
       this.coup =0; // compteur inisialisé en 1 et pour compte le nombre des coups à jouer.
    }
        
    public void jeu(){
        int l,c,d,t,n;
        
        
       
        System.out.println(" Veuillez saisir la dimension du tableau :    ");// demander à l'utilisateur de choisir la dimension 
        t= Lire.i();
        //2-la difficulté du jeu avec le calcul de nombre des mines  
         do{
        System.out.println("Choisissez le niveau du jeu (1,2,3…) :");// Demander à l'utilisateur de choisir le niveu de jeu
        d = Lire.i();
        }while(d>=10);  
        n = (t*t*d)/10;// calcul du nombre des mines 
        System.out.println("Vous devez trouver " +n+ " mines"); // affichage de nombre des mines 
        this.pt = new Plateau(n,t);  
        this.pt.initPlateauCase();//appel de la methode initPlateauCase()
        this.pt.initPlateau(); //appel de la methode initPlateau()
        this.pt.remplirMine();//appel de la methode remplirMine()
        
        System.out.println(this.pt.affichePlateau()); // appel de la methode afficher pour afficher le plateau 
        do{
            this.coup++;
                System.out.println("Veuillez jouer pour le coup : " + this.coup); // affichage du coup à jouer
        //3- choix d'une case
        do{
            System.out.println("Choisissez une case "); // demander a l'utilisateur de choisir la case 
            System.out.println(" ligne");  // deamnder à l'utilisateur de choisir la ligne de la case
            l = Lire.i();
            System.out.println("colonne");// deamnder à l'utilisateur de choisir la colonne de la case
            c = Lire.i();
            
        }while(l>t+1 || c>t+1 || c<0 || l<0);
        
         //si la case contient une mine son activation provoque li fin du jeu et dévoile toutes les autres case du plateau 
        if(pt.getCase(l,c).getEstFinie() == true){ 
                pt.getCase(l,c).activation();                
                this.etat = true;
                   
                System.out.println("Vous avez perdu en " +this.coup +" coups");
        }
        //si la case est vide et n'a aucune mine dans son entourage, toutes ses cases vides adjacentes sont dévoilées.
        else{
                pt.getCase(l,c).activation();
                this.etat = false;
                this.coup++;
                System.out.println(" vous avez gagné en "+coup +"coups");
                
                
        }
        
        }while(pt.getNbCase() != 0 && this.etat == false);
    }
}
