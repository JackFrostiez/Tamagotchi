package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import gui.GUI;

public class Game implements Runnable{

	private GUI gui;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage tamagotchi;
	private BufferedImage interf;
	private BufferedImage home;
	
	private void init(){
		gui = new GUI();
		interf = ImageLoader.loadImage("/textures/interface.png");
		home = ImageLoader.loadImage("/textures/home.png");
		tamagotchi = ImageLoader.loadImage("/textures/tamagotchi.jpg");
	}
	
	private void tick(){
		
	}
	
	private void render(){
		bs = gui.getCanvas().getBufferStrategy();
		if(bs==null){
			gui.getCanvas().createBufferStrategy(3);
			return; 
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, 350, 350);
		
		//DRAWING
		g.drawImage(interf, 0, 0, null);
		g.drawImage(home, 0, 60, null);
		g.drawImage(tamagotchi, 35, 70, null);
		
		//COORDINATES FOR BUTTON IMPLEMENTATION
/*		g.drawRect(2, 2, 86, 55);
		g.drawRect(180, 2, 86, 55);
	top	g.drawRect(183, 2, 80, 55);
		g.drawRect(267, 2, 80, 55);
*/		
/*		g.drawRect(2, 290, 86, 59);
		g.drawRect(91, 290, 87, 60);
	bot	g.drawRect(180, 290, 86, 60);
		g.drawRect(265, 290, 84, 60);
*/		//end drawing
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		init();
		
		while(running){
			tick();
			render();
		}
		stop();
	}
	
	public void start() {
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		if(!running){
			return;
		}
		running=false;
		try {
			thread.join();
		}
		catch(InterruptedException ip){
			ip.printStackTrace();
		}
	}
	
}
