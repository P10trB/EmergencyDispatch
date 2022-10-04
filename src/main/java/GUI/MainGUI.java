package GUI;

import Backend.RequestDispatchListener;
import CommonClasses.MessageValuesForGui;
import IncidentFactory.Incident;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainGUI {

    JFrame frame = new JFrame(MessageValuesForGui.APP_NAME);
    @Getter @Setter
    JList<Incident> listOfPendingIncidents;
    @Setter
    JTextArea currentIncident;
    private JCheckBox[] checkBoxes;

    


    public void makeGUI(List<Incident> incidentList){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        Dimension minimumDimension = new Dimension(400, 400);
        frame.setMinimumSize(minimumDimension);
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src/main/resources/icon.png");
            frame.setIconImage(icon);
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        createGUI(frame, incidentList);

    }

    private void createGUI(JFrame frame, List<Incident> incidentList) {
        Incident[] incidentArray = new Incident[incidentList.size()];
        for (int i = 0; i < incidentArray.length; i++) {
            incidentArray[i] = incidentList.get(i);
        }
        listOfPendingIncidents = new JList<>(incidentArray);

        JScrollPane scrollerOfIncidents = new JScrollPane(listOfPendingIncidents); //scroller of the list
        scrollerOfIncidents.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollerOfIncidents.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        listOfPendingIncidents.setVisibleRowCount(8);
        currentIncident = new JTextArea(4,20);//current incident display
        currentIncident.setEditable(false);
        currentIncident.setLineWrap(true);
        listOfPendingIncidents.addListSelectionListener(e -> currentIncident.setText(listOfPendingIncidents.getSelectedValue().getIncidentDescription()));
        JLabel numberOfPendingIncidents = new JLabel();

        JButton requestDispatchButton = new JButton(MessageValuesForGui.REQUEST_DISPATCH);  //dispatch button
        requestDispatchButton.addActionListener(new RequestDispatchListener());

        JPanel bottomPanel = new JPanel(new GridLayout(2,1));

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mainPanel.add(scrollerOfIncidents);
        mainPanel.add(currentIncident);

        JPanel footerPanel = new JPanel();

        checkBoxes = new JCheckBox[3];
        for(int i =0; i < 3; i++){
            checkBoxes[i] = new JCheckBox();
            footerPanel.add(checkBoxes[i]);
            checkBoxes[i].setEnabled(false);
            checkBoxes[i].setText(MessageValuesForGui.SEND_EMERGENCY_SERVICES[i]);
            checkBoxes[i].setEnabled(true);
        }
        bottomPanel.add(footerPanel);
        bottomPanel.add(requestDispatchButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.getContentPane().add(BorderLayout.NORTH, numberOfPendingIncidents);
        frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        numberOfPendingIncidents.setText(MessageValuesForGui.PENDING_INCIDENTS + incidentList.size());
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
