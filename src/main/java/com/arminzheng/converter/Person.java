package com.arminzheng.converter;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Person
 *
 * @author zy
 * @version 2022/4/17
 */
@Data
public class Person implements Serializable {
    private String name;
    private Date birthday;
}
