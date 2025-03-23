package com.blogApp.Blog_application_project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {

	private int id;

	@NotEmpty
	@Size(min = 4, message = "userName must be four character")
	private String name;
	@Email(message = "Email address is not valid")
	private String email;
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be 3 chars and maximmum of 10 char")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$", message = "Password must be at least 8 characters long, include an uppercase letter, a lowercase letter, a digit, and a special character")
	private String password;
	@NotEmpty
	private String about;
}
