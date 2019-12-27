package com.tutorial.Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {
	

	
	private Handler handler;
	Random r = new Random();
	private Color col;
	
	int dir = 0;

	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler; 
		
		velX = (r.nextInt(5 - -6) + -6);
		velY = (r.nextInt(5 - -6) + -6);
		
		if(velX == 0)velX = 1;
		if(velY == 0)velY = 1;
		
		//CHANGE DIRECTION AND SPEED OF MENU LINES
//		dir = r.nextInt(2);
//		if(dir == 0) {
//			velX = 2;
//			velY = 7;
//		}else if (dir == 1) {
//			velX = 7;
//			velY = 2;
//		}
		
		
		//MAKE RANDOM COLOR
		col = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,32,32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		
		
		handler.addObject(new Trail(x, y, ID.Trail, col, 16,16, 0.05f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(col);
		g.fillRect((int)x,(int)y,16,16);
		
	}
}
