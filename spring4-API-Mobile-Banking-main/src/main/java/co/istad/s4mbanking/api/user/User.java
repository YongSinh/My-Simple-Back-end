package co.istad.s4mbanking.api.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String gender;
    private String oneSignalId;
    private Boolean isDeleted;
    private Boolean isStudent;
    private String studentCardId;

    // Security
    private String email;
    private String password;

    // Relationship
    private List<Role> roles;

}
