/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Vinícius Vieira, Adroan e Eduardo
 */


public class Estado8Puzzle {

    
    public static void main(String[] args) {
        
    }
    
    public String getDescricao() {
        return
        "Este problema consiste em posicionar 8\n" +
        "numeros em um tabuleiro 3x3 na seguinte disposcao:\n"+
        "1 2 3\n"+
        "4 5 6\n"+
        "7 8 0\n"+
        "sendo que o espaco pode se mover.\n";
    }
    
     public static final short tamanho = 3; // Tamanho padrão da linha e coluna
    
    int[][] tabuleiro = new int[tamanho][tamanho]; // Cria o tabuleiro 3x3 do jogo
    int colunaBranco = -1; // Como não se sabe ainda a posição em branco...
    int linhaBranco = -1; // Como não se sabe ainda a posição em branco...
    
     /**
     *  Cria um estado inicial (aleatorio)
     */
    public Estado8Puzzle() {
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
    
    /**
     * verifica se um estado e igual a outro
     */
    public boolean verificaIgualdade(Object objeto) {
    	if (objeto instanceof Estado8Puzzle) {
            Estado8Puzzle e = (Estado8Puzzle)objeto;
            for (int l=0;l<tamanho;l++) {
                for (int c=0;c<tamanho;c++) {
                    if (tabuleiro[l][c] != e.tabuleiro[l][c]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    Estado8Puzzle(int[][] p) { //Construtor passando uma matriz como parâmetro, cria uam cópia para o tabuleiro
        for (int l=0;l<tamanho;l++) {
            //System.arraycopy(p,0,tabuleiro,0,tam);
            for (int c=0;c<tamanho;c++) {
                tabuleiro[l][c] = p[l][c];
            }
            
        }
    }
    
    public boolean ehMeta() { // Verifica se o tabuleiro é igual ao objetivo, passado o objetivo por parâmetro
        return this.verificaIgualdade(estadoMeta);
    }
    
    private final static Estado8Puzzle estadoMeta = setEstadoMeta();
    
    private static Estado8Puzzle setEstadoMeta() { // Seleciona o estado objetivo a ser alcançado
        Estado8Puzzle estadoMeta = new Estado8Puzzle(new int[][] {{1,2,3},{4,5,6},{7,8,0}});
        estadoMeta.setPosBranco();
        return estadoMeta;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }
    
    
}
