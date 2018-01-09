package zero.common.base.result;

/**
 * @author ningcheng
 * @date 2017/11/17
 */
public class Result {

    private boolean isSuccess;
    private Integer status;
    private String msg;
    private Object value;

    public Result() {
        this.isSuccess = true;
        this.status = ResultStatus.NORMAL;
    }

    public Result(Object value) {
        this.isSuccess = true;
        this.value = value;
        this.status = ResultStatus.NORMAL;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
