package com.sparta.spartaproject01.dto;



import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {

    @NotBlank(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9].{3,10}$",
            message = "아이디를 3 ~ 10자 내외로 입력해주세요.")
    private String username;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9].{4,10}$",
        message = "비밀번호를 4 ~ 10자 내외로 입력해주세요!")
    private String password;


    @NotBlank(message = "비밀번호를 확인해주세요!")
    private String checkPw;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email
    private String email;

    //private boolean admin = false;
}