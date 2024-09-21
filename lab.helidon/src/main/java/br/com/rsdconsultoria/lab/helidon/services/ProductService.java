package br.com.rsdconsultoria.lab.helidon.services;

import br.com.rsdconsultoria.lab.helidon.core.model.Product;
import br.com.rsdconsultoria.lab.helidon.infrastructure.repository.ProductRepositoryImpl;
import io.helidon.config.Config;
import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.HttpService;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import jakarta.json.JsonObjectBuilder;

public class ProductService extends BaseServie implements HttpService {

    private ProductRepositoryImpl productRepository;

    public ProductService() {
        this(Config.global().get("app"));
    }

    public ProductService(final ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService(Config config) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void routing(HttpRules rules) {
        rules.get("/", this::listAllHandler);
    }

    private void listAllHandler(ServerRequest request,
            ServerResponse response) {
        var jsonArray = JSON.createArrayBuilder();
        System.out.println("chamou...");

        for (Product product : this.productRepository.listAll()) {
            JsonObjectBuilder objectBuilder = JSON.createObjectBuilder()
                    .add("id", product.getId().toString())
                    .add("name", product.getName())
                    .add("category", product.getCategory());
            jsonArray.add(objectBuilder.build());
        }

        response.send(jsonArray.build());
    }
}
