package com.tyy.stu.adapter.jpa;

import com.tyy.stu.adapter.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
