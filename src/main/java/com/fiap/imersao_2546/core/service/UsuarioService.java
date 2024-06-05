package com.fiap.imersao_2546.core.service;

import com.fiap.imersao_2546.core.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario criarUsuario(Usuario usuario);
    Usuario atualizarUsuario(Long id, Usuario usuario);
    Usuario atualizarSobrenome(Long id, String sobrenome);
    void deletarUsuario(Long id);
    List<Usuario> consultarUsuarios();
    Usuario consultarUsuario(Long id);
}
