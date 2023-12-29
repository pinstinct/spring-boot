package com.example.demo1.controller;

import com.example.demo1.Repository.CoffeeRepository;
import com.example.demo1.domain.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {

    private final CoffeeRepository coffeeRepository;

    // 멤버 변수 타입을 최상위 인터페이서인 제너릭 List로 만들었지만, 비어 있는 ArrayList를 할당해 사용
//    private List<Coffee> coffees = new ArrayList<>();

    /*스프링 프레임워크 4.3 이전 버전에서는 매개변수가 autowire/주입될 스프링 빈일 때는
    * 언제나 해당 메서드에 @Autowired 어노테이션을 표시
    * 4.3 이후 버전부터 단일 생성자(single constructor) 클래스는
    * autowire되는 매개변수를 나타내기 위한 어노테이션이 필요 없다.
    * */
    public RestApiDemoController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping
    Iterable<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        // findById()가 Optional 타입을 반환
        return coffeeRepository.findById(id);
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    /* PUT 요청은 기존 리소스의 업데이트에 사용 */
    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        return (coffeeRepository.existsById(id)) ?
                new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK) :
                new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffeeRepository.deleteById(id);
    }
}
