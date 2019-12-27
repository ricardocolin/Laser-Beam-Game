package com.tutorial.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class BasicEnemy extends GameObject {
	
	private Handler handler;
	
	private BufferedImage enemy_image;

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler; 
		
		velX = 5;
		velY = 5;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		enemy_image = ss.grabImage(1,2,16,16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16,16, 0.02f, handler));
	}

	public void render(Graphics g) {
		
		
		
		//if(id==ID.Player)g.setColor(Color.white);
		//else if(id==ID.Player2)g.setColor(Color.red);
		//g.fillRect((int)x,(int)y,32,32);
		
		g.drawImage(enemy_image, (int)x, (int)y, null);
	}
		
	}
