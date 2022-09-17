package com.faculdadeImpacta.politicainfobackend.http;

import java.util.Map;

public class Consulta {

    private final Map<String, String> parametros;

    protected Consulta(Map<String, String> parametros) {
        this.parametros = parametros;
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

    public static class Builder extends ConsultaBuilder<Consulta.Builder> {

        public Builder() {
            super(ModoValidacao.PERMISSIVO);
        }

        public Builder(ModoValidacao modoValidacao) {
            super(modoValidacao);
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public Consulta build() {
            return new Consulta(getParametros());
        }
    }
}
