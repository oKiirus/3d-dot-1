package pog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import processing.core.*;



public class Main extends PApplet{
	
	static boolean w, a, s, d, space, shift, up, right, left, down;
	Dot dot;
	ArrayList<Dot> dots = new ArrayList<Dot>();
	ArrayList<Cube> cubes = new ArrayList<Cube>();
	ArrayList<Cube> render = new ArrayList<Cube>();
	static Camera cam;
	
	public void setup() {
	

		for(float x = -5; x < 5; x += 1) {
		
				for(float z = -5; z < 5; z += 1) {
			
			
		cubes.add(new Cube(x, noise(x, z), z, 1, 1, 1, this));
				}
		}
	
		cam = new Camera(0, 0, -15, 0, HALF_PI, 0, this);
	}
	
	public void draw() {
		background(0);
		
		Collections.sort(cubes);
		
	rectMode(CENTER);
		stroke(255);
		translate(50, 50);
		rect(cam.x, -cam.z, 1, 1);
		line(cam.x, -cam.z, cam.x + cos((cam.dX - HALF_PI / 4)) * 13, -cam.z + -sin((cam.dX - HALF_PI / 4)) * 13);
		line(cam.x, -cam.z, cam.x + cos((cam.dX + HALF_PI / 4)) * 13, -cam.z + -sin((cam.dX + HALF_PI / 4)) * 13);
		
		for(int i = 0; i < dots.size(); i++) {
			Dot dot = dots.get(i);
			rect(dot.x / 2, dot.z / 2, 1, 1);
			
		}
		
		for(int i = 0; i < cubes.size(); i++) {
			Cube cube = cubes.get(i);
			cube.show();
			
			
		}
		
	
		for(int i = 0; i < dots.size(); i++) {
			
		Dot dot = dots.get(i);
		dot.show();
		
	}
	
	
	
		cam.move();
	}
	

	public void settings() {
		size(800,800);
	}
	
	public static void main(String args[]) {
	    PApplet.main("pog.Main"); //Change me!
	}
	
	
public void keyPressed() {
		

		
		switch(key) {
		
			
		case 97:
			a = true;	
			break;
		case 115:
			s = true;	
			break;
		case 100: 
			d = true;
			break;
		case 119: 
			w = true;
			break;
			
		
		
		
		}
		
		switch(keyCode) {
		case 32:
			space = true;
			break;
			
		case 16:
			shift = true;	
			break;
		case 38:
			up = true;	
			break;
		case 39:
			right = true;	
			break;
		case 40: 
			down = true;
			break;
		case 37: 
			left = true;
			break;
		
	
	}
	
	}
	
	public void keyReleased() {
		switch(key) {
	
			
		case 97:
			a = false;	
			break;
		case 115:
			s = false;	
			break;
		case 100: 
			d = false;
			break;
		case 119: 
			w = false;
			break;
	
		
	
	}
		switch(keyCode) {
		case 32:
			space = false;
			break;
			
		case 16:
			shift = false;	
			break;
		case 38:
			up = false;	
			break;
		case 39:
			right = false;	
			break;
		case 40: 
			down = false;
			break;
		case 37: 
			left = false;
			break;
		
	
	}
	}
	
	
}