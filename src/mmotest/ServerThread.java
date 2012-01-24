package mmotest;

import java.io.IOException;
import java.net.*;

public class ServerThread extends Thread {

	private boolean running = true;
	private DatagramSocket socket = null;
	private int port = 27015;
	private DataParser dataparser = null;
	
	public ServerThread(int ports) {
		port = ports;
	}
	

	public void run() {
		
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e1) {
			e1.printStackTrace();
		}
		
		dataparser = DataParser.getInstance();
		
		while (running) {
			byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			try {
				socket.receive(packet);

				System.out.println("Connection from: " + packet.getAddress()
						+ ":" + packet.getPort());

				dataparser.parse(packet);
				

			} catch (IOException e) {
				ExceptionHandler.exchandle(e);
			}
		}
		socket.close();
	}

	public void StopThread() {
		running = false;
	}
}