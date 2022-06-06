// Music source: http://www.videogamescrapbook.com/download/super_mario_galaxy.php?p=1
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.*;
import java.awt.geom.QuadCurve2D; 


public class Game  extends JPanel implements Runnable, KeyListener,  MouseListener, MouseMotionListener{


	private BufferedImage back; 
	private int key; 
	private final static int SCREEN_WIDTH = 1280;
	private final int SCREEN_HEIGHT = 700;
	private final int LEVEL_SIZE = 70, SETTING_SIZE = 50;
	private static String[] song;
	private static char screen;
	private static char tutorial;
	private ImageIcon soundOn, soundOff,menu,setting,homeSet,astro,alien;
	private ImageIcon spaceWord,backSpaceWord,music,note,volume,settingg, settingg2, settingg3;
	private ImageIcon bright, dark,sun,moon,halfsun,globe,win;
	private ArrayList<Color> colorList; 
	private ArrayList<Setting> settingList;
	private ArrayList<ArrayList<Level>> levelList1;
	private ArrayList<Laser> laserList;
	private static Integer[] numberList = new Integer[] {0,0,0,0,0,0,0,0};
	private String levelCompleted;
	private static String numberPicked;
	private int setScreen,useHint,quit;
	private int levelWon;
	private static int level;
	private static boolean resetNumberList;
	private static boolean musicOff;
	private boolean buttonPress, finalWin;
	private boolean lastTut, reverse,reverse1, alienVis,finalClick;
	private static boolean finishLevel, recentlyReturned;
	private static int xCoorParallel;
	private static int yCoor;
	private int[] xSquare, ySquare,xPos,yPos;
	private static int[] xPosition;
	private static int[] yPosition;
	private static int number;
	private int draw;
	private String[] hello,bye, hint, airplane;

	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		back = null;
		song = new String[]{"menu.wav","red.wav","orange.wav","yellow.wav","green.wav","blue.wav","purple.wav","pink.wav"};
		colorList = getColor();
		levelList1 = getLevel();
		settingList = getSetting();
		menu = new ImageIcon("menu.png");
		setting = new ImageIcon("setting.png");
		soundOn = new ImageIcon("play.png");
		soundOff = new ImageIcon("pause.png");
		homeSet = new ImageIcon("sethome.png");
		astro = new ImageIcon("astroo.png");
		alien = new ImageIcon("alienn.png");
		spaceWord = new ImageIcon("space.png");
		backSpaceWord = new ImageIcon("backtospace.png");
		music = new ImageIcon("earr.png");
		note = new ImageIcon("notes.png");
		volume = new ImageIcon("volume.png");
		settingg = new ImageIcon("settingg.png");
		settingg2 = new ImageIcon("settingg2.png");
		settingg3 = new ImageIcon("settingg3.png");
		bright = new ImageIcon("brightness.png");
		dark = new ImageIcon("darkness.png");
		sun = new ImageIcon("sun.png");
		moon = new ImageIcon("moon.png");
		halfsun = new ImageIcon("halfsunmoon.png");
		globe = new ImageIcon("globe.png");
		win = new ImageIcon("win.png");
		screen = 'M';
		tutorial = 'A';
		resetNumberList = false; 
		musicOff = false;
		lastTut = false; finishLevel = false;
		buttonPress = false; finalWin = true;
		levelCompleted = "";
		level = -1;
		setScreen = 0; useHint = 0;quit = 0; levelWon = 0; 
		Player.playmusic(song[0]);
		recentlyReturned = false;
		hint = new String[] {"no hint found","arrow keys and clicks","the words correspond to keys","connect the squares with keys & clicks","note the volume (F + CTRL)","return to the game and observe :)","note the brightness (F + CTRL)","mouse exit/enter & airplane mode"};
		
		// Level 2
		reverse = false;
		alienVis = false;
		laserList = getLaser();
		xCoorParallel = 0;
		yCoor = 0;
		reverse1 = true;

		// Level 3
		xSquare = new int[] {60,180,300,420,540,420,300,180};
		ySquare = new int[] {200,300,400,300,200,100,200,100};
		xPos = new int[] {325,325,325,325,325,325,325,325};
		yPos = new int[] {225,225,225,225,225,225,225,225};
		number = 99;
		finalClick = false;
		numberPicked = "";

		// Level 6
		hello = new String[] {"Hello","Bonjour","Hola","Zdravstvuyte","Nin hao","Konnichiwa","Salve","Guten Tag","Xin Chao","Anyoung haseyo","Ola","God dag"};
		bye = new String[] {"Goodbye","Adios","Au Revoir","Adeus","Arrivederci","Auf Wiedersehen","Tam Biet","Sayonara","Do svidaniya","Annyeong","Slan","Tot ziens"};
		airplane = new String[] {"Airplane","Avion","Flugzeug","Aeroplano","May Bay","Eroplano","Lennuk","Kapal udara","Balafir","Scapha","Ajruplan","Kapal terbang"};
		draw = 0;
		xPosition = new int[] {-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100};
		yPosition = new int[] {-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100,-100};
		Player.playmusic(song[0]);
	}




	public void run()
	{
		try
		{
			while(true)
			{
				Thread.currentThread().sleep(5);
				repaint();
			}
		}
		catch(Exception e)
		{
		}
	}






	public void paint(Graphics g){

		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 


		Graphics g2d = back.createGraphics();

		g2d.clearRect(0,0,getSize().width, getSize().height);
		drawGame(g2d);
		twoDgraph.drawImage(back, null, 0, 0);
	}

	public ArrayList<ArrayList<Level>> getLevel(){
		ArrayList<ArrayList<Level>> temp = new ArrayList<ArrayList<Level>>();

		ArrayList<Level> list_level0 = new ArrayList<>();
		list_level0.add(new Level(165,265,colorList.get(0)));
		list_level0.add(new Level(485,425,colorList.get(0)));
		list_level0.add(new Level(805,125,colorList.get(0)));
		list_level0.add(new Level(1045,485,colorList.get(0)));

		ArrayList<Level> list_level1 = new ArrayList<>();
		list_level1.add(new Level(255,505,colorList.get(1)));
		list_level1.add(new Level(1165,285,colorList.get(1)));


		ArrayList<Level> list_level2 = new ArrayList<>();
		list_level2.add(new Level(895,345,colorList.get(2)));

		ArrayList<Level> list_level3 = new ArrayList<>();
		list_level3.add(new Level(85,180,colorList.get(3)));
		list_level3.add(new Level(795,580,colorList.get(3))); 
		list_level3.add(new Level(960,50,colorList.get(3))); 

		ArrayList<Level> list_level4 = new ArrayList<>();
		list_level4.add(new Level(670,400,colorList.get(4)));
		list_level4.add(new Level(600,130,colorList.get(4)));
		list_level4.add(new Level(390,305,colorList.get(4)));
		list_level4.add(new Level(100,580,colorList.get(4)));

		ArrayList<Level> list_level5 = new ArrayList<>();
		list_level5.add(new Level(50,460,colorList.get(5)));
		list_level5.add(new Level(1100,70,colorList.get(5)));

		ArrayList<Level> list_level6 = new ArrayList<>();
		list_level6.add(new Level(350,180,colorList.get(6)));
		list_level6.add(new Level(970,200,colorList.get(6)));
		list_level6.add(new Level(660,500,colorList.get(6)));

		temp.add(list_level0);
		temp.add(list_level1);
		temp.add(list_level2);
		temp.add(list_level3);
		temp.add(list_level4);
		temp.add(list_level5);
		temp.add(list_level6);

		return temp;
	}

	public void drawLevel(Graphics g, int level) {
		for (int j = 0; j < levelList1.get(level).size();j++) {
			g.setColor(levelList1.get(level).get(j).getColor());
			g.drawOval(levelList1.get(level).get(j).getX(), levelList1.get(level).get(j).getY(), LEVEL_SIZE, LEVEL_SIZE);
		}	
	}

	public void drawCompleteLevel(Graphics g, int level) {
		for (int j = 0; j < levelList1.get(level).size();j++) {
			g.setColor(levelList1.get(level).get(j).getColor());
			g.fillOval(levelList1.get(level).get(j).getX(), levelList1.get(level).get(j).getY(), LEVEL_SIZE, LEVEL_SIZE);
		}	
	}


	public ArrayList<Setting> getSetting(){
		ArrayList<Setting> temp = new ArrayList<>();
		temp.add(new Setting("home.png",1020,600));
		temp.add(new Setting("music.png",1080,600));
		temp.add(new Setting("question.png",1140,600));
		temp.add(new Setting("quit.png",1200,600));
		return temp;
	}

	public void drawSetting(Graphics g, int x) {
		for(int i =x; i < settingList.size(); i++) 
			g.drawImage(settingList.get(i).getPic().getImage(),settingList.get(i).getX(), settingList.get(i).getY(), SETTING_SIZE, SETTING_SIZE, this);
	}

	public static char getTutorial() {
		return tutorial;
	}

	public static void setTutorial(char c) {
		tutorial = c;
	}

	public static void setReset(boolean b) {
		resetNumberList = b;
	}

	public static void setScreen(char c) {
		screen = c;
	}

	public void levelPlay(Graphics g) {
		for (int i = 0; i < levelList1.size();i++) {
			if(level == i) 
				drawLevel(g,i);
		}
		firstLevel(g,level);
		switch(level) {
		case 0: 
			firstLevelArrow(g);
			g.drawImage(astro.getImage(), 400, 120, 200, 180, this);
			g.drawImage(astro.getImage(), 650, 320, 300, 260, this);
			break;
		case 1: 
			numberList[2] = 100; numberList[3] = 100;
			int[] x = {690 + xCoorParallel, 700 + xCoorParallel,710,700};
			int[] y = {90,615,590,65};
			g.fillPolygon(x, y, 4);
			g.drawImage(spaceWord.getImage(),100,50,350,300,this);
			g.drawImage(astro.getImage(),570 + xCoorParallel, levelList1.get(1).get(0).getY() - yCoor, 150, 120, this);
			if(alienVis) {
				g.drawImage(backSpaceWord.getImage(),100,50,350,300,this);
				g.drawImage(alien.getImage(),levelList1.get(1).get(0).getX() - 15, levelList1.get(1).get(0).getY()  - 150, 100, 200, this);
				addMoreLaser();
				drawLaser(g);
				getCollision();
			}
			else 
				resetNumberList();
			break;
		case 2: 
			g.setColor(levelList1.get(2).get(0).getColor());
			for (int i = 0; i < xSquare.length; i++) {
				numberList[1] = 100; numberList[2] = 100; numberList[3] = 100;
				g.fillRect(xSquare[i], ySquare[i], 60, 30);
				g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 30));
				g.drawString(String.valueOf(i), xSquare[i] + 25, ySquare[i]-25);
				level3(g);
			}
			break;
		case 3: 
			numberList[3] = 100;
			g.drawImage(music.getImage(), 200,0,400,660,this);
			g.drawImage(note.getImage(), 250,70,300,170,this);
			g.drawImage(volume.getImage(), 553,190,300,200,this);
			break;
		case 4: 
			g.drawImage(settingg3.getImage(), 750,120,400,250,this);
			g.drawImage(settingg2.getImage(), -55,70,450,250,this);
			g.drawImage(settingg.getImage(), 250,430,300,200,this);
			break;
		case 5: 
			numberList[2] = 100; numberList[3] = 100;
			g.drawImage(bright.getImage(), 530,50,550,550,this);
			g.drawImage(dark.getImage(), 150,50,550,550,this);
			g.drawImage(moon.getImage(), 260,450,100,100,this);
			g.drawImage(sun.getImage(), 870,450,100,100,this);
			g.drawImage(halfsun.getImage(), 565,220,100,100,this);
			break;
		case 6: 
			numberList[3] = 100;
			g.drawImage(globe.getImage(), 520,0,400,450,this);
			level6(g);
			break;
		}
	}

	public int getRandomLevel2() {
		return (int)(Math.random()*((460-400) + 1) + 400); 
	}

	public void paintLaser(Graphics g) {
		for (int i =0; i < laserList.size(); i++) {
			laserList.get(i).drawLaser(g);
		}
	}

	public ArrayList<Laser> getLaser(){ 
		ArrayList<Laser> temp = new ArrayList<Laser>();
		int x[] = {1,1,1,1};
		int y[] = {1,1,1,1};
		temp.add(new Laser(x,y));
		return temp;
	}

	public void addMoreLaser() {
		int xLaser = 350;
		int yValue = getRandomLevel2();
		if(laserList.size() < 30) {
			int[]x = {xLaser, xLaser + 5,xLaser + 50, xLaser + 50 - 5};
			int[]y = {yValue, yValue + 5, yValue + 5, yValue};
			laserList.add(new Laser(x, y));
		}
	}


	public void drawLaser(Graphics g) {
		for (int i = 0; i < laserList.size(); i++) {
			laserList.get(i).drawLaser(g);
			laserList.get(i).moveLaser();
			if(laserList.get(i).getXClosest() > SCREEN_WIDTH)
				laserList.remove(i);
		}
	}

	public void getCollision() {
		boolean y = false;
		for (int i = 0; i < laserList.size();i++) {
			if(laserList.get(i).getXFarthest() > 610 + xCoorParallel && 
					laserList.get(i).getXClosest() < 710 + xCoorParallel && 
					laserList.get(i).getYFarthest() < levelList1.get(1).get(0).getY() - yCoor + 100 && 
					laserList.get(i).getYClosest() > levelList1.get(1).get(0).getY() - yCoor)
				y= true;
			if(y) {
				resetNumberList = true;
				alienVis = false;
				xCoorParallel = 0;
				yCoor = 0;
				reverse = false; 
				reverse1 = true;
			}
		}
	}

	public static boolean getWin() {
		return finishLevel;
	}

	public static void setWin(boolean b) {
		finishLevel = b;
	}

	public static String[] getSong() {
		return song;
	}

	public void checkWin() {
		if(numberList[0] > 0 && numberList[1] > 1 && numberList[2] > 2 && numberList[3] > 3) {
			finishLevel = true;
			if(!levelCompleted.contains(String.valueOf(level))) { 
				levelCompleted += level;
				levelWon++;
			}
		}
	}

	public static void setLevel(int v) {
		level = v;
	}

	public void openSetting(Graphics g) {	
		for (int i = 4; i<numberList.length;i++) {
			if(numberList[i]==1) {
				g.drawImage(setting.getImage(),0,0,SCREEN_WIDTH,SCREEN_HEIGHT,this);
				FontMetrics metrics = getFontMetrics(g.getFont());
				g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 30));
				Graphics2D g2d = (Graphics2D)g;
				g2d.setStroke(new BasicStroke(6));
				switch(i) {
				case 4:
					g.drawString("to return home, press the house",(SCREEN_WIDTH)/2 - metrics.stringWidth("to return home, press the house") + 40, 180);
					g.drawString("else press back",(SCREEN_WIDTH)/2 - metrics.stringWidth("else press back")/2-20, 220);
					g.drawImage(homeSet.getImage(),SCREEN_WIDTH/2 -100, SCREEN_HEIGHT/2 - 100,200,200,this);
					g.drawString("home",430,85);
					if(setScreen == 0 && buttonPress) {
						g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 25));
						g.drawString("you're not done with the tutorial yet!", 510, 470);
					}
					break;
				case 5: 
					g.drawString("music",430,85);
					g.drawImage(soundOn.getImage(),450,270,100,100,this);
					g.drawImage(soundOff.getImage(),720,270,100,100,this);
					g.drawString("music on", 460, 410);
					g.drawString("music off", 730, 410);
					g.drawString("press the button to change the music status", 460, 160);
					String s = "";
					if (musicOff) s = "stopped";
					else s = "playing";
					g.drawString("music status: " + s, 550, 470);
					g.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
					g.drawString("options for music",545, 220);
					break;
				case 6: 
					g.drawString("help",430,85);
					if(setScreen != 1) {
						g.drawString("are you sure you want to utilize the hint?", 470, 270);
						g.setColor(new Color(184,141,80));
						g.fillRect(480, 320, 100, 50);
						g.fillRect(700, 320, 100, 50);
						g.setColor(Color.black);
						g.drawRect(480, 320, 100, 50);
						g.drawRect(700, 320, 100, 50);
						g.drawString("yes", 518, 350);
						g.drawString("no", 740, 350);
						g.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
						g.drawString("hint",615, 220);
						g.setFont(new Font("Bodoni MT Condensed", Font.ITALIC, 30));
						switch(useHint) {
						case 0: 
							break;
						case 1: 
							g.drawString("your hint is: " + hint[level+1],(SCREEN_WIDTH)/2 - metrics.stringWidth("your hint is: "+hint[level+1])/2-60,450);
							break;
						case 2: 
							g.drawString("alright then! good luck!",(SCREEN_WIDTH)/2 - metrics.stringWidth("alright then! good luck!")+25,450);
							break;
						case 3: 
							g.drawString(hint[0],(SCREEN_WIDTH)/2 - metrics.stringWidth(hint[0]) + 10,450);
							break;
						}
					}
					else if(setScreen==1) {
						g.drawString("BoxOut is a critical thinking game", 500, 160);
						g.drawString("where users must utilize the", 525, 200);
						g.drawString("else, click back to return home", 513, 470);
						g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 25));
						g.drawString("unfilled circle = incomplete level; filled circle = completed level", 413, 320);
						g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 30));
						g.drawString("to fill in the circle(s) on the screen", 495, 280);
						g.drawString("if you are still confused, replay the tutorial here", 440, 360);
						g.setColor(new Color(184,141,80));
						g.fillRect(550, 380, 180, 45);
						g.setColor(Color.black);
						g.drawRect(550, 380, 180, 45);
						g.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
						g.drawString("mouse & keyboard", 550, 240);
						g.drawString("tutorial",600,410);
					}

					break;
				case 7: 
					g.drawString("quit",430,85);
					g.drawString("are you sure you want to exit the game?", 475, 270);
					g.setColor(new Color(184,141,80));
					g.fillRect(480, 320, 100, 50);
					g.fillRect(700, 320, 100, 50);
					g.setColor(Color.black);
					g.drawRect(480, 320, 100, 50);
					g.drawRect(700, 320, 100, 50);
					g.drawString("yes", 518, 350);
					g.drawString("no", 740, 350);
					g.setFont(new Font("Bodoni MT Condensed", Font.ITALIC, 30));
					if(quit == 2) g.drawString("if no, please click back!",(SCREEN_WIDTH)/2 - metrics.stringWidth("if no, please click back!")+25,450);
					else if (quit == 1) System.exit(0);
					else if (quit == 3) g.drawString("you're not done with the tutorial yet!", 490, 450);
					break;
				}
			}
		}
	}

	public void drawGame(Graphics g) {
		switch(screen) {
		case 'M':
			g.drawImage(menu.getImage(), 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT-33, this);
			break;
		case 'T':
			setScreen = 0;
			drawBoxOut(g);
			drawTutorial(g);
			break;
		case 'S': 
			openSetting(g);
			break;
		case 'L': 
			drawBoxOut(g);
			resetNumberList();
			lastTut = false;
			alienVis = false;
			setScreen = 1;
			drawSetting(g,1);
			unCompletedLevel(g);
			completedLevel(g);	
			getWin1();
			break;
		case 'G': 
			resetNumberList();
			setScreen = 2;
			drawSetting(g,0);
			levelPlay(g);
			checkWin();
			break;
		case 'W': 
			g.drawImage(win.getImage(), 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, this);
			break;
		}
	}

	public ArrayList<Color> getColor(){
		ArrayList<Color> temp = new ArrayList<>();
		temp.add(new Color(255,102,99));
		temp.add(new Color(254,177,68));
		temp.add(new Color(248,213,137));
		temp.add(new Color(158,224,158));
		temp.add(new Color(158,193,207));
		temp.add(new Color(204,153,201));
		temp.add(new Color(247,168,166));
		return temp;
	}

	public void drawBoxOut(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 40));
		g.drawString("welcome to ", 100,100);
		g.setFont(new Font("Bodoni MT Black", Font.ITALIC, 40));
		g.drawString("BoxOut!", 240,100);
	}
	
	public void getWin1() {
		if (levelWon == 7 && finalWin)
			screen = 'W';
	}
	
	public void drawTutorial(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 30));
		switch (tutorial) {
		case 'A': 
			g.drawString("see those circles? click on them!", 300,200);
			break;
		case 'B':
			g.drawString("nice job! keep going!", 500,300);
			break;
		case 'C': 
			g.drawString("voila! you just solved a puzzle", 300,220);
			g.drawString("do you get it?", 600,350);
			g.drawString("let's do another level", 850,475);
			break;
		case 'D':
			resetNumberList();
			g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 30));
			g.drawString("here are some more unfilled circles", 300, 200);
			g.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 30));
			g.drawString("unfilled circle = unsolved level", 470, 315);
			g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 30));
			g.drawString("to solve this puzzle, use the keyboard", 700,430);
			if(numberList[0] == numberList[1] && numberList[2] == numberList[3] && numberList[2] == numberList[1] && numberList[1]==1)
				tutorial = 'E';
			break;	
		case 'E': 
			g.drawString("puzzle solved!", 300,200);
			g.drawString("simple right?", 450,300);
			g.drawString("with BoxOut, your goal is to fill the circle(s) on the screen", 550,370);
			g.drawString("by using your mouse and keyboard", 630,410);
			g.drawString("each circle have its own solution", 900,470);
			break;
		case 'F': 
			g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 30));
			g.drawString("before we proceed", 300,200);
			g.drawString("take a look at the bottom right corner", 450,300);
			g.drawString("press on the buttons to explore their functions",750,400);
			g.setFont(new Font("Bodoni MT Condensed", Font.ITALIC, 25));
			g.drawString("<visit all the setting functions to move on>", 100, 630); 
			g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 20));
			g.drawString("note: some functions aren't going to work yet",850,450);
			g.drawString("so click back when you're done exploring",860,480);
			QuadCurve2D quadcurve = new QuadCurve2D.Float(580,340,600,550,1000,620);
			Graphics2D g2d = (Graphics2D) g;
			g2d.draw(quadcurve);
			g.drawLine(970, 600, 1000, 620);
			g.drawLine(970, 640, 1000, 620);
			drawSetting(g,0);
			break;
		case 'G': 
			drawSetting(g,0);
			lastTut = true;
			g.setFont(new Font("Bodoni MT Black", Font.ITALIC, 30));
			g.drawString("BoxOut!", 540,250);
			g.setFont(new Font("Bodoni MT Condensed", Font.HANGING_BASELINE, 30));
			g.drawString("now you are ready to play", 300,250);
			g.drawString("let's check out the home screen!", 630,445);
			g.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 25));
			g.drawString("Credits: Music - Super Mario Galaxy", 90,450);
			g.drawString("Inspiration - BlackBox by Ryan McLoed", 145,485);
			g.setFont(new Font("Bodoni MT Condensed", Font.ITALIC, 25));
			g.drawString("<and remember these buttons are here to help you>", 580,635);
			levelWon = 1;
			levelCompleted = "0";
			break;
		case 'H': 
			resetNumberList = true;
			drawCompleteLevel(g,0);
			drawLevel(g,1);
			drawLevel(g,2);
			drawLevel(g,3);
			drawSetting(g,1);
			g.setColor(Color.white);
			g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 30));
			g.drawString("welcome to the home screen!", 300, 170);
			g.drawString("the filled circles are completed levels", 400, 250);
			g.drawString("the unfilled circles are unlocked levels", 600, 450);
			g.drawString("you are welcome to replay completed levels", 660, 530);
			g.setFont(new Font("Bodoni MT Condensed", Font.ITALIC, 30));
			g.drawString("similar color circles are part of the same level", 450, 350);
			break;
		}
		drawLevel(g,0);
		if(tutorial == 'A'||tutorial == 'B'|| tutorial == 'C') {
			firstLevel(g,0);
			if(numberList[0]>0 || numberList[1]>1 || numberList[2]>2 || numberList[3]>3) {
				if(numberList[0]>0 && numberList[1]>1 && numberList[2]>2 && numberList[3]>3)
					tutorial = 'C';
				else tutorial = 'B';
			}
		}
		if(tutorial == 'D' || tutorial == 'E'|| tutorial == 'F'|| tutorial == 'G') {
			firstLevelArrow(g);
			g.setColor(levelList1.get(0).get(0).getColor());
			for(int i = 0; i < 4; i++) {
				if(numberList[i]==1) 
					fillLevel(g,0,i);
			}
		}
	}

	public void firstLevelArrow(Graphics g) {
		g.setColor(new Color(194,59,34));
		for (int i = 0; i < 2; i++) 
			g.fillRect(levelList1.get(0).get(i).getX() - 20, levelList1.get(0).get(i).getY() + 50, 52, 52);
		Polygon triangle1 = new Polygon();
		triangle1.addPoint(levelList1.get(0).get(0).getX() - 50, levelList1.get(0).get(0).getY() + 75);
		triangle1.addPoint(levelList1.get(0).get(0).getX() - 20, levelList1.get(0).get(0).getY() + 40);
		triangle1.addPoint(levelList1.get(0).get(0).getX() - 20, levelList1.get(0).get(0).getY() + 110);

		Polygon triangle2 = new Polygon();
		triangle2.addPoint(levelList1.get(0).get(1).getX() + 60, levelList1.get(0).get(1).getY() + 75);
		triangle2.addPoint(levelList1.get(0).get(1).getX() + 30, levelList1.get(0).get(1).getY() + 40);
		triangle2.addPoint(levelList1.get(0).get(1).getX() + 30, levelList1.get(0).get(1).getY() + 110);
		if(screen == 'T') {
			for (int i = 2; i < 4; i++) 
				g.fillRect(levelList1.get(0).get(i).getX() - 20, levelList1.get(0).get(i).getY() + 50, 52, 52);

			Polygon triangle3 = new Polygon();
			triangle3.addPoint(levelList1.get(0).get(2).getX() + 5, levelList1.get(0).get(2).getY() + 130);
			triangle3.addPoint(levelList1.get(0).get(2).getX() - 30, levelList1.get(0).get(2).getY() + 100);
			triangle3.addPoint(levelList1.get(0).get(2).getX() + 40, levelList1.get(0).get(2).getY() + 100);

			Polygon triangle4 = new Polygon();
			triangle4.addPoint(levelList1.get(0).get(3).getX() + 5, levelList1.get(0).get(3).getY() + 20);
			triangle4.addPoint(levelList1.get(0).get(3).getX() - 30, levelList1.get(0).get(3).getY() + 50);
			triangle4.addPoint(levelList1.get(0).get(3).getX() + 40, levelList1.get(0).get(3).getY() + 50);

			g.fillPolygon(triangle3);
			g.fillPolygon(triangle4);
		}
		g.fillPolygon(triangle1);
		g.fillPolygon(triangle2);
	}
	
	public void firstLevel(Graphics g, int level) {
		g.setColor(levelList1.get(level).get(0).getColor());
		for(int i = 0; i < levelList1.get(level).size();i++) {
			switch(i) {
			case 0: 
				if(numberList[i]!=0)
					g.fillOval(levelList1.get(level).get(i).getX(), levelList1.get(level).get(i).getY(), LEVEL_SIZE, LEVEL_SIZE); break;
			case 1: 
				switch(numberList[1]){
				case 1: 
					g.fillArc(levelList1.get(level).get(i).getX(), levelList1.get(level).get(i).getY(), LEVEL_SIZE, LEVEL_SIZE, 40, 180); 
					if(level!=1) {
						g.drawLine(levelList1.get(level).get(i).getX()+10, levelList1.get(level).get(i).getY()+20, levelList1.get(level).get(i).getX()-30, levelList1.get(level).get(i).getY()+10);
						g.drawLine(levelList1.get(level).get(i).getX()+30, levelList1.get(level).get(i).getY()+10, levelList1.get(level).get(i).getX()+30, levelList1.get(level).get(i).getY()-30);
					}
				case 0: break;
				default:g.fillArc(levelList1.get(level).get(i).getX(), levelList1.get(level).get(i).getY(), LEVEL_SIZE, LEVEL_SIZE, 40, 360); break;
				}
				break;
			case 2: 
				switch(numberList[2]){
				case 2: 
					g.fillArc(levelList1.get(level).get(i).getX(), levelList1.get(level).get(i).getY(), LEVEL_SIZE, LEVEL_SIZE, 280, 120);
					g.drawArc(levelList1.get(level).get(i).getX()+7, levelList1.get(level).get(i).getY()+3, LEVEL_SIZE, LEVEL_SIZE, 280, 120);
				case 1: 
					g.fillArc(levelList1.get(level).get(i).getX(), levelList1.get(level).get(i).getY(), LEVEL_SIZE, LEVEL_SIZE, 100, 120);
					g.drawArc(levelList1.get(level).get(i).getX()-7, levelList1.get(level).get(i).getY()-3, LEVEL_SIZE, LEVEL_SIZE, 100, 120);
				case 0: 
					break;
				default:
					g.fillArc(levelList1.get(level).get(i).getX(), levelList1.get(level).get(i).getY(), LEVEL_SIZE, LEVEL_SIZE, 40, 360); 
					break;
				}
				break;
			case 3: 
				switch(numberList[3]){
				case 3:
					g.fillArc(levelList1.get(level).get(i).getX(), levelList1.get(level).get(i).getY(), LEVEL_SIZE, LEVEL_SIZE, 90, 90);
				case 2: 
					g.fillArc(levelList1.get(level).get(i).getX(), levelList1.get(level).get(i).getY(), LEVEL_SIZE, LEVEL_SIZE, 0, 90);
				case 1:
					g.fillArc(levelList1.get(level).get(i).getX(), levelList1.get(level).get(i).getY(), LEVEL_SIZE, LEVEL_SIZE, 180, 90);
				case 0: 
					break;
				default:
					g.fillArc(levelList1.get(level).get(i).getX(), levelList1.get(level).get(i).getY(), LEVEL_SIZE, LEVEL_SIZE, 40, 360); 
					break;
				}
			}
		}
	}

	public void level3(Graphics g) {
		boolean  done = true;
		for (int i = 0; i < 8; i++) {
			if(number == i) 
				g.drawLine(xSquare[i] + 35, ySquare[i] + 25, xPos[i],yPos[i]);
			if(numberPicked.contains(String.valueOf(i)))
				g.drawLine(xSquare[i] + 35, ySquare[i] + 25, xPos[i],yPos[i]);

			if(i < 7) {
				if(!(xPos[i] > xSquare[i+1] && xPos[i] < xSquare[i+1] + 50 && yPos[i] > ySquare[i+1] && yPos[i] < ySquare[i+1] + 50)) 
					done = false;
			}
			if(!(xPos[7] > xSquare[0] && xPos[7] < xSquare[0] + 70 && yPos[7] > ySquare[0] && yPos[7] < ySquare[0] + 50)) 
				done = false;
		}
		if(done && !finalClick) {
			numberList[0] = 1;
			numberPicked = "";
			number = 99;
			for (int i = 0; i < 8; i++) {
				xPos[i] = 325;
				yPos[i] = 225;
			}
		}
	}
	
	public static int randomX6() {
		int x = (int)(Math.random()*((SCREEN_WIDTH-150 - 1070)+ 1) + 1070);
		int y = (int)(Math.random()*(250)+ 1);
		int k = (int)(Math.random()*((1)+1)+1);
		if(k == 1)
			return x;
		else return y;
	}

	public static int randomY6() {
		int x = (int)(Math.random()*((600 - 50)+1) + 50);
		return x;
	}

	public static int getLevelMain() {
		return level;
	}

	public static int[] getXPos() {
		return xPosition;
	}

	public static int[] getYPos() {
		return yPosition;
	}

	public int randomGreeting() {
		return (int)(Math.random()*(11)+1);
	}

	public void level6(Graphics g) {
		g.setColor(levelList1.get(6).get(0).getColor());
		g.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 30));
		if(numberList[0] == 0) 
			draw = 1;
		else if(numberList[0] > 0 && numberList[1] <2)
			draw = 2;
		else draw = 3;
		if(draw == 1) {
			for (int i = 0; i<xPosition.length;i++) {
				g.drawString(hello[i],xPosition[i],yPosition[i]);
			}	
		}
		else if(draw == 2) {
			for (int i = 0; i<xPosition.length;i++) {
				g.drawString(bye[i],xPosition[i],yPosition[i]);
			}
		}
		else {
			for (int i = 0; i<xPosition.length;i++) {
				g.drawString(airplane[i], xPosition[i], yPosition[i]);
			}
		}
	}

	public static void setNumber(int n) {
		number = n;
	}
	public static void setNumberPicked(String s) {
		numberPicked = s;
	}
	public static void setXPar(int n) {
		xCoorParallel = n;
	}
	public static void setYCoor(int n) {
		yCoor = n;
	}
	public static boolean checkAllSettings() {
		if(numberList[4] == numberList[5] && numberList[6] == numberList[7] && numberList[4] == numberList[7] && numberList[7] == 2)
			return true;
		else return false;
	}

	public void resetNumberList() {
		if(resetNumberList) {
			for (int i = 0; i< numberList.length;i++) {
				numberList[i] = 0;	
				finishLevel = false;
			}
		}
		resetNumberList = false;
	}

	public void unCompletedLevel(Graphics g) {
		if(levelWon + 2 < levelList1.size()){
			for (int i = 0; i < levelWon +3;i++) 
				//	for (int i = 0; i < levelList1.size(); i++) 
				drawLevel(g,i);
		}
		if(levelWon == 5 || levelWon == 6 || levelWon == 7) {
			for (int i = 0; i < levelList1.size(); i++) 
				drawLevel(g,i);
		}
	}

	public void completedLevel(Graphics g) {
		if(levelWon + 2 < levelList1.size()){
			for(int i = 0; i < levelWon + 3;i++) {
				if(levelCompleted.contains(String.valueOf(i)))
					drawCompleteLevel(g,i);
			}
		}
		if(levelWon == 5 || levelWon == 6 || levelWon == 7) {
			for (int i = 0; i < levelList1.size(); i++) {
				if(levelCompleted.contains(String.valueOf(i)))
					drawCompleteLevel(g,i);
			}
		}
	}

	public void fillLevel(Graphics g,int level, int circle) {
		g.fillOval(levelList1.get(level).get(circle).getX(),levelList1.get(level).get(circle).getY(),LEVEL_SIZE,LEVEL_SIZE);
	}

	public void pressLevel(int i) {
		level = i;
		screen = 'G';
		resetNumberList = true;
		Player.playmusic("stop");
		if(!musicOff) {
			Player.playmusic(song[i+1]);	
		}
		else recentlyReturned = true;
	}

	public static boolean getMusic() {
		return musicOff;
	}

	public static void setRecentlyReturned(boolean b) {
		recentlyReturned = b;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		key= e.getKeyCode();
		switch(screen) {
		case 'T':
			if(tutorial == 'D') {
				if(key == KeyEvent.VK_LEFT) 
					numberList[0]=1;
				if(key == KeyEvent.VK_RIGHT)
					numberList[1]=1;
				if(key == KeyEvent.VK_DOWN)
					numberList[2]=1;
				if(key == KeyEvent.VK_UP)
					numberList[3]=1;
			}
			break;
		case 'G': 
			switch(level) {
			case 0: 
				if(key == KeyEvent.VK_LEFT) 
					numberList[0]=1;
				if(key == KeyEvent.VK_RIGHT) {
					if(numberList[1] == 1) 
						numberList[1]=2;
					else if(numberList[1] == 0)
						numberList[1]=1;
				}
				break;
			case 1: 
				if(key == KeyEvent.VK_SPACE) {
					if(xCoorParallel < -305 || xCoorParallel > 490)
						reverse = !reverse;
					if(reverse) 	
						xCoorParallel -= 8;
					else xCoorParallel +=8;

				}
				if(xCoorParallel < -302) {
					numberList[0] = 1;
					alienVis = true;
				}
				if(alienVis && key == KeyEvent.VK_BACK_SPACE) {
					if(yCoor > 400 || yCoor < 0)
						reverse1 = !reverse1;
					if(reverse1)
						yCoor +=20;
					else yCoor -= 20;
				}
				if(yCoor == 260 && xCoorParallel> 470)
					numberList[1]++;
				break;
			case 2:
				if(!finalClick ) {
					if(key == KeyEvent.VK_0) {
						number = 0;
						finalClick = true;
					}
					else if(key == KeyEvent.VK_1) {
						number = 1;
						finalClick = true;
					}
					else if(key == KeyEvent.VK_2) {
						number = 2;
						finalClick = true;
					}
					else if(key == KeyEvent.VK_3) {
						number = 3;
						finalClick = true;
					}
					else if(key == KeyEvent.VK_4) {
						number = 4;
						finalClick = true;
					}
					else if(key == KeyEvent.VK_5) {
						number = 5;
						finalClick = true;
					}
					else if(key == KeyEvent.VK_6) {
						number = 6;
						finalClick = true;
					}
					else if(key == KeyEvent.VK_7) {
						number = 7;
						finalClick = true;
					}
					else if(key == KeyEvent.VK_8 || key == KeyEvent.VK_9) {
						number = 99;
					}
				}
				if(!numberPicked.contains(String.valueOf(number)))
					numberPicked += number;
				break;	
			case 3: 
				if(key == KeyEvent.VK_F6)
					numberList[1] ++;
				if(key == KeyEvent.VK_F7)
					numberList[0] ++;
				if(key == KeyEvent.VK_F8)
					numberList[2] ++;
				break;
			case 5: 
				if(key == KeyEvent.VK_F2)
					numberList[0]++;
				if(key == KeyEvent.VK_F3)
					numberList[1]++;
				break;
			case 6: 
				if(key == KeyEvent.VK_F12)
					numberList[2]++;
			}
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {


	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub


	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		switch (screen) {
		case 'G': 
			for (int i = 0; i < 8; i++) {
				if(i == number && finalClick){
					xPos[i] = arg0.getX();
					yPos[i] = arg0.getY();
				}
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		switch(screen) {
		case 'M': 
			screen = 'T';
			break;
		case 'T': 
			switch(tutorial) {
			case 'A':
				resetNumberList();
				for(int i = 0; i < 4;i++) {
					if(arg0.getX()>levelList1.get(0).get(i).getX()&&arg0.getX() < levelList1.get(0).get(i).getX() + LEVEL_SIZE
							&& arg0.getY() > levelList1.get(0).get(i).getY() && arg0.getY() < levelList1.get(0).get(i).getY()+ LEVEL_SIZE) 
						numberList[i]+=1;
				}
				break;
			case 'B': 
				for(int i = 0; i < 4;i++) {
					if(arg0.getX()>levelList1.get(0).get(i).getX()&&arg0.getX() < levelList1.get(0).get(i).getX() + LEVEL_SIZE
							&& arg0.getY() > levelList1.get(0).get(i).getY() && arg0.getY() < levelList1.get(0).get(i).getY()+ LEVEL_SIZE) 
						numberList[i]+=1;
				}
				break;
			}
			break;		
		case 'W': 
			screen = 'L';
			finalWin = false; 
			break;
		case 'S':
			for (int i = 4; i<numberList.length;i++) {
				if(arg0.getX() > 547 && arg0.getX() < 735 && arg0.getY() > 490 && arg0.getY() < 547 && numberList[i] == 1) {
					if(setScreen==0) {
						screen = 'T';
						numberList[i]=2;
						if(lastTut) 
							tutorial = 'G';
						else tutorial = 'F';
					}
					else if(setScreen==1) {
						screen = 'L';
						numberList[i]=0;
					}
					else if (setScreen==2) {
						screen = 'G';
						numberList[i]=0;
					}
					useHint = 0;
					quit = 0;
					buttonPress = false;
				}
				if(numberList[4] == 1) {
					if(arg0.getX() >SCREEN_WIDTH/2 - 100 && arg0.getX() < SCREEN_WIDTH/2 + 100 && 
							arg0.getY() > SCREEN_HEIGHT/2-100 && arg0.getY() < SCREEN_HEIGHT/2+100){ 
						if(setScreen!=0) {
							for (int k = 0; k < 8; k++) {
								xPos[k] = 325;
								yPos[k] = 225;
								number = 99;
							}
							xCoorParallel = 0;
							yCoor = 0;
							alienVis = false;
							screen = 'L';
							numberPicked = "";
							Player.playmusic("stop");
							if(!musicOff) 
								Player.playmusic(song[0]);
						}
						else if (setScreen==0)
							buttonPress = true;
					}
				}
				if(numberList[5]==1) {
					if(arg0.getY() > 270 && arg0.getY() < 370) {
						if(arg0.getX() > 450 && arg0.getX() < 550 && musicOff) {
							musicOff = false;
							if(setScreen == 0 || (setScreen == 1 && !recentlyReturned)) {
								Player.playmusic(song[0]);
							}
							else if(setScreen == 1 && recentlyReturned) {
								Player.playmusic("stop");
								Player.playmusic(song[0]);
								setRecentlyReturned(false);
							}
							else if(setScreen == 2 && recentlyReturned){
								Player.playmusic("stop");
								Player.playmusic(song[level + 1]);
								setRecentlyReturned(false);
							}
							else if (setScreen == 2 && !recentlyReturned)
								Player.playmusic(song[level+1]);
							if(level == 4) numberList[1]=2;	
						}
						else if(arg0.getX() > 720 && arg0.getX() < 820) {
							Player.playmusic("pause");
							musicOff = true;
							if(level == 4) numberList[3]=4;
						}
					}
				}
				if(numberList[6]==1) {
					if(setScreen !=1) {
						if(arg0.getY() > 320 && arg0.getY() < 370) {

							if(arg0.getX() > 480 && arg0.getX()<580) {
								if(setScreen == 2) {
									useHint = 1;
									if(level == 4) numberList[0]=1;
								}
								else if(setScreen == 0) {
									useHint = 3;
								}
							}
							else if (arg0.getX() > 700 && arg0.getX()<800) {
								useHint = 2;
								if(level == 4) numberList[2]=3;
							}
						}
					}
					else if(setScreen ==1) {
						if(arg0.getX()>550 && arg0.getX()<730&& arg0.getY() > 360 && arg0.getY() < 405) {
							resetNumberList();
							screen = 'T';	tutorial = 'A'; lastTut = false; resetNumberList = true;
							if(!musicOff) {
								Player.playmusic("pause");
								Player.playmusic(song[0]);
							}
						}
					}
				}

				if(numberList[7]==1) {
					if(arg0.getY() > 320 && arg0.getY() < 370) {
						if(arg0.getX() > 480 && arg0.getX()<580) {
							if(setScreen!=0)
								quit = 1;
							else quit = 3;
						}
						else if (arg0.getX() > 700 && arg0.getX()<800)
							quit = 2;
					}
				}
			}
			if(lastTut && numberList[4] == 1 && arg0.getX() >SCREEN_WIDTH/2 - 100 && arg0.getX() < SCREEN_WIDTH + 100 && 
					arg0.getY() > SCREEN_HEIGHT/2-100 && arg0.getY() < SCREEN_HEIGHT/2+100) {
				screen = 'T'; tutorial = 'H'; 
			}
			break;	
		case 'L': 
			if(levelWon < 5) {
				for(int i = 0; i < levelWon + 3; i++) {
					for (int j = 0; j < levelList1.get(i).size();j++) {
						if(arg0.getX()>levelList1.get(i).get(j).getX() && arg0.getX() < levelList1.get(i).get(j).getX() + LEVEL_SIZE
								&& arg0.getY() > levelList1.get(i).get(j).getY() && arg0.getY() < levelList1.get(i).get(j).getY()+ LEVEL_SIZE) 
							pressLevel(i);
					}
				}
			}
			if (levelWon == 5 || levelWon == 6 || levelWon == 7) {
				for(int h = 0; h < levelList1.size(); h++) {
					for (int k = 0; k < levelList1.get(h).size();k++) {
						if(arg0.getX()>levelList1.get(h).get(k).getX() && arg0.getX() < levelList1.get(h).get(k).getX() + LEVEL_SIZE
								&& arg0.getY() > levelList1.get(h).get(k).getY() && arg0.getY() < levelList1.get(h).get(k).getY()+ LEVEL_SIZE) {
							pressLevel(h);
							if(level == 6) key = -1;
						}
					}
				}
			}

			break;
		case 'G': 
			switch(level) {
			case 0: 
				for(int i = 2; i < 4;i++) {
					if(arg0.getX()>levelList1.get(0).get(i).getX()&&arg0.getX() < levelList1.get(0).get(i).getX() + LEVEL_SIZE
							&& arg0.getY() > levelList1.get(0).get(i).getY() && arg0.getY() < levelList1.get(0).get(i).getY()+ LEVEL_SIZE) 
						numberList[i]+=1;
				}
				break;
			case 2: 
				for (int i =0; i <8; i++) {
					if(number == i&& finalClick) {
						xPos[i] = arg0.getX();
						yPos[i] = arg0.getY();
						finalClick = false;
					}
				}
				break;
			}
			break;
		}
		if((screen == 'T' && tutorial == 'F')|| (screen == 'T' && tutorial == 'G') || screen == 'G') {
			for (int i = 0; i < settingList.size();i++) {
				if(arg0.getX() > settingList.get(i).getX() && arg0.getX() < settingList.get(i).getX() + SETTING_SIZE &&
						arg0.getY() > settingList.get(i).getY() && arg0.getY() < settingList.get(i).getY() + SETTING_SIZE) {
					numberList[i+4] = 1; 
					screen = 'S';
				}			
			}
		}
		if(screen == 'L') {
			for (int i = 1; i < settingList.size();i++) {
				if(arg0.getX() > settingList.get(i).getX() && arg0.getX() < settingList.get(i).getX() + SETTING_SIZE &&
						arg0.getY() > settingList.get(i).getY() && arg0.getY() < settingList.get(i).getY() + SETTING_SIZE) {
					numberList[i+4] = 1; 
					setScreen = 1;
					screen = 'S';
					tutorial = 'A';
				}			
			}
		}
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(screen == 'G' && level ==6 && draw == 1)
			numberList[0] = 1;
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(screen == 'G' && level ==6 && draw == 2)
			numberList[1]++;
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
