package com.ningcheng.zero.web.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

/**
 * @author ningcheng
 * @date 2017/10/9
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private static final String FILE_PATH = "/tmp/image/";

    private static final String CHARSET_UTF8 = "utf-8";

    private static final String DEFAULT_FILE_NAME = "upload_test_file";

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public @ResponseBody
    String importFromXML(HttpServletRequest request, @RequestParam("fileName") String fileName) throws Exception {
        FileOutputStream fos = null;
        InputStream is = null;
        try {
            request.setCharacterEncoding(CHARSET_UTF8);
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (!isMultipart) {
                throw new RuntimeException("错误请求");
            }
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);
            FileItem item = items.get(0);
            if (StringUtils.isBlank(fileName)) {
                fileName = DEFAULT_FILE_NAME;
            }
            String imagePath = FILE_PATH + fileName + ".jpg";
            if (!item.isFormField()) {
                File file = new File(imagePath);
                if (file.exists()) {
                    if (!file.delete()) {
                        throw new RuntimeException("文件删除失败");
                    }
                }
                File folder = file.getParentFile();
                if (folder != null && !folder.exists()) {
                    FileUtils.forceMkdir(folder);
                }
                if (!file.createNewFile()) {
                    throw new RuntimeException("文件创建失败");
                }

                FileInputStream fis = new FileInputStream(file);
                OutputStream os = item.getOutputStream();

                byte[] b = new byte[1024];
                while (is.read(b) != -1) {
                    fos.write(b);
                }
                is.close();
                fos.close();

//                BufferedImage bi = ImageIO.read(item.getInputStream());
//                ImageIO.write(bi, "jpg", file);
            }
        } catch (Exception e) {
            return "fail " + e.getMessage();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {

            }
        }
        return "success";
    }

    @RequestMapping(value = "download", method = RequestMethod.GET)
    public @ResponseBody
    String exportToXML(HttpServletResponse response, @RequestParam("fileName") String fileName) {
        FileInputStream fis = null;
        OutputStream os = null;
        try {
            if (StringUtils.isBlank(fileName)) {
                fileName = DEFAULT_FILE_NAME;
            }
            response.setHeader("Content-Type", CONTENT_TYPE);
            response.addHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName + ".jpg", CHARSET_UTF8));
            String imagePath = FILE_PATH + fileName + ".jpg";
            File file = new File(imagePath);
            if (!file.exists()) {
                throw new RuntimeException("文件不存在");
            }

            byte[] b = new byte[1024];
            fis = new FileInputStream(file);
            os = response.getOutputStream();
            while (fis.read(b) != -1) {
                os.write(b);
            }

//            BufferedImage bi = ImageIO.read(file);
//            ImageIO.write(bi, "jpg", response.getOutputStream());
        } catch (IOException e) {
            return "fail " + e.getMessage();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {

            }
        }
        return "success";
    }
}
