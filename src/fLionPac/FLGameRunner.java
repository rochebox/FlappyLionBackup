package fLionPac;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class FLGameRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int fWidth = 1000;
		int fHeight = 900;
		
		JFrame f = new JFrame("Flappy Lion");
		f.setSize(fWidth, fHeight);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new BorderLayout());
		
		
		// make game window
		GameWindow g = new GameWindow(fWidth, (int)(fHeight*0.85)-30, f);
		ControlPanel cp = new ControlPanel(fWidth, (int)(fHeight*0.10), g);
		//cp.setMyGW(g);
		f.add(g, BorderLayout.CENTER);
		f.add(cp, BorderLayout.SOUTH);
		
		f.setVisible(true);

	}

}
