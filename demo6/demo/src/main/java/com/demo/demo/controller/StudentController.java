package com.demo.demo.controller;


import com.demo.demo.dto.StudentDTO;
import com.demo.demo.entity.Student;
import com.demo.demo.repository.StudentRepository;
import com.demo.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService =  studentService;
    }

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student-list";
    }

    @GetMapping("/add-new")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student-add";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        StudentDTO student = studentService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student id: " + id));
        model.addAttribute("student", student);
        return "student-edit";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") StudentDTO student) {
        studentService.save(student);
        return "redirect:/students";
    }


    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable(value = "id") Long id, @ModelAttribute("student") StudentDTO student) {
        studentService.updateStudentById(id, student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        studentService.deleteById(id);
        return "redirect:/students";
    }
}

