import java.time.LocalTime;


public class Coche extends Thread{

    int numCoche;
    int numPlaza;
    int tiempoAparcado;
    int tiempoVuelta;
    Parking parking = new Parking();    
    
    LocalTime horaCierre = LocalTime.parse("18:00:00");
    LocalTime horaApertura = LocalTime.parse("18:01:00");
    LocalTime horaActual;

    
    public Coche(Parking parking, int numCoche) {
        this.parking = parking;
        this.numCoche = numCoche;
    }

    
    public void run(){
    	   	
	    	while(true) {
	    		
		        tiempoAparcado = (int) (Math.random() * (20000 - 7000)) + 5000;
		        tiempoVuelta = (int) (Math.random() * (60000 - 30000) + 30000);
		        horaActual = LocalTime.now();
		        		        
		        
		        if(horaActual.isAfter(horaCierre) && horaActual.isBefore(horaApertura)) {		        			        	
			        	System.out.println("PARKING CERRADO MOMENTÁNEAMENTE");			        	
				        	try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						continue;			        	
		        	}
		        		        		       
		        
		        parking.entraCoche(numCoche);
		        
		        try {
		            Thread.sleep(tiempoAparcado);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        		        
		        
		        if(horaActual.isAfter(horaCierre) && horaActual.isBefore(horaApertura)) {		        			        	
		        	System.out.println("PARKING CERRADO MOMENTÁNEAMENTE");			        	
			        	try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					continue;			        	
	        	}
		        		        
		        
		        parking.saleCoche(numCoche);
		        
		        try {
					Thread.sleep(tiempoVuelta);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
    	
    }
}
