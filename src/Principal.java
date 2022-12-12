import java.time.LocalTime;

public class Principal {

	public static void main(String[] args){

        Parking parking = new Parking();
        int[] plazas = new int[6];
        Coche[] coche = new Coche[15];
        int tiempo;       
        
        LocalTime horaActual;
        LocalTime horaCierre = LocalTime.parse("18:00:00");
        LocalTime horaApertura = LocalTime.parse("18:01:00");
        
        Thread[] c = new Thread[15];

        
        for(int i=1; i<16; i++){   
        	horaActual = LocalTime.now();       	
        	tiempo = (int) (Math.random() * (3000 - 1500)) + 1500;
            coche[i] = new Coche(parking, i);
            c[i] = new Thread(coche[i]);
            
            if(horaActual.isAfter(horaCierre) && horaActual.isBefore(horaApertura)) {		        			        	
	        	System.out.println("PARKING CERRADO MOMENTÁNEAMENTE");			
	        	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        i--;	
				continue;			        	
        	}
            
            c[i].start();
            
            try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
        	            
    }
}
