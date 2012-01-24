package mmotest;

import java.net.*;

public class DataParser {

	private static DataParser instance = null;
	 
    private DataParser() {}
    
    DatagramPacket packet;

    public static DataParser getInstance() {
        if (instance == null) {
            instance = new DataParser();
        }
        return instance;        
    }
    
    public void parse(DatagramPacket incpacket) {
    	byte[] buf = new byte[256];
    	int id = (int) buf[0];
    	
    	switch(id) {
    		case 1:
    			login(incpacket); break;
    		case 2:
    			movement(incpacket); break;
    		case 3:
    			action(incpacket); break;
    		default:
    			System.out.println("Unknown ID: " + id);
    	}
    }
	
}
