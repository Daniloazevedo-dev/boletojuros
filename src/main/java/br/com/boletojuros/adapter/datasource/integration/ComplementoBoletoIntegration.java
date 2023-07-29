package br.com.boletojuros.adapter.datasource.integration;

import br.com.boletojuros.adapter.datasource.integration.client.ComplementoBoletoClient;
import br.com.boletojuros.adapter.datasource.mapper.BoletoMapper;
import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.port.out.ComplementoBoletoPort;
import org.springframework.stereotype.Component;

@Component
public class ComplementoBoletoIntegration implements ComplementoBoletoPort {

    private final ComplementoBoletoClient complementoBoletoClient;
    private final BoletoMapper mapper;

    public ComplementoBoletoIntegration(ComplementoBoletoClient complementoBoletoClient, BoletoMapper mapper) {
        this.complementoBoletoClient = complementoBoletoClient;
        this.mapper = mapper;
    }

    @Override
    public Boleto executar(String codigo) {
        var boletoDTO = complementoBoletoClient.getBoleto(codigo);
        return mapper.toDomain(boletoDTO);
    }
}
