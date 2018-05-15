package pl.pawellukaszewski.models.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BankForm {
    @NotBlank
    private String login;
    @NotBlank
    private String password;

}
