package com.pinyougou.vo;/*
 * @Description  -  -    :  规格的富合类
 * @Create    -  -  -    ： 2018/12/22 15:11
 * @Author    -  -  -    ： Ti
 * @Version   -  -  -    :  1.0
 **/

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

public class Specification implements Serializable {
    private TbSpecification spec;
    private List<TbSpecificationOption> optionList;


    public Specification() {
    }

    public Specification(TbSpecification spec, List<TbSpecificationOption> optionList) {
        this.spec = spec;
        this.optionList = optionList;
    }

    public TbSpecification getSpec() {
        return this.spec;
    }

    public void setSpec(TbSpecification spec) {
        this.spec = spec;
    }

    public List<TbSpecificationOption> getOptionList() {
        return this.optionList;
    }

    public void setOptionList(List<TbSpecificationOption> optionList) {
        this.optionList = optionList;
    }

    @Override
    public String toString() {
        return "Specification{spec='" + spec + "'" +
                ", optionList='" + optionList + "'" +
                "}";
    }
}