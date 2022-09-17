package com.faculdadeImpacta.politicainfobackend.dominio;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.Objects;

@Getter
@Setter
public class Deputado implements Comparable<Deputado> {

    private final int id;

    private URL uri;

    private String siglaPartido;

    private URL urlFoto;

    private String email;

    private String nome;

    private int idLegislatura;

    private Estado siglaUf;

    public Deputado(int id){
        if(id <= 0){
            throw new IllegalArgumentException("Deputados tem que ter ID maior que zero");
        }
        this.id = id;
    }

    public String getNomeFormatado() {
        String[] split = nome.split(" ");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String nome : split) {
            nome = nome.toLowerCase();
            nomeFormatado
                    .append(nome.substring(0, 1).toUpperCase())
                    .append(nome.substring(1))
                    .append(" ");
        }
        return nomeFormatado.substring(0, nomeFormatado.length()-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deputado deputado = (Deputado) o;
        return id == deputado.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Deputado o) {
        return Integer.compare(this.id, o.id);
    }
}
