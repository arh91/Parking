
public class Parking {

    int numPlazas = 6;
    int numCoches;
    int tiempo;
    int numPlaza;
    int numIteracion1 = 1;
    int numIteracion2 = 1;
    int numIteracion3 = 1;
    int numIteracion4 = 1;
    int numIteracion5 = 1;
    int numIteracion6 = 1;
    int[] plazas = {0,0,0,0,0,0};
    
    
	public synchronized void entraCoche(int numCoche){
		
        if(numPlazas ==  0){
            System.out.println("No hay plazas disponibles");
            System.out.println("\n");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(numCoche == 1 && numIteracion1 == 1) {
        	cogePlaza(numCoche);
            numIteracion1++;
            return;
        }
        if(numCoche == 2 && numIteracion2 == 1) {
        	cogePlaza(numCoche);
            numIteracion2++;
            return;
        }
        if(numCoche == 3 && numIteracion3 == 1) {
        	cogePlaza(numCoche);
            numIteracion3++;
            return;
        }
        if(numCoche == 4 && numIteracion4 == 1) {
        	cogePlaza(numCoche);
            numIteracion4++;
            return;
        }
        if(numCoche == 5 && numIteracion5 == 1) {
        	cogePlaza(numCoche);
            numIteracion5++;
            return;
        }
        if(numCoche == 6 && numIteracion6 == 1) {
        	cogePlaza(numCoche);
            numIteracion6++;
            return;
        }
        
        
        for(int i=0; i<plazas.length; i++) {
        	
        	if(plazas[i] == 0) {
        		plazas[i] = numCoche;
        		numPlaza = i;
        		System.out.println("El coche "+numCoche+" ocupa la plaza "+numPlaza);
        		numPlazas--;
                
                System.out.println("Plazas disponibles: "+numPlazas);
                System.out.println("\n");
        		break;
        	}
        }                
    }

	
    public synchronized void saleCoche(int numCoche){
    	   	
    	for(int i=0; i<plazas.length; i++) {
    		if(plazas[i] == numCoche) {
    			plazas[i] = 0;
    			numPlaza = i;
    			System.out.println("El coche "+numCoche+" libera la plaza "+numPlaza);
    			break;
    		}
    	}
    	
        numPlazas++;
        
        System.out.println("Plazas disponibles: "+numPlazas);
        System.out.println("\n");
    }
    
    
    public void cogePlaza(int numCoche) {
    	plazas[numCoche-1] = numCoche;
    	System.out.println("El coche "+numCoche+" ocupa la plaza "+(numCoche-1));
		numPlazas--;
        
        System.out.println("Plazas disponibles: "+numPlazas);
        System.out.println("\n");
    }
}
