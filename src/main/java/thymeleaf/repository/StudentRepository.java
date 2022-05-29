package thymeleaf.repository;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import thymeleaf.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository

public class StudentRepository {

    private final EntityManager entityManager;


    public StudentRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void saveStudent(Student student){
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    public Student findById(Long id) {

        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, id);

        entityManager.getTransaction().commit();

        return student;
    }

    public List<Student> findAll() {
        entityManager.getTransaction().begin();

        List<Student> students = entityManager.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();

        entityManager.getTransaction().commit();

        return students;
    }

    public void deleteStudentById(Long studentId) {
        entityManager.getTransaction().begin();

        entityManager.createQuery("delete from Student s where s.id = ?1")
                .setParameter(1, studentId)
                .executeUpdate();

        entityManager.getTransaction().commit();
    }
}
