package gameClasses;

import java.awt.Rectangle;

public class Enemy {
	
	protected int maxHealth, currentHealth, power, speedX, speedY=1, centerX, centerY;
	public int health=5;
	public boolean isVisible;
	public Rectangle r= new Rectangle(0,0,0,0);
	public int getMaxHealth() {
		return maxHealth;
	}


	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}


	public int getCurrentHealth() {
		return currentHealth;
	}


	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}


	public int getPower() {
		return power;
	}


	public void setPower(int power) {
		this.power = power;
	}


	public int getSpeedX() {
		return speedX;
	}


	public void setSpeedX(int speedX) {
		this.speedX = speedX;
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


	


	// Behavioral Methods
	public void update() {
	centerY += speedY;
	r.setBounds(centerX-28, centerY-35, 28, 45);
	
	
    if (centerY + speedY > 425) {
        isVisible = false;
    }
    
	
	/*r.setBounds(centerX-25, centerY-25, 50, 60);
	
	if (r.intersects(Robot.yellowRed)){
		checkCollision();
	}*/
	}
	
	
	public void die(){
		
	}
	
	public void attack(){
		
	}


	public int getSpeedY() {
		return speedY;
	}


	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}


	public boolean isVisible() {
		return isVisible;
	}


	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

}
