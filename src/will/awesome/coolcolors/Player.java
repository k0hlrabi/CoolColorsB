package will.awesome.coolcolors;

import android.graphics.Bitmap;
import android.view.MotionEvent;

public class Player extends GameObject {

	//This code is pretty self explanatory
	boolean movingLeft;
	boolean movingRight;
	boolean movingUp;
	boolean movingDown;
	float moveYSpeed = 5;
	float moveXSpeed= 5;
	int maxWidth = 0;
	int maxHeight = 0;
	
	public Player(Bitmap b, DrawingPanel p) {
		
		super(b,p); //Call the constructor of the class that Drawing Panel extends. This must Be done
					//within the constructor of an object that has a super class (i.e. a object that
					// has the word EXTENDS after the public class CLASSNAME part)
		posY = 100; // Non-scaled position. 
		posX = 100;	// Non-scaled position
		
		//after this it gets really easy.
		movingLeft = false;
		movingRight = false;
		movingUp = false;
		movingDown = false;	
		moveXSpeed = 10;
		moveYSpeed = 10;
		
	}
	
	@Override
	public void update(){
		if(movingLeft){
			posX-=moveXSpeed;
		}else if(movingRight){
			posX+=moveXSpeed;
		}else if(movingUp){
			posY -=moveYSpeed;
		}else if(movingDown){
			posY +=moveYSpeed;
		}
		
		if(posX >= _refPanel.getWidth()){
			movingLeft = true;
			movingRight = false;
			movingDown = false;
			movingUp = false;
		}
		else if(posX <= 0){
			movingLeft = false;
			movingRight = true;
			movingDown = false;
			movingUp = false;
			
		}else if(posY >= _refPanel.getHeight()){
			movingLeft = false;
			movingRight = false;
			movingDown = false;
			movingUp = true;
			
		}else if(posY <= 0){
			movingLeft = false;
			movingRight = false;
			movingDown = true;
			movingUp = false;
			
		}
		
		
	}
	
	
	
	
	//This is not the method that handles the motion events. It is a class to be called
	//within a method that handles motionEvents. (A motionEvent is like someone tapping the screen.
	
	public void HandleTouchEvent(MotionEvent event){
		
		    //awesomeString = " " +xTouch + " " + yTouch;
		    switch (event.getAction()) {  //With this action
		        case MotionEvent.ACTION_DOWN: // in this case do what's below
		      
		        	if(movingLeft){
		        	movingLeft = false;
		        	movingRight = false;
		        	movingUp = false;
		        	movingDown = true;
		        	}else if(movingRight){
		        		movingLeft = false;
			        	movingRight = false;
			        	movingUp = true;
			        	movingDown = false;
		        	}else if(movingDown){
		        		movingLeft = false;
			        	movingRight = true;
			        	movingUp = false;
			        	movingDown = false;
		        	}else if(movingUp){
		        		movingLeft = true;
			        	movingRight = false;
			        	movingUp = false;
			        	movingDown = false;
		        	}else{
		        		
		        		
		        		movingDown = true;
		        	}
		        		
		        	break;
	  
		    }
		
		
	
	}

}
