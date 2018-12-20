package entity;

import java.io.Serializable;

/**
 * @Description -  -    :  返回信息
 * @Create -  -  -    ： 2018/12/19 16:46
 * @Author -  -  -    ： Ti
 * @Version -  -  -    :  1。0
 **/
public class Result implements Serializable {
    private boolean success;
    private String message;

    public Result() {
    }

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void isSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{success='" + success + "'" +
                ", message='" + message + "'" +
                "}";
    }
}