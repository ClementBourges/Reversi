package fr.isima.business;

public class Grille {
    public int[][] matrice=new int[8][8];

    public Grille(){
        int i, j;
        for(i=0; i<matrice.length; i++) {
            for(j=0; j<matrice[i].length; j++) {
                matrice[i][j]=0;
            }
        }
        matrice[3][3]=1;
        matrice[4][4]=1;
        matrice[4][3]=2;
        matrice[3][4]=2;

    }
}
