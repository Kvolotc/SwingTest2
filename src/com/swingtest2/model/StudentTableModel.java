package com.swingtest2.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class StudentTableModel extends AbstractTableModel {

    private ArrayList<String[]> studentRow = new ArrayList<>();

    private Students students;

    private int page = 0;

    public StudentTableModel(Students students) {
        this.students = students;

        this.studentRow.add(new String[]{students.getStudents().get(0).getPersonNumber(), students.getStudents().get(0).getFirstName(), students.getStudents().get(0).getMiddleName(),
                students.getStudents().get(0).getLastName(), students.getStudents().get(0).getFather(), students.getStudents().get(0).getMother(), students.getStudents().get(0).getBirthDate(),
                students.getStudents().get(0).getGender().name()});
    }

    @Override
    public String getColumnName(int i) {
        return students.getStudents().get(0).getClass().getDeclaredFields()[i].getName();
    }

    @Override
    public int getRowCount() {
        return studentRow.size();
    }

    @Override
    public int getColumnCount() {
        return studentRow.get(0).length;
    }

    @Override
    public String getValueAt(int i, int i1) {
        return studentRow.get(i)[i1];
    }

    public int getCurentPage() {
        return page;
    }

    public int getMaxPage() {
        return students.getStudents().size() - 1;
    }

    public void nextPage() {
        page++;
        studentRow.remove(0);
        studentRow.add(new String[]{students.getStudents().get(page).getPersonNumber(), students.getStudents().get(page).getFirstName(), students.getStudents().get(page).getMiddleName(),
                students.getStudents().get(page).getLastName(), students.getStudents().get(page).getFather(), students.getStudents().get(page).getMother(), students.getStudents().get(page).getBirthDate(),
                students.getStudents().get(page).getGender() == null ? null : students.getStudents().get(page).getGender().name()});
        fireTableRowsInserted(studentRow.size() - 1, studentRow.size() - 1);
    }

    public void previousPage() {
        page--;
        studentRow.remove(0);
        studentRow.add(new String[]{students.getStudents().get(page).getPersonNumber(), students.getStudents().get(page).getFirstName(), students.getStudents().get(page).getMiddleName(),
                students.getStudents().get(page).getLastName(), students.getStudents().get(page).getFather(), students.getStudents().get(page).getMother(), students.getStudents().get(page).getBirthDate(),
                students.getStudents().get(page).getGender() == null ? null : students.getStudents().get(page).getGender().name()});
        fireTableRowsInserted(studentRow.size() - 1, studentRow.size() - 1);
    }

    public void changeStudent(Student student) {

        students.getStudents().set(page, student);
        studentRow.remove(0);
        studentRow.add(new String[]{students.getStudents().get(page).getPersonNumber(), students.getStudents().get(page).getFirstName(), students.getStudents().get(page).getMiddleName(),
                students.getStudents().get(page).getLastName(), students.getStudents().get(page).getFather(), students.getStudents().get(page).getMother(), students.getStudents().get(page).getBirthDate(),
                students.getStudents().get(page).getGender().name()});
        fireTableRowsInserted(studentRow.size() - 1, studentRow.size() - 1);
    }

    public void addStudent(Student student) {
        students.getStudents().add(student);
    }

    public Students getStudents() {
        return students;
    }


}
