package will.awesome.coolcolors;

import android.R;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 
		 DrawingPanel a = new DrawingPanel(this);		//Make a drawing panel
		 
		 
		 
		 //THis is my stupid way to get screen size and then
		 DisplayMetrics metrics = new DisplayMetrics();			
		 getWindowManager().getDefaultDisplay().getMetrics(metrics);

		int height =  metrics.heightPixels;
		 int width = metrics.widthPixels;
		 LayoutParams lp = new LayoutParams(height,width);
		 	//a.setLayoutParams(ViewGroup.LayoutParams.FILL_PARENT);
		
		 a.setLayoutParams(lp);
		 
		 //end shitty method to get screensize
		 setContentView(a);//the entire screen is dedicated to the DrawingPanel
		        

	
	}
}
