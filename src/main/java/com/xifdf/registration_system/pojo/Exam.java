package com.xifdf.registration_system.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Exam {
    private int examId;
    private String examName;
    private Timestamp beginTime;
    private Timestamp endTime;
    private Timestamp dateTime;
    private String site;
}
