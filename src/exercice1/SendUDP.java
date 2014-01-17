package exercice1;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class SendUDP {
	private DatagramSocket socket;
	private InetAddress destinary;
	
	public SendUDP(String target, int port, String msg) {
		try {
			// On crée un socket sans définir de port, c'est le paquet qui viendra définir sur quel port est envoyé le message
			socket = new DatagramSocket();
			
			// On crée l'adresse du destinataire à l'aide de son "nom" sur le réseau
			destinary = InetAddress.getByName(target);
			
			// Un tableau de byte est nécessaire pour l'envoie du paquet
			byte[] buf = msg.getBytes();
			
			// Création du paquet qui sera envoyé sur le réseau via le socket
			DatagramPacket paquet = new DatagramPacket(buf, buf.length,destinary,port);
			
			// On envoie le paquet
			socket.send(paquet);
			System.out.println("Sending message done");
			
			socket.close();
		} catch (Exception e) {
			System.out.println("Sending message fail");
			e.printStackTrace();
		}
	}
	

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendUDP sender = new SendUDP(args[0], Integer.parseInt(args[1]), args[2]);
	}

}
