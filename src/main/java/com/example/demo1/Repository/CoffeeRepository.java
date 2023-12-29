package com.example.demo1.Repository;

import com.example.demo1.domain.Coffee;
import org.springframework.data.repository.CrudRepository;

/* 정의된 두 가지 타입은 Coffee와 고유 ID를 담을 String 타입 */
public interface CoffeeRepository extends CrudRepository<Coffee, String> {}
