package com.example.demo.jpa;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sunchuanyin
 * @version 1.0
 * @description
 * @date 2021/4/30 1:48 下午
 */
@Repository
public interface JpaTeacherRepository extends JpaRepository<JpaTeacherEntity, Integer>, JpaSpecificationExecutor<JpaTeacherEntity> {

    /**
     * 根据命名规则查询
     *
     * @param id
     * @return
     */
    JpaTeacherEntity findById(int id);


    /**
     * 根据sql查询
     *
     * 操作实体类
     *  第一种写法  需要有构造器
     *        @Query("select new JpaTeacherEntity (id,name,sex) from JpaTeacherEntity where id = ?1")
     *  第二种写法 起别名的形式
     *        @Query("select a from JpaTeacherEntity a where a.id = ?1")
     *
     * 直接操作表
     *  第三中写法：
     *        @Query(value = "select * from teacher where id = ?1",nativeQuery = true)
     * @param id
     * @return
     */
    @Query(value = "select * from teacher where id = ?1",nativeQuery = true)
    JpaTeacherEntity findTeacherById(int id);


     // @Query(nativeQuery = true,value = "select * from teacher t where t.id not in ?1 and name != ?2 limit 1")
     @Query(value = "select a from JpaTeacherEntity a where a.id not in (?1) and a.name <> ?2")
   List<JpaTeacherEntity> getOneTeachey(List<Integer> ids, String name, Pageable pageable);

}
