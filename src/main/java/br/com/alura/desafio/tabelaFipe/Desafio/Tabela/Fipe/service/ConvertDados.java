package br.com.alura.desafio.tabelaFipe.Desafio.Tabela.Fipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConvertDados implements IConvertDados{
    ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T obterDados(String e, Class<T> tClass) {
        try {
            return mapper.readValue(e, tClass);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> List<T> obterLista(String e, Class<T> tClass) {
        CollectionType lista = mapper.getTypeFactory().constructCollectionType(List.class, tClass);
        try {
            return mapper.readValue(e, lista);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }


}
