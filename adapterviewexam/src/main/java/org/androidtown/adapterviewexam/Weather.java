package org.androidtown.adapterviewexam;

/**
 * 모델 클래스 : 현실의 사물 또는 객체를 표현(속성, 동작)하기 위해 클래스로 작성한 것
 * 이 모델 클래스는 캡슐화를 위해 private 접근 지정자를 사용했다. *readme.md
 */
public class Weather {
    private String city;
    private String temp;
    private String weather;

    public Weather(String city, String temp, String weather) {
        this.city = city;
        this.temp = temp;
        this.weather = weather;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     * toString 메서드 재정의
     * toString()은 자바에서 모든 클래스가 가지고 있는 기본 메서드로 해당 객체의 정보를 표시하는 기능
     * 이 메서드를 재정의하여 원하는 정보 표시
     * */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Weather{");
        sb.append("city='").append(city).append('\'');
        sb.append(", temp='").append(temp).append('\'');
        sb.append(", weather='").append(weather).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
