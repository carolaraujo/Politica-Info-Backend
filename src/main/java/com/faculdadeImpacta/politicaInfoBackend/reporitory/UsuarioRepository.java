package com.faculdadeImpacta.politicaInfoBackend.reporitory;

import com.faculdadeImpacta.politicaInfoBackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNomeContainingIgnoreCase(String nome);

    public Optional<Usuario> findByEmail(String email);

}
