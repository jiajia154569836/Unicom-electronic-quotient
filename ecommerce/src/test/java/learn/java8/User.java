package learn.java8;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
}
