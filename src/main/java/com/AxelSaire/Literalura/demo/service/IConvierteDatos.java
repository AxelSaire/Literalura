package com.AxelSaire.Literalura.demo.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}