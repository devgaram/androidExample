package org.androidtown.implicitintentexam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialPhone(View view) {
        EditText editText = (EditText) findViewById(R.id.phone_number_edit);
        dialPhoneNumber(editText.getText().toString());
    }

    private void dialPhoneNumber(String phoneNumber) {
        //암시적 인텐트, ACTION_DIAL 설정
        /**
         * 암시적 인텐트의 4가지 속성(모두 다 사용X)
         * Action : Intent.ACTION_DIAL과 같은 미리 정의된 액션
         * URL Data : tel:0310000000과 같은 URL 형태의 데이터
         * Type : text/plain과 같은 MIME타입
         * Extras : String과 같은 인텐트에 담을 일반적인 데이터
         */
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phoneNumber));

        //이러한 인텐트를 처리할 수 있는 액티비티가 있으며
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
