package com.desafio.reto.Services;

@FunctionalInterface
public interface AttributeExtractor<T> {
    String extract(T object);
}