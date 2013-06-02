package gameClasses;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Projectile {
	 private int x, y, speedX;
	 private Rectangle r;
	 
	   public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	private boolean visible;

	public Projectile( int startX, int startY) {
		x= startX;
		y=startY;
		speedX=12;
		visible=true;
		r= new Rectangle(0,0,0,0);
		// TODO Auto-generated constructor stub
	}
	
	public void update(){
		x += speedX;
		r.setBounds(x, y, 30, 6);
		if (x>=800){
			visible = false;
			r=null;
		}
			
		if (x<800)
			checkCollision();
	}
	
	private void checkCollision() {
		ArrayList<Ballon> ballons = startingClass.getBallon_Objects();
		for (int i=0; i< ballons.size(); i++){
			if (r.intersects(ballons.get(i).r)){
				startingClass.burstSound.play();
				int cX = ballons.get(i).centerX;
				int cY= ballons.get(i).centerY;
				startingClass.getBallon_Objects().get(i).isVisible = false;
				
				startingClass.getBallon_Objects().remove(i);
				startingClass.getBallon_Bottom_Objects().add(new BallonBottom(cX, cY+25));
				
				startingClass.ballonScore++;
				
			}
		}
		
		
		/*if(r.intersects(StartingClass.hb.r)){
		visible = false;
		if (StartingClass.hb.health>0){
			StartingClass.hb.health -= 1;
		}
		
		if (StartingClass.hb.health==0){
			StartingClass.hb.setCenterX(-100);
			StartingClass.score += 5;
		}
		
		}

		if (r.intersects(StartingClass.hb2.r)){
		visible = false;
		if (StartingClass.hb2.health>0){
			StartingClass.hb2.health -= 1;
		}
		
		if (StartingClass.hb2.health==0){
			StartingClass.hb2.setCenterX(-100);
			StartingClass.score += 5;
		}
		


		}*/
		}

}
