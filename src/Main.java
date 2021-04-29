import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main implements ActionListener {
	
	///Creating Topic choice menu using swing
	JFrame frame=new JFrame();
	JLabel label=new JLabel("Select Topic :");
	JComboBox<String> menu=new JComboBox<String>();
	JButton button =new JButton("Procced");	
	
	Main() {
		
		///Setting GUI component's bounds
		button.setBounds(170,250,100,30);
		button.addActionListener(this);
		
		menu.setBounds(150,200,150,30);
		menu.setBackground(null);
		
		label.setBounds(170, 150, 200, 50);
		label.setForeground(new Color(255,255,255));
		label.setFont(new Font("MPONOSPACED",Font.BOLD,15));
		
		///Adding topics to ComboBox
		menu.addItem("Cryptography");
		menu.addItem("Blockchain");
		
		///Adding components to frame and setting up frame
		frame.add(button);
		frame.add(menu);
		frame.add(label);
		frame.setSize(500,500);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(38,38,38));
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	///Redirecting to paticular topic which is selected (using ActionListener)
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String choice=menu.getSelectedItem().toString();
	
		///disposing the frame after the topic is selected
		if(choice=="Cryptography") {
			frame.dispose();
			new TopicOne();
		}
		else {
			frame.dispose();
			new TopicTwo();
		}
	}
	
	public static void main(String args[]) {
		///calling the constructor
		new Main();
	}
}

