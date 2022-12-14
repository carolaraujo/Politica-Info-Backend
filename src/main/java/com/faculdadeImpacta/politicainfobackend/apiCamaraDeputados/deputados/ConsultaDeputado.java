package com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.deputados;

import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.despesas.ConsultaDespesas;
import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.dominio.Estado;
import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.dominio.Genero;
import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http.Consulta;
import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http.ConsultaBuilder;
import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http.ModoValidacao;

import java.util.Map;

public class ConsultaDeputado extends Consulta {

    protected ConsultaDeputado(Map<String, String> parametros){
        super(parametros);}

    public static class Builder extends ConsultaBuilder<Builder>{

        public Builder(){
            super(ModoValidacao.PERMISSIVO);
        }

        public Builder(ModoValidacao modoValidacao){
            super(modoValidacao);
        }

        public Builder nome(String nome){
            adicionarParam("nome", nome);
            return this;
        }

        public Builder estados(Estado... estados){
            StringBuilder sb = new StringBuilder();
            for (Estado estado : estados){
                sb.append(estado.name()).append(",");
            }
            adicionarParam("siglaUf", sb.substring(0, sb.length()-1));
            return this;
        }

        public Builder legislaturas(int... legislaturas){
            adicionarParamMultiValores("idLegislatura", legislaturas);
            return this;
        }

        public Builder genero(Genero genero) {
            adicionarParam("siglaSexo", genero.name().toUpperCase().substring(0, 1));
            return this;
        }

        @Override
        public ConsultaDespesas build() {
            return new ConsultaDespesas(getParametros());
        }

        @Override
        protected Builder getThis() {
            return this;
        }
    }

}
