import java.sql.*;
public class DBConn {
    private final String DB_URL = "jdbc:sqlite:pos.db";
    
    public Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to SQLite Database!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
    public String login(String username, String password ){
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            
            String role = rs.getString("role");
            
            return rs.next() ? role : "";
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return "";
        }
    } 
}
