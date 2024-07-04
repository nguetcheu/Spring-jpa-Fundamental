package com.aliboucoding.JPA.repositories;

import com.aliboucoding.JPA.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, Integer id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthor(int age);

    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);

    // Select * From author Where first_name = 'ali'
    List<Author> findAllByFirstName(String firstName);

    // Select * From author Where first_name = 'ali' or 'ALI'
    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    // Select * From author Where first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String keyWords);

    // Select * From author Where first_name like 'al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String startWords);

    // Select * From author Where first_name like '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String startWords);

    // Select * From author Where first_name in ('ali', 'bou', 'coding')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> startWords);
}
