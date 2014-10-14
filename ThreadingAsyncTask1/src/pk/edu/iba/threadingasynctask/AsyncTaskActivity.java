package pk.edu.iba.threadingasynctask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AsyncTaskActivity extends Activity {

	private View mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.async_task);
		mImageView=findViewById(R.id.imageView1);
		//mProgessBar=findViewById(R.id.)
	}
}
