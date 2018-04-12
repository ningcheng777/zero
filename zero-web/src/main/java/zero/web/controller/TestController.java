package zero.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ningcheng
 * @date 2017/10/9
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody
    String test() {
        return "success";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download1(HttpServletResponse response)
            throws Exception {
        response.setContentType("application/msexcel;charset=GBK");
        response.setHeader("Content-Disposition", "attachment;filename=sss.csv");
        OutputStream out = response.getOutputStream();
        out.write("a1,a2\n".getBytes());
        out.write("a3,a4".getBytes());
        response.flushBuffer();
    }
}
