package com.faculdadeImpacta.politicainfobackend.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Pagina<T> extends ArrayList<T> {

    private final Integer total;

    private final Integer paginaAtual;

    public Pagina(Collection<? extends T> c, Integer total, Integer paginaAtual) {
        super(c);
        this.total = Objects.requireNonNull(total, "Uma Página de resultados precisa do número total de elementos para operar.");
        if (paginaAtual == null || paginaAtual == 0) {
            paginaAtual = 1;
        }
        this.paginaAtual = paginaAtual;
    }

    public int getTotal() {
        return total;
    }

    public Integer getPaginaAtual() {
        return paginaAtual;
    }

    public boolean temProxima() {
        if (isEmpty()) {
            return false;
        }
        return total > (paginaAtual * size());
    }
}
