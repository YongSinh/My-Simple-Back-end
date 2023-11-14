package co.istad.s4mbanking.security;

import co.istad.s4mbanking.api.auth.AuthMapper;
import co.istad.s4mbanking.api.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthMapper authMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername: {}", username);

        User user = authMapper.selectByEmail(username).orElseThrow(()
            -> new UsernameNotFoundException("User is not found!"));

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUser(user);

        log.info(customUserDetails.getUsername());
        log.info(customUserDetails.getPassword());
        log.info(customUserDetails.getUser().getRoles().toString());

        return customUserDetails;
    }
}
