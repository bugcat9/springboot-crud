package com.zhouning.controller;

import com.zhouning.dao.StudentDao;
import com.zhouning.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author zhouning
 */
@Controller
public class StudentController {
    @Autowired
    StudentDao studentDao;

    /**
     * 查找所有人
     * @param model
     * @return
     */
    @GetMapping("/students")
    public String list(Model model){
        Collection<Student> students = studentDao.getAll();
        System.out.println(students);
        //放在请求域中
        model.addAttribute("students", students);
        return "student/list";
    }

    /**
     * 查找或者修改一个人
     * @param sno
     * @param model
     * @return
     */
    @GetMapping("/student/{sno}")
    public String toUpdataPage(@PathVariable(value = "sno")Integer sno,Model model){
        Student student = studentDao.get(sno);
        model.addAttribute("student", student);
        return "student/update";
    }

    /**
     * 修改学生
     * @param student
     * @return
     */
    @PutMapping("/student")
    public String updateStudent(Student student){
        System.out.println(student);
        studentDao.save(student);
        return "redirect:/students";
    }

    /**
     * 到添加页面
     * @return
     */
    @GetMapping("/student")
    public String toAddPage(){
        return "student/add";
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @PostMapping("/student")
   public String addStudent(Student student){
        System.out.println(student);
        studentDao.save(student);
        return "redirect:/students";
   }

    @DeleteMapping("/student/{sno}")
    public String deleteStudent(@PathVariable(value = "sno")Integer sno){
        System.out.println(sno);
        studentDao.delete(sno);
        return "redirect:/students";
    }

}
