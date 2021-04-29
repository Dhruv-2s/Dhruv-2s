import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public abstract class Quiz implements Result {
	
	///Declaring all the variables
	int countdown=10;
	int index;
	int counter=0;
	int totalQuestions;
	char answer;
	int correctGuess=0;
	
	///using Random Class to randomize the question order
	Random random=new Random();
	
	//Declaring all the GUI Components
	JFrame f=new JFrame();
	JTextField seconds=new JTextField();
	JTextField result=new JTextField();
	JTextField question_no=new JTextField();
	JTextArea question=new JTextArea();
	JButton next=new JButton("Next");
	JButton repeat=new JButton("Repeat Topic");
	JButton nextTopic=new JButton("Next Topic");
	//GUI Components for the option list
	JLabel optionA=new JLabel();
	JLabel optionB=new JLabel();
	JLabel optionC=new JLabel();
	JLabel optionD=new JLabel();
	JCheckBox A=new JCheckBox();
	JCheckBox B=new JCheckBox();
	JCheckBox C=new JCheckBox();
	JCheckBox D=new JCheckBox();
	ButtonGroup bgroup=new ButtonGroup();
	
	///Countdown Timer for each question (Starting from 10)
	Timer timer =new Timer(1000, (ActionEvent e) ->{
		countdown--;
		seconds.setText(String.valueOf(countdown));
		
		if(countdown<=0) 
			displayAnswer();
	});
	
	public Quiz() {
		
		///Headers
		question_no.setBounds(0,0,500,30);
		question_no.setBackground(new Color(0,0,0));
		question_no.setForeground(new Color(255,255,255));
		question_no.setHorizontalAlignment(JTextField.CENTER);
		question_no.setEditable(false);
		question_no.setFont(new Font("MONOSPACED",Font.BOLD,15));
		
		question.setBounds(0,40,500,80);
		question.setBackground(new Color(0,0,0));
		question.setForeground(new Color(255,255,255));
		question.setEditable(false);
		question.setFont(new Font("MONOSPACED",Font.BOLD, 20));
		
		///seconds used in countdown 
		seconds.setBounds(420,400,50,50);
		seconds.setEditable(false);
		seconds.setText(String.valueOf(countdown));
		seconds.setFont(new Font("MONOSPACED",Font.BOLD,30));
		seconds.setHorizontalAlignment(JTextField.CENTER);
		seconds.setBackground(new Color(0,0,0));
		seconds.setForeground(new Color(255,0,0));
		
		///added to the frame when the quiz is over for displaying marks
		result.setBounds(150,200,150,70);
		result.setBackground(new Color(10,10,10));
		result.setForeground(new Color(255,255,255));
		result.setHorizontalAlignment(JTextField.CENTER);
		result.setEditable(false);
		result.setFont(new Font("SANS_SERIF",Font.BOLD,20));
		
		///Options
		A.setBounds(10,120,40,40);
		A.setBackground(new Color(38,38,38));
		B.setBounds(10,170,40,40);
		B.setBackground(new Color(38,38,38));
		C.setBounds(10,220,40,40);
		C.setBackground(new Color(38,38,38));
		D.setBounds(10,270,40,40);
		D.setBackground(new Color(38,38,38));
		
		bgroup.add(A);
		bgroup.add(B);
		bgroup.add(C);
		bgroup.add(D);
		
		///Option Labels
		optionA.setBounds(60,120,300,40);
		optionA.setForeground(new Color(255,255,255));
		optionB.setBounds(60,170,300,40);
		optionB.setForeground(new Color(255,255,255));
		optionC.setBounds(60,220,300,40);
		optionC.setForeground(new Color(255,255,255));
		optionD.setBounds(60,270,300,40);
		optionD.setForeground(new Color(255,255,255));
		
		///Buttons 
		next.setBounds(170,400,90,40);
		repeat.setBounds(100,300,130,40);
		nextTopic.setBounds(250,300,100,40);
		
		///adding components to the frame
		f.add(question_no);
		f.add(question);
		f.add(seconds);
		f.add(A);f.add(B);f.add(C);f.add(D);
		f.add(optionA);
		f.add(optionB);
		f.add(optionC);
		f.add(optionD);
		f.add(next);
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(38,38,38));
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
		
		///calling the for the first question as sson as the frame is set up
		nextQuestion();		
	}
	
	///to jump onto the next question when one is over 
	abstract public void nextQuestion();
	
}
