package cajera2;
import java.util.Scanner;
public class Cajera2 {

    static int contador = 0;
    static float costoFinal = 0;
    static Dinero efectivo = new Dinero();
    static String nombreProducto[] = new String[100];
    static int cantidadProducto[] = new int[100];
    static float costoProducto[] = new float[100];
    
    public static float entrada1(String mensaje){
        Scanner lectura1 = new Scanner(System.in);
        System.out.println(mensaje);
        return lectura1.nextFloat();
    }
    
    public static String entrada2(String mensaje){
        Scanner lectura2 = new Scanner(System.in);
        System.out.println(mensaje);
        return lectura2.next();
    }
    public static void lecturaDeDatos(){
        System.out.println("Para dejar de agregar artículos, solo llene los campos con ceros");
        for (int i=0; i<nombreProducto.length; i++){
            nombreProducto[i] = entrada2("Ingrese el nombre del artículo: " + (i+1));
            cantidadProducto[i] = (int)entrada1("Ingrese la cantidad: ");
            costoProducto[i] = cantidadProducto[i] * entrada1("Ingrese su costo");
            costoFinal += costoProducto[i];   
            contador++;
            if (nombreProducto[i] == "0" || cantidadProducto[i] == 0 || costoProducto[i] == 0){
                break;
            }
        }
        System.out.println("El total es de: " + costoFinal);
    }
    
    public static void pedirDinero(){
        efectivo.setPago(entrada1("Ingrese la cantidad con la que va a pagar: "));
        efectivo.verificarDinero(costoFinal, efectivo.getPago());
        efectivo.setCambio((efectivo.getPago()-costoFinal));
    }
    
    public static void ticket(){
        System.out.println("Cantidad\tNombre\t\tCosto");
        for (int i=0; i<contador; i++){
            System.out.println(cantidadProducto[i] + "\t\t"+ nombreProducto[i] + "\t\t" +  costoProducto[i]);   
        }
        System.out.println("Total: " + costoFinal);
        System.out.println("Efectivo: " + efectivo.getPago());
        System.out.println("Cambio: " + efectivo.getCambio());
    }
    public static void main(String[] args) {
        lecturaDeDatos();
        pedirDinero();
        if (efectivo.getPago() < costoFinal){
            System.out.println("No hay ticket que mostrar");
        }
        else{
            ticket();  
        }
    }   
}