
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class connectFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public static String ip;
	public static int port;
	public Socket sock;
	public InetAddress dest;
	static JTextField ipAddress = new JTextField(15);
	static JTextField portNumber = new JTextField(15);
	private JLabel label1 = new JLabel("IP Address: ");
	private JLabel label2 = new JLabel("Port Number: ");

	public static void main(String[] args) {
		new connectFrame().setVisible(true);
		
		
		

			
	
	}
	
	public connectFrame() {
		setTitle("Who you talking to?");
		setSize(400,200);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		add(label1);
		label1.setBounds(20,10,200,30);
		
		add(ipAddress);
		ipAddress.setBounds(120,10,150,30);
		ipAddress.addActionListener(this);
		
		add(label2);
		label2.setBounds(20,50,200,30);
		
		add(portNumber);
		portNumber.setBounds(120,50,100,30);
		portNumber.addActionListener(this);
		System.out.print(ipAddress);
		
	
		
		JButton button = new JButton("New chat");
		add(button);
		button.setBounds(20,150,100,30);
		button.addActionListener(this);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		ip = ipAddress.getText();
		port = Integer.parseInt(portNumber.getText());
		
		
		try {
			dest = InetAddress.getByName(ip);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		windowGUI chatWindow = new windowGUI( dest , port);
		Driver.map.put(ip, chatWindow);
		
		
	}
	
	

}
