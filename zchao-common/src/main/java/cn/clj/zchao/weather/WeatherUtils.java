package cn.clj.zchao.weather;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/**
 * 〈通过get请求向网站http://wthrcdn.etouch.cn/weather_mini获取某个 城市的天气状况数据，数据格式是Json〉
 *
 * @author 22902
 * @create 2018/12/17
 */
public class WeatherUtils {
    /**
     * 通过城市名称获取该城市的天气信息
     *
     * @param cityName 城市名
     * @return
     */

    public static String GetWeatherData(String cityName) {
        StringBuilder sb=new StringBuilder();;
        try {
            String weather_url = "http://wthrcdn.etouch.cn/weather_mini?city="+cityName;

            URL url = new URL(weather_url);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            GZIPInputStream gzin = new GZIPInputStream(is);
            // 设置读取流的编码格式，自定义编码
            InputStreamReader isr = new InputStreamReader(gzin, "utf-8");
            BufferedReader reader = new BufferedReader(isr);
            String line = null;
            while((line=reader.readLine())!=null){
                sb.append(line+" ");
            }
            reader.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(sb.toString());
        return sb.toString();

    }


    /**
     * 将JSON格式数据进行解析 ，返回一个weather对象
     * @param cityName 城市名
     * @return WeatherInfo
     */
    private static WeatherInfo GetWeather(String cityName){

        String weatherInfobyJson = WeatherUtils.GetWeatherData(cityName);

        JSONObject dataOfJson = JSONObject.fromObject(weatherInfobyJson);
        if(dataOfJson.getInt("status")!=1000){
            return null;
        }

        //创建WeatherInfo对象，提取所需的天气信息
        WeatherInfo weatherInfo = new WeatherInfo();
        //从json数据中提取数据
        String data = dataOfJson.getString("data");
        dataOfJson = JSONObject.fromObject(data);
        //城市
        weatherInfo.setCityname(dataOfJson.getString("city"));
        //温度
        String temperature = dataOfJson.getString("wendu");
        weatherInfo.setTemperature(temperature);
        //获取预测的天气预报信息
        JSONArray forecast = dataOfJson.getJSONArray("forecast");
        //取得当天的
        JSONObject result=forecast.getJSONObject(0);
        //时间
        weatherInfo.setDate(result.getString("date"));
        //风力
        weatherInfo.setFengli(formatFengli(result.getString("fengli")));
        //风向
        weatherInfo.setFengxiang(result.getString("fengxiang"));
        //阴晴
        weatherInfo.setType(result.getString("type"));
        return weatherInfo;
    }

    private static String formatFengli(String date){
        Pattern p = Pattern.compile(".*<!\\[CDATA\\[(.*)\\]\\]>.*");
        Matcher m = p.matcher(date);
        String group ="";
        if(m.matches()) {
            group= m.group(1);
        }
        return group;

    }
    public static void main(String[] args){
        WeatherInfo weatherinfo = WeatherUtils.GetWeather("通州");
        System.out.println(weatherinfo.toString());
    }
}
