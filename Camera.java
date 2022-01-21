package pog;

import processing.core.PApplet;
import processing.core.PConstants;

public class Camera {
	float x, y, z;
	float dX, dY, dZ;
	float speed = 0.1f;
	PApplet p;
	
	Camera(float x, float y, float z, float dX, float dY, float dZ, PApplet p){
		this.x = x;
		this.y = y;
		this.z = z;
		this.dX = dX;
		this.dY = dY;
		this.dZ = dZ;
		this.p = p;
	}
	
	void move() {
		
		
		
		dY = PApplet.constrain(dY, 0, PConstants.PI);
		

		
		if(Main.w) {
			z += speed * PApplet.sin(dX );
			x += speed * PApplet.cos(dX );
		}
		if(Main.a) {
			z -= speed * PApplet.sin(dX  - PConstants.HALF_PI);
			x -= speed * PApplet.cos(dX  - PConstants.HALF_PI);	
				}
		if(Main.s) {
			z -= speed * PApplet.sin(dX );
			x -= speed * PApplet.cos(dX );
		}
		if(Main.d) {
			z += speed * PApplet.sin(dX  - PConstants.HALF_PI);
			x += speed * PApplet.cos(dX  - PConstants.HALF_PI);	
		}
		if(Main.space) {
			y -= speed;
		}
		if(Main.shift) {
			y += speed;
		}
		if(Main.up) {
			dY -= 0.03;
		}
		if(Main.down) {
			dY += 0.03;
		}
		if(Main.left) {
			dX += 0.03;
		}
		if(Main.right) {
			dX -= 0.03;
		}
		
		if(dX > PConstants.TWO_PI) {
			dX -= PConstants.TWO_PI;
		}
		if(dX < 0) {
			dX += PConstants.TWO_PI;
		} 
		if(dY > PConstants.TWO_PI) {
			dY -= PConstants.TWO_PI;
		} 
		if(dY < 0) {
			dY += PConstants.TWO_PI;
		} 
	}
}
