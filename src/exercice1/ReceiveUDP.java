package exercice1;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;

public class ReceiveUDP {
	private DatagramSocket socket;
	private final static int buff_size=1024;
	
	public ReceiveUDP (int port) {
		try {
			// On crée un socket en lui donnant un port, ce qui permettra d'écouter ce port
			socket = new DatagramSocket(port);
			listen();
			
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	
	public void listen () {
		// On crée un tableau de byte afin de récupérer les données du paquet
		byte[] buffer = new byte[buff_size];
		DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);	
		
		while(true){
			try {
				// Ici le paquet reçoit ses données à l'aide de la méthode receive() du socket
				socket.receive(paquet);
				
				System.out.println("Nouveau message : ");
				// Une conversion des données byte en String est nécessaire pour l'affichage du message
				System.out.println(new String(paquet.getData()));
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReceiveUDP listener = new ReceiveUDP(Integer.parseInt(args[0]));
	}
}
