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

    public WeatherInfo() {
    }

    public String getDate() {
        return this.date;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public String getCityname() {
        return this.cityname;
    }

    public String getFengli() {
        return this.fengli;
    }

    public String getFengxiang() {
        return this.fengxiang;
    }

    public String getType() {
        return this.type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WeatherInfo(date=" + this.date + ", temperature=" + this.temperature + ", cityname=" + this.cityname + ", fengli=" + this.fengli + ", fengxiang=" + this.fengxiang + ", type=" + this.type + ")";
    }
}
