package fLionPac;

import java.awt.Color;
import java.awt.Graphics;

public class Lion extends Obstacle {
    /* we think we need to make the lion:
     * jump
     * do collisions did it collide with any other object
     */
    
    private int ySpeed;
    private int origY;
    
//    private int gameBBXLoc = 0;
//    private int gameBBYLoc = 0;
//    private int gameBBWidth = 0;
//    private int gameBBHeight = 0;
//    private boolean showGameBB = false;
    
    public Lion(int x, int y, String fileName,
            String ext, int mW, GameWindow gw, int numOfPics) {
        
        super(x, y, fileName, ext, mW, gw, numOfPics);
        // TODO Auto-generated constructor stub
        
        ySpeed = 0;
        origY = y;
    }
    
    public void animate() {
        super.animate();
        
        //CHANGE 2 MOVE BEFORE YOU CHANGE THE SPEED
        super.setYLoc(super.getYLoc()+ySpeed);
        ySpeed += GameWindow.L_GRAVITY;
        //super.setYLoc(super.getYLoc()+ySpeed);  dont do it after
        
        if(super.getYLoc() > origY) {
            super.setYLoc(origY);
            //CHANGE 3 ADD A YSPEED WHEN YOU HIT THE GROUNDSC
            ySpeed = 0; //  I added this
        }
        
        
    }
    
    public void jump() {
       
        //***** CHANGE 1 ADD SOME SERIOUS GRAVITY
        ySpeed += -(GameWindow.L_GRAVITY*13);  
    }
    
    
    /* This sets up a bounding box for collisions based on 
     * an inset value provided by gameWindow
     */
//    public void setGameBBInsets(int gBBX, int gBBY, int gBBW, int gBBH) {
//        gameBBXLoc = gBBX;
//        gameBBYLoc = gBBY;
//        gameBBWidth = gBBW;
//        gameBBHeight = gBBH; 
//    }
    

//    public void drawMe(Graphics g) {
//        super.drawMe(g);
//        g.setColor(Color.YELLOW);
//        g.drawRect(
//                super.getXLoc() - (int)(super.getBW() * 0.5) + gameBBXLoc, 
//                super.getYLoc() - (int)(super.getBH() * 0.5) + gameBBYLoc, 
//                gameBBWidth /* super.getBW() - (2*gameBBXLoc) */, 
//                gameBBHeight /* super.getBW() - (2*gameBBYLoc) */
//                        );
//        
//        
//    }
    
    

}
