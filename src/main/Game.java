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
	
	//just a test so delete this
	private BufferedImage tamagotchi;
	
	private void init(){
		gui = new GUI();
		//just a test so delete the tamagotchi
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
		
		//drawing
		
		//drawing this image here was just a test so remove this
		g.drawImage(tamagotchi, 50, 50, null);
		
		//end drawing
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
