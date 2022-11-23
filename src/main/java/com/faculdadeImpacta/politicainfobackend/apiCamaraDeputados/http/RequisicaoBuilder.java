package com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.Objects;

public class RequisicaoBuilder {

    private Consulta consulta;

    private String[] segmentosPath;

    private final String urlBase;

    public RequisicaoBuilder(String urlBase) {
        this.urlBase = urlBase;
    }

    public RequisicaoBuilder segmentosPath(String... segmentosPath) {
        this.segmentosPath = segmentosPath;
        return this;
    }

    public RequisicaoBuilder consulta(Consulta consulta) {
        this.consulta = consulta;
        return this;
    }

    // Timeout por default de 1 min pra todas as requisições
    public HttpRequest build() {
        return HttpRequest
                .newBuilder(construirUri(urlBase))
                .header("accept", "application/json")
                .timeout(Duration.ofMinutes(1L))
                .build();
    }

    private void adicionarParametrosDeConsulta(StringBuilder sb) {
        if (consulta != null && consulta.getParametros().size() > 0) {
            sb.append("?");
            consulta.getParametros().forEach((chave, valor) -> sb.append(chave).append("=").append(valor).append("&"));
        }
    }

    private void adicionarSegmentos(StringBuilder sb) {
        if (segmentosPath != null) {
            for (String segmento : segmentosPath) {
                sb.append("/").append(segmento);
            }
        }
    }

    private URI construirUri(String urlBase) {
        urlBase = Objects.requireNonNull(urlBase, "Uma consulta por ID precisa de uma URL base para concatenação do ID");
        if (urlBase.isBlank()) {
            throw new IllegalArgumentException("A URL base para concatenação do ID na consulta por ID não pode estar em branco");
        }
        StringBuilder sb = new StringBuilder(urlBase);
        adicionarSegmentos(sb);
        adicionarParametrosDeConsulta(sb);
        return URI.create(sb.toString());
    }
}
