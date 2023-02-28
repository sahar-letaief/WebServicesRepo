package esprit.tn.soa.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import esprit.tn.soa.entity.Student;
import esprit.tn.soa.repository.StudentRepository;

import java.util.List;

public class Query implements GraphQLResolver {

    private final StudentRepository studentRepository;
    public Query(StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }

    public List<Student> allStudents(){
        return studentRepository.getAllStudents();
    }
}
