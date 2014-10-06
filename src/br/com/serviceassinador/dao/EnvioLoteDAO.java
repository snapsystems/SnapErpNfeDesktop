package br.com.serviceassinador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.serviceassinador.bean.EnvioLote;


public class EnvioLoteDAO {
	public EnvioLoteDAO(){
		
	}
	
	public void inserirEnvioLote(String nomeCertificado, String senha, String arquivo, String municipio) throws ClassNotFoundException, SQLException{
		try{
			Connection con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement("INSERT INTO TBL_ENVIO_LOTE (NOME_CERTIFICADO, SENHA_CERTIFICADO, ARQUIVO_ENVIO, SITUACAO, MUNICIPIO) values (?, ?, ?, ?, ?)");
			stmt.setString(1, nomeCertificado);
			stmt.setString(2, senha);
			stmt.setString(3, arquivo);
			stmt.setString(4, "Aguardando Envio");
			stmt.setInt(5, Integer.valueOf(municipio).intValue());
			stmt.executeUpdate();
			stmt.close();
		}catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public void atualizarEnvioLote(EnvioLote envioLote) throws ClassNotFoundException, SQLException{
		try{
			Connection con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement("UPDATE TBL_ENVIO_LOTE SET SITUACAO = ?, PROTOCOLO = ?, ARQUIVO_RETORNO = ? WHERE ID = ?");
			stmt.setString(1, "Lote Processado"); // Aguardando Retorno
			stmt.setString(2, "PROTOCOLO");
			stmt.setString(3, envioLote.getArquivoRetorno());
			stmt.setInt(4, envioLote.getId());

			stmt.executeUpdate();
			
			stmt.close();
		}catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
	}

	public ResultSet getEnvioLote(){
		try{
		Connection con = ConnectionFactory.getConnection();
		
		Statement st = con.createStatement();
		ResultSet rs;
		rs = st.executeQuery("Select TOP 1 LOTE.ID, LOTE.NOME_CERTIFICADO, LOTE.SENHA_CERTIFICADO, LOTE.ARQUIVO_ENVIO, LOTE.ARQUIVO_RETORNO, LOTE.SITUACAO, LOTE.MUNICIPIO " +
							 "From TBL_ENVIO_LOTE AS LOTE " +
							 "Where LOTE.SITUACAO = \'Aguardando Envio\' ORDER BY ID ASC");		
	
		return rs;
	
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
