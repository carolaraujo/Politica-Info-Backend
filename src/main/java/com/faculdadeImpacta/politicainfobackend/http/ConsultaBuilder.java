package com.faculdadeImpacta.politicainfobackend.http;

import com.faculdadeImpacta.politicainfobackend.despesas.ConsultaDespesas;

import java.util.*;

public abstract class ConsultaBuilder<T extends ConsultaBuilder<T>> {

    private final Map<String, String> parametros = new HashMap<>();

    private final ModoValidacao modoValidacao;

    public ConsultaBuilder(ModoValidacao modoValidacao) {
        this.modoValidacao = modoValidacao;
    }

    protected void adicionarParam(String chave, String valor) {
        if (valor != null && !valor.isBlank()) {
            parametros.put(chave, valor);
        }
        if (modoValidacao.equals(ModoValidacao.RIGOROSO)) {
            String mensagem = String.format("O Builder está em modo rigoroso e o parametro %s é \"%s\"", chave, valor);
            throw new IllegalArgumentException(mensagem);
        }
    }
    protected Map<String, String> getParametros() {
        return Collections.unmodifiableMap(parametros);
    }

    protected void adicionarParamMultiValores(String param, List<Integer> valores) {
        if (valores != null) {
            adicionarParamMultiValoresInterno(param, valores);
        }
        if (modoValidacao.equals(ModoValidacao.RIGOROSO)) {
            throw new IllegalArgumentException("O Builder está em modo rigoroso e a lista de valores é null.");
        }
    }

    private void adicionarParamMultiValoresInterno(String param, List<Integer> valores) {
        List<Long> valoresLong = new ArrayList<>();
        for (Integer valorInteger : valores) {
            if (valorInteger == null) {
                if (modoValidacao.equals(ModoValidacao.RIGOROSO)) {
                    throw new IllegalArgumentException("O Builder está em modo rigoroso e um dos valores da entrada é null.");
                }
                return;
            }
            valoresLong.add(Long.valueOf(valorInteger));
        }
        if (!valoresLong.isEmpty()) {
            adicionarParamMultiValores(param, valoresLong.stream().mapToLong(l -> l).toArray());
        }
    }

    protected void adicionarParamMultiValores(String param, int... valores) {
        long[] valoresLong = Arrays.stream(valores).asLongStream().toArray();
        adicionarParamMultiValores(param, valoresLong);
    }

    protected void adicionarParamMultiValores(String param, long... valores) {
        if (valores.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (long valor : valores) {
                sb.append(valor).append(",");
            }
            adicionarParam(param, sb.substring(0, sb.length()-1));
        }
    }

    public T itens(Integer itens) {
        adicionarParam("itens", itens == null ? null : itens.toString());
        return getThis();
    }

    public T pagina(Integer pagina) {
        adicionarParam("pagina", pagina == null ? null : pagina.toString());
        return getThis();
    }

    public T ordenarPor(String campo, Ordem ordem) {
        adicionarParam("ordenarPor", campo);
        adicionarParam("ordem", ordem == null ? null : ordem.name());
        return getThis();
    }

    public abstract ConsultaDespesas build();

    protected abstract T getThis();
}
