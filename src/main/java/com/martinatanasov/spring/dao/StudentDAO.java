package com.martinatanasov.spring.dao;

import com.martinatanasov.spring.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    void update(Student student);
    void delete(Integer id);
    int deleteAllStudents();

    Student findById(Integer id);

    List<Student> findALl();
}
