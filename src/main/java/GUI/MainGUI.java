package GUI;

import Backend.DispatchEngine;
import CommonClasses.Strings;
import IncidentFactory.Incident;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*  chyba nigdy nie bede frontendowcem, bo nie mam pojecia jak zaplanowac GUI,
 *   zeby bylo ladne i funkcjonalne
 *   Tu mamy wersje 0.001 GUI
 *   Czesciowo dziala, ale brakuje backendu jeszcze
 *   Te wszystkie tymczasowe dane to zapelniacze do debugu samego GUI    */
public class MainGUI {

    JFrame frame = new JFrame(Strings.APP_NAME);
    @Getter @Setter
    JList<Incident> listOfPendingIncidents;
    @Setter
    JTextArea currentIncident;
    private JCheckBox[] checkBoxes;

    


    public void makeGUI(List<Incident> incidentList){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,350);
        //frame.setResizable(false);
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src/main/resources/icon.png");
            frame.setIconImage(icon);
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        createGUI(frame, incidentList);   //What other method name should it be?

    }

    private void createGUI(JFrame frame, List<Incident> incidentList) {
        for (Incident incident : incidentList){
            Incident[] incidentArray = new Incident[incidentList.size()];
            for (int i = 0; i < incidentArray.length; i++) {
                incidentArray[i] = incidentList.get(i);
            }
            listOfPendingIncidents = new JList<>(incidentArray);
        }
        JScrollPane scrollerIncidents = new JScrollPane(listOfPendingIncidents);
        listOfPendingIncidents.setVisibleRowCount(8);
        scrollerIncidents.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollerIncidents.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        currentIncident = new JTextArea(4,20);
        currentIncident.setEditable(false);
        currentIncident.setLineWrap(true);
        listOfPendingIncidents.addListSelectionListener(e -> currentIncident.setText(listOfPendingIncidents.getSelectedValue().getIncidentName()));
        JLabel numberOfPendingIncidents = new JLabel(Strings.PENDING_INCIDENTS + listOfPendingIncidents.getComponentCount());

        JButton requestDispatchButton = new JButton(Strings.REQUEST_DISPATCH);
        requestDispatchButton.addActionListener(new DispatchEngine.RequestDispatchListener());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(requestDispatchButton);

        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        centerPanel.add(scrollerIncidents);
        centerPanel.add(currentIncident);

        checkBoxes = new JCheckBox[3];
        for(int i =0; i < 3; i++){
            checkBoxes[i] = new JCheckBox();
            centerPanel.add(checkBoxes[i]);
            checkBoxes[i].setEnabled(false);
            checkBoxes[i].setText(Strings.SEND_EMERGENCY_SERVICES[i]);
        }

        frame.getContentPane().add(BorderLayout.CENTER, centerPanel);
        frame.getContentPane().add(BorderLayout.NORTH, numberOfPendingIncidents);
        frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        frame.setVisible(true);
    }
    public String getCurrentlySelectedIncident(){
        return listOfPendingIncidents.getSelectedValue().getIncidentName();
    }
    public boolean getCheckboxStatus(int i){
        return checkBoxes[i].isSelected();
    }
    public void setCheckboxesStatus(boolean[] status){
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i].setEnabled(status[i]);
        }
    }
}
