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
    @Setter
    private JCheckBox[] checkBoxes;
    private static final int DEFAULT_BORDER_SIZE = 10;

    


    public void makeGUI(List<Incident> incidentList){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        Dimension minimumDimension = new Dimension(400, 400);
        frame.setMinimumSize(minimumDimension);
        try {
            Image icon = Toolkit.getDefaultToolkit().getImage("src/main/resources/icon.png");
            frame.setIconImage(icon);
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        finally {
            createGUI(frame, incidentList);
        }

    }

    private void createGUI(JFrame frame, List<Incident> incidentList) {
        Incident[] incidentArray = new Incident[incidentList.size()];
        for (int i = 0; i < incidentArray.length; i++) {
            incidentArray[i] = incidentList.get(i);
        }
        JScrollPane scrollerOfIncidents = createListOfIncidents(incidentArray);

        createCurrentIncidentDisplay();

        JLabel numberOfPendingIncidents = new JLabel();

        JButton requestDispatchButton = new JButton(MessageValuesForGui.REQUEST_DISPATCH);
        requestDispatchButton.addActionListener(new RequestDispatchListener());

        JPanel bottomPanel = new JPanel(new GridLayout(2,1));

        JPanel mainPanel = createMainPanel();
        mainPanel.add(scrollerOfIncidents);
        mainPanel.add(currentIncident);

        JPanel footerPanel = new JPanel();

        checkBoxes = new JCheckBox[3];
        for(int i =0; i < 3; i++){
            checkBoxes[i] = new JCheckBox();
            checkBoxes[i].setEnabled(false);
            checkBoxes[i].setText(MessageValuesForGui.SEND_EMERGENCY_SERVICES[i]);
            checkBoxes[i].setEnabled(true);
            footerPanel.add(checkBoxes[i]);
        }
        bottomPanel.add(footerPanel);
        bottomPanel.add(requestDispatchButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.getContentPane().add(BorderLayout.NORTH, numberOfPendingIncidents);
        frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        numberOfPendingIncidents.setText(MessageValuesForGui.PENDING_INCIDENTS + incidentList.size());
        frame.setVisible(true);
    }

    private static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(DEFAULT_BORDER_SIZE,DEFAULT_BORDER_SIZE,DEFAULT_BORDER_SIZE,DEFAULT_BORDER_SIZE));
        return mainPanel;
    }

    private void createCurrentIncidentDisplay() {
        currentIncident = new JTextArea();
        currentIncident.setEditable(false);
        currentIncident.setLineWrap(true);
        listOfPendingIncidents.addListSelectionListener(e -> currentIncident.setText(listOfPendingIncidents.getSelectedValue().getIncidentDescription()));
    }

    private JScrollPane createListOfIncidents(Incident[] incidentArray) {
        listOfPendingIncidents = new JList<>(incidentArray);

        JScrollPane scrollerOfIncidents = new JScrollPane(listOfPendingIncidents); //scroller of the list
        scrollerOfIncidents.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollerOfIncidents.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        listOfPendingIncidents.setVisibleRowCount(8);
        return scrollerOfIncidents;
    }

    public String getCurrentlySelectedIncident(){
        return listOfPendingIncidents.getSelectedValue().getIncidentName();
    }
    public boolean getCheckboxStatus(int i){
        return checkBoxes[i].isSelected();
    }

}
