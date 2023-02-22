package cns.assignment2.assignment2.controller;

import cns.assignment2.assignment2.dao.UserDao;
import cns.assignment2.assignment2.entity.User;
import cns.assignment2.assignment2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@Controller

public class LoginController {

    @Autowired
    private UserDao userDao;
    @GetMapping("/addUserPage")
    public String addUserPage(Model model) {
        model.addAttribute("loginPage", true);
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Register User");
        model.addAttribute("formAction", "/add-user");
        model.addAttribute("message", "Student Added Successfully");
        return "signup";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("user") User user, Model model) throws ParseException {


        userDao.saveUser(user);
        String message = "Record with id is save successfully";
        model.addAttribute("message", message);
        return "redirect:addStudentPage";
    }

    @GetMapping("/loginUserPage")
    public String loginUserPage(Model model) {
        model.addAttribute("loginPage", false);
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Login User");
        model.addAttribute("formAction", "/login");
        model.addAttribute("message", "Student Added Successfully");
        return "signup";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user,Model model) {
        String username = user.getUsername();
        String password = user.getPassword();
        User data = userDao.findByUsernameAndPassword(username, password);
        if (data != null) {
            return "redirect:list";
        }
        return "redirect:loginUserPage";
    }

}



