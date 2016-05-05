package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {

	Connection  conn;
	public static Connection conectare()
	{
		
			//specifica ce tip de db avem (aici avem sqlite)
			try {
				Class.forName("org.sqlite.JDBC");
				//obtinem conectarea la baza de date
				Connection conn=DriverManager.getConnection("jdbc:sqlite:D:\\Java work\\SilviuDB.sqlite");
				System.out.println("M-am conectat!!");
				return conn;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
					
		
		return null;
		
	}
	
}
