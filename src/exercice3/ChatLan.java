package exercice3;

public class ChatLan {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {		
		ReceiveUDP listener = new ReceiveUDP();
		SendUDP sender = new SendUDP();
		
		listener.start();
		sender.start();
		
	}

	

}
