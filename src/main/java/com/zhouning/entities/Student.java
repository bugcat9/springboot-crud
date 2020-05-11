package com.zhouning.entities;

/**
 * 学生
 *
 * @author zhouning
 */
public class Student {
    /**
     * 姓名
     */
    private String name;

    /**
     * 学号，学号作为标识，不能相同
     */
    private Integer sno;

    public Student() {}

    public Student(String name, Integer sno) {
        this.name = name;
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sno=" + sno +
                '}';
    }
}
