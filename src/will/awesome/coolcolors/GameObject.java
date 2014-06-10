package will.awesome.coolcolors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

//Game object class. all drawn things come from this so i don't have to write a bunch of repetitive code

public class GameObject {
	public Bitmap _image;			//Image to be drawn
	public boolean movable;			//if the gameObject can be moved set to true (not used yet)
	public float  posX;				// x position
	public float posY;				// y position
	public Rect collisionRect;		//I'm working on making invisible polygons for collisions
	public int objWidth;			// width of object
	public int objHeight;			// height of object
	public int type;				//type of object. I have 1 as enemy and 2 as player, 0 as default
	 
	public int newHeight;			//Unimplimented scaling code: the height of the scaled object
	public int newWidth;			// unimplimented scaling code: the width of the scaled object
	public Bitmap scaledBitmap;		// Unimplimented scaling code: the scaled image
	public float Scale;				// Unimplimented scaling code: the object's scale.
	public DrawingPanel _refPanel;	// The drawing panel that the object will be drawn on. This allows for things like
									// stopping the gameObject at a certain point or other things.
	
	public GameObject(Bitmap pic, DrawingPanel d){
		posX = 0;												//By default the position is at 0,0 and the width is 10.
		posY = 0;
		objWidth = 10;
		objHeight = 10;
		_refPanel = d;											//Forces the object to state the panel it is going to be drawn on to avoid
																// NullPointExceptions
		collisionRect = new Rect((int)posX, (int)posY, (int)posX+objWidth, (int)posY+objHeight);	//Unused collsion Rectangle codde
		type = 0;												//by def all gameobjects are 0
		_image = pic;
		Scale = (float)_image.getHeight()/(float)d.getHeight();	//Unused scaling code
		 newWidth = Math.round(_image.getWidth());//Unused scaling code
		 newHeight = Math.round(_image.getHeight());//Unused scaling code
		 scaledBitmap = Bitmap.createScaledBitmap(_image, newWidth, newHeight, true);//Unused scaling code
		
		
	}
	
	public void update(){
		
		
	}
	
	public void onCreate(){
	
		
	}
	
	public void onDestory(){
		
		
	}
	
	public void Draw(Canvas c){
		
		
		
		
		
		 
		 
		 
		//collisionRect= new Rect((int)posX, (int)posY, (int)posX + newWidth, (int)posY + newHeight ); //Unused code
		
	    c.drawBitmap(_image,posX,posY, new Paint());
		
		
	}
	
	//unused collsion method
	public boolean checkHit(GameObject a){
		return collisionRect.intersect(a.collisionRect);
		
		
		
	}
	
	
	
	
}
