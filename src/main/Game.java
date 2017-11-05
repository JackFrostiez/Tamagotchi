package main;

import gui.GUI;

public class Game implements Runnable{

	private GUI gui;
	private Thread thread;
	private boolean running = false;
	
	private void init(){
		gui = new GUI();
	}
	
	private void tick(){
		
	}
	
	private void render(){
		
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
