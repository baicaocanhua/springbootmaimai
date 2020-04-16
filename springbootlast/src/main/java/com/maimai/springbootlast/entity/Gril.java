package com.maimai.springbootlast.entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * @program: springbootmaimai
 * @description: 2
 * @author: zxb
 * @create: 2020-03-11 16:55
 **/
public class Gril implements Serializable {

    private static final long serialVersionUID = 8836888875699038000L;
    @NotNull(message = "这个id必传")
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gril gril = (Gril) o;
        return Objects.equals(id, gril.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
