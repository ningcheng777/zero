package zero.common.base.object;

import java.util.Date;

/**
 * @author ningcheng
 * @date 2018/1/3
 */
public class CommonObject extends BaseObject {

    private Long id;
    private Date addTime;
    private Date updateTime;
    private String oper;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

}
