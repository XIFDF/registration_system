package com.xifdf.registration_system.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Exam {
    private int examId;
    private String examName;
    private Date beginTime;
    private Date endTime;
    private String site;
}
