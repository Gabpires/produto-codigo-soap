package br.products.cod.br.produto_codigo.endpoint;

import br.products.cod.br.model.ConsultarProdutoRequest;
import br.products.cod.br.model.ConsultarProdutoResponse;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProdutoEndpoint {

    private static final String NAMESPACE = "http://br.products.cod.br/produto";

    @PayloadRoot( namespace = NAMESPACE, localPart = "consultarProdutoRequest"  )
    @ResponsePayload
    public ConsultarProdutoResponse consultarProduto( @RequestPayload ConsultarProdutoRequest request) {

        ConsultarProdutoResponse response =  new ConsultarProdutoResponse();

        if (request.getCodigo() == 12345) {

            response.setNomeproduto("Arroz 5kg");
            response.setDescricao("Pacote de 5kg de arroz");
            response.setMarca("São João");
            response.setEstoque("5 pacotes");


        } else {

            response.setNomeproduto( "Produto não encontrado" );
            response.setDescricao("-");
            response.setMarca("-");
            response.setEstoque("-");
        }

        return response;
    }
}