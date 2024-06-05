package com.fiap.imersao_2546.entrypoint.controller.dto;

import com.fiap.imersao_2546.core.model.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioResponseDto {
    private Long id;
    private String nomeCompleto;

    public UsuarioResponseDto(Usuario entity) {
        this.nomeCompleto = entity.getNomeCompleto();
        this.id = entity.getId();
    }
}
