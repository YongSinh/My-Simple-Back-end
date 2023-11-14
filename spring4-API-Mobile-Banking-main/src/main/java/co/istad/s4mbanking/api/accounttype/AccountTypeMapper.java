package co.istad.s4mbanking.api.accounttype;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface AccountTypeMapper {

    @SelectProvider(type = AccountTypeProvider.class,
            method = "buildSelectSql")
    List<AccountType> select();

    @SelectProvider(type = AccountTypeProvider.class, method = "buildSelectByIdSql")
    Optional<AccountType> selectById(@Param("id") Integer id);

}
