package com.maimai.springbootlast.entity;

import java.util.List;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-30 11:51
 **/
public class Grils {
    private Integer id;
    private List<Gril> grilList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Gril> getGrilList() {
        return grilList;
    }

    public void setGrilList(List<Gril> grilList) {
        this.grilList = grilList;
    }
}
