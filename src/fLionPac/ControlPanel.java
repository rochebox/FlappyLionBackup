package fLionPac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class ControlPanel extends JPanel {
    
    int controlPW;
    int controlPH;
    Color bc = new Color(43, 7, 153);
    GameWindow myGW;
    
    //Font tr = new Font("TimesRoman", Font.PLAIN, 18);
    Font trb = new Font("TimesRoman", Font.BOLD, 36);
    Font tri = new Font("TimesRoman", Font.ITALIC, 18);
    //Font trbi = new Font("TimesRoman", Font.BOLD+Font.ITALIC, 18);
    //Font h = new Font("Helvetica", Font.PLAIN, 18);
    //Font c = new Font("Courier", Font.PLAIN, 18);
    //Font d = new Font("Dialog", Font.PLAIN, 18);   
    
    JPanel scoreP;
    JPanel livesP;
    
    public ControlPanel(int w, int h, GameWindow gw) {
        controlPW = w;
        controlPH = h;
        myGW = gw;
        this.setSize(controlPW, controlPH);
        this.setPreferredSize(new Dimension(controlPW, controlPH));
        this.setMaximumSize(new Dimension(controlPW, controlPH));
        this.setBackground(bc);
        this.setLayout(new BorderLayout());
        Border b = BorderFactory.createBevelBorder(
                BevelBorder.LOWERED, 
                Color.PINK,
                Color.RED,  
                Color.BLACK,
                Color.DARK_GRAY );
      
        this.setBorder(b);
        
        //This sets up the Score  with two parts Score Label and Score Text
        scoreP = new JPanel();
        scoreP.setPreferredSize(new Dimension(controlPW/2, controlPH));
        scoreP.setBackground(Color.BLUE);
        //scoreP.setLayout(new BorderLayout());  Going to use Grid Rather Than Boarder
        scoreP.setLayout(new GridLayout(1,2,10, 5));
        // x,x,x,x, --> top, left, bottom right
        scoreP.setBorder(BorderFactory.createEmptyBorder(5,(int)(controlPW* 0.05), 5, 5)); 
        scoreP.setVisible(true);
        
        JLabel scoreLabel = new JLabel("Score: ");
        scoreLabel.setFont(trb);
        scoreLabel.setForeground(Color.WHITE);
        scoreP.add(scoreLabel /*, BorderLayout.CENTER */);
        
        JLabel scoreText = new JLabel( "   " + myGW.getScoreValStr());
        scoreText.setFont(trb);
        scoreText.setForeground(Color.WHITE);
        scoreP.add(scoreText /*, BorderLayout.CENTER */);
        
        this.add(scoreP, BorderLayout.WEST);
        
        //This sets up the Lives  with two parts Lives Label and Lives Text
        livesP = new JPanel();
        livesP.setPreferredSize(new Dimension(controlPW/2, controlPH));
        livesP.setBackground(bc);
        
        livesP.setVisible(true);
        //livesP.setLayout(new BorderLayout());
        livesP.setLayout(new GridLayout(1,2,10, 5));
        // x,x,x,x, --> top, left, bottom right
        livesP.setBorder(BorderFactory.createEmptyBorder(5,(int)(controlPW* 0.05), 5, 5)); 
        
        JLabel livesLabel = new JLabel("Lives: " );
        livesLabel.setFont(trb);
        livesLabel.setForeground(Color.WHITE);
        
        JLabel livesText = new JLabel(" " +  myGW.getLivesValStr());
        livesText.setFont(trb);
        livesText.setForeground(Color.WHITE);
        
        livesP.add(livesLabel);
        livesP.add(livesText);
        
        this.add(livesP, BorderLayout.EAST);
        
 
        this.setVisible(true);
        
    }
    
    public void setMyGW(GameWindow gw) {
        myGW = gw;
    }
    
    public GameWindow getMyGW() {
        return myGW;
    }

}
