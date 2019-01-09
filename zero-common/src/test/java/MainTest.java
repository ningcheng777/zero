import com.google.common.collect.ImmutableList;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ningcheng
 * @date 2018/1/25
 */
public class MainTest {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println(ImmutableList.copyOf(InetAddress.getAllByName("www.baidu.com")));
    }

}
