package pog;

import processing.core.PApplet;
import processing.core.PConstants;

public class Dot {
	float x, y, z, rX, rY, delta, angleDiff, angle;
	PApplet p;
	Camera cam;
	
	Dot(float x, float y, float z, PApplet p){
		this.x = x;
		this.y = y;
		this.z = z;
		this.p = p;
		this.cam = Main.cam;
	}
	
	void show() {
		
		angle = PApplet.atan2(z - Main.cam.z, x - Main.cam.x) - Main.cam.dX;
		angleDiff = (Main.cam.dX - angle + PConstants.PI + PConstants.TWO_PI) % PConstants.TWO_PI - PConstants.PI;
		
		
		

		//if(angleDiff >= -PConstants.QUARTER_PI && angleDiff <= PConstants.QUARTER_PI) {
			
			
		
	
		
		//3D
		
		
		delta = p.width / PApplet.cos(angle) / PApplet.dist(x, z, Main.cam.x, Main.cam.z) * 2;
		
		rX = (PApplet.sin(Main.cam.dX) * (x - Main.cam.x) + -PApplet.cos(Main.cam.dX) * (z - Main.cam.z))* delta;
		rY = (PApplet.sin(Main.cam.dY) * (y - Main.cam.y) + PApplet.cos(Main.cam.dY) * ((x - Main.cam.x) * PApplet.cos(Main.cam.dX) + (z - Main.cam.z) * PApplet.sin(Main.cam.dX)))* delta;
		
	
		//3D
		
		
		/*
		
		p.noStroke();
		p.fill(255);
		p.rect(rX, rY, 2, 2);
		
		p.pop();
		
		*/
		
		
		
		
	
		
	}
}
