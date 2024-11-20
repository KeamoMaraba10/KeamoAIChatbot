
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChatApplication extends JFrame {

	private JTextArea chatArea;
	private JTextField messageField;
	
	public ChatApplication() {
		
		 setTitle("Chatbot");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(400, 300);
	        setLayout(new BorderLayout());

	        // Chat Header
	        JLabel headerLabel = new JLabel("KeamoAI", SwingConstants.CENTER);
	        add(headerLabel, BorderLayout.NORTH);

	        // Chat Area
	        chatArea = new JTextArea();
	        chatArea.setEditable(false);
	        JScrollPane scrollPane = new JScrollPane(chatArea);
	        add(scrollPane, BorderLayout.CENTER);

	        // Message Input Field
	        JPanel inputPanel = new JPanel(new BorderLayout());
	        messageField = new JTextField();
	        inputPanel.add(messageField, BorderLayout.CENTER);
	        JButton sendButton = new JButton("Send");
	        sendButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                sendMessage();
	            }
	        });
	        inputPanel.add(sendButton, BorderLayout.EAST);
	        add(inputPanel, BorderLayout.SOUTH);

	        setVisible(true);
		
	}
	
	private void sendMessage() {
		
		
		String message = messageField.getText();
        if (!message.isEmpty()) {
            appendMessage("You: " + message);
            // Simulate receiving a response
            appendMessage(Robot.chatBot(message));
            messageField.setText("");
        }
	}
	
	private void appendMessage(String message) {
		
		chatArea.append(message + "\n");
	}
	
	

	
}
