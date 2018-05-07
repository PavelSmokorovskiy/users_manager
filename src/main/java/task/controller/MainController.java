package task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Pavel Smokorovskiy on 07.05.18
 */

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String index(){
        return "redirect:/users";
    }

}
