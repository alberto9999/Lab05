package it.polito.tdp.lab05.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab05.DAO.ConnectDB;

public class AnagrammaDAO {

	public boolean findParola(String parola){
		final String sqlQuery ="SELECT nome "+
                                "FROM parola "+
                                "WHERE nome=?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sqlQuery);

			st.setString(1,parola);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
			return true;}
			
			else
			return false;
	
	       }
		catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");	
           }
	}
}
