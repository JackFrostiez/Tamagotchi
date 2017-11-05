package gui;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI {

	Canvas canvas;
	
	public GUI() {
		JFrame frame = new JFrame("Tamagotchi");
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(350,350));
		
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas(){
		return canvas;
	}

}
