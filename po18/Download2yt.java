package po18;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Download2yt {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.2yt.tw/64427/37318384.html");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setUseCaches(false);
        conn.setConnectTimeout(50000); // 请求超时5秒
        // 设置HTTP头:
        conn.setRequestProperty("Accept","text/html, */*; q=0.01");
        conn.setRequestProperty("Accept-Language","zh-CN,zh;q=0.9");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36");
        // 连接并发送HTTP请求:
        conn.connect();
        // 判断HTTP响应是否200:
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("bad response");
        }
        // 获取所有响应Header:
        Map<String, List<String>> map = conn.getHeaderFields();
        for (String key : map.keySet()) {
            //System.out.println(key + ": " + map.get(key));
        }
        // 获取响应内容:
        InputStream input = conn.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(input, "gbk"));
        StringBuffer sb = new StringBuffer();



        BufferedWriter writer = new BufferedWriter(new FileWriter("tempPopo.txt"));

        String line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            if(line.startsWith("&nbsp;&nbsp;&nbsp;&nbsp;")) {
                line = line.replace("<br />", "").replace("&nbsp;&nbsp;&nbsp;&nbsp;", "");
                sb.append(line);
                writer.write(line);
                writer.newLine();
                writer.flush();
            }
        }
        //System.out.println(sb);
        System.out.println("-------------success----------");


    }
}
