package com.martinatanasov.spring.dao;

import com.martinatanasov.spring.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //Define fields of entity manager
    private EntityManager entityManager;

    //Inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implement methods
    @Override
    //Select class Transactional from the spring framework
    //Use @Transactional only if you write in the BD
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student student = entityManager.find(Student.class, id);
        //delete the student
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        return entityManager.createQuery("DELETE FROM Student")
                .executeUpdate();
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findALl() {
        //create query sort by lastName, default asc (A-Z), available option desc(Z-A), or use ("FROM Student" w/o sort)
        //"acs" could be safe deleted from the query string. This is default behavior!
        TypedQuery<Student> customQuery = entityManager.createQuery("FROM Student order by lastName asc", Student.class);
        //create query results
        return customQuery.getResultList();
    }
}
