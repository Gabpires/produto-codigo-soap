package br.products.cod.br.produto_codigo.endpoint;

import br.products.cod.br.produto_codigo.exception.ProdutoNaoEncontradoException;
import br.products.cod.br.produto_codigo.schema.ConsultarProdutoRequest;
import br.products.cod.br.produto_codigo.schema.ConsultarProdutoResponse;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProdutoEndpoint {

    private static final String NAMESPACE = "http://produto.codigo.br/produto";

    @PayloadRoot(namespace = NAMESPACE, localPart = "consultarProdutoRequest")
    @ResponsePayload
    public ConsultarProdutoResponse consultarCliente(
            @RequestPayload ConsultarProdutoRequest request) {

        if (request.getCodigo() == 1) {
            ConsultarProdutoResponse response = new ConsultarProdutoResponse();
            response.setNomeproduto("Arroz 5kg");
            response.setDescricao("pacote com 5kg de arroz");
            response.setMarca("tio joao");
            response.setEstoque("5 pacotes");
            return response;
        }

        throw new ProdutoNaoEncontradoException(
                "Produto não encontrado no estoque: " + request.getCodigo());
    }
}
