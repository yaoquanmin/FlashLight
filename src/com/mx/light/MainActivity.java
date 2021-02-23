package com.mx.light;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.Button;
import android.widget.Switch;
import android.app.ActionBar;



public class MainActivity extends Activity implements OnClickListener {

	/**
	 * ��¼״̬
	 */
	private boolean flag = true;
	/**
	 * ͼƬ��ť
	 */
	private Switch switch1;
	/**
	 * ��׿������
	 */
	private Camera camera;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        
       this.getActionBar().setElevation(0);
		
        switch1 = (Switch)findViewById(R.id.switch1);
		switch1.setOnClickListener(this);
        
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.switch1:
			if (flag) {
				openFlash();
			
				flag = !flag;
			} else {
				closeFlash();
				
				flag = !flag;
			}
			break;

		default:
			break;
		}
	}

	/**
	 *close light
	 */
	private void closeFlash() {
        camera = Camera.open();
		camera.stopPreview();
		camera.release();
	}

	/**
	 * open light
	 */
	private void openFlash() {
		camera = Camera.open();
		if (camera == null) {
			Toast.makeText(MainActivity.this, "Your phone no FlashLight", 2000).show();
			return;
		}
		Parameters parameters = camera.getParameters();
		parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
		camera.setParameters(parameters);
		camera.startPreview();
	}
    
    

    @Override
    protected void onDestroy() {
        super.onDestroy();
    

	
		closeFlash();
	
       // finish();
        
	}

}
