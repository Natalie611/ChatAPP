import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;


import javax.swing.JFrame;
import javax.swing.*;

public class windowGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JTextArea ChatHistory = new JTextArea();
	JPanel panel = new JPanel();
	JTextField msg = new JTextField();
	JButton send = new JButton("Send");
	InetAddress destination = null;
	
	public InetAddress destinationip = null;
	public int destinationport ;
	
	
	
	
	public windowGUI(InetAddress dest , int port ) {
		
		
		
		setTitle("IP address: " + dest + " Port: " + port);
		
		destinationip = dest;
		destinationport = port;
		
		
		setSize(500,500);
		setResizable(true);
		setLocationRelativeTo(null);
		
		setLayout(null);
	    
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		add(panel);
		
		add(ChatHistory);
		ChatHistory.setBounds(20, 20, 450, 360);
		ChatHistory.setEditable(false);
        
		add(msg);
	    msg.setBounds(20, 400, 340, 30);
	    msg.addActionListener(this);
	    
	    add(send);
	    send.setBounds(375, 400, 95, 30);
	    send.addActionListener(this);
	    setVisible(true);
		
	    
	    
	} 
	
	
	
	public static void main(String[] args) {
		
		
	
		
		
		
	
	}
	
	  
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = msg.getText();
        ChatHistory.append("Me: " + text + '\n');
        msg.setText("");
        Driver.mySocket.send(text,destinationip,destinationport);
        
	}
	

}
