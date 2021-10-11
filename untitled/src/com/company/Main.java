package com.company;

public class Main {

    public static void main(String[] args) {
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        System.out.println(isMutant(dna));

    }
    public static int dimensión(String[] dna){

        return dna.length;

    }
    public static char[][] matriz(String[] dna, int dim){

        char[][] matriz = new char[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matriz[i][j] = dna[i].charAt(j);
            }
        }
        return matriz;

    }
    public static boolean isMutant(String[] dna){
        int dimension = dimensión(dna);
        char[][] matriz = matriz(dna, dimension);
        return (filas(matriz) + columnas(matriz) + diagonales(matriz)) > 1;
    }
    public static int filas(char[][] matriz){
        int aux = 1;
        int coincidencias = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (j+4 <= matriz.length){
                    if(matriz[i][j] == matriz[i][j+1]){
                        aux++;
                        if (aux == 4){
                            coincidencias++;
                            aux = 1;
                            break;
                        }
                    }else{
                        aux = 1;
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return coincidencias;
    }
    public static int columnas(char[][] matriz){
        int aux = 1;
        int coincidencias = 0;

        for (int j = 0; j < matriz.length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                if (i+4 <= matriz.length){
                    if(matriz[i][j] == matriz[i+1][j]){
                        aux++;
                        if (aux == 4){
                            coincidencias++;
                            aux = 1;
                            break;
                        }
                    }else{
                        aux = 1;
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return coincidencias;
    }
    public static int diagonales(char[][] matriz){
        int aux = 1;
        int coincidencias = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i+4 <= matriz.length && j+4 <= matriz.length){
                    for (int k = 0; k < matriz.length; k++) {
                        if(matriz[k+i][k+j] == matriz[k+i+1][k+j+1]){
                            aux++;
                            if (aux == 4){
                                coincidencias++;
                                aux = 1;
                                break;
                            }
                        }else{
                            aux = 1;
                            break;
                        }
                    }
                }
                else{
                    break;
                }
            }
        }
        return coincidencias;
    }
}
