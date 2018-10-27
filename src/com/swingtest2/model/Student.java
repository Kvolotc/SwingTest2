package com.swingtest2.model;

import com.swingtest2.enums.Gender;


public class Student {

    private String personNumber;

    private String firstName;

    private String middleName;

    private String lastName;

    private String father;

    private String mother;

    private Gender gender;

    private String birthDate;

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "personNumber=" + personNumber +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", father='" + father + '\'' +
                ", mother='" + mother + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                '}';
    }

    public static Student buildStudent(String personNumber,
                                String firstName,
                                String middleName,
                                String lastName,
                                String father,
                                String mother,
                                String gender,
                                String birthDate) {
        Student student = new Student();
        Gender gender1;
        if(gender == Gender.FEMALE.name()) {
            gender1 = Gender.FEMALE;
        } else if(gender == Gender.MALE.name()) {
            gender1 = Gender.FEMALE;
        } else {
            gender1 = null;
        }
        student.setPersonNumber(personNumber);
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setLastName(lastName);
        student.setFather(father);
        student.setMother(mother);
        student.setGender(gender1);
        student.setBirthDate(birthDate);

        return student;
    }
}
