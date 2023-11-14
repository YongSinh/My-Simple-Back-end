package co.istad.s4mbanking.api.accounttype;

import co.istad.s4mbanking.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account-types")
@RequiredArgsConstructor
public class AccountTypeRestController {
    private final AccountTypeService accountTypeService;

    //@ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping
    public BaseApi<?> findAllAccountTypes() {
        List<AccountTypeDto> accountTypesDto = accountTypeService.findAllAccountTypes();
        return BaseApi.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("Account types have been found")
                .timestamp(LocalDateTime.now())
                .data(accountTypesDto)
                .build();
    }

}
