package co.istad.s4mbanking.api.auth.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RegisterDto(@NotBlank
                          @Email String email,
                          @NotBlank
                          String password,
                          @NotBlank
                          String confirmedPassword,
                          @NotNull
                          List<Integer> roleIds) {
}
