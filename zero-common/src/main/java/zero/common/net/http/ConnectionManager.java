package zero.common.net.http;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * @author ningcheng
 * @date 2017/11/1
 */
public class ConnectionManager {

    public static HttpResponse<String> get(String url) {
        HttpResponse<String> ret = null;
        try {
            ret = Unirest.get(url).header("cache-control", "no-cache").asString();
        } catch (UnirestException e) {
            ///
        }
        return ret;
    }

    public static HttpResponse<String> post(String url, Object requestBody) {
        HttpResponse<String> ret = null;
        try {
            ret = Unirest.post(url).header("cache-control", "no-cache").body(requestBody).asString();
        } catch (Exception e) {
            ///
        }
        return ret;
    }
}
