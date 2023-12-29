package com.example.demo1.component;

import com.example.demo1.Repository.CoffeeRepository;
import com.example.demo1.domain.Coffee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

/*CommandLineRunner와 ApplicationRunner가 repository 빈을 autowire하면, repository 빈을 Mock 객체로 대체하기 어려우므로 일부 단위 테스트가 제대로 동작하지 않음
* 테스트 내에서 repository 빈을 Mock 객체로 대체해 사용하거나 샘플 데이터를 생성하지 않고 애플리케이션을 실행하면, @Component 어노테이션을 주석 처리해서 데이터를 추가하는 빈을 손쉽게 비활성화
* */
@Component
public class DataLoader {
    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData() {
        this.coffeeRepository.saveAll(List.of(
                new Coffee("cafe cereza"),
                new Coffee("cafe ganador"),
                new Coffee("cafe lareno"),
                new Coffee("cafe tres pontas")
        ));
    }
}
