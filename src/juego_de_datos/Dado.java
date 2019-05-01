package juego_de_datos;

//@author AsCraft Contreras

import java.util.Random;

public class Dado {
    private int valorTotal;
    private int valorActual;
    
    /**Dado
     * Constructor de un dado de cualquier cantidad de caras.
     * @param valorTotal 
     */
    public Dado(int valorTotal){
        this.valorActual=0;
        this.valorTotal=valorTotal;
    }
    /**getValorTotal
     * @return Caras del dado.
     */
    public int getValorTotal() {
        return valorTotal;
    }
    /**getValorActual
     * @return resultado tras ser lanzado
     */
    public int getValorActual() {
        return valorActual;
    }
    /**lanzarDado
     * Usa la clase random para seleccionar un numero entre 1 y el total de caras del dado.
     */
    public void lanzarDado(){
        Random rnum = new Random();
        this.valorActual = rnum.nextInt(valorTotal)+1;
    }
}
