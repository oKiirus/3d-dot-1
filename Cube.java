package pog;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;

public class Cube implements Comparable<Cube>{
	float x, y, z, rX, rY, delta, angleDiff, angle, width, length, height, distToCam;
	PApplet p;
	Camera cam;
	ArrayList<Dot> points = new ArrayList<Dot>();
	Dot TBL, TBR, TTL, TTR, BBL, BBR, BTL, BTR;
	
	Cube(float x, float y, float z, float width, float height, float length, PApplet p){
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = width;
		this.height = height;
		this.length = length;
		this.p = p;
	
		
		
			for(float py = y; py <= y + height; py += height) {
				
				for(float pz = z; pz <= z + length; pz += length) {
					for(float px = x; px <= x + width; px += width) {
					points.add(new Dot(px, py, pz, p));
				
				}
			}
		}
		this.TBL = points.get(0);
		this.TBR = points.get(1);
		this.TTL = points.get(2);
		this.TTR = points.get(3);
		this.BBL = points.get(4);
		this.BBR = points.get(5);
		this.BTL = points.get(6);
		this.BTR = points.get(7);
	}
	
	void show() {
p.push();
distToCam = PApplet.sqrt(PApplet.pow(Main.cam.x - x, 2) + PApplet.pow(Main.cam.y - y, 2) + PApplet.pow(Main.cam.z - z, 2));
		for(int i = 0; i < points.size(); i++) {
			Dot point = points.get(i);
			point.show();
		}
		p.translate(p.width / 2, p.height / 2);
		
		
		if(Main.cam.y < y + height / 2) {
			p.fill(255, 0, 0);
			p.quad(TBL.rX, TBL.rY, TBR.rX, TBR.rY, TTR.rX, TTR.rY, TTL.rX, TTL.rY); //top
		} else if(Main.cam.y > y + height / 2) {
			p.fill(255, 255, 0);
			p.quad(BBL.rX, BBL.rY, BBR.rX, BBR.rY, BTR.rX, BTR.rY, BTL.rX, BTL.rY); //bottom
		}
		
		if(Main.cam.x < x + width / 2) {
			p.fill(0, 255, 0);
			p.quad(BBL.rX, BBL.rY, BTL.rX, BTL.rY, TTL.rX, TTL.rY, TBL.rX, TBL.rY); //left
		} else if(Main.cam.x > x + width / 2) {
			p.fill(0, 255, 255);
			p.quad(TBR.rX, TBR.rY, TTR.rX, TTR.rY, BTR.rX, BTR.rY, BBR.rX, BBR.rY); //right
		}
		
		if(Main.cam.z < z + length / 2) {
			p.fill(0, 0, 255);
			p.quad(TBL.rX, TBL.rY, TBR.rX, TBR.rY, BBR.rX, BBR.rY, BBL.rX, BBL.rY); //front
		} else if(Main.cam.z > z + length / 2) {
			p.fill(255, 255, 255);
			p.quad(TTL.rX, TTL.rY, TTR.rX, TTR.rY, BTR.rX, BTR.rY, BTL.rX, BTL.rY); //back
		}
	
	
		
	
	
		
		
	
	
	
	

		
		
		
	
		p.pop();
	}
	
	
	public int compareTo(Cube c) {
		return (int) (c.distToCam - distToCam);
	}


	
}
