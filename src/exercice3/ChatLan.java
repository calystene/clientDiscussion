package exercice3;

public class ChatLan {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {		
		ReceiveUDP listener = new ReceiveUDP();
		SendUDP sender = new SendUDP();
		
		System.out.println("Welcome on the multicast project !  (/exit pour quitter)");
		listener.start();
		sender.start();
		
	}

	

}
