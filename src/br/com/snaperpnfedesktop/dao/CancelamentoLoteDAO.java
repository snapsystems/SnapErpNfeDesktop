package br.com.snaperpnfedesktop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.snaperpnfedesktop.bean.CancelamentoLote;

public class CancelamentoLoteDAO {
	
	public CancelamentoLoteDAO(){
		
	}
	
	public void atualizarCancelamentoLote(CancelamentoLote cancelamentoLote) throws ClassNotFoundException, SQLException{
		try{
			Connection con = ConnectionFactory.getConnection();

			PreparedStatement stmt = con.prepareStatement("UPDATE TBL_CANC_LOTE SET SITUACAO = ?, ARQUIVO_RETORNO = ? WHERE ID = ?");
			stmt.setString(1, "Lote Processado"); // Aguardando Retorno
			stmt.setString(2, cancelamentoLote.getArquivoRetorno());
			stmt.setInt(3, cancelamentoLote.getId());

			stmt.executeUpdate();
			
			stmt.close();
		}catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public ResultSet getCancelamentoLote(){
		try{
			Connection con = ConnectionFactory.getConnection();
			
			Statement st = con.createStatement();
			ResultSet rs;
			rs = st.executeQuery("Select TOP 1 CANC.ID, CANC.NOME_CERTIFICADO, CANC.SENHA_CERTIFICADO, CANC.ARQUIVO_ENVIO, CANC.ARQUIVO_RETORNO, CANC.SITUACAO, CANC.MUNICIPIO " +
								 "From TBL_CANC_LOTE AS CANC " +
								 "Where CANC.SITUACAO = \'Aguardando Envio\' AND CANC.MUNICIPIO IS NOT NULL AND CANC.ARQUIVO_ENVIO IS NOT NULL ORDER BY ID ASC");		
		
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
