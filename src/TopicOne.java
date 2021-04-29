///Topic 1 : Cryptography

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

public class TopicOne extends Quiz implements Result , ActionListener
{
	
	/// try creating it in a JSON file format
	///Questions 
		static String questions_array[]= {
											" What is Cryptography ?",
											" The original message, before being" + "\n" +" transformed, is ?",
											" DES stands for ?",
											" Decrypt this SHA256 Hash: 3757639bc62d"+"\n"+" b8a60a621a4f19c806ab09bf3d8dd2dacd55852"+"\n"+" 0049771152939 ?"
										};
	///Options
		static String options[][]= {
			 						{"Corrupting Data","Secret Writing","Open Writing","Closed Writing"},
			 						{"Cypher Text","Plain Text"," Decrypted Text","Encrypted Text"},
			 						{"Data Encryption Standard","Data Encryption Subscription","Data Encryption Solutions","Data Encryption Slots"},
			 						{"Cryptography is Fun","Decryption Complete","Hello World","Get a life"}
								};
	 ///Answers
		static char answers[]= {
	 								'B',
	 								'B',
	 								'A',
	 								'D'
								};
	///for shuffling the questions
		///try making it dynamic
		static List<Integer> indexArray =Arrays.asList(0,1,2,3);
		
		///Constructor for ActionListeners
		TopicOne(){
			
			next.addActionListener(this);
			///to Repeat the same topic
			repeat.addActionListener((ActionEvent e) -> {
				f.dispose();
				new TopicOne();
			});
			
			///to move onto the next Topic
			nextTopic.addActionListener((ActionEvent e) ->{
				f.dispose();
				new TopicTwo();
			});
		}
		
	
	@Override
	public void nextQuestion() {
		
		totalQuestions=(int)questions_array.length;
		
		///to renew the selected CheckBoxes
		bgroup.clearSelection();
		
		///if the all questions are completed  
		if(counter>=totalQuestions) {
			
			next.setEnabled(false);
			try {
				///Call for the result
				showMarks();
			}catch (Exception e) {
				
			}
		}
		else {
			
			///for displaying the next question
			index=indexArray.get(counter);
			
			question_no.setText("Question : "+ (counter+1));
			question.setText(questions_array[index]);
			optionA.setText(options[index][0]);
			optionB.setText(options[index][1]);
			optionC.setText(options[index][2]);
			optionD.setText(options[index][3]);
			
			///countdown starts here
			timer.start();
		}
		
	}
	
	//when the option is selected and submitted
	///calls the displayAnswer method
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
				
				///Problem lies here 
//				int i=0;
//				do {
//					previous=random.nextInt(questions_array.length)-1;
//					
//					if(check[i]==previous)
//						previous=random.nextInt(questions_array.length)-1;
//
//					if(previous==-1)
//						previous++;
//					i++;
//				}while(==previous);
//				
//				check[counter]=previous;
//				
//				for(int j=0 ; j<check.length ; j++) {
//					if(check[j]!=index)
//					index=previous;
//				}
		}
		
	
	@Override
	public void displayAnswer() {
	
		///stops the timer
		timer.stop();
		
		//disable all the components 
		A.setEnabled(false);
		B.setEnabled(false);
		C.setEnabled(false);
		D.setEnabled(false);
		
		next.setEnabled(false);
		
		///display the right and wrong answers
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
		
		///record for number of questions complete so that none of the questions repeat 
		counter++;
		
		//timer for setting default color options for the nextQuestion 
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
			//resetting the countdown timer
			countdown=10;
		});
		
		pause.setRepeats(false);
		pause.start();
	}
	
	
	///Shows the result
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
		f.add(repeat);
		f.add(nextTopic);
	}
	
	public static void main(String args[]) {	
		///shuffles the array
		Collections.shuffle(indexArray);
		new TopicOne();
	}
}