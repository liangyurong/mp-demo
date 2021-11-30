package com.sdyb.mp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String myEmail;

}
