package juego_de_datos;

//@author AsCraft Contreras

import java.util.Scanner;

public class Interfaz {
    Dado d1 = new Dado(6);
    Dado d2 = new Dado(6);
    
    /** Menu
     *  Enumera las opciones del programa.
     */
    public void menu(){
        System.out.println("1.Lanzar dados");
        System.out.println("2.Salir");
        accion(validar(2));
    }
    /** validarMenu
     *  @param n:int (número de opciones en el menu)
     *  @return opcion:int (número de la opcion del usuario)
     *  Pregunta al usuario que quiere hacer esperando un entero como respuesta.
     */
    private int validar(int n){
        Scanner in = new Scanner (System.in);
        int opcion;
        try{
            opcion= in.nextInt();
        }catch(Exception e){
            System.err.println("Eso no es una opcion");
            opcion=validar(n);
        }      
        if(opcion>n||opcion<1){
            System.err.println("Eso no es una opcion");
            opcion=validar(n);
        }       
        return opcion;
    }
    /** accion
     *  @param opcion:int (numero de la opcion del usuario)
     *  Switch con las acciones a realizar por opcion del menu.
     */
    private void accion(int opcion){
        switch(opcion){
            case 1:
                lanzarDados();
                decirResultado(esVictoria(sumarPuntaje()),sumarPuntaje());
                menu();
            case 2:
                System.exit(0);
        }
    }
    /**lanzarDados
     * Lanza los dos dados usando el metodo lanzarDado de cada Dado.
     */
    private void lanzarDados(){
        d1.lanzarDado();
        d2.lanzarDado();
    }
    /**sumarPuntaje
     * @return suma de los dos dados
     */
    private int sumarPuntaje(){
        return d1.getValorActual()+d2.getValorActual();
    }
    /**esVictoria
     * @param suma (Suma de las cantidades del los dados)
     * @return si ha ganado o no.
     */
    private boolean esVictoria(int suma){
        boolean victoria=false;
        if(suma==7){
            victoria=true;
        }
        return victoria;
    }
    /**decirResultado
     * Enuncio los resultados del juego.
     * @param victoria
     * @param suma 
     */
    private void decirResultado(boolean victoria, int suma){    
        System.out.println("----------------------------");
        System.out.println("El dado 1 dio: "+d1.getValorActual());
        System.out.println("El dado 2 dio: "+d2.getValorActual());
        System.out.println("Su suma fue de: "+suma);
        if(victoria){
            System.out.println("¡Ha ganado!");
        }else{
            System.out.println("Suerte para la proxima.");
        }
        System.out.println("----------------------------");
    }
}
