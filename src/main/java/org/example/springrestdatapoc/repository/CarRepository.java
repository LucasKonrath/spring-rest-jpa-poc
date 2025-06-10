package org.example.springrestdatapoc.repository;

import org.example.springrestdatapoc.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends PagingAndSortingRepository<Car, Long>,
        CrudRepository<Car, Long> {

        List<Car> findByName(@Param("name") String name);
}
