package gameClasses;

public class BallonBottom extends Enemy{

	public BallonBottom (int centerX,int  centerY){
		setCenterX(centerX);
		setCenterY(centerY);
		isVisible= true;
	}
	public void update(){
		centerY += speedY;
		r.setBounds(centerX-10, centerY-13, 20, 26);
		
		if(centerY > 450 && centerY < 475){
			checkCollisionWithbasket();
		}
	    if (centerY + speedY > 500) {
	        isVisible = false;
	    }
	    
	}
	private void checkCollisionWithbasket() {
		// TODO Auto-generated method stub
		if (r.intersects(Basket.r)){
			startingClass.basketScore++;
			startingClass.collectSound.play();
		}
		
	}
}
