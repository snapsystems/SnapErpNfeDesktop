package br.com.snaperpnfedesktop.bean;

public class EnvioLote {
	public int id;
	public String nomeCertificado;
	public String senhaCertificado;
	public String arquivoEnvio;
	public String arquivoRetorno;
	public String situacao;
	public int municipio;
	
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
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public int getMunicipio() {
		return municipio;
	}
	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}

}
