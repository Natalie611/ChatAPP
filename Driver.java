import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Driver {
	int count = 0;
	static HashMap<String, windowGUI> map = new HashMap<>();
	public static Socket mySocket = new Socket(64000, Socket.SocketType.NoBroadcast);

	public Driver(String ip, int port, InetAddress dest) {

		if (map.containsKey(ip)) {
			windowGUI currentChat = map.get(ip);
			String text = currentChat.msg.getText();
			currentChat.ChatHistory.append("Me: " + text + '\n');
			currentChat.msg.setText("");
			mySocket.send(text, dest, port);

		} else {
			windowGUI chatWindow = new windowGUI(dest, port);
			map.put(ip, chatWindow);
		}

	}

	

	public static void main(String[] args) {
		
		
		new connectFrame().setVisible(true);
		

		
		DatagramPacket hello = null;

		do {

			System.out.println("Just woke up!!");

			

			hello = mySocket.receive();
			
			
			if (hello == null) {
				
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
					System.exit(-1);
				}
			
			
			}
			
			else {	
				
					byte[] inBuffer = new byte[100];
					for (int i = 0; i < inBuffer.length; i++) {
						inBuffer[i] = ' ';
					}
					
					inBuffer = hello.getData();
					
					String inMsg = new String(inBuffer);
					
					System.out.println("inMsg = " + inMsg);
					
					
					InetAddress senderAddress = hello.getAddress();
					int senderPort = hello.getPort();
		
					
		
					String ipsender = senderAddress.getHostAddress();
		
					if (!(map.containsKey(ipsender))) {
						windowGUI chatWindow = new windowGUI(senderAddress, senderPort);
						map.put(ipsender, chatWindow);
						chatWindow.ChatHistory.append("You: " + inMsg + '\n');
						
		
					} else {
		
						windowGUI currentChat = map.get(ipsender);
						currentChat.ChatHistory.append("You: " + inMsg + '\n');
						
						System.out.println(inMsg);
		
					}
			
			}
			

		} while (true);

	}

}
