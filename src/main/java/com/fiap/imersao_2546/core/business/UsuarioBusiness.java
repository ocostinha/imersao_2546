package com.fiap.imersao_2546.core.business;

import com.fiap.imersao_2546.core.model.Usuario;

import java.util.List;

public interface UsuarioBusiness {
    Usuario criarUsuario(Usuario usuario);
    Usuario atualizarUsuario(Long id, Usuario usuario);
    Usuario atualizarSobrenome(Long id, String sobrenome);
    void deletarUsuario(Long id);
    List<Usuario> consultarUsuarios();
    Usuario consultarUsuario(Long id);
}
