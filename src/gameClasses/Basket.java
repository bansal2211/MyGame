package gameClasses;

import java.awt.Rectangle;

public class Basket {
	final int MOVESPEED = 5;

    private int centerX = 170;
    private int centerY = 465;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private int speedX = 0;
    private int speedY = 0;
    public static Rectangle r = new Rectangle(0,0,0,0);
    
    public void update(){
    	
    	if (centerX + speedX < 120) {
            centerX = 120;
        }
        if (centerX + speedX > 750) {
            centerX = 750;
        }
        if (speedX > 0 && centerX < 750 ){
        	centerX += speedX;
        }
        if (speedX < 0 && centerX >120){
        	centerX += speedX;
        }
        r.setBounds(centerX-54+20, centerY-15, 70, 30);
    }
    
    public void moveLeft(){
    	speedX = -MOVESPEED;
    }
    public void moveRight(){
    	speedX = MOVESPEED;
    }
    public void stopMoving(){
    	speedX = 0;
    }
    
    public int getCenterX() {
		return centerX;
	}
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	public int getCenterY() {
		return centerY;
	}
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	public boolean isMovingLeft() {
		return movingLeft;
	}
	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}
	public boolean isMovingRight() {
		return movingRight;
	}
	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getSpeedY() {
		return speedY;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	public int getMOVESPEED() {
		return MOVESPEED;
	}
	
}
