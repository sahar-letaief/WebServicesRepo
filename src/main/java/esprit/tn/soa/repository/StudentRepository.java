package esprit.tn.soa.repository;

import esprit.tn.soa.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final List<Student> students;

    public StudentRepository(){
        students=new ArrayList<>();
        students.add(new Student("0123456","Sahar Letaief","sahar.letaief@esprit.tn"));
        students.add(new Student("0789654","Salma Letaief","salma.letaief@esprit.tn"));
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public void saveStudent(Student student){
        students.add(student);
    }

}
