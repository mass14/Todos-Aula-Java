package oo.jogo;

import java.util.Random;

public class MapaAna {

    private int[][] dimensao;
    private int[][] obstaculos;

    public static void main(String[] args){
        MapaAna mapa = new MapaAna(5, 5, 4);
        
        for(int i=0; i < mapa.getObstaculos().length ; i++ ){
            System.out.println("Obstáculo " + (i+1) + ": " + "[" + mapa.getObstaculos()[i][0] + ", " + mapa.getObstaculos()[i][1] + "]");
        }
    }    
    
    public MapaAna(int largura, int altura, int numObstaculos) {
        this.dimensao = new int [altura][largura];
        gerarObstaculos(numObstaculos);
    }
    
    private void gerarObstaculos(int numObstaculos){
        this.obstaculos = new int[numObstaculos][2];
        Random posObstaculo = new Random();
        
        for(int i=0; i < numObstaculos ; i++){
            do {
                this.obstaculos[i][0]=posObstaculo.nextInt(this.dimensao.length);    //Coordenada X
                this.obstaculos[i][1]=posObstaculo.nextInt(this.dimensao[0].length); //Coordenada Y
                //System.out.println("Obstáculo "+ i + ": ["+ this.obstaculos[i][0]+","+this.obstaculos[i][1]+"]");
            } while(!validaObstaculo(i));
        }
    }

    public int[][] getDimensao() {
        return dimensao;
    }

    public void setDimensao(int[][] dimensao) {
        this.dimensao = dimensao;
    }

    public int[][] getObstaculos() {
        return obstaculos;
    }

    public void setObstaculos(int[][] obstaculos) {
        this.obstaculos = obstaculos;
    }
    
    public boolean validaObstaculo(int i){
        
        for(int j = 0 ; j < i ; j++){
            //SE (obsX entre (x-1) e (x+1)) E (obsY entre (y-1) e (y+1)) ----> Retorna FALSO
            if (((this.obstaculos[j][0] - 1 <= this.obstaculos[i][0]) && 
            		(this.obstaculos[i][0] <= this.obstaculos[j][0] + 1)) &&
            		((this.obstaculos[j][1] - 1 <= this.obstaculos[i][1]) && 
            		(this.obstaculos[i][1] <= this.obstaculos[j][1] + 1))){
                return false;
            } 
        }      
        
        return true;
    }
    
}