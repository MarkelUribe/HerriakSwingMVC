package herria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setTitle("HERRIEN KUDEAKETA");
        view.herrienTableModela.datuak = model.irakurri();
        view.herrienTableModela.fireTableChanged(null);
        anadirActionListener(this);
    }

    private void anadirActionListener(ActionListener listener) {
        //GUIaren konponente guztiei gehitu listenerra
        view.jButtonGehitu.addActionListener(listener);
    }

    private void anadirKeyListener(ActionListener listener) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        //listenerrak entzun dezakeen eragiketa bakoitzeko. Konponenteek 'actionCommad' propietatea daukate
        switch (actionCommand) {
            case "GEHITU":

                Herria h = new Herria(view.jTextFieldHerria.getText(), view.jComboBoxProbintzia.getSelectedItem().toString(),
                        view.jCheckBoxHondartza.isSelected(), view.jTextAreaOharrak.getText());
                model.txertatu(h);
                view.herrienTableModela.datuak = model.irakurri();
                view.herrienTableModela.fireTableChanged(null);
                break;
            case "EZABATU":
                try{
                    ArrayList<Herria> d = model.irakurri();
                    model.ezabatu(d.get(view.jTableHerriak.getSelectedRow()).getIzena());
                    view.herrienTableModela.datuak = model.irakurri();
                    view.herrienTableModela.fireTableChanged(null);
                    System.out.println("Ezabatu da");
                }catch  (Exception E){
                    System.out.println("Arazoa ezabatzerakoan");
                }
                break;
        }
    }
}
