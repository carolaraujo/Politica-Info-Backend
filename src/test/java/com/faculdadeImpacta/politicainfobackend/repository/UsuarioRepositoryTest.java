package com.faculdadeImpacta.politicainfobackend.repository;


import com.faculdadeImpacta.politicainfobackend.model.Usuario;
import com.faculdadeImpacta.politicainfobackend.reporitory.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioRepositoryTest {
    @Autowired
    private com.faculdadeImpacta.politicainfobackend.reporitory.UsuarioRepository UsuarioRepository;

    // JUnit test for saveEmployee
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest(){

        Usuario usuario = Usuario.builder()
                .nome("Antonio Araujo")
                .email("antonio@gmail.com")
                .build();

        UsuarioRepository.save(usuario);

        Assertions.assertThat(usuario.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getUserTest(){

        Usuario usuario = UsuarioRepository.findById(1L).get();

        Assertions.assertThat(usuario.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfUsersTest(){

        List<Usuario> usuarios = UsuarioRepository.findAll();

        Assertions.assertThat(usuarios.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){

        Usuario usuario = UsuarioRepository.findById(1L).get();

        usuario.setEmail("ram@gmail.com");

        Usuario userUpdated =  UsuarioRepository.save(usuario);

        Assertions.assertThat(userUpdated.getEmail()).isEqualTo("ram@gmail.com");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){

        Usuario usuario = UsuarioRepository.findById(1L).get();

        UsuarioRepository.delete(usuario);

        //employeeRepository.deleteById(1L);

        Usuario user1 = null;

        Optional<Usuario> optionalUsuario = UsuarioRepository.findByEmail("ram@gmail.com");

        if(optionalUsuario.isPresent()){
            user1 = optionalUsuario.get();
        }

        Assertions.assertThat(user1).isNull();
    }
}
