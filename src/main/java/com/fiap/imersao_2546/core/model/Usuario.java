package com.fiap.imersao_2546.core.model;

import com.fiap.imersao_2546.entrypoint.controller.dto.UsuarioRequestDto;
import com.fiap.imersao_2546.resources.database.entity.UsuarioEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private Long id;
    private String nomeCompleto;

    public Usuario(UsuarioEntity entity) {
        this.id = entity.getId();
        this.nomeCompleto = entity.getNomeCompleto();
    }

    public Usuario(UsuarioRequestDto requestDto) {
        this.nomeCompleto = requestDto.getNome() + " " + requestDto.getSobrenome();
    }

    public void sobrescreverNome(UsuarioRequestDto requestDto) {
        this.nomeCompleto = requestDto.getNome() + " " + requestDto.getSobrenome();
    }
}
