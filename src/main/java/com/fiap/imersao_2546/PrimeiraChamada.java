package com.fiap.imersao_2546;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PrimeiraChamada {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> primeiraChamada() {
        return ResponseEntity.ok("Primeira chamada realizada com sucesso!");
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ContratoSaida> primeiroPost(@Valid @RequestBody ContratoEntrada contratoEntrada) {
        ContratoSaida contratoSaida = new ContratoSaida();

        contratoSaida.setNomeCompleto(contratoEntrada.getNome() + " " + contratoEntrada.getSobrenome());

        Usuario usuario = new Usuario();

        usuario.setNomeCompleto(contratoSaida.getNomeCompleto());

        Usuario usuarioSalvo = repository.save(usuario);

        contratoSaida.setId(usuarioSalvo.getId());

        return ResponseEntity.ok(contratoSaida);
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
