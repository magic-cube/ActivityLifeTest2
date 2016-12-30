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
				Toast.makeText(MainActivity.this, "number����Ϊ��", 1).show();
				return ;
			}
			//��ͼ
			Intent intent=new Intent();
			//���ö���
			intent.setAction(Intent.ACTION_CALL);
			//����Ҫ���������
			intent.setData(Uri.parse("tel:"+number));
			//������ͼ
			startActivity(intent);
			
		}
    	
    }
}
