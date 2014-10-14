package pk.edu.iba.threadingasynctask;

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

public class AsyncTaskActivity extends Activity {

	private ImageView mImageView;
	private ProgressBar mProgessBar;
	private Button btnLoad;
	private Button btnOther;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.async_task);
		mImageView=(ImageView)findViewById(R.id.imageView1);
		mProgessBar=(ProgressBar)findViewById(R.id.progressBar1);
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
				Toast.makeText(AsyncTaskActivity.this, "I am working",Toast.LENGTH_LONG).show();
			}
		});	}
	
	
	class LoadIconTask extends AsyncTask<Integer,Integer,Bitmap>{

		@Override
		protected Bitmap doInBackground(Integer... params) {
			Bitmap tmp=BitmapFactory.decodeResource(getResources(), params[0]);
			for(int i=1;i<11;i++){
				sleep();
				publishProgress(i*10);
				}
				return tmp;
				
				
			
		}

		@Override
		protected void onPreExecute() {
			
			mProgessBar.setVisibility(ProgressBar.VISIBLE);
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			mProgessBar.setVisibility(ProgressBar.INVISIBLE);
			mImageView.setImageBitmap(result);
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			mProgessBar.setProgress(values[0]);
			
		}
		
		
		
	}


	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
