package zero.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.time.LocalDateTime;

/**
 * @author ningcheng
 * @date 2017/10/9
 */
@RestController
public class TestController {

    @GetMapping("/ok")
    public String test() {
        return "success";
    }

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("date", LocalDateTime.now().toString());
        return mv;
    }

    @GetMapping("/now")
    public ModelAndView now() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("now");
        mv.addObject("date1", LocalDateTime.now().toString());
        return mv;
    }

    @GetMapping("/download")
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
