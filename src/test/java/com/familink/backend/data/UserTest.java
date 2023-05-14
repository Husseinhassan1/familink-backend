package com.familink.backend.data;

import com.familink.backend.enums.Role;
import com.familink.backend.models.UserDto;
import com.familink.backend.models.entities.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.familink.backend.enums.Role.ADMIN;
import static com.familink.backend.enums.Role.USER;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTest {
    private static long id1 = 1L;
    private static String nickname1 = "nickname1";
    private static String firstName1 = "firstName1";
    private static String lastName1 = "lastName1";
    private static String email1 = "email1@mail.com";
    private static String password1 = "password1";
    private static Role role1 = ADMIN;


    public static User user() {
        User user = new User();
        user.setId(id1);
        user.setNickname(nickname1);
        user.setFirstName(firstName1);
        user.setLastName(lastName1);
        user.setEmail(email1);
        user.setPassword(password1);
        user.setRole(role1);

        return user;
    }

    public static UserDto userDto1() {
        return new UserDto(id1, email1, firstName1, lastName1, nickname1, password1, role1);
    }

    public static UserDto userDto3() {
        return new UserDto(3L, "email2@mail.com",
                "firstname2",
                "lastname2",
                "nickname2",
                "password2",
                USER);
    }
}
