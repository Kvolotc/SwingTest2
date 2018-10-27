package com.swingtest2;

import com.swingtest2.model.Student;
import com.swingtest2.model.StudentTableModel;
import com.swingtest2.model.Students;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class SwingApp {

    private JFrame mainFrame;
    private JPanel controlPanel;
    private JPanel controlPanel2;
    private JPanel controlPanel3;
    private JPanel controlPanel4;
    private JButton nextButton;
    private JButton previousButton;
    private JButton changeStudemtButton;
    private JButton addStudentButton;
    private StudentTableModel studentTableModel;
    private JTextField personNumberFiled;
    private JTextField firstNameFiled;
    private JTextField middleNameFiled;
    private JTextField lastNameFiled;
    private JTextField fatherFiled;
    private JTextField motherFiled;
    private JTextField genderFiled;
    private JTextField birthDateFiled;

    public SwingApp(){
        prepareGUI();
    }
    public static void main(String[] args){
        SwingApp swingControlDemo = new SwingApp();
        swingControlDemo.showEventDemo();
    }
    private void prepareGUI(){

        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(700,500);
        mainFrame.setLayout(new GridBagLayout());


        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel2 = new JPanel();
        controlPanel2.setLayout(new BorderLayout());
        controlPanel3 = new JPanel();
        controlPanel3.setLayout(new FlowLayout());
        controlPanel4 = new JPanel();
        controlPanel4.setLayout(new FlowLayout());

        mainFrame.add(controlPanel, new GridBagConstraints(1,0,1,1,1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2),0 ,0));
        mainFrame.add(controlPanel2, new GridBagConstraints(1,1,1,1,1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2),0 ,0));
        mainFrame.add(controlPanel3, new GridBagConstraints(1,2,1,1,1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2),0 ,0));
        mainFrame.add(controlPanel4, new GridBagConstraints(1,3,1,1,1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2),0 ,0));
        mainFrame.setVisible(true);
    }
    private void showEventDemo(){

        studentTableModel = new StudentTableModel(getStudents());

        JTable table = new JTable(studentTableModel);
        table.setFillsViewportHeight(true);
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        changeStudemtButton = new JButton("Change");
        addStudentButton = new JButton("Add");

        personNumberFiled = new JFormattedTextField("Person number");
        firstNameFiled = new JFormattedTextField("First name");
        middleNameFiled = new JFormattedTextField("Middle name");
        lastNameFiled = new JFormattedTextField("Last name");
        fatherFiled = new JFormattedTextField("Father");
        motherFiled = new JFormattedTextField("Mother");
        genderFiled = new JFormattedTextField("Gender");
        birthDateFiled = new JFormattedTextField("Birth date");

        nextButton.setActionCommand("Next");
        previousButton.setActionCommand("Previous");
        changeStudemtButton.setActionCommand("Change");
        addStudentButton.setActionCommand("Add");
        previousButton.setVisible(false);

        nextButton.addActionListener(new ButtonClickListener());
        previousButton.addActionListener(new ButtonClickListener());
        changeStudemtButton.addActionListener(new ButtonClickListener());
        addStudentButton.addActionListener(new ButtonClickListener());


        controlPanel.add(nextButton,new GridBagConstraints(1,1,1,2,5,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2),0 ,0));
        controlPanel.add(previousButton);

        controlPanel2.add(table.getTableHeader(), BorderLayout.PAGE_START);
        controlPanel2.add(table, BorderLayout.CENTER);

        controlPanel3.add(personNumberFiled);
        controlPanel3.add(firstNameFiled);
        controlPanel3.add(middleNameFiled);
        controlPanel3.add(lastNameFiled);
        controlPanel3.add(fatherFiled);
        controlPanel3.add(motherFiled);
        controlPanel3.add(genderFiled);
        controlPanel3.add(birthDateFiled);

        controlPanel4.add(changeStudemtButton);
        controlPanel4.add(addStudentButton);

        mainFrame.setVisible(true);
    }

    private Students getStudents() {
        File xmlFile = new File("/home/kindgeek/SwingTest2/src/com/resources/students.xml");
        Students students = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Students) unmarshaller.unmarshal(xmlFile);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return students;
    }

    private void saveToXmlFile(Students students) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(students, new File("/home/kindgeek/SwingTest2/src/com/resources/students.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Next":
                    studentTableModel.nextPage();
                    if (studentTableModel.getMaxPage() == studentTableModel.getCurentPage()) {
                        nextButton.setVisible(false);
                    }
                    previousButton.setVisible(true);
                    break;
                case "Previous":
                    studentTableModel.previousPage();
                    if (0 == studentTableModel.getCurentPage()) {
                        previousButton.setVisible(false);
                    }
                    nextButton.setVisible(true);
                    break;
                case "Change":
                    studentTableModel.changeStudent(Student.buildStudent(personNumberFiled.getText(), firstNameFiled.getText(), middleNameFiled.getText(),
                            lastNameFiled.getText(), fatherFiled.getText(), motherFiled.getText(), genderFiled.getText(), birthDateFiled.getText()));
                    saveToXmlFile(studentTableModel.getStudents());
                    break;
                case "Add":
                    studentTableModel.addStudent(Student.buildStudent(personNumberFiled.getText(), firstNameFiled.getText(), middleNameFiled.getText(),
                            lastNameFiled.getText(), fatherFiled.getText(), motherFiled.getText(), genderFiled.getText(), birthDateFiled.getText()));
                    saveToXmlFile(studentTableModel.getStudents());
                    break;
            }
        }
    }
}
