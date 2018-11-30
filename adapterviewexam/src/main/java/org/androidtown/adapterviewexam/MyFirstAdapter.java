package org.androidtown.adapterviewexam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseAdapter은 추상 클래스이므로 메서드 오버라이딩 필요.
 * 어댑터를 구현하는 기본 클래스
 */
public class MyFirstAdapter extends BaseAdapter {
    private final List<Weather> mData;
    private Map<String, Integer> mWeatherImageMap;

    public MyFirstAdapter(List<Weather> data) {
        mData = data;
        mWeatherImageMap = new HashMap<>();
        mWeatherImageMap.put("맑음", R.drawable.sunny);
        mWeatherImageMap.put("구름", R.drawable.cloudy);
        mWeatherImageMap.put("비", R.drawable.rainy);
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

   /**
    * 각 아이템이 화면에 보일 때 호출되는 메서드
    * 아이템 하나하나가 화면에 표시될 때마다 호출되며, 여기서 화면에 표시할 레이아웃과 데이터를 모두 작성해야 한다.
    * */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /**
         * LayoutInflater 클래스란?
         * Activity 이외의 클래스에서 Context를 통해 XML로 정의한 레이아웃을 로드하여 View로 반환해주는 클래스
         */
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
            ImageView weatherImage = (ImageView) convertView.findViewById(R.id.weather_image);
            TextView cityText = (TextView) convertView.findViewById(R.id.city_text);
            TextView tempText = (TextView) convertView.findViewById(R.id.temp_text);
            holder.cityText = cityText;
            holder.tempText = tempText;
            holder.weatherImage = weatherImage;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Weather weather = mData.get(position);
        holder.cityText.setText(weather.getCity());
        holder.tempText.setText(weather.getTemp());
        holder.weatherImage.setImageResource(mWeatherImageMap.get(weather.getWeather()));
        return convertView;
    }
    static class ViewHolder {
        ImageView weatherImage;
        TextView cityText;
        TextView tempText;
    }

}
