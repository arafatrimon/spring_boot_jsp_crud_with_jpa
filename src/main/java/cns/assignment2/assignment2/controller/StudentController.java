package cns.assignment2.assignment2.controller;

import cns.assignment2.assignment2.dao.StudentDao;
import cns.assignment2.assignment2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping
public class StudentController {
    @Autowired
    private StudentDao studentDao;

    @GetMapping("/addStudentPage")
    public String addStudentPage(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("pageTitle", "Register Student");
        model.addAttribute("formAction", "/create");
        model.addAttribute("message", "Student Added Successfully");
        return "create-student";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) throws ParseException {

        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Register Student");
            model.addAttribute("formAction", "/create");
            return "create-student";
        }

        studentDao.saveStudent(student);
        String message = "Record with id is save successfully";
        model.addAttribute("message", message);
        List students = studentDao.getAllStudents();
        model.addAttribute("students", students);
        return "redirect:addStudentPage";
    }

    @GetMapping("/list")
    public String getAllStudents(@RequestParam(value = "message", required = false) String message, Model model) {
        List<Student> students = studentDao.getAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("message", message);
        return "list-student";

    }

    @GetMapping("/edit")
    public String getEditPage(ModelMap model, @RequestParam Long id, Model m) {
        String page = null;
        try {
            m.addAttribute("pageTitle", "Update Student");
            m.addAttribute("formAction", "/update");
            Student student = studentDao.getStudentById(id);
            model.put("student", student);
            page = "create-student";
        } catch (Exception e) {
            e.printStackTrace();
            page = "redirect:list";
        }
        return page;
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute Student student, BindingResult result, Model m) throws ParseException {

        if (result.hasErrors()) {
            return "create-student";
        }

        studentDao.saveStudent(student);
        Long id = student.getId();
        //attributes.addAttribute("message", "Student with id " + id + " is updated successfully");
        List students = studentDao.getAllStudents();
        m.addAttribute("students", students);
        return "list-student";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Long id, RedirectAttributes attributes, Model model) {
        try {
            studentDao.deleteStudent(id);
            attributes.addAttribute("message", "Invoice with id: " + id + " is removed successfully");
            List students = studentDao.getAllStudents();
            model.addAttribute("students", students);
            return "list-student";
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
            return "list-student";
        }


    }
}
