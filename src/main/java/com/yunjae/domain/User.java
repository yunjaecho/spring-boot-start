package com.yunjae.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
// XML 사용시 반드시 지정
// 기본 Accept 지정 없이는 xml MessageConverter 사용
//@XmlRootElement
public class User {
    @NotEmpty
    private String name;

    @Size(min = 10)
    private int age;

    @Size(min = 50)
    private int height;
}
