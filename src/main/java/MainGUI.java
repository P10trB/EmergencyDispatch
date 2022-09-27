import javax.swing.*;
import java.awt.*;

/*  chyba nigdy nie bede frontendowcem, bo nie mam pojecia jak zaplanowac GUI,
 *   zeby bylo ladne i funkcjonalne
 *   Tu mamy wersje 0.001 GUI
 *   Czesciowo dziala, ale brakuje backendu jeszcze
 *   Te wszystkie tymczasowe dane to zapelniacze do debugu samego GUI    */
public class MainGUI {
    public void buildGUI(){
        JFrame frame = new JFrame("Emergency Dispatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,350);
        frame.setResizable(false);

        String[] tempList = {"Cat on a tree", "Building fire", "Bank robbery", "Drunk driving",
                "Car accident", "Leaking chemicals", "Missing person", "Kidnapping"};//TODO remove this

        JList<String> listOfPendingIncidents = new JList<>(tempList);//TODO fill with actual data
        JScrollPane scrollerIncidents = new JScrollPane(listOfPendingIncidents);
        scrollerIncidents.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JTextArea currentIncident = new JTextArea(4,20);
        currentIncident.setText("Temporary text representing\ncurrently selected\nincident put here\nfor debugging");//TODO replace with actual data
        currentIncident.setEditable(false);
        currentIncident.setLineWrap(true);
        listOfPendingIncidents.addListSelectionListener(e -> currentIncident.setText(listOfPendingIncidents.getSelectedValue()));//TODO replace with actual incident data
        JLabel numberOfPendingIncidents = new JLabel("Pending incidents: " + tempList.length);

        JButton selectImportantButton = new JButton("Select top priority incident");//TODO add button click listener
        JButton reqestDispatchButton = new JButton("RequestDispatch");//TODO add button click listener

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(selectImportantButton);
        bottomPanel.add(reqestDispatchButton);


        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        centerPanel.add(scrollerIncidents);
        centerPanel.add(currentIncident);

        JCheckBox[] checkBoxes = new JCheckBox[3];
        for(int i =0; i < 3; i++){
            checkBoxes[i] = new JCheckBox();
            centerPanel.add(checkBoxes[i]);
            //TODO add Action listeners to checkboxes
        }
        checkBoxes[0].setText("Send Police units");
        checkBoxes[1].setText("Send Medical units");
        checkBoxes[2].setText("Send Fire Dept units");

        frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
        frame.getContentPane().add(BorderLayout.NORTH, numberOfPendingIncidents);
        frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        frame.setVisible(true);

    }
}
