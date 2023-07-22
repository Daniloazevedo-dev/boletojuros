package br.com.boletojuros.core.domain.enums;

public enum TipoExecao {
    BOLETO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "O boleto encontrado é inválido";
        }
    },
    TIPO_BOLETO_INVALIDO {
        @Override
        public String getMensagemErro() {
            return "Infelizmente só podemos calcular os juros dos boletos XPTO";
        }
    },
    BOLETO_NAO_VENCIDO {
        @Override
        public String getMensagemErro() {
            return "O Boleto informado ainda não está vencido";
        }
    };

    public abstract String getMensagemErro();
}
