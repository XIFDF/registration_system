package com.xifdf.registration_system.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private int userid;
    private String username;
    private String pid;
    private int sid;
    private String profile;
    private String password;
    private String email;
    private int status;
    private String role;

}
