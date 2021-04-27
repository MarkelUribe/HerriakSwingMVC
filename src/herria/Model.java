package herria;

import java.sql.*;
import java.util.ArrayList;

public class Model {

    public Connection konektatu() {
        String mota = "local";
        String db;
        String url;
        Connection conn = null;

        if (mota.equals("remotoa")) {
            db = "HerrienDBa";
            url = "jdbc:mariadb:" + db;
//            conn = DriverManager.getConnection(url, "dami", "dami");
        } else {
            try {
                db = "HerrienDBa.sqlite";
                url = "jdbc:sqlite:" + db;
                conn = DriverManager.getConnection(url);
                System.out.println("datu basera konektatua");
            } catch (SQLException e) {
                System.out.println("cum");
            }
        }

        return conn;
    }

    public boolean txertatu(Herria h) {
        String taula = "Herria";

        String sql = "INSERT INTO Herriak VALUES(?, ?, ?, ?)";

        try ( Connection conn = this.konektatu();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
     public void ezabatu(String id) {
        String sql = "DELETE FROM Herriak WHERE Herria = ?";

        try (Connection conn = this.konektatu();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Herria> irakurri() {
        String sql = "SELECT * FROM Herriak";

        try ( Connection conn = this.konektatu();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            ArrayList<Herria> herriak = new ArrayList<>();
            while (rs.next()) {
                Herria h = new Herria(rs.getString("Herria"), rs.getString("Probintzia"),
                        rs.getBoolean("Hondartza"), rs.getString("Oharrak"));

                herriak.add(h);
            }
            return herriak;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        model.konektatu();

//        Herria h = new Herria("Azpeitia", "Gipuzkoa", false, "Earraek");
//        Herria h2 = new Herria("Azpeitia2", "Gipuzkoa", false, "Earraek");

//        model.txertatu(h);
//        model.txertatu(h2);
        
        System.out.println(model.irakurri());
    }
}
