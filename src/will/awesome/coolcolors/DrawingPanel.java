package will.awesome.coolcolors;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class DrawingPanel extends SurfaceView implements Callback {
PanelThread _thread;

float x = 1;
float y = 1;
String awesomeString = "yeahhhh";
boolean movingLeft = false;
boolean movingRight = false;
boolean movingUp = false;
boolean movingDown = true;
GameRules gameRules; //Make a gameRules object
Bitmap enemyBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.enemy); //Get R.Drawable.enemy and make it a bitmap.
Bitmap PlayerBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.smallcircle); //Make a bitmap using R.Drawable.smallcircle
//note the bitmaps can only be called within a view. i.e. player.java cannot call this due to the "getResources()" bit.

	public DrawingPanel(Context context) {
		super(context);
		getHolder().addCallback(this); //Copied Code
		
		gameRules = new GameRules(this); //Call gameRuels constructor
		Player playplay =  new Player(PlayerBitmap ,this); //Call player constructor.
        gameRules.one = playplay; //Set the main player as the player object
        gameRules.enemyBitmap = enemyBitmap; //Set the enemy image as R.drawable.enemy
		// TODO Auto-generated constructor stub
	}

	
	
	//Constrcutors that are required
	public DrawingPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public DrawingPanel(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}
	
	//end req constructors

	 @Override
	    public void surfaceCreated(SurfaceHolder holder) {

		 //<Copied code>
	     setWillNotDraw(false); //Allows us to use invalidate() to call onDraw()


	     _thread = new PanelThread(getHolder(), this); //Start the thread that
	    // _thread.setPriority(_thread.MAX_PRIORITY);
	        _thread.setRunning(true);                     //will make calls to 
	        _thread.start();                             //onDraw()
	       //</Copied Code>
	       
	     	    }
	    @Override
	    public void surfaceDestroyed(SurfaceHolder holder) {
	    	//<Copied Code>
	     try {
	            _thread.setRunning(false);                //Tells thread to stop
	     _thread.join();                           //Removes thread from mem.
	 } catch (InterruptedException e) {}
	    }
	    
	    	//</Copied Code>


	public void onDraw(Canvas canvas){
		canvas.drawColor(Color.WHITE); //Clear the window and make it white
		gameRules.draw(canvas);		   //Call the draw method in GameRules
	       super.onDraw(canvas);
	       
	       
	}
	public void update(){ //This is constantly being called while the program is opened.

		//gameRules.update();
			
	}

	
	
	public boolean onTouchEvent(MotionEvent event) { // This method is constantly Checking if the screen had been 
													//touched.
	   gameRules.one.HandleTouchEvent(event);     //call the player object within GameRules and get the method
	   												//to handle touch events.
	return false; //copied code
	}
	

}
