package co.istad.s4mbanking.api.accounttype;

import org.apache.ibatis.jdbc.SQL;

public class AccountTypeProvider {
    public String buildSelectSql() {
        return new SQL() {{
            SELECT("*");
            FROM("account_types");
        }}.toString();
    }
    public String buildSelectByIdSql() {
        return new SQL() {{
            SELECT("*");
            FROM("account_types");
            WHERE("id = #{id}");
        }}.toString();
    }
}
