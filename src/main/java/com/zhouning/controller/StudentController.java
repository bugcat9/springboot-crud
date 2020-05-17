package com.zhouning.controller;

import com.zhouning.dao.StudentDao;
import com.zhouning.entities.Student;
import com.zhouning.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

/**
 * @author zhouning
 */
@Controller
public class StudentController {
    @Autowired
    StudentDao studentDao;

    @PostMapping("/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            //登录成功,防止表单重复提交，进行重定向
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户名或者密码错误");
            return "login";
        }
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello world ....再来";
    }

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

    @GetMapping("/exception")
    public String toException(){
        throw new UserNotExistException();
    }

}
