package com.noah.entity;/**
 * Created by ljp on 2017/3/7.
 */

/**
 * @author ljp
 * @create 2017 03 07 19:47
 **/
public class Product {
    private Long id;
    private String name;
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
