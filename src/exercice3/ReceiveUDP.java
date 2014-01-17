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
			/* On crée le socket multicast
			 * et on rejoint le groupe multicast. Cette opération est nécessaire que pour l'écoute et non pas pour l'envoie
			 */
			socket = new MulticastSocket(port);
			socket.joinGroup(InetAddress.getByName(group));
			
			/* A la fin de l'opération, penser à quitter le groupe et fermer le socket. 
			 * remarque : on arrive jamais à cette opération vu qu'on ferme le programme dans le shell à l'aide de
			 * Ctrl + C, néanmoins c'est une bonne habitude à prendre
			 */
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* L'opération d'écoute et d'affichage du paquet ne change pas de celle de l'exercice 1, on affiche juste l'adresse
	 * du destinataire en plus
	 */
	public void listen () {
		byte[] buffer = new byte[buff_size];
		DatagramPacket p = new DatagramPacket(buffer, buffer.length);	
		
		while(true){
			try {
				socket.receive(p);
				System.out.println("Nouveau message de " + p.getAddress().getHostName().toString() + " : ");
				System.out.println(new String(p.getData()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void run() {
		listen();
		socket.close();
	}
	
	/*
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReceiveUDP listener = new ReceiveUDP();
	}
	*/
}
