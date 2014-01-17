package exercice3;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiveUDP extends Thread {
	public static MulticastSocket socket;
	private final static int buff_size=1024;
	private final static String group="224.0.0.1";
	private final static int port=7654;
	
	public ReceiveUDP () {
		try {
			socket = new MulticastSocket(port);
			socket.joinGroup(InetAddress.getByName(group));		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void listen () {
		byte[] buffer = new byte[buff_size];
		DatagramPacket p = new DatagramPacket(buffer, buffer.length);	
		
		while(true){
			try {
				socket.receive(p);
				System.out.println("Message de " + p.getAddress().getHostName().toString() + " : " + new String(p.getData()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void run() {
		listen();
		socket.close();
	}
	
}
