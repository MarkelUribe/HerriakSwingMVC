package herria;

import com.sun.jdi.connect.spi.Connection;

public class Model {
    
    public Connection konektatu(){
        String mota = "remotoa";
        String db;
        String url;
        Connection conn = null;
        
        if (mota.equals("remotoa")){
            db ="HerrienDBa";
            url = "jdbc:mariadb:" + db;
            conn = DriverManager.getConnection(url, "dami", "dami");
        }else{
            db ="HerrienDBa.sqlite";
        }
        
        
    }
    
    public boolean txertatu(Herria h){
        String taula = "Herria";
        
        String sql = "";
        
        return false;
    }
}
