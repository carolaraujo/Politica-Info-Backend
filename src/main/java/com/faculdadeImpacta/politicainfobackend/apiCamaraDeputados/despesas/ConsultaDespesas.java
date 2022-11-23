package com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.despesas;

import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http.ConsultaBuilder;
import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http.ModoValidacao;

import java.util.List;
import java.util.Map;

public class ConsultaDespesas {

    private final int idDeputado;

    public ConsultaDespesas(Map<String, String> parametros, int idDeputado) {
        this.idDeputado = idDeputado;
    }

    public ConsultaDespesas(Map<String, String> parametros) {
        idDeputado = 0;
    }

    public int getIdDeputado() {
        return idDeputado;
    }

    public static class Builder extends ConsultaBuilder<Builder> {

        private final int idDeputado;

        public Builder(int idDeputado) {
            super(ModoValidacao.PERMISSIVO);
            this.idDeputado = idDeputado;
        }

        public Builder(ModoValidacao modoValidacao, int idDeputado) {
            super(modoValidacao);
            this.idDeputado = idDeputado;
        }

        public Builder anos(int... anos) {
            adicionarParamMultiValores("ano", anos);
            return this;
        }

        public Builder anos(List<Integer> anos) {
            adicionarParamMultiValores("ano", anos);
            return this;
        }

        public Builder meses(int... meses) {
            adicionarParamMultiValores("mes", meses);
            return this;
        }

        public Builder meses(List<Integer> meses) {
            adicionarParamMultiValores("mes", meses);
            return this;
        }

        public Builder legislaturas(int... legislaturas) {
            adicionarParamMultiValores("idLegislatura", legislaturas);
            return this;
        }

        @Override
        public ConsultaDespesas build() {
            return new ConsultaDespesas(getParametros(), idDeputado);
        }

        @Override
        protected Builder getThis() {
            return this;
        }
    }
}
