package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ Description  -  -    :  分页返回信息类
 * @ Create    -  -  -    ：2018/12/17 19：30
 * @ Author    -  -  -    ：Ti
 * @ Version   -  -  -    : 1.0
 **/
public class PageResult<T> implements Serializable {
    Long total;

    List<T> rows;


    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}