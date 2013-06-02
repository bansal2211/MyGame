package gameClasses;


import java.awt.Rectangle;
import java.util.ArrayList;

public class Robot {

    // Constants are Here
    final int JUMPSPEED = -5;
    final int MOVESPEED = 5;

    private int centerX = 68;
    private int centerY = 377;
    private boolean jumped = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean movingUp = false;
    
	private boolean movingDown = false;
    private boolean ducked = false;
    private boolean readyToFire = true;

    private int speedX = 0;
    private int speedY = 0;
    public static Rectangle rect = new Rectangle(0, 0, 0, 0);
    public static Rectangle rect2 = new Rectangle(0, 0, 0, 0);
    public static Rectangle rect3 = new Rectangle(0, 0, 0, 0);
    public static Rectangle rect4 = new Rectangle(0, 0, 0, 0);
    public static Rectangle yellowRed = new Rectangle(0, 0, 0, 0);
   
    public static Rectangle footleft = new Rectangle(0,0,0,0);
    public static Rectangle footright = new Rectangle(0,0,0,0);
   
   
    /*private Background bg1 = StartingClass.getBg1();
    private Background bg2 = StartingClass.getBg2();*/

    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    public void update() {
        // Moves Character or Scrolls Background accordingly.

        /*if (speedX < 0) {
            centerX += speedX;
        }
        if (speedX == 0 || speedX < 0) {
            bg1.setSpeedX(0);
            bg2.setSpeedX(0);

        }
        if (centerX <= 200 && speedX > 0) {
            centerX += speedX;
        }
        if (speedX > 0 && centerX > 200) {
            bg1.setSpeedX(-MOVESPEED / 5);
            bg2.setSpeedX(-MOVESPEED / 5);
        }*/
    	centerY+= speedY;
    	/*if(centerY >= 70 && centerY <=377){
    		centerY += speedY;
    	}
    	
    	if (centerY<=377 && speedY<0){
    		centerY += speedY;
    	}
    	if (centerY <= 100 && speedY < 0){
    		centerY = 100;
    	}
    	if (centerY >= 70 && speedY > 0){
    		centerY += speedY;
    	}
    	if (centerY >= 377 && speedY > 0){
    		centerY = 377;
    	}*/

        // Updates Y Position
        /*centerY += speedY;

        // Handles Jumping

            speedY += 1;

        if (speedY > 3){
            jumped = true;
        }*/

        // Prevents going beyond X coordinate of 0
        if (centerY + speedY < 60) {
            centerY = 60;
        }
        if (centerY + speedY > 377) {
            centerY = 377;
        }
        if (speedY > 0 && centerY < 377 ){
        	centerY += speedY;
        }
        if (speedY < 0 && centerY >59){
        	centerY += speedY;
        }

       


    }
    
    public void moveUp(){
    	speedY = JUMPSPEED
    			;
    }
    
    public void moveDown(){
    	speedY = -JUMPSPEED;
    }

   /* public void moveRight() {
        if (ducked == false) {
            speedX = MOVESPEED;
        }
    }

    public void moveLeft() {
        if (ducked == false) {
            speedX = -MOVESPEED;
        }
    }*/
    
    public void stopUp(){
    	speedY=0;
    	/*setMovingUp(false);
    	stop();*/
    }
    public void stopDown(){
    	speedY=0;
    	/*setMovingDown(false);
    	stop();*/
    }

    public void stopRight() {
        setMovingRight(false);
        stop();
    }

    public void stopLeft() {
        setMovingLeft(false);
        stop();
    }

    private void stop() {
        if (isMovingUp() == false && isMovingDown() == false) {
            speedY = 0;
        }

        /*if (isMovingUp() == false && isMovingDown() == true) {
            moveDown();
        }

        if (isMovingUp() == true && isMovingDown() == false) {
            moveUp();
        }*/

    }

    /*public void jump() {
        if (jumped == false) {
            speedY = JUMPSPEED;
            jumped = true;
        }

    }*/

    public void shoot() {
        if (readyToFire) {
            Projectile p = new Projectile(centerX + 50, centerY - 15);
            projectiles.add(p);
        }
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public boolean isJumped() {
        return jumped;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public boolean isDucked() {
        return ducked;
    }

    public void setDucked(boolean ducked) {
        this.ducked = ducked;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public ArrayList getProjectiles() {
        return projectiles;
    }

    public boolean isReadyToFire() {
        return readyToFire;
    }

    public void setReadyToFire(boolean readyToFire) {
        this.readyToFire = readyToFire;
    }

	public boolean isMovingDown() {
		return movingDown;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}
	
	public boolean isMovingUp() {
		return movingUp;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}


}