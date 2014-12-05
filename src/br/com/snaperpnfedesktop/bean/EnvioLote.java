package br.com.snaperpnfedesktop.bean;

public class EnvioLote {
	public int id;
	public String nomeCertificado;
	public String senhaCertificado;
	public String arquivoEnvio;
	public String arquivoRetorno;
	public String arquivoRetornoConsultaLote;
	public String situacao;
	public String protocolo;
	public String cnpj;
	public int municipio;
	public int estado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCertificado() {
		return nomeCertificado;
	}
	public void setNomeCertificado(String nomeCertificado) {
		this.nomeCertificado = nomeCertificado;
	}
	public String getSenhaCertificado() {
		return senhaCertificado;
	}
	public void setSenhaCertificado(String senhaCertificado) {
		this.senhaCertificado = senhaCertificado;
	}
	public String getArquivoEnvio() {
		return arquivoEnvio;
	}
	public void setArquivoEnvio(String arquivoEnvio) {
		this.arquivoEnvio = arquivoEnvio;
	}
	public String getArquivoRetorno() {
		return arquivoRetorno;
	}
	public void setArquivoRetorno(String arquivoRetorno) {
		this.arquivoRetorno = arquivoRetorno;
	}
	public String getArquivoRetornoConsultaLote() {
		return arquivoRetornoConsultaLote;
	}
	public void setArquivoRetornoConsultaLote(String arquivoRetornoConsultaLote) {
		this.arquivoRetornoConsultaLote = arquivoRetornoConsultaLote;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public int getMunicipio() {
		return municipio;
	}
	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
