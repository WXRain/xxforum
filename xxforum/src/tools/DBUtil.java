package tools;

import java.sql.Connection;
import java.util.Vector;


public class DBUtil {
	private Vector<Connection> pools = new Vector<Connection>();
	private final int POOL_SIZE = 10;
	private static DBUtil instance = null;
	private final String DRIVER="com.mysql.jdbc.Driver";
	private final String URL="jdbc:mysql://127.0.0.1:3306/forum";
	private final String USERNAME="root";
	private final String PASSWORD="12345678";
	
	public DBUtil(){
		try {
			Class.forName(DRIVER);
			for(int i = 0; i < POOL_SIZE; i++){
				Connection con = java.sql.DriverManager.getConnection(URL, USERNAME, PASSWORD);
				pools.add(con);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DBUtil getInstance(){
		if(instance == null){
			instance = new DBUtil();
		}
		return instance;
	}
	
	public  Connection getConnection(){
		if(pools.size() == 0){
			try {
				Class.forName(DRIVER);
				for(int i = 0; i < POOL_SIZE; i++){
					Connection con=java.sql.DriverManager.getConnection(URL,USERNAME,PASSWORD);
					pools.add(con);
				}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Connection con=null;
		con=pools.get(0);
		pools.remove(0);
		return con;
	}
	public void release(Connection con){
		pools.add(con);
	}
}
