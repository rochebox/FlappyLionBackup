package fLionPac;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JPanel implements ActionListener, KeyListener {
   
    public static final int SPACE_KEY = 32;
    public static final int L_GRAVITY = 4;  //in pixels per frame
 
    private static final long serialVersionUID = 1L;
    //data e
    private int windowW, windowH;
    private Color bColor = new Color(107, 255, 247);
    private JFrame myFrame = null;
    //private ScreenObj test1;
    //private Cloud c1Test;  //make place for object..
    private Cloud[ ] cList;
    private Lion alexLion;
    private Vac vac;
    private Egg e1;
    //*** new Egg
    private Egg e2;
    
    private Timer t;
    
    //**2019 variables
    private int score = 0;
    private int lives = 6;
    
    //Display for the Score
    //JPanel scoreP;
    
    //Constructor(s)
    public GameWindow(int w, int h) {
        windowW = w;
        windowH = h;
        
        this.setSize(windowW, windowH);
        this.setBackground(bColor);
    }
    
    public GameWindow(int w, int h, JFrame f) {
        this(w, h);
        myFrame = f;
        
        makeAllClouds( (int)(Math.random() * 5) + 5);
        //makeAllClouds(1);  <-- for testing
        
        makeObstacles();
        //let's activate the keyListener
        addKeyListener(this);
        //setScorePanels();
        setFocusable(true);
        
        t = new Timer(50, this);    
        t.start();  
    }
//    
//    public void setScorePanels() {
//        scoreP = new JPanel();
//        int scorePW = (int)(windowW *0.25);
//        int scorePH = (int)(windowH * 0.15);
//        System.out.println("ScorePW is " + scorePW);
//        System.out.println("ScorePH is " + scorePH);
//        //scoreP.setSize(scorePW, scorePH);
//        scoreP.setPreferredSize( new Dimension(scorePW, scorePH) );
//        scoreP.setBackground(Color.BLACK);
//        this.add(scoreP);
//        int scorePX = (int)(windowW * 0.75);
//        int scorePY = (int)(windowH * 0.2);
//        System.out.println("ScorePX is " + scorePX);
//        System.out.println("ScorePY is " + scorePY);
//        scoreP.setLocation( scorePX, scorePY);
//        scoreP.setVisible(true);
//    }
    
    public void makeObstacles() {
        makeAlexLion();
        int theMaxWVac = (int) (windowW * 0.14);
        int frameNumVac= 3;
        //int vacX = (int)(windowW) - theMaxWVac;
        int vacX = (int)(windowW) + theMaxWVac;
        int vacY = windowH - (int)(theMaxWVac * 1.45);
        vac = new Vac (
                vacX,  /* OK */
                vacY,   /* using the new vacY */
                "vac/Vach",
                ".png", 
                theMaxWVac, 
                this, 
                frameNumVac); 
        vac.setMoveSpeed(25);
        vac.showGameBB(true);
        vac.setGameBBXExtra( (int) (vac.getBW()  * 0.5) );
        vac.setGameBBYExtra( (int) (vac.getBH()  * 0.05) );
        vac.setGameBBW( (int) (vac.getBW()  * 0.30) );
        vac.setGameBBH( (int) (vac.getBH()  * 0.95) );
        
        //*** New Egg made in class
        int theMaxE2 = (int) (windowW * 0.125);
        int frameNumNewEgg= 1;
        int newEggX = (int)(windowW) + theMaxE2;
        int newEggY = windowH - (int)(theMaxE2 * 1.45);
        e2 = new Egg (
                newEggX,  /* OK */
                newEggY,   /* using the new vacY */
                "Eggs",
                ".png", 
                theMaxE2, 
                this, 
                frameNumNewEgg); 
        e2.setMoveSpeed(7);
        e2.showGameBB(true);
        e2.setGameBBXExtra( (int) (e2.getBW()  * 0.12) );
        e2.setGameBBYExtra( (int) (e2.getBH()  * 0.12) );
        e2.setGameBBW( (int) (e2.getBW()  * 0.85) );
        e2.setGameBBH( (int) (e2.getBH()  * 0.75) );
        
        
        
        
        
        //***NewStuff for an Egg 
        int theMaxWE1 = (int) (windowW * 0.15);
        int frameNumE1= 6;
        int e1X = vacX + (int)(windowW * 0.5) + theMaxWE1;
       
        int e1Y = (int) (windowH * 0.09);
        e1 = new Egg (
                e1X,  /* OK */
                e1Y,   /* making it be high in the sky */
                "cookingEggs/frame_",
                "_delay-0.15s.gif", 
                theMaxWE1, 
                this, 
                frameNumE1); 
        e1.setMoveSpeed(25);
        e1.showGameBB(true);
        e1.setGameBBXExtra( (int) (e1.getBW()  * 0.02) );
        e1.setGameBBYExtra( (int) (e1.getBH()  * 0.55) );
        e1.setGameBBW( (int) (e1.getBW()  * 0.80) );
        e1.setGameBBH( (int) (e1.getBH()  * 0.35) );
        
        
    }
    
    public void makeAlexLion() 
    {
        
        int theMaxW = (int) (windowW * 0.3);
        int frameNum = 16;
        alexLion = new Lion (
                (int)(windowW/2),  /* OK */
                windowH - (int)(theMaxW/2), 
                "LionPics/frame_",
                ".png", 
                theMaxW, 
                this, 
                frameNum);
        
        alexLion.showGameBB(true);
        alexLion.setGameBBXExtra( (int) (alexLion.getBW()  * 0.35) );  //David Ragone's numbers
        alexLion.setGameBBYExtra( (int) (alexLion.getBH()  * 0.20) );
        alexLion.setGameBBW( (int) (alexLion.getBW()  * 0.45) );
        alexLion.setGameBBH( (int) (alexLion.getBH()  * 0.60) );
    }
    
    public void makeAllClouds(int howMany) {
        //allocate memory....
        int topDown = 150;  //how Far Down from the Top of Screen
        cList = new Cloud[howMany];
        //makeClouds
        
        for(int i = 0; i < howMany; i++) {

            cList[i] = new Cloud (
                    windowW + (int)(Math.random() * 200),  /* cloudX */
                    topDown + (int)(Math.random() * 100) - 50, /* cloudY */
                    "cloudHappy",
                    ".png",
                    (int)(Math.random()*150) + 70,
                    this,
                    1 );            
        }       
    }
    
    //Behaviors-Methods
    public void paintComponent(Graphics g) {
        windowW = myFrame.getWidth();
        windowH = myFrame.getHeight();
        g.setColor(bColor);
        g.fillRect(0, 0, windowW, windowH);

        drawClouds(g);
        alexLion.drawMe(g);
        vac.drawMe(g);
        e1.drawMe(g);
        e2.drawMe(g);
        
    }
    
    public void drawClouds(Graphics g) {
        
        for(int i = 0; i < cList.length; i++) {
            cList[i].drawMe(g);
        }
        
    }
    
    public void checkCollisions() {
        if(vac.collision(alexLion) == true) 
        {
           // System.out.println("VAC COLLISION");
        } 
        
        if(e1.collision(alexLion) == true) 
        {
            //System.out.println("EGG1 COLLISION");
        } 
        
        
        //System.out.println();
        
    }
    
    
    public String getScoreValStr() {
        return Integer.toString(score);
    }
    
    public String getLivesValStr() {
        return Integer.toString(lives);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub 
        alexLion.animate();  //**********
        moveAllObstacles();
        checkCollisions();
        moveClouds();
        repaint();  
    }
    
    public void moveAllObstacles() {
        vac.moveObstacle();
        vac.animate();  //********
        e1.moveObstacle();
        e1.animate();
        e2.moveObstacle();
        e2.animate();
    }
    
    public void moveClouds() {
        for(int i = 0; i < cList.length; i++) {
            cList[i].moveCloud();
            cList[i].animate();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("Hey you typed a key");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
        //System.out.println("Hey you pressed a key");
        //System.out.println("Key has keyCode of " +  e.getKeyCode());
        // System.out.println("Key has Character of " +  e.getKeyChar());
        //System.out.println();
        
        if(e.getKeyCode()== this.SPACE_KEY) {
            alexLion.jump();
            repaint();
        }
        //Change 4 move repaint to inside the if...
        // repaint();   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
       // System.out.println("Hey you released a key");
    }
}
