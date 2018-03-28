package com.jiajia.main.repository;

import com.jiajia.main.model.Qq;
import com.jiajia.main.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by DENGJIAN on 2017/11/16.
 */
public interface QRepository extends JpaRepository<Qq,Long>,JpaSpecificationExecutor<Qq> {
   /* @Query(value = "SELECT * FROM qq  WHERE a = ?1")
    Qq findByA(Integer a);
*/

    @Query(value = "SELECT * FROM qq ",nativeQuery=true)
    List<Qq> findAllQ();

    /*
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM qq  WHERE a = ?1 AND b = ?2")
    int deleteAAndB(Integer a,Integer b);
*/

    /*
    @Modifying
    @Transactional
    @Query(value = "UPDATE qq SET b = ?2 WHERE a = ?1")
    void updateState(int a, int b);
    */
}
