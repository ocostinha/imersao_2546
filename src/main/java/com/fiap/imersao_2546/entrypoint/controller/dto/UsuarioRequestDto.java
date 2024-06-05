package com.fiap.imersao_2546.entrypoint.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequestDto {
    @NotBlank(message = "Por favor, informe o nome corretamente")
    private String nome;

    @NotBlank
    private String sobrenome;
}
