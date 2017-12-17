package Application.SecondApplet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ControlsPanelListener implements ActionListener {
    private final JSpinner figureSpinner;
    private final JList<String> colorList;
    private final JSpinner startXSpinner;
    private final JSpinner startYSpinner;
    private final JSpinner heightSpinner;
    private final JSpinner widthSpinner;
    private final ShapesPanel shapesPanel;


    ControlsPanelListener(JSpinner figureSpinner, JList<String> colorList,
                          JSpinner startXSpinner, JSpinner startYSpinner,
                          JSpinner heightSpinner, JSpinner widthSpinner,
                          ShapesPanel shapesPanel) {
        this.figureSpinner = figureSpinner;
        this.colorList = colorList;
        this.startXSpinner = startXSpinner;
        this.startYSpinner = startYSpinner;
        this.heightSpinner = heightSpinner;
        this.widthSpinner = widthSpinner;
        this.shapesPanel = shapesPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Draw":
                System.err.println("Draw this piece of art!");
                shapesPanel.actionPerformed(figureSpinner.getValue().toString(),
                        (int) startXSpinner.getValue(), (int) startYSpinner.getValue(),
                        (int) widthSpinner.getValue(), (int) heightSpinner.getValue(),
                        colorList.getSelectedValue());
                break;
            case "Clear":
                //shapesPanel = new ShapesPanel();
                shapesPanel.clearScreen();
                break;
            default:
                System.err.println("No action specified at ControlsPanelListener.actionPerformed()");
                break;
        }
    }
}
