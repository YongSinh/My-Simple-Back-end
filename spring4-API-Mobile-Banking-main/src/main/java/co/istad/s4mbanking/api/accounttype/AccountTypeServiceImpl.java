package co.istad.s4mbanking.api.accounttype;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService {
    private final AccountTypeMapper accountTypeMapper;
    @Override
    public List<AccountTypeDto> findAllAccountTypes() {
        List<AccountType> accountTypes = accountTypeMapper.select();
        List<AccountTypeDto> accountTypesDto = accountTypes.stream()
                .map(accountType -> new AccountTypeDto(accountType.getName()))
                .toList();
        return accountTypesDto;
    }

    @Override
    public AccountTypeDto findById(Integer id) {
        return null;
    }
}
