package zero.common.base.exception;

/**
 * @author ningcheng
 * @date 2017/11/10
 */
public class CommonServiceException extends RuntimeException {

    public CommonServiceException(String message, Object... args) {
        super(String.format(message, args));
    }

    public CommonServiceException(String message) {
        super(message);
    }

    public CommonServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonServiceException(Throwable cause) {
        super(cause);
    }

    public CommonServiceException() {
    }
}
