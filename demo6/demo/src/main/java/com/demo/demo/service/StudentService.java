package com.demo.demo.service;


import com.demo.demo.dto.StudentDTO;
import com.demo.demo.entity.Student;
import com.demo.demo.repository.StudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<StudentDTO> findById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        assert student != null;
        studentDTO.setName(student.getName());
        studentDTO.setAge(student.getAge());
        studentDTO.setEmail(student.getEmail());
        return Optional.of(studentDTO);
    }

    public Boolean save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setEmail(studentDTO.getEmail());
        try {
            studentRepository.save(student);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Student updateStudentById(Long id,StudentDTO upadteStudent) {
        return studentRepository.findById(id)
                .map(student ->  {
                    student.setName(upadteStudent.getName());
                    student.setAge(upadteStudent.getAge());
                    student.setEmail(upadteStudent.getEmail());
                    return studentRepository.save(student);
                }).orElseThrow(()-> new IllegalArgumentException("Invalid student id: " + id));
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
