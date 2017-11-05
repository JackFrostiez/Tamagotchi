package gui;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI {

	public GUI() {
		JFrame frame = new JFrame("Tamagotchi");
		
		Canvas canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(350,350));
		
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(canvas);
		frame.pack();
	}

}
