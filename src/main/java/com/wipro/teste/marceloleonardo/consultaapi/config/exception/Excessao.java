package com.wipro.teste.marceloleonardo.consultaapi.config.exception;

import java.time.LocalDateTime;
import java.util.List;

public class Excessao {

    private Integer codigo;
    private LocalDateTime dataHora;
    private String DescricaoResumida;
    private List<DetalhamentoErro> detalhamentoErro;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricaoResumida() {
        return DescricaoResumida;
    }

    public void setDescricaoResumida(String descricaoResumida) {
        DescricaoResumida = descricaoResumida;
    }

    public List<DetalhamentoErro> getDetalhamentoErro() {
        return detalhamentoErro;
    }

    public void setDetalhamentoErro(List<DetalhamentoErro> detalhamentoErro) {
        this.detalhamentoErro = detalhamentoErro;
    }

    public static class DetalhamentoErro {
        private String campo;
        private String mensagem;

        public DetalhamentoErro(String campo, String mensagem) {
            super();
            this.campo = campo;
            this.mensagem = mensagem;
        }

        public String getCampo() {
            return campo;
        }
        public void setCampo(String campo) {
            this.campo = campo;
        }
        public String getMensagem() {
            return mensagem;
        }
        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }
    }
}
