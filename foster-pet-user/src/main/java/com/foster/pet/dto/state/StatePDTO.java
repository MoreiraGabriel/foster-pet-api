package com.foster.pet.dto.state;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.foster.pet.dto.IdentificatorDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StatePDTO implements Serializable {

	private static final long serialVersionUID = 551614595058863777L;

	@Size(min = 1, max = 70, message = "O campo 'Estado' deve conter entre 1 e 70 caracteres.")
	private String name;

	@NotNull
	private IdentificatorDTO country;
}
