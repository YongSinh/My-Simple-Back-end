package co.istad.s4mbanking.api.auth;

import co.istad.s4mbanking.api.auth.web.RegisterDto;
import co.istad.s4mbanking.api.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapStruct {

    User toUser(RegisterDto registerDto);

}
