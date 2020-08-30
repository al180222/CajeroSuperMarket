package cajera2;
public class Dinero {
    
    private float pago;
    private float cambio;
    
    public Dinero(){
        this.cambio = 0;
        this.pago = 0;
    }
    
    public float getPago(){
        return pago;
    }
    
    public void setPago(float pago){
        this.pago = pago;
    }
    
    public float getCambio(){
        return cambio;
    }
    
    public void setCambio(float cambio){
        this.cambio = cambio;
    }
    
    public void verificarDinero(float costoFinal, float pago ){
        if (pago <= costoFinal){
            System.out.println("Lo sentimos, no alcanza a pagar la cuenta, le faltan: " + "$" + (costoFinal - pago) );
        }
        else{
            System.out.println("Su cambio es de: " + "$" + (pago - costoFinal));
        }
    }
    
}
