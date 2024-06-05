package com.fiap.imersao_2546.resources.service;

import com.fiap.imersao_2546.core.model.Usuario;
import com.fiap.imersao_2546.core.service.UsuarioService;
import com.fiap.imersao_2546.exception.NotFoundException;
import com.fiap.imersao_2546.resources.database.entity.UsuarioEntity;
import com.fiap.imersao_2546.resources.database.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return new Usuario(
                repository.save(
                        new UsuarioEntity(usuario)
                )
        );
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        UsuarioEntity entity = repository.findById(id).orElseThrow(NotFoundException::new);

        entity.setNomeCompleto(usuario.getNomeCompleto());

        return new Usuario(
                repository.save(
                        entity
                )
        );
    }

    @Override
    public Usuario atualizarSobrenome(Long id, String sobrenome) {
        UsuarioEntity entity = repository.findById(id).orElseThrow(NotFoundException::new);

        entity.atualizaSobrenome(sobrenome);

        return new Usuario(
                repository.save(
                        entity
                )
        );
    }

    @Override
    public void deletarUsuario(Long id) {
        UsuarioEntity entity = repository.findById(id).orElseThrow(NotFoundException::new);

        repository.delete(entity);
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        repository.findAll().forEach(entity -> usuarios.add(new Usuario(entity)));

        return usuarios;
    }

    @Override
    public Usuario consultarUsuario(Long id) {
        return new Usuario(
                repository.getReferenceById(id)
        );
    }
}
