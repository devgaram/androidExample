### ListView & GridView 
- 반복되고 양이 많은 데이터를 표시하고 싶을 때
- 이미지와 같이 메모리를 차지하는 리소스를 표시하고 싶을 때    
- 모두 AdapterView 추상클래스를 상속받아 어댑터 패턴을 사용하여 데이터를 뷰에 표시한다.
- ScrollView의 경우 한번에 모든 컨텐츠를 로드하므로 컨텐츠가 메모리를 많이 사용할 경우 메모리 부족으로 앱이 종료될 수 있다.

### AdapterView
AdapterView를 상속받은 뷰들은 화면에 보이는 내용만 로드하는 기법을 사용한다.

1. AdapterView의 구현
- 데이터를 준비한다.
```{.java}
//MainActivity.java
ArrayList<Weather> data = new ArrayList<Weather>()
data.add(new Weather("수원", "25도", "맑음"));
data.add(new Weather("안양", "22도", "비"));
data.add(new Weather("부천", "22도", "구름"));
data.add(new Weather("성남", "24도", "맑음"));
data.add(new Weather("서울", "28도", "구름"));
data.add(new Weather("광주", "30도", "비"));
data.add(new Weather("부산", "20도", "비"));
```
- 데이터를 뷰에 연결해 줄 어댑터를 준비한다.
```{.java}
//MainActivity.java
MyFirstAdapter adapter = new MyFirstAdapter(data);
```
- 뷰에 어댑터를 붙인다.
```{.java}
//MainActivity.java
ListView listView = (ListView) findViewById(R.id.list_view);
listView.setAdapter(adapter);
```
2. 클릭 이벤트 구현    
**public static interface AdapterView.OnItemClickListener**    
android.widget.AdapterView.OnItemClickListener    
*어댑터뷰의 아이템 클릭시 호출되는 콜백 메서드를 정의한 인터페이스*

Public methods    
**public abstract void onItemClick (AdapterView<?> parent, View view, int position, long id)**    
&nbsp;*parent : 클릭이 일어난 AdapterView *    
&nbsp;*view : AdapterView 안의 클릭된 View = 클릭된 아이템 뷰*    
&nbsp;*position : 클릭된 아이템 뷰의 위치*    
&nbsp;*id : 클릭된 아이템 뷰의 row ID*


```{.java}
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Toast.makeText(MainActivity.this, position + " 번째 아이템 선택", Toast.LENGTH_SHORT).show();
   }
});
```
