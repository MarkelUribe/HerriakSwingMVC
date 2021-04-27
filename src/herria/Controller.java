package herria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setTitle("HERRIEN KUDEAKETA");
        view.herrienTableModela.datuak = model.irakurri();

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
                break;
            case "EZABATU":
                
                model.ezabatu("");
                break;
            default:

        }
    }
}
