package com.fiap.imersao_2546.entrypoint.controller;

import com.fiap.imersao_2546.entrypoint.controller.dto.UsuarioRequestDto;
import com.fiap.imersao_2546.entrypoint.controller.dto.UsuarioResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/primeira_chamada")
public class PrimeiraChamadaController {
    @GetMapping
    @ResponseBody
    public ResponseEntity<String> primeiraChamada() {
        return ResponseEntity.ok("Primeira chamada realizada com sucesso!");
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<UsuarioResponseDto> primeiroPost(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();

        usuarioResponseDto.setNomeCompleto(usuarioRequestDto.getNome() + " " + usuarioRequestDto.getSobrenome());

        return ResponseEntity.ok(usuarioResponseDto);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
