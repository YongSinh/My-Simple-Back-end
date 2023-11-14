package co.istad.s4mbanking;

import co.istad.s4mbanking.api.auth.AuthMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MobileBankingApiMainTests {

    @Autowired
    AuthMapper authMapper;

    @Test
    void testSelectUserByEmail() {
        System.out.println(authMapper.selectByEmail("user1@gmail.com"));
    }

}
