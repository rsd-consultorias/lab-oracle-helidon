package br.com.rsdconsultoria.lab.helidon.services;

import java.util.Collections;

import jakarta.json.Json;
import jakarta.json.JsonBuilderFactory;

public class BaseServie {
    protected static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
}
