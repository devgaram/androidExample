package org.androidtown.adapterviewexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //자료
        ArrayList<Weather> data = new ArrayList<Weather>();
        data.add(new Weather("수원", "25도", "맑음"));
        data.add(new Weather("안양", "22도", "비"));
        data.add(new Weather("부천", "22도", "구름"));
        data.add(new Weather("성남", "24도", "맑음"));
        data.add(new Weather("서울", "28도", "구름"));
        data.add(new Weather("광주", "30도", "비"));
        data.add(new Weather("부산", "20도", "비"));
         /**
         * 간단한 리스트나 배열을 표현할 수 있는 기본 어댑터
         * context, 기본 정의된 레이아웃 id, List(ArrayList)
         */
        MyFirstAdapter adapter = new MyFirstAdapter(data);

        //뷰와 어댑터 연결
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        /**
         * 클릭 이벤트 추가
         * OnItemClickListener을 구현한다.
         * onItemClick() 콜백 메서드가 전달받는 파라미터
         * parent : 클릭이 일어난 객체인 listView
         * view : 클릭된 아이템 뷰
         * position : 클릭된 아이템의 위치
         * id : 아이템의 고유 id(cf, DB 사용시에는 실제 DB의 id 값이고 DB 사용안하면 id 값은 position 값과 같다)
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, position + " 번째 아이템 선택", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
