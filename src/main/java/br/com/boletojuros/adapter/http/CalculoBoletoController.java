package br.com.boletojuros.adapter.http;

import br.com.boletojuros.adapter.http.dto.CalculoBoletoRequest;
import br.com.boletojuros.adapter.http.dto.CalculoBoletoResponse;
import br.com.boletojuros.adapter.http.mapper.CalculoBoletoMapper;
import br.com.boletojuros.core.port.in.CalculaBoletoPort;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/boleto")
public class CalculoBoletoController {

    private final CalculaBoletoPort calculoBoletoPort;

    private final CalculoBoletoMapper mapper;

    public CalculoBoletoController(CalculaBoletoPort calculoBoletoPort, CalculoBoletoMapper mapper) {
        this.calculoBoletoPort = calculoBoletoPort;
        this.mapper = mapper;
    }


    @PostMapping("/calcul0")
    @Operation(summary = "Calcular juros de um boleto")
    public ResponseEntity<CalculoBoletoResponse> calcularBoleto(@Valid @RequestBody CalculoBoletoRequest boleto) {
        var boletoCalculado = calculoBoletoPort.executar(boleto.getCodigo(), boleto.getDataPagamento());
        return ResponseEntity.ok(mapper.toDto(boletoCalculado));
    }

}
