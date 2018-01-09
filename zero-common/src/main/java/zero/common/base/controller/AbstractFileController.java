package zero.common.base.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

/**
 * @author ningcheng
 * @date 2018/1/9
 */
public abstract class AbstractFileController extends BaseController {

    protected ResponseEntity<byte[]> getResponseEntity(String dst, String fileName)
            throws IOException {
        HttpHeaders headers = new HttpHeaders();
        String downloadFielName = new String((fileName).getBytes("UTF-8")
                , "iso-8859-1");
        headers.setContentDispositionFormData("attachment", downloadFielName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(
                getFileByteArray(dst), headers, HttpStatus.CREATED);
    }

    protected abstract byte[] getFileByteArray(String dst) throws IOException;
}
