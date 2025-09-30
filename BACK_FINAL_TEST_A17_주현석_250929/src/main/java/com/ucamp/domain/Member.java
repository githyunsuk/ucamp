package com.ucamp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long memberId;
    private String id;
    private String password;
    private String name;


}