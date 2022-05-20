package edu.poniperro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {

    @RequestMapping(value = {"/", "", "/index", "/home"}, method = RequestMethod.GET)
    // @GetMapping(value = "/") -> Se puede hacer así con todos los otros tipos de envío
    // o recibo o simplemente indicando en el method = RequestMethod.x
    public String index (Model model) {
        model.addAttribute("titulo", "Hola Spring Framework");
        return "index";
    }

    // Distintas formas de ponerlo:

    /**
     * public String index (ModelMap model) {
     *         model.addAttribute("titulo", "Hola Spring Framework");
     *         return "index";
     *     }
     */

    /**
     * public ModelAndView index (ModelAndView mv) {
     *         mv.addObject("titulo", "Hola Spring Framework");
     *         mv.setViewName("index");
     *         return mv;
     *     }
     */

}
