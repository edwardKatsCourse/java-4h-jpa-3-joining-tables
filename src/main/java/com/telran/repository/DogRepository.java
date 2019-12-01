package com.telran.repository;

import com.telran.entity.Dog;
import com.telran.entity.DogOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findAllByDogOwner(DogOwner dogOwner);
    //DogOwner


    //DogOwner ... where Dog.id, nickname, dob, ....
}
