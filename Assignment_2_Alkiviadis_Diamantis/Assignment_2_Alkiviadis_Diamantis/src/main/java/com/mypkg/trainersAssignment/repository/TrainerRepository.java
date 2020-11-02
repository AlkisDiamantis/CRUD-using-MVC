
package com.mypkg.trainersAssignment.repository;

import com.mypkg.trainersAssignment.model.Trainer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

    List<Trainer> findByNameAndSubject(String name, String subject);

    List<Trainer> findBySubjectContaining(String subject);

    List<Trainer> findByNameContaining(String name);
    
    
    @Query("    \n"
            + "    SELECT t FROM Trainer t \n"
            + "    WHERE t.name LIKE :name%\n"
            + "    OR\n"
            + "    t.surname LIKE :name%")
    List<Trainer> getthetrainers(@Param("name") String name);

}
