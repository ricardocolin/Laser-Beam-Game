package com.tutorial.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject {
	
	private Handler handler;
	
	private BufferedImage enemy_image;

	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler; 
		
		velX = 2;
		velY = 9;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		enemy_image = ss.grabImage(1,3,16,16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.CYAN, 16,16, 0.02f, handler));
	}

	public void render(Graphics g) {
		
		
		
		//if(id==ID.Player)g.setColor(Color.white);
		//else if(id==ID.Player2)g.setColor(Color.red);
		//g.fillRect((int)x,(int)y,32,32);
		
		g.drawImage(enemy_image, (int)x, (int)y, null);
		
	}
}
