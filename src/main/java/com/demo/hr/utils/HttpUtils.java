package com.demo.hr.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpUtils {
    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    private static HttpProtocolHandler httpHandler = HttpProtocolHandler.getInstance();

    /**
     * post默认超时时间为3秒
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, String> params) {
        String result = null;
        try {
            result = httpHandler.doPost(url, params);
            //log.info("post url:"+url+";post result:"+result);
        } catch (HttpException e) {
            log.error("http exception:", e);
        } catch (IOException e) {
            log.error("io exception:", e);
        } finally {

        }
        return result;
    }

    public static String uploadFile(String urlStr, Map<String, byte[]> fileMap, String fileName, Map<String, String> map) {
        String res = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
            if (map != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> entry = iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes());
            }

            // file
            if (fileMap != null) {
                Iterator<Map.Entry<String, byte[]>> iter = fileMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, byte[]> entry = iter.next();
                    String inputName = (String) entry.getKey();
                    byte[] inputValue = (byte[]) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    FileNameMap fileNameMap = URLConnection.getFileNameMap();
                    String mimeType = fileNameMap.getContentTypeFor(fileName);

                    StringBuffer strBuf = new StringBuffer();
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + fileName + "\"\r\n");
                    strBuf.append("Content-Type:" + mimeType + "\r\n\r\n");

                    out.write(strBuf.toString().getBytes());

                    out.write(inputValue);
                }
            }

            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();

            // 读取返回数据
            StringBuilder strBuf = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" + urlStr);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }

    public static String getRequestBody(HttpServletRequest request) {
        try {
            InputStream input = request.getInputStream();
            BufferedInputStream bi = new BufferedInputStream(input);
            byte[] bytes = new byte[1024];
            StringBuffer sb = new StringBuffer();
            int len = 0;
            while ((len = bi.read(bytes, 0, 1024)) > 0) {
                sb.append(new String(bytes, 0, len));
            }
            return sb.toString();
        } catch (Exception e) {
            log.error("获取http body失败", e);
            return null;
        }
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        String host = "http://192.168.20.40/weixin.action";
        Map<String, String> map = new HashMap<String, String>();
        map.put("shopId", "278");
        map.put("staffId", "566");
        String url = host + "/o2o/user/listUser";
        //String data = HttpUtils.doPostByParam(url, map);
        //System.out.println(data);
        String data = null;
        for (int i = 0; i < 50; i++) {
            data = post(url, map);
        }
        System.out.println("result1=" + data);
        long end = System.currentTimeMillis();
        long t1 = (end - begin);
        begin = System.currentTimeMillis();

        System.out.println("result2=" + data);
        end = System.currentTimeMillis();
        long t2 = (end - begin);
        System.out.println("take:t1=" + t1);
        System.out.println("take:t2=" + t2);
    }
}
