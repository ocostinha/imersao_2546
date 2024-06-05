package com.fiap.imersao_2546.resources.database.entity;

import com.fiap.imersao_2546.core.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nomeCompleto;

    public UsuarioEntity(Usuario usuario) {
        this.nomeCompleto = usuario.getNomeCompleto();
    }

    private String getNome() {
        return this.nomeCompleto.split(" ")[0];
    }

    public void atualizaSobrenome(String sobrenome) {
        this.nomeCompleto = getNome() + " " + sobrenome;
    }
}
