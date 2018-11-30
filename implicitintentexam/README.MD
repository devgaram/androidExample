인텐트
-------
#### 명시적 인텐트와 암시적 인텐트
- 명시적 인텐트 : 보통 다른 앱 안에서 다른 구성 요소를 시작할 때 사용한다.
- 암시적 인텐트 : 수행할 액션을 지정하면, 해당 작업을 처리 할 수 있는 구성요소가 선택되어 작업을 수행한다.

사용 예
~~~
Intent intent = new Intent(Intent.ACTION_DIAL);
intent.setData(Uri.parse("tel:" + phoneNumber));
if (intent.resolveActivity(getPackageManager()) != null) {
  startActivity(intent);
} else {
  Toast.makeText(this, "수행할 앱이 없어요", Toast.LENGTH_SHORT).show();
}
~~~

#### 암시적 인텐트의 4가지 속성
- ACTION : Intent.ACTION_DIAL과 같은 미리 정의된 액션
- URL DATA : tel:0000000000과 같은 url 형태의 데이터
- TYPE : text/plain과 같은 MIME 타입
- EXTRAS : String과 같은 인텐트를 담을 일반적인 
