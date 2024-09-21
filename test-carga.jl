using Distributed
using HTTP
using Statistics

# Função para processar os resultados
function process_results(results)
    successes = count(x -> x[1] == "200", results)
    failures = length(results) - successes
    success_rate = successes / length(results) * 100
    response_times = [x[2] for x in results]
    avg_response_time = mean(response_times)
    min_response_time = minimum(response_times)
    max_response_time = maximum(response_times)

    println("Sucessos: $successes")
    println("Falhas: $failures")
    println("Percentual de Sucesso: $success_rate%")
    println("Tempo Médio de Resposta: $avg_response_time segundos")
    println("Menor Tempo de Resposta: $min_response_time segundos")
    println("Maior Tempo de Resposta: $max_response_time segundos")
end

# Iniciar as requisições
addprocs()  # Adiciona processos de trabalho com base no número de núcleos disponíveis
@everywhere using HTTP

results = @distributed (vcat) for i in 1:1000
    start_time = time()
    response = read(`curl -s -o /dev/null -w "%{http_code}" http://localhost:8080/products`, String)
    end_time = time()
    (response, end_time - start_time)
end

# Processar e exibir os resultados
process_results(results)
