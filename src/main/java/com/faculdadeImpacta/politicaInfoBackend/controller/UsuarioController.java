package com.faculdadeImpacta.politicaInfoBackend.controller;

import com.faculdadeImpacta.politicaInfoBackend.model.Usuario;
import com.faculdadeImpacta.politicaInfoBackend.reporitory.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid Usuario usuario){
        Optional<Usuario> emailDuplicado = usuarioRepository.findByEmail(usuario.getEmail());
        if(emailDuplicado.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado!");
    }

}
