//Topic 2: Blockchain

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

public class TopicTwo extends Quiz implements Result , ActionListener
{
	 
		static String questions_array[]= {
											" Blockchain is a type of ?",
											" In Bitcoin Case ,Blockchain is used in"+"\n"+" what way?",
											" Who first proposed a blockchain-like"+"\n"+" protocol?",
											" Blocks hold batches of valid "+"\n"+" transactions that are hashed and"+"\n"+" encoded into a?"
										};

		static String options[][]= {
			 							{"Object","Database","Table","View"},
			 							{"Centralized","Decentralized"," Both","None of the above"},
			 							{"Stuart Haber","W. Scott Stornetta","David Chaum","Dave Bayer"},
			 							{"merkle tree","cryptographic hash","genesis block","temporary fork"}
									};
	 
		static char answers[]= {
	 								'B',
	 								'B',
	 								'C',
	 								'A'
								};
		static List<Integer> indexArray =Arrays.asList(0,1,2,3);
		
		TopicTwo(){
			next.addActionListener(this);
			repeat.addActionListener((ActionEvent e) -> {
				f.dispose();
				new TopicTwo();
			});
			
			nextTopic.addActionListener((ActionEvent e) ->{
				f.dispose();
				new TopicOne();
			});
		}
		
	@Override
	public void nextQuestion() {
		
		totalQuestions=(int)questions_array.length;
		
		bgroup.clearSelection();
		
		
		if(counter>=totalQuestions) {
			
			next.setEnabled(false);
			try {
				showMarks();
			}catch (Exception e) {
				
			}
		}
		else {
			
			index=indexArray.get(counter);
			
			question_no.setText("Question : "+ (counter+1));
			question.setText(questions_array[index]);
			optionA.setText(options[index][0]);
			optionB.setText(options[index][1]);
			optionC.setText(options[index][2]);
			optionD.setText(options[index][3]);
			
			timer.start();
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
				if(A.isSelected()) {
					answer='A';
					if(answer==answers[index]) {
					correctGuess++;
				}
			}
		
				if(B.isSelected()) {
					answer='B';
					if(answer==answers[index]) {
					correctGuess++;
				}
			}
		
				if(C.isSelected()) {
					answer='C';
					if(answer==answers[index]) {
					correctGuess++;
				}
			}
		
				if(D.isSelected()) {
					answer='D';
					if(answer==answers[index]) {
					correctGuess++;
				}
			}
				
				answer=' ';
				displayAnswer();
		}
	
	@Override
	public void displayAnswer() {
		
		timer.stop();
	
		A.setEnabled(false);
		B.setEnabled(false);
		C.setEnabled(false);
		D.setEnabled(false);
		
		next.setEnabled(false);
		
		if(answers[index] != 'A')
			optionA.setForeground(new Color(255,0,0));
		else
			optionA.setForeground(new Color(0,255,0));
		if(answers[index] != 'B')
			optionB.setForeground(new Color(255,0,0));
		else
			optionB.setForeground(new Color(0,255,0));
		if(answers[index] != 'C')
			optionC.setForeground(new Color(255,0,0));
		else
			optionC.setForeground(new Color(0,255,0));
		if(answers[index] != 'D')
			optionD.setForeground(new Color(255,0,0));
		else
			optionD.setForeground(new Color(0,255,0));
		
		counter++;
		
		Timer pause =new Timer(1000 , (ActionEvent e) ->{
			
			optionA.setForeground(new Color(255,255,255));
			optionB.setForeground(new Color(255,255,255));
			optionC.setForeground(new Color(255,255,255));
			optionD.setForeground(new Color(255,255,255));
			
			A.setEnabled(true);
			B.setEnabled(true);
			C.setEnabled(true);
			D.setEnabled(true);
			
			next.setEnabled(true);
			nextQuestion();
			countdown=10;
		});
		
		pause.setRepeats(false);
		pause.start();
	}
	
	@Override
	public void showMarks() throws Exception {
		
		if(correctGuess>4 || correctGuess<0) {
			String e="Result Greater than or Less than expected";
			throw new Exception(e);
		}
		
		System.out.println(correctGuess + " / 4");

		question_no.setText("");
		question.setFont(new Font("MONOSPACED",Font.BOLD,30));
		question.setText(" 	 Result!");
		optionA.setText("");
		optionB.setText("");
		optionC.setText("");
		optionD.setText("");
		seconds.setText("");
		
		result.setText(correctGuess+" / 4");
		f.add(result);
		f.add(nextTopic);
		f.add(repeat);	
	}
	
	public static void main(String args[]) {
		
		Collections.shuffle(indexArray);
		new TopicTwo();
	}
}


