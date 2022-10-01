package task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import task.model.User;
import task.services.UserService;



@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService service;
    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @RequestMapping()
    public String index(Model model) {
        model.addAttribute("list", service.listUser());
        return "users/table";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.removeUser(id);
        return "redirect:/users";
    }
    @GetMapping("new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/newUser";
    }

    @RequestMapping(value = "/savenew", method = RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println(user.toString());
        service.updateUser(user.getId(),user);
        return "redirect:/users";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("users/editUser");
        User user = service.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

}
