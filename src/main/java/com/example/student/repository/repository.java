package com.example.student.repository;

import com.example.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<Student,Long> {


    public List<Student> findByFirstName(String firstName);
    public List<Student> findByLastName(String lastName);




    //--------------------CRUD JPQL--------------------------------------------------
    @Query("select e from Employee e where e.id = ?1")
    public Student findByCustomId(Long id);

    @Transactional
    @Modifying
    @Query("update Student e set e.firstName = ?2 where e.id = ?1 ")
    public void updateById(Long id, String firstName);

    @Modifying
    @Transactional
    @Query("DELETE FROM Student e WHERE e.id = ?1")
    public void deleleStudentJPQL(Long id);


    //-----------------------CRUD Native---------------------------------------------------------
    @Query(value = "select * from tbl_Student", nativeQuery = true)
    public List<Employee> findAllStudentNative();

    @Query(value = "select * from tbl_Student where id = ?1"
            ,nativeQuery = true)
    public Employee findByStudentNative(Long id);

    @Transactional
    @Modifying
    @Query(value = "update tbl_Student e set e.last_name = ?2 where e.id = ?1", nativeQuery = true)
    public void  updateStudentative(Long id, String lastName);



    @Modifying
    @Query(value = "insert into tbl_Student (id,first_name, last_name, email) VALUES (?1,?2,?3,?4)", nativeQuery = true)
    @Transactional
    public void AddStudent(Long id,String firstName, String lastName, String email);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tbl_v WHERE id = ?1", nativeQuery = true)
    public void deleleStudent(Long id);

}
