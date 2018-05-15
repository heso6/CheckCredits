package pl.pawellukaszewski.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pawellukaszewski.models.forms.BankForm;


import javax.validation.Valid;
import java.util.Locale;

@Controller
public class BankController {


    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String bank(@ModelAttribute("bankForm") @Valid BankForm form, BindingResult result, Model model, Locale locale
    ) {


        if (form.getLogin().equals("pawel") && form.getPassword().equals("admin")) {
            return "redirect:/credit";
        } else {

            model.addAttribute("infoLoginError", "Error");
            return "bank";
        }


    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String bank(Model model, BankForm form) {
        model.addAttribute("bankForm", new BankForm());
        return "bank";
    }
}
