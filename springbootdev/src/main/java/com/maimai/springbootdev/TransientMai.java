package com.maimai.springbootdev;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: springbootmaimai
 * @description: 2
 * @author: zxb
 * @create: 2020-01-08 15:09
 **/
public class TransientMai implements Serializable {
    private Date nowtime = new Date();
    private String uid;
    private transient String pswd;

    public TransientMai(String uid, String pswd) {
        this.uid = uid;
        this.pswd = pswd;

    }

    public String toString() {
        String password = null;
        if (pswd == null)
            password = "没有值";
        else
            password = pswd;
        return "nowtime=" + nowtime + "uid=" + uid + "pswd=" + password;

    }

}
