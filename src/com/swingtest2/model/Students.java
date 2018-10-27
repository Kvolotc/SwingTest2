package com.swingtest2.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Student.class})
public class Students {

    @XmlElement(name = "student")
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Students{" +
                "students=" + students +
                '}';
    }
}
