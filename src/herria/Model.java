package herria;

import java.sql.*;
import java.util.ArrayList;

public class Model {
    
    public Connection konektatu(){
        String mota = "local";
        String db;
        String url;
        Connection conn = null;
        
        if (mota.equals("remotoa")){
            db ="HerrienDBa";
            url = "jdbc:mariadb:" + db;
//            conn = DriverManager.getConnection(url, "dami", "dami");
        }else{
            try{
                db ="HerrienDBa.sqlite";
                url = "jdbc:sqlite:"+db;
                conn = DriverManager.getConnection(url);
                System.out.println("datu basera konektatua");
            }catch(SQLException e){
                System.out.println("cum");
            }
        }
        
        return conn;
    }
    
    public boolean txertatu(Herria h){
        String taula = "Herria";
        
        String sql = "INSERT INTO Herriak VALUES(?, ?, ?, ?)";
        
        try (Connection conn = this.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, h.getIzena());
            pstmt.setString(2, h.getProbintzia());
            pstmt.setString(3, h.getHondartza());
            pstmt.setString(4, h.getOharrak());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static void main(String[] args) {
        Model model = new Model();
        model.konektatu();
        
        Herria h = new Herria("Azpeitia", "Gipuzkoa", false, "Earraek");
        
        model.txertatu(h);
    }
}
