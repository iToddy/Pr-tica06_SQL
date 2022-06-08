package Q1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Conect {
	
	 private final String url = "jdbc:postgresql://localhost/BDlivrariaUniversitaria";
	 private final String user = "postgres";
	 private final String password = "Ferrugem2";
	 Connection conect ;

	 
	 public Statement start() {
	        try {
	            Class.forName("org.postgresql.Driver");
	            conect = DriverManager.getConnection(url, user, password);
	            Statement statement = conect.createStatement();
	            return statement;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }

	    public void end() {
	        try {
	            conect.close();
	        } catch (Exception ex2) {
	            ex2.printStackTrace();
	        }
	    }

}
