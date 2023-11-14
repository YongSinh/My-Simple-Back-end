package co.istad.s4mbanking.api.auth.web;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LogInDto(@NotBlank
                       @Email
                       @Schema(description = "Email address from user") String email,
                       @NotBlank
                       String password) {
}
