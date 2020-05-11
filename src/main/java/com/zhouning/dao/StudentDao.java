package com.zhouning.dao;

import com.zhouning.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouning
 */
@Repository
public class StudentDao {
    private static Map<Integer, Student> students = null;

    static {
        students = new HashMap<>();
        students.put(101, new Student("张三",101));
        students.put(102, new Student("李四",102));
        students.put(103, new Student("王五",103));
        students.put(104, new Student("赵六",104));
    }

    private static Integer initSno = 1006;
    public void save(Student student){
        if (student.getSno()==null){
            student.setSno(initSno++);
        }
        students.put(student.getSno(), student);
    }

    public Collection<Student> getAll(){
        return students.values();
    }

    public Student get(Integer sno){
        return students.get(sno);
    }

    public void delete(Integer sno){
        students.remove(sno);
    }

}
