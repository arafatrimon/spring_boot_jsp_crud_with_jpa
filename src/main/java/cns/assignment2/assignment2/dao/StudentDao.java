package cns.assignment2.assignment2.dao;

import cns.assignment2.assignment2.entity.Student;
import cns.assignment2.assignment2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDao {
    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) throws Exception {
        Optional<Student> getId = studentRepository.findById(id);
        if (getId.isPresent()) {
            return getId.get();
        } else {
            throw new Exception("Student with id :" + id + " NOT FOUND");
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
