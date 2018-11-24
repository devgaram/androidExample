package org.androidtown.androidexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Send 버튼을 눌렀을 때 호출되는 메서드
     * android:onclick 속성에 정의한 이름으로 된 메서드는 다음의 규칙을 따라야 한다.
     * 접근 지정자는 public
     * 반환값은 void이어야 함
     * 파라미터를 뷰만 가지고 있어야 함
     */
    public void sendMessage(View view) {
        /**
         * new Intent(Context 타입, Class 타입)
         * Context : 무엇이든 할 수 있는 존재, Activity 클래스가 Context를 상속받고 있기 때문에 this를 넘겨도 된다.
         * Class : Intent를 통해서 수행할 대상
         */
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        /**
         * EditText의 값을 인텐트의 추가 정보로 저장한다.
         * 인텐트에는 key-value 쌍(Map 자료구조)으로 이루어진 데이터를 추가 정보로 저장할 수 있다.
         * EXTRA_MESSAGE 상수 : 키값을 다른 클래스에서도 사용할 수 있도록 할 수 있다.
         * 키값은 UNIQUE 해야한다.
         */
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent); //인텐트를 동작하게 하여 다른 액티비티를 화면에 표시한다.
    }
}

