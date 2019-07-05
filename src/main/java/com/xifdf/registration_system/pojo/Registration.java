package com.xifdf.registration_system.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Registration {
    private int userid;
    private int examid;
}
