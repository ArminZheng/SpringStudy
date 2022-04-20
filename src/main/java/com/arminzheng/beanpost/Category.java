package com.arminzheng.beanpost;

/**
 * Category
 *
 * @author zy
 * @version 2022/4/20
 */
public class Category {
    private Integer id;
    private String name;

    public Category() {
        System.out.println("Category.Category");
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Category.setName");
    }

    public String toString() {
        return "Category(id=" + this.getId() + ", name=" + this.getName() + ")";
    }
}
