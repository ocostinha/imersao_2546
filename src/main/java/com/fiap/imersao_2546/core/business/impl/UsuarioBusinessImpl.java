package com.fiap.imersao_2546.core.business.impl;

import com.fiap.imersao_2546.core.business.UsuarioBusiness;
import com.fiap.imersao_2546.core.model.Usuario;
import com.fiap.imersao_2546.core.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioBusinessImpl implements UsuarioBusiness {
    @Autowired
    private UsuarioService service;

    @Override
    public Usuario criarUsuario(final Usuario usuario) {
        return service.criarUsuario(usuario);
    }

    @Override
    public Usuario atualizarUsuario(final Long id, final Usuario usuario) {
        return service.atualizarUsuario(id, usuario);
    }

    @Override
    public Usuario atualizarSobrenome(final Long id, final String sobrenome) {
        return service.atualizarSobrenome(id, sobrenome);
    }

    @Override
    public void deletarUsuario(final Long id) {
        service.deletarUsuario(id);
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        return service.consultarUsuarios();
    }

    @Override
    public Usuario consultarUsuario(final Long id) {
        return service.consultarUsuario(id);
    }
}
