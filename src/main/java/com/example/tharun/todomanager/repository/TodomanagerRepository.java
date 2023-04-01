package com.example.tharun.todomanager.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tharun.todomanager.entity.Todomanager;

@Repository
public interface TodomanagerRepository extends JpaRepository<Todomanager, Long>{
	
	@Query(value="SELECT * FROM todo.todos WHERE name=?1")
	public List<Todomanager> findTodoByName(String name);
}
