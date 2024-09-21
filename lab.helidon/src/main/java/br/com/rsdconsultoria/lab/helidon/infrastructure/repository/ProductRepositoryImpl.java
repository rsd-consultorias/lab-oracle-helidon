package br.com.rsdconsultoria.lab.helidon.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.rsdconsultoria.lab.helidon.core.model.Product;
import br.com.rsdconsultoria.lab.helidon.core.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> listAll() {
        var result = new ArrayList<Product>();

        result.add(new Product("Product A", "Category X"));
        result.add(new Product("Product B", "Category X"));
        result.add(new Product("Product C", "Category X"));
        result.add(new Product("Product D", "Category Y"));

        return result;
    }

}
