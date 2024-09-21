package br.com.rsdconsultoria.lab.helidon.core.repository;

import java.util.List;

import br.com.rsdconsultoria.lab.helidon.core.model.Product;

public interface ProductRepository {
    List<Product> listAll();
}
