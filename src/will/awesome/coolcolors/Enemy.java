package will.awesome.coolcolors;

import java.util.Random;

import android.graphics.Bitmap;

public class Enemy extends GameObject {

	
	//public DrawingPanel _refPanel;
	public int direction = 0; // the enemy can either be going left or right. -1 indicates left 1 indicated right.
	public float speed = 0;	 //Speeeeed
	public Enemy(Bitmap b, DrawingPanel p) {
		super(b,p);				
		type = 1;			//type 1 is enemy
		//_refPanel = p;
		speed = (float)(p.getWidth()/b.getWidth()/100);			//UNUSED SPEED CODEEE
		Random r = new Random();								//random number
		int x = r.nextInt(5);									//if the random number is 3 or below start on left side going left
																// otherwise go right starting on right side
		if(x <=3){
			posX = 0;
			direction = 1;
		}else{
			posX = (int)_refPanel.getWidth();
			direction = -1;
		}
		
		int y = r.nextInt( _refPanel.getHeight()) ;
		posY = y;
	}
	
	public void update(){
		posX += 10*direction; //SPPEEDD BE 10
	}
	
	
	
	

}
