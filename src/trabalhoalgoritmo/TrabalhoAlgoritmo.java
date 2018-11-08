/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoalgoritmo;

/**
 *
 * @author Vinícius Vieira, Adroan e Eduardo
 */


public class TrabalhoAlgoritmo {

    
    public static void main(String[] args) {
        
    }
    
    public String getDescricao() {
        return
        "Este problema consiste em posicionar 8\n" +
        "numeros em um tabuleiro 3x3 na seguinte disposcao:\n"+
        "1 2 3\n"+
        "8 0 4\n"+
        "7 6 5\n"+
        "sendo que o espaco pode se mover.\n";
    }
    
     public static final short tamanho = 3; // Tamanho padrão da linha e coluna
    
    int[][] tabuleiro = new int[tamanho][tamanho]; // Cria o tabuleiro 3x3 do jogo
    int colunaBranco = -1; // Como não se sabe ainda a posição em branco...
    int linhaBranco = -1; // Como não se sabe ainda a posição em branco...
    
     /**
     *  Cria um estado inicial (aleatorio)
     */
    public TrabalhoAlgoritmo() {
        for (int i=0;i< (tamanho*tamanho);i++) {
            // tenta até achar uma posicao livre
            int linha = Math.round( (float)(Math.random()*(tamanho-1)) ); //Gera um número de 0 a 2
            int coluna = Math.round( (float)(Math.random()*(tamanho-1)) ); //Gera um número de 0 a 2
            while (tabuleiro[linha][coluna] != 0) { //Verifica se a posição é diferente de 0, sendo que os vetores iniciam em 0
                linha = Math.round( (float)(Math.random()*(tamanho-1)) ); // Seta um novo valor entre 0 e 2 para a linha
                coluna = Math.round( (float)(Math.random()*(tamanho-1)) ); // Seta um novo valor entre 0 e 2 para a coluna
            }
            tabuleiro[linha][coluna] = i; //Seta o valor de i para a posição escolhida aleatoriamente
        }
        setPosBranco(); // O método procura a posição no tabuleiro que possui o valor 0
    }
    
    public void setPosBranco() {  // O método procura a posição no tabuleiro que possui o valor 0
        for (int linha=0;linha<tamanho;linha++) {
            for (int coluna=0;coluna<tamanho;coluna++) {
                if (tabuleiro[linha][coluna] == 0) { // Se o valor é 0 seta a posição em colunaBranco e linhaBranco
                    colunaBranco = coluna;
                    linhaBranco = linha;
                }
            }
        }
    }
    
}
