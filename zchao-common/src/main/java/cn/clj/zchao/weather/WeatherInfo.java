package cn.clj.zchao.weather;

/**
 * 〈天气〉
 *
 * @author 22902
 * @create 2018/12/17
 */
public class WeatherInfo {
    /**
     * 时间
     */
    private String date;
    /**
     *气温
     */
    private String temperature;
    /**
     * 城市名
     */
    private String cityname;
    /**
     * 风力
     */
    private String fengli;
    /**
     * 风向
     */
    private String fengxiang;

    /**
     * 阴晴
     */
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "date='" + date + '\'' +
                ", temperature='" + temperature + '\'' +
                ", cityname='" + cityname + '\'' +
                ", fengli='" + fengli + '\'' +
                ", fengxiang='" + fengxiang + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
