package pk.edu.iba.asynctask1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView mImageView;
	private ProgressBar mProgressbar;
	private int mDelay=500;
	private Button btnLoad;
	private Button btnOther;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mImageView=(ImageView)findViewById(R.id.imageView1);
		mProgressbar=(ProgressBar)findViewById(R.id.progressBar1);
		btnLoad=(Button)findViewById(R.id.btnLoad);
		btnLoad.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				new LoadIconTask().execute(R.drawable.ic_launcher);
			
			}
		});
		btnOther=(Button)findViewById(R.id.btnOther);
		btnOther.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this,"I am working",Toast.LENGTH_LONG).show();
				
			}
		});	
		
	}
	
	class LoadIconTask extends AsyncTask<Integer, Integer,Bitmap>{

		
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			mProgressbar.setVisibility(ProgressBar.VISIBLE);
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			mProgressbar.setVisibility(ProgressBar.INVISIBLE);
			mImageView.setImageBitmap(result);
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			mProgressbar.setProgress(values[0]);
		}

		@Override
		protected Bitmap doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			Bitmap tmp=BitmapFactory.decodeResource(getResources(), params[0]);
			for (int i=1;i <11;i++){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				publishProgress(i*10);
			}
			return tmp;
		}
		
		
		
	}
}
