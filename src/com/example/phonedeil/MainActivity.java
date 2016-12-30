package com.example.phonedeil;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText ed_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_number=(EditText) findViewById(R.id.editText1);
        Button bt_call=(Button)findViewById(R.id.button1);
        bt_call.setOnClickListener(new MyClickListener());
        
    }
    private class MyClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			String number=ed_number.getText().toString().trim();
			if("".equals(number)){
				Toast.makeText(MainActivity.this, "number不能为空", 1).show();
				return ;
			}
			//意图
			Intent intent=new Intent();
			//设置动作
			intent.setAction(Intent.ACTION_CALL);
			//设置要拨打的数据
			intent.setData(Uri.parse("tel:"+number));
			//启动意图
			startActivity(intent);
			
		}
    	
    }
}
