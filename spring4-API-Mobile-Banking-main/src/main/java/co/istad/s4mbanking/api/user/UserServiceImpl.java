package co.istad.s4mbanking.api.user;

import co.istad.s4mbanking.api.user.web.SaveUserDto;
import co.istad.s4mbanking.api.user.web.UserDto;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserMapStruct userMapStruct;

    @Override
    public UserDto deleteById(Integer id) {

        if (userMapper.existsById(id)) {
            UserDto userDto = findById(id);
            userMapper.updateIsDeleted(id, true);
            return userDto;
        }

        // Throw your business exception
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with ID = %d is not found in DB", id));

    }

    @Override
    public PageInfo<UserDto> findWithPaging(int pageNum, int pageSize) {

        // TODO: call method select in mybatis mapper
        PageInfo<User> userPageInfo = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(userMapper::select);

        return userMapStruct.userPageInfoToUserDtoPageInfo(userPageInfo);
    }

    @Override
    public UserDto findById(Integer id) {
        User user = userMapper.selectById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with ID = %d is not found in DB", id)));
        return userMapStruct.userToUserDto(user);
    }

    @Override
    public UserDto updateById(Integer id, SaveUserDto saveUserDto) {

        if (userMapper.existsById(id)) {
            // TODO: update user
            User user = userMapStruct.saveUserDtoToUser(saveUserDto);
            user.setId(id);
            userMapper.update(user);
            return findById(id);
        }

        // Throw your business exception
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User with ID = %d is not found in DB", id));

    }

    @Override
    public UserDto create(SaveUserDto saveUserDto) {
        User user = userMapStruct.saveUserDtoToUser(saveUserDto);
        userMapper.insert(user);
        return findById(user.getId());
    }


}
