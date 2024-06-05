package com.fiap.imersao_2546.entrypoint.controller;

import com.fiap.imersao_2546.core.business.UsuarioBusiness;
import com.fiap.imersao_2546.core.model.Usuario;
import com.fiap.imersao_2546.entrypoint.controller.dto.UsuarioRequestDto;
import com.fiap.imersao_2546.entrypoint.controller.dto.UsuarioResponseDto;
import com.fiap.imersao_2546.exception.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioBusiness business;

    @PostMapping
    @ResponseBody
    public ResponseEntity<UsuarioResponseDto> cadastroDeUsuario(
            @Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        return ResponseEntity.ok(
                new UsuarioResponseDto(
                        business.criarUsuario(
                                new Usuario(usuarioRequestDto))
        ));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<UsuarioResponseDto> getPorId(@NotNull @Valid @PathVariable Long id) {
        return ResponseEntity.ok(
                new UsuarioResponseDto(
                        business.consultarUsuario(id)
                )
        );
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<UsuarioResponseDto>> getAll() {
        List<UsuarioResponseDto> usuarioResponseDto = new ArrayList<>();

        List<Usuario> usuarios = business.consultarUsuarios();

        usuarios.forEach(usuarioEntity -> usuarioResponseDto.add(new UsuarioResponseDto(usuarioEntity)));

        return ResponseEntity.ok(usuarioResponseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> delete(@NotNull @Valid @PathVariable Long id) {
        business.deletarUsuario(id);

        return ResponseEntity.accepted().body("Usuario removido com sucesso");
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<UsuarioResponseDto> atualizarRegistro(
            @Valid @RequestBody UsuarioRequestDto usuarioRequestDto,
            @NotNull @Valid @PathVariable Long id) {
        return ResponseEntity.accepted().body(
                new UsuarioResponseDto(
                        business.atualizarUsuario(id,
                                new Usuario(usuarioRequestDto)
                        )
                )
        );
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public ResponseEntity<UsuarioResponseDto> atualizarSobrenome(
            @Valid @NotNull @PathVariable Long id,
            @Valid @NotBlank @RequestParam String sobrenome) {
        return ResponseEntity.accepted().body(
                new UsuarioResponseDto(
                        business.atualizarSobrenome(id, sobrenome)
                )
        );
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(NotFoundException.class)
    public String handlerNotFoundException(
            NotFoundException exception) {
        return "Usuario não encontrado";
    }
}
