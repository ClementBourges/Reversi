package fr.isima.business;

import java.util.Scanner;

/* On part du principe qu'au tour 5 c'est les blanc qui commencent */
/* Les pions blanc sont representé par un 1 dans la matrice */
public class MoteurJeu {
    public int tour= 4;

    /* Verifie qu'un coup est valide */
    /* Le joueur est le joueur qui veut poser un pion*/
    /* x,y est la position ou joueur veut placer un pion*/
    public boolean isValide(Grille grille,int joueur,int x, int y) {
        boolean b=false;
        int i=x;
        int j=y;
        int pion_adverse = 3 - joueur; /* Permet d'obtenir la valeur du pion adverse*/
        while ((grille.matrice[i][j]==pion_adverse)&&(x<8 & y<8)){
            i++;
            j++;
        }
        if ((x<8 & y<8)&grille.matrice[i][j]==0){
            b=true;
        }
        return b;
    }

    /* Retourne le nombre de points du joueur 1, permet de calculer qui à gagne */
    public int comptePoint(Grille grille) {
        int somme_j1 =0;
        for (int i=0;i<grille.matrice.length;i++){
            for (int j=0;j<grille.matrice.length;j++){
                if (grille.matrice[i][j]== 1) {
                    somme_j1 += 1;
                }
            }
        }
        return somme_j1;
    }

    public int min(int a,int b){
        if (a<b){
            return a;
        }
        else{
            return b;
        }
    }
    public int max(int a,int b){
        if (a<b){
            return b;
        }
        else{
            return a;
        }
    }

    /* Changement de couleurs des pions entre 2 positions */
    public void changerCouleur(int i,int j, int x, int y,int tour_joueur,Grille grille){
        for (int k=min(i,x);k<max(i,x);k++){
            for (int l=min(j,y);l<max(j,y);l++){
                grille.matrice[i][j]=tour_joueur;

        }

        }

    }
    /* On parcourt la grille dans les 8 directions et on change tous les pions concernes*/
    public void effectuerCoup(Grille grille,int tour_joueur,int x,int y){
        int i=x;
        int j=y;
        while (grille.matrice[i][j]==3 -tour_joueur){ /* Tant que pion adverse*/
            /*diagonale bas droite*/
            i++;
            j++;
        }
        if (grille.matrice[i][j]== tour_joueur) {
            changerCouleur(i,j,x,y,tour_joueur,grille);
        }
        i=x;
        j=y;
        while (grille.matrice[i][j]==3 -tour_joueur){ /* Tant que pion adverse*/
            /*diagonale haut gauche*/
            i--;
            j--;
        }
        if (grille.matrice[i][j]== tour_joueur) {
            changerCouleur(i,j,x,y,tour_joueur,grille);
        }
        i=x;
        j=y;
        while (grille.matrice[i][j]==3 -tour_joueur){ /* Tant que pion adverse*/
            /* diagonale haut droite*/
            i++;
            j--;
        }
        if (grille.matrice[i][j]== tour_joueur) {
            changerCouleur(i,j,x,y,tour_joueur,grille);
        }
        i=x;
        j=y;
        while (grille.matrice[i][j]==3 -tour_joueur){ /* Tant que pion adverse*/
            /* diagonale bas gauche */
            i--;
            j++;
        }
        if (grille.matrice[i][j]== tour_joueur) {
            changerCouleur(i,j,x,y,tour_joueur,grille);
        }
        i=x;
        j=y;
        while (grille.matrice[i][j]==3 -tour_joueur){ /* Tant que pion adverse*/
            /* vers la droite */
            i++;
        }
        if (grille.matrice[i][j]== tour_joueur) {
            changerCouleur(i,j,x,y,tour_joueur,grille);
        }
        i=x;
        j=y;
        while (grille.matrice[i][j]==3 -tour_joueur){ /* Tant que pion adverse*/
            /* vers la gauche*/
            i--;

        }
        if (grille.matrice[i][j]== tour_joueur) {
            changerCouleur(i,j,x,y,tour_joueur,grille);
        }
        i=x;
        j=y;
        while (grille.matrice[i][j]==3 -tour_joueur){ /* Tant que pion adverse*/
            /* vers le haut */
            j--;
        }
        if (grille.matrice[i][j]== tour_joueur) {
            changerCouleur(i,j,x,y,tour_joueur,grille);
        }
        i=x;
        j=y;
        while (grille.matrice[i][j]==3 -tour_joueur){ /* Tant que pion adverse*/
            /*vers le bas*/
            j++;
        }
        if (grille.matrice[i][j]== tour_joueur) {
            changerCouleur(i,j,x,y,tour_joueur,grille);
        }
    }

    public void partieEntiere(Grille grille){
        int tour_joueur = 1; /* Joueur blanc commence*/
        while (tour!=64){
            x,y = demanderPosition(); /* Comment on obtient la case ???*/
            if (isValide(grille,tour_joueur,x,y) {
                effectuerCoup(grille,tour_joueur,x,y);
            }
            tour++;
        }
        int point=comptePoint(grille);
        if (point > 32){
            System.out.print("Joueur 1 gagne avec ");
            System.out.println(point);
            System.out.print("Joueur 2 a ");
            System.out.println(64-point);
        }
        else {
            System.out.print("Joueur 2 gagne avec ");
            System.out.println(64- point);
            System.out.print("Joueur 1 a ");
            System.out.println(point);
        }
    }
}
