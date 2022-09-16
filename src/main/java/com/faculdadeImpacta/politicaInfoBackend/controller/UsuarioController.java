package com.faculdadeImpacta.politicaInfoBackend.controller;

import com.faculdadeImpacta.politicaInfoBackend.model.Usuario;
import com.faculdadeImpacta.politicaInfoBackend.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> listaUsuarios(){
        return usuarioService.listaUsuarios();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario buscarUsuarioPorId(@PathVariable("id") Long id){
        return usuarioService.buscarPorid(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerUsuario(@PathVariable ("id") Long id){
        usuarioService.buscarPorid(id)
                .map(usuario -> {
                    usuarioService.removerPorId(usuario.getId());
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarUsuario(@PathVariable("id")  Long id, @RequestBody Usuario usuario){
        usuarioService.buscarPorid(id)
                .map(usuarioBase -> {
                    modelMapper.map(usuario, usuarioBase);
                    usuarioService.salvarUsuario(usuarioBase);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
    }
}
