package com.martinatanasov.spring;

import com.martinatanasov.spring.dao.StudentDAO;
import com.martinatanasov.spring.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
			readStudent(studentDAO);
			queryForStudents(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int rows = studentDAO.deleteAllStudents();
		System.out.println("Deleted rows: " + rows);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 1;
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on id: primary key
		int id = 1;
		Student currentStudent = studentDAO.findById(id);
		//change first name
		currentStudent.setFirstName("Zaio");
		//update student in the DB
		studentDAO.update(currentStudent);
		//print the result
		System.out.println("Current user: " + currentStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//Get list of students
		List<Student> myStudents = studentDAO.findALl();

		//Print students
		for(Student student: myStudents){
			System.out.println(student);
		}
	}

	private  void createStudent(StudentDAO studentDAO){
		//Create object of new student
		Student testStudent = new Student("Martin", "Atanasov", "matanasov@abv.bg");
		//Saving the student to the DB
		System.out.println("Saving student");
		studentDAO.save(testStudent);
		//Get the student's ID
		System.out.println("Student id is " + testStudent.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent = new Student("Rado", "Nano", "test@test.bg");

		studentDAO.save(tempStudent);
		int locator = tempStudent.getId();
		System.out.println("print id " + locator);

		Student newStudent = studentDAO.findById(locator);
		System.out.println("new student: " + newStudent);
	}

}
