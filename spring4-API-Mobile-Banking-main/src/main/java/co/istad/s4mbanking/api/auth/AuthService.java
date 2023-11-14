package co.istad.s4mbanking.api.auth;

import co.istad.s4mbanking.api.auth.web.AuthDto;
import co.istad.s4mbanking.api.auth.web.LogInDto;
import co.istad.s4mbanking.api.auth.web.RegisterDto;

public interface AuthService {

    void register(RegisterDto registerDto);

    AuthDto login(LogInDto logInDto);

}
