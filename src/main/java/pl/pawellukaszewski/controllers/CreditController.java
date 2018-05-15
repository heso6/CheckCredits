package pl.pawellukaszewski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pawellukaszewski.models.forms.CreditForm;


@Controller
public class CreditController {


    @PostMapping("/credit")
    public String credit(@ModelAttribute("creditForm") CreditForm creditForm, Model model) {


        model.addAttribute("creditInfo", canGetCredit(creditForm));

        return "credit";
    }

    @GetMapping("/credit")

    public String credit(Model model, CreditForm creditForm) {
        model.addAttribute("infoMessage", "Zalogowałes się poprawnie");
        model.addAttribute("creditForm", new CreditForm());
        return "credit";
    }

    private boolean canGetCredit(CreditForm creditForm) {

        return (creditForm.getDochodMiesieczny() - creditForm.getMiesieczneZobowiazania()) * 100 /
                (creditForm.getKwotaKredytu() / creditForm.getIloscRat()) - 100 > 30;

    }
}