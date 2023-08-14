package com.sms.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;









public class PlayerDTO {
	private long id;

	@NotNull(message="Name of Player can never be null")
	@NotBlank(message="Name of Player can never be empty")
	@Size(min=5)
	private String playername;

	@NotBlank(message="Name of Player can never be empty")
	private String playerteam;


	
	


}
