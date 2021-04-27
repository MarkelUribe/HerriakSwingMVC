package herria;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class HerrienTableModela extends AbstractTableModel {

    public ArrayList<Herria> datuak = new ArrayList<Herria>();
    public String[] zutabeIzenak = {"HERRIA", "PROBINTZIA", "HONDARTZA", "OHARRA"};

    @Override
    public int getRowCount() {
        return datuak.size();
    }

    @Override
    public int getColumnCount() {
        return zutabeIzenak.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return datuak.get(rowIndex).getIzena();
            case 1:
                return datuak.get(rowIndex).getProbintzia();
            case 2:
                return datuak.get(rowIndex).getHondartza();
            case 3:
                return datuak.get(rowIndex).getOharrak();
            default:
                return null;
        }

    }

}
