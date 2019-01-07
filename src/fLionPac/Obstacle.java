package fLionPac;

public class Obstacle extends ScreenObj {

    private int moveSpeed;  //we like data hiding

    public Obstacle(int x, int y, String fileName, String ext, int mW, GameWindow gw, int numOfPics) {
        super(x, y, fileName, ext, mW, gw, numOfPics);
        // TODO Auto-generated constructor stub
        
        moveSpeed = (int) (Math.random() * 10) + 3;
    }
    
    // recycling of old movecloud....
    public void moveObstacle() {
        
        super.setXLoc(super.getXLoc()-moveSpeed); 
        
        if(super.getXLoc() < -1 * (super.getBW() + 200) )
        {
            super.setXLoc(super.getGameWindow().getWidth() 
                    + super.getBW() 
                    + (int)(Math.random() * 200) 
                    );
            //moveSpeed = (int) (Math.random() * 10) + 3;
        }
        //System.out.println("Hi from moveCloud xLoc is " + super.getXLoc());   
    }
    
    public void setMoveSpeed(int nSpeed) {
        moveSpeed = nSpeed;
    }
    
    public boolean collision(Obstacle theLion) {
        boolean didC = false;
        // get all the x coordinate info you need....
        int theLionX0 = theLion.getXLoc() -(int)(theLion.getBW()/2) + theLion.getGameBBXExtra();
        int theLionX1 = theLionX0 + theLion.getGameBBW();    
        
        int myX0 = this.getXLoc() -(int)(this.getBW()/2)+ this.getGameBBXExtra();
        int myX1 = myX0 + this.getGameBBW();
        
        //now adding y
        int theLionY0 = theLion.getYLoc() -(int)(theLion.getBH()/2)+ theLion.getGameBBYExtra();
        int theLionY1 = theLionY0 + theLion.getGameBBH();  
        
        int myY0 = this.getYLoc() -(int)(this.getBH()/2) + this.getGameBBYExtra();
        int myY1 = myY0 + this.getGameBBH();
        
        
        //*** Now Checking each point
        //Check point1 myX0, myY0 to see if its in Lion Box
        if( 
                theLionX0 <= myX0 && myX0 <= theLionX1 && 
                theLionY0 <= myY0 && myY0 <= theLionY1
          ) {
            //System.out.println("Point 1A Intersect");
            didC = true;
        }
        //Check point2 myX1, myY0 to see if its in Lion Box
        if( 
                theLionX0 <= myX1 && myX1 <= theLionX1 && 
                theLionY0 <= myY0 && myY0 <= theLionY1
          ) {
            //System.out.println("Point 2A Intersect");
            didC = true;
        }
        
        //Check point3 myX0, myY1 to see if its in Lion Box
        if( 
                theLionX0 <= myX0 && myX0 <= theLionX1 && 
                theLionY0 <= myY1 && myY1 <= theLionY1
          ) {
            //System.out.println("Point 3A Intersect");
            didC = true;
        }
        
        //Check point4 myX1, myY1 to see if its in Lion Box
        if( 
                theLionX0 <= myX1 && myX1 <= theLionX1 && 
                theLionY0 <= myY1 && myY1 <= theLionY1
          ) {
            //System.out.println("Point 4A Intersect");
            didC = true;
        }
        
        //Now do it the other way around
        //Check point1 LionX0, LionY0 to see if its in Lion Box
        if( 
                myX0 <= theLionX0 && theLionX0  <= myX1 && 
                myY0 <= theLionY0 && theLionY0  <= myY1
          ) {
            //System.out.println("Point 1B Intersect");
            didC = true;
        }  
        
      //Check point2 LionX1, LionY0 to see if its in Lion Box
        if( 
                myX0 <= theLionX1 && theLionX1  <= myX1 && 
                myY0 <= theLionY0 && theLionY0  <= myY1
          ) {
            //System.out.println("Point 2B Intersect");
            didC = true;
        }  
        
        //Check point3 LionX0, LionY1 to see if its in Lion Box
        if( 
                myX0 <= theLionX0 && theLionX0  <= myX1 && 
                myY0 <= theLionY1 && theLionY1  <= myY1
          ) {
            //System.out.println("Point 3B Intersect");
            didC = true;
        } 
        
        //Check point4 LionX1, LionY1 to see if its in Lion Box
        if( 
                myX0 <= theLionX1 && theLionX1  <= myX1 && 
                myY0 <= theLionY1 && theLionY1  <= myY1
          ) {
            //System.out.println("Point 4B Intersect");
            didC = true;
        }  
    
        if (myX0 < theLionX1 &&
                myX1 > theLionX0 &&
                myY0 < theLionY1 &&
                myY1 > theLionY0) {
                    didC = true;
                    //System.out.println("Extra Intersect");
             }

        
           
        
        if(
                
                
                (theLionX0 < myX0 && myX0 < theLionX1 ||
                theLionX0 < myX1 && myX1 < theLionX1 )
                
                ||
                
                (myX0 < theLionX0 && theLionX0 < myX1 ||
                 myX1 < theLionX1 && theLionX1 < myX1) 
                ) 
        {
            if(
                   
                    
                    (theLionY0 < myY0 && myY0 < theLionY1 ||
                    theLionY0 < myY1 && myY1 < theLionY1) 
                    ||
                    (myY0 < theLionY0 && theLionY0 < myY1 ||
                     myY0 < theLionY1 && theLionY1 < myY1) 
                
                    ) 
            {
              
            didC = true;
            //System.out.println("We have an  intersect..." );
        }
       }

        return didC;
    }
    
    
    
    



}
