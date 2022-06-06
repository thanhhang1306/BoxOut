import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private static final int WIDTH =1280;
	private static final int HEIGHT=700;
	
	public Main () {
		super("Box Out!");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		
		Color background = new Color(47,44,39);
		setBackground(background);
		
		
		getContentPane().add(play);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
		  ActionListener taskPerformer = new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	if(Game.getTutorial()  == 'C') {
	                	Game.setTutorial('D');
	                	Game.setReset(true);
	            	}
	            
	            	if(Game.getTutorial()  == 'E') 
	                	Game.setTutorial('F');
	            	

	                if(Game.getTutorial()  == 'H') {
	                	Game.setScreen('L');
	                	Game.setTutorial('K');
	                	Game.setReset(true);
	                }
	                
	            	if(Game.getTutorial()  == 'G'&& Game.checkAllSettings()) 
	                	Game.setTutorial('H');
	                
	               
	            	 if(Game.getTutorial()  == 'F' && Game.checkAllSettings()) 
		                Game.setTutorial('G');
	                
	                if(Game.getWin()) {
	                	Game.setScreen('L');
	                	Game.setWin(false);
	                	Game.setLevel(-1);
	                	Game.setReset(true);
	                	Game.setNumber(99);
	                	Game.setNumberPicked("");
	                	Game.setXPar(0);
	                	Game.setYCoor(0);
	                	if(!Game.getMusic()) {
	                		Player.playmusic("stop");
	                		Player.playmusic(Game.getSong()[0]);
	                		Game.setRecentlyReturned(false);
	                	}
	                	else if(Game.getMusic())
	                		Game.setRecentlyReturned(true);
	                	
	               
	                }
	             
	            }
	        };
	      
	        Timer timer = new Timer(4500 ,taskPerformer);
	     //  timer.setRepeats(false);
	        timer.start();
	        
	        ActionListener taskPerformer2 = new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            
	              if(Game.getLevelMain()==6) {
	            	  for (int i = 0; i < 11; i++) {
	  					Game.getXPos()[i] = Game.randomX6();
	  					Game.getYPos()[i] = Game.randomY6();
	            	  }
	           	}
	            }
	        };
	      
	        Timer timer2 = new Timer(500 ,taskPerformer2);
	     //  timer.setRepeats(false);
	        timer2.start();

	       
	}
	       

	
	
}
