package com.fiap.imersao_2546;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContratoEntrada {
    @NotBlank(message = "Por favor, informe o nome corretamente")
    private String nome;

    @NotBlank
    @Size(min = 3, max = 10)
    private String sobrenome;
}
