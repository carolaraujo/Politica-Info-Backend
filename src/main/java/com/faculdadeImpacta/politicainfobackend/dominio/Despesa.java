package com.faculdadeImpacta.politicainfobackend.dominio;

import java.net.URL;
import java.time.YearMonth;
import java.util.Objects;

public class Despesa implements Despesas {

    private final int ano;

    private final int mes;

    private final long codDocumento;

    private final double valorDocumento;

    private String tipoDespesa;

    private String tipoDocumento;

    private int codTipoDocumento;

    private URL urlDocumento;

    private String nomeFornecedor;

    private String cnpjCpfFornecedor;

    private String numDocumento;

    public Despesa(double valorDocumento, long codDocumento, int ano, int mes) {
        if (valorDocumento <= 0 || codDocumento <= 0 || ano <= 0 || mes <= 0) {
            throw new IllegalArgumentException("Uma despesa precisa de valor, codigo, ano e mes válidos.");
        }
        this.ano = ano;
        this.mes = mes;
        this.valorDocumento = valorDocumento;
        this.codDocumento = codDocumento;
    }

    public YearMonth getDataDocumento() {
        return YearMonth.of(ano, mes);
    }

    public long getCodDocumento() {
        return codDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public double getValorDocumento() {
        return valorDocumento;
    }

    public URL getUrlDocumento() {
        return urlDocumento;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public String getCnpjCpfFornecedor() {
        return cnpjCpfFornecedor;
    }

    public int getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setCodTipoDocumento(int codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    public void setUrlDocumento(URL urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public void setCnpjCpfFornecedor(String cnpjCpfFornecedor) {
        this.cnpjCpfFornecedor = cnpjCpfFornecedor;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return codDocumento == despesa.codDocumento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codDocumento);
    }

//    @Override
//    public int compareTo(Despesa o) {
//        return Double.compare(this.valorDocumento, o.getValorDocumento());
//    }
}
