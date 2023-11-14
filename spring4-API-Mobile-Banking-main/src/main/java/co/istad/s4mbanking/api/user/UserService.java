package co.istad.s4mbanking.api.user;

import co.istad.s4mbanking.api.user.web.SaveUserDto;
import co.istad.s4mbanking.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;

public interface UserService {

    UserDto deleteById(Integer id);

    PageInfo<UserDto> findWithPaging(int pageNum, int pageSize);

    UserDto findById(Integer id);

    UserDto updateById(Integer id, SaveUserDto saveUserDto);

    UserDto create(SaveUserDto saveUserDto);

}
