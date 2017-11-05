package graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage stillEgg, leftEgg, rightEgg, crackedEgg, baby;

	public static void init() {
		stillEgg = ImageLoader.loadImage("/textures/egg1.png");
		leftEgg = ImageLoader.loadImage("/textures/egg2.png");
		rightEgg = ImageLoader.loadImage("/textures/egg3.png");
		crackedEgg = ImageLoader.loadImage("/textures/egg4.png");
		baby = ImageLoader.loadImage("/textures/baby.png");
	}
}
