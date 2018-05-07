package task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import task.service.IUserService;
import task.model.User;

/**
 * @author Pavel Smokorovskiy on 03.05.18
 */

@Controller
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView users() {
        ModelAndView model = new ModelAndView("users");
        model.addObject("list", userService.listAllUsers());
        return model;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteUsers(@PathVariable long id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView userRegister(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView("users");
        if (user != null) {
            userService.saveUser(user);
            model.addObject("warning", "User Registration Success");

        } else {
            model.addObject("danger", "Something wrong");

        }
        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") long id) {
        ModelAndView model = new ModelAndView("edit");
        User user = userService.getUserById(id);
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("id") long id
            , @RequestParam("name") String name
            , @RequestParam("last_name") String last_name
            , @RequestParam("adress") String adress) {
        User user = userService.getUserById(id);
        user.setName(name);
        user.setLast_name(last_name);
        user.setAdress(adress);
        userService.saveUser(user);
        return new ModelAndView("redirect:/users");
    }

}
