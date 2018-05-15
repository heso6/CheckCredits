package pl.pawellukaszewski.models.forms;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreditForm {
    @NotBlank
    private double dochodMiesieczny;
    @NotBlank
    private double miesieczneZobowiazania;
    @NotBlank
    private double kwotaKredytu;
    @NotBlank
    private double iloscRat;


}
