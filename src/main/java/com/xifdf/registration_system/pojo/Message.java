package com.xifdf.registration_system.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Message {
    private int mid;
    private int examid;
    private String examname;
    private int userid;
    private String username;
    private String says;
}
