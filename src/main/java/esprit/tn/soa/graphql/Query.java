package esprit.tn.soa.graphql;

import esprit.tn.soa.entity.Student;
import esprit.tn.soa.repository.StudentRepository;

import java.util.List;

public class Query {

    private final StudentRepository studentRepository;
    public Query(StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }

    public List<Student> allStudents(){
        return studentRepository.getAllStudents();
    }
}
