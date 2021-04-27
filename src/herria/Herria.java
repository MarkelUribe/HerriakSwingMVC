package herria;

public class Herria {
    private String izena;
    private String probintzia;
    private boolean hondartza;
    private String oharrak;
    
    public Herria(String izena, String probintzia, boolean hondartza, String oharrak) {
        this.izena = izena;
        this.probintzia = probintzia;
        this.hondartza = hondartza;
        this.oharrak = oharrak;
    }

    @Override
    public String toString() {
        return "izena:" + izena + ", probintzia:" + probintzia + ", hondartza:" + hondartza + ", oharrak:" + oharrak + "\n";
    }
    
    public String getHondartza(){
        if(hondartza){
            return "bai";
        }else{
            return "ez";
        }
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    public void setHondartza(boolean hondartza) {
        this.hondartza = hondartza;
    }

    public void setOharrak(String oharrak) {
        this.oharrak = oharrak;
    }

    public String getIzena() {
        return izena;
    }

    public String getProbintzia() {
        return probintzia;
    }

    public boolean isHondartza() {
        return hondartza;
    }

    public String getOharrak() {
        return oharrak;
    }
}
