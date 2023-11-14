package co.istad.s4mbanking.api.user;

import co.istad.s4mbanking.api.user.web.SaveUserDto;
import co.istad.s4mbanking.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {

    User saveUserDtoToUser(SaveUserDto dto);

    UserDto userToUserDto(User user);

    PageInfo<UserDto> userPageInfoToUserDtoPageInfo(PageInfo<User> model);

}
