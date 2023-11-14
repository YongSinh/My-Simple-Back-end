package co.istad.s4mbanking.api.accounttype;

import java.util.List;

public interface AccountTypeService {
    List<AccountTypeDto> findAllAccountTypes();
    AccountTypeDto findById(Integer id);
}
