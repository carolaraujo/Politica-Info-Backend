package com.faculdadeImpacta.politicaInfoBackend.service;

import com.faculdadeImpacta.politicaInfoBackend.model.Usuario;
import com.faculdadeImpacta.politicaInfoBackend.reporitory.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorid(Long id){
        return usuarioRepository.findById(id);
    }

    public void removerPorId(Long id){
        usuarioRepository.deleteById(id);
    }
}
