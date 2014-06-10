package will.awesome.coolcolors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



//Pretty much this entire class is copied
//A lot if it goes over my head minus the crazy shit
public class PanelThread extends Thread {
	private SurfaceHolder _surfaceHolder;
    private DrawingPanel _panel;
    private boolean _run = false;
    
    
    //THis be some crazy shit I'm still workin' on 
    public static final String TAG = "drawingPanel";
    private final static int    MAX_FPS = 60;   // desired fps
    private final static int    MAX_FRAME_SKIPS = 5;    // maximum number of frames to be skipped
    private final static int    FRAME_PERIOD = 1000 / MAX_FPS;  // the frame period
    private int timeA = 0;
    private int timeB = 0;
//end crazy shit variables
    

	public PanelThread(SurfaceHolder surfaceHolder, DrawingPanel panel) {
		 _surfaceHolder = surfaceHolder;
         _panel = panel;
	}

	public void setRunning(boolean run) { //Allow us to stop the thread
        _run = run;
    }


    
	@Override
    public void run() {
        Canvas c;
       Log.d(TAG, "Starting game loop");
        long beginTime;     // the time when the cycle begun
        long timeDiff;      // the time it took for the cycle to execute
        int sleepTime;      // ms to sleep (<0 if we're behind)
        int framesSkipped;  // number of frames being skipped 
        sleepTime = 0;

        while (_run) {     //When setRunning(false) occurs, _run is 
            c = null;      //set to false and loop ends, stopping thread
            
            
            beginTime = System.currentTimeMillis();//crazy shit 
            framesSkipped = 0;//crazy shit 
            try {


                c = _surfaceHolder.lockCanvas(null);
                synchronized (_surfaceHolder) {
                
                	_panel.update();
                 //Insert methods to modify positions of items in onDraw()
                 _panel.postInvalidate();
                }
            } finally {
                if (c != null) {
                    _surfaceHolder.unlockCanvasAndPost(c);
                }
                
              //start crazy shit 
                timeDiff = System.currentTimeMillis() - beginTime;//crazy shit 
                sleepTime = (int)(FRAME_PERIOD - timeDiff);//crazy shit 
                if(sleepTime > 0){//crazy shit 
                    try{//crazy shit 
                        Thread.sleep(sleepTime);
                    }
                    catch(InterruptedException e){
                        //
                    }
                }
                while(sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
                    // catch up - update w/o render
                    _panel.update();
                    sleepTime += FRAME_PERIOD;
                    framesSkipped++;
                }
                
              //end crazy shit 
                
            }
         
        }
    }
    
    
    
    
    
    

}
