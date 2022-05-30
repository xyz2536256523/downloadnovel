package po18;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.*;

public class DownloadPo18 {
    static HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) throws Exception {
        String url = "http://www.2yt.tw/64427/37318384.html";
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .header("Accept","text/html, */*; q=0.01")
                .header("Accept-Language","zh-CN,zh;q=0.9")
                .header("Cookie","_paabbcc=lgqriegbmaj3eoqvf8f26q0tp2; _po18rf-tk001=874eba8ceefb8d431e1e63b746f9818272f021caeb8f141a4f944bf16ff0095ba%3A2%3A%7Bi%3A0%3Bs%3A13%3A%22_po18rf-tk001%22%3Bi%3A1%3Bs%3A32%3A%229s-5IZYLBW94tDzyXvbl-02IVtjzg_k8%22%3B%7D; _ga=GA1.2.1394389911.1653907389; _gid=GA1.2.1657487635.1653907389; url=https%3A%2F%2Fwww.po18.tw; authtoken1=Q2hlcnlsMjUzNjI1NjUyMw%3D%3D; authtoken2=ZTQwOGQ0OGMzNjdjZTE1YmM3NTJjZGU2MzEyZTEzMzQ%3D; authtoken3=438509687; authtoken4=985098084; authtoken5=1653907602; authtoken6=1; bgcolor=bg-default; word=select-m")
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36")
                .header("X-Requested-With","XMLHttpRequest")
                // 设置超时:
                .timeout(Duration.ofSeconds(50))
                // 设置版本:
                .version(Version.HTTP_2).build();
        HttpResponse<InputStream> response = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());
        InputStream body = response.body();
        Reader reader = new InputStreamReader(body, "UTF-8");
        char[] buffer = new char[1024];
        int n;
        while ((n = reader.read(buffer)) != -1) {
            System.out.println(buffer);
        }
        reader.close();

    }
}
