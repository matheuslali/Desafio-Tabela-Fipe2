package br.com.alura.desafio.tabelaFipe.Desafio.Tabela.Fipe.service;

import java.util.List;

public interface IConvertDados {
    <T> T obterDados (String e, Class<T> tClass);
    <T> List<T> obterLista (String e, Class<T> tClass);

}
