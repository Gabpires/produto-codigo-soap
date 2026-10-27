package br.products.cod.br.produto_codigo.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class ProdutoNaoEncontradoException extends RuntimeException {

    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
