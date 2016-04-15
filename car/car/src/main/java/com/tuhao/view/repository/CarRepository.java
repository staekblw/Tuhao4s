package com.tuhao.view.repository;

import java.util.List;

import com.tuhao.view.model.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
    List<Car> findByName(String name);
}
