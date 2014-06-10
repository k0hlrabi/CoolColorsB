package will.awesome.coolcolors;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Iterator;






//Everything here is not copied.


public class GameRules {
	
	public ArrayList<GameObject> objectList = new ArrayList<GameObject>(); //make a new array for the objects (not player)
																		   // It's an array list because the size can be changed dymanically
	public DrawingPanel _refPanel; //More on this in the constructor
	public Rect GameBounds; //Unused. if you are making a game with user controlled direction
							//A gameBounds rectangle will let you create a rectangle that is the playable area
							// then you can make the player stop if you exit the rectangle
	public  Player one;		//The main player. This is called outside of the object list so it 
							//Cannot be accidently deleted
	public Bitmap enemyBitmap; //bitmap for the enemy as a public variable so 
	public int NumEnemiesActive=0;		//number of enemies (red dots)
	public GameRules(DrawingPanel p){
		_refPanel = p;					//make ref to drawing panel just incase
		
	
	
	}
	
	
	
	public void update(){			//This is always running
		
		for(GameObject s : objectList)  
		{
		    s.update();
		    //Have the enemies be destoryed after leaving the screen
		
		}
		
		
		
		
		if(NumEnemiesActive > 0){
		Iterator a = objectList.iterator();				//an iterator is an object who's sole purpose is to 
														// go through the arraylist.
		
		while(a.hasNext()){								//while there is still more shit for "a" to go through
			
			GameObject objj = (GameObject)a.next();		//make the current thing "a" is on a variable
			if(objj.type == 1 && (Math.abs(objj.posX) > _refPanel.getWidth()) ){	// if the enemy is off screen delete that shit
				//objsToBeRemoved.add(s);
				//s = null;
				a.remove();
				NumEnemiesActive--;
			}
			
			
		}
		
		}
			
	
		
			one.update();			//update the player
			
			
			
			
			
			
			
		}
		 
			
		
		
		
		
	
	public void addGameObject(GameObject a){ //Try not to use this
		objectList.add(a);
		
	}
	
	public void removeGameObject(GameObject a){		//don't fuckin' use this (causes a concurrentModifcation error 
													// because if you try removing an object in an array that is 
													// currently being modified/iterated over/looked at it makes the 
													// computer cry
															
		
		//objectList.remove(a);
		a=null;
		NumEnemiesActive--;
	}
		
		public void onCreate(){						// Not really used but having a "Run one time on startup" method doesn't hurt
			
		
		for(GameObject s : objectList)  
		{
		    s.onCreate();
		}
		
	}
	
	public void draw(Canvas canvas){				// The code that is called when you have to draw anything
		//canvas.drawColor(Color.BLACK);
		update();									// this is called here because if you attempt to loop over
													// the objectList to draw everything and for some reason 
													// you need to remove an object you will get an error
		
		
		for(GameObject s : objectList){
			s.Draw(canvas);
		}
		one.Draw(canvas);							//again, the player has everything done separately 
	}
	
	public void addEnemy(){							//use this to add the red dots that fly across the screen
		objectList.add(new Enemy(enemyBitmap,_refPanel));
		NumEnemiesActive++;
	}
	

}
