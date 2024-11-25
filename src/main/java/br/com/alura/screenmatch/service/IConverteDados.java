package br.com.alura.screenmatch.service;

public interface IConverteDados {
    //METODO QUE CONVERTE UM JSON PARA A CLASSE ESPECIFICADA
    <T> T obterDados(String json, Class<T> classe);
}
