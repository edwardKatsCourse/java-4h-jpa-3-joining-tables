package com.telran;

import com.telran.entity.Dog;
import com.telran.entity.DogOwner;
import com.telran.repository.DogOwnerRepository;
import com.telran.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OurMain implements CommandLineRunner {

    //web
    //controller -> service -> repository

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private DogOwnerRepository dogOwnerRepository;

    @Override
    public void run(String... args) throws Exception {

        //1. Create Dog owner
        DogOwner owner = DogOwner.builder()
                .name("Ralph")
                .build();
        dogOwnerRepository.save(owner);

        //2. Create Dog
        Dog dog1 = Dog.builder()
                .nickname("Sharik")
                .dogOwner(owner)
                .build();
        dogRepository.save(dog1);

        Dog dog2 = Dog.builder()
                .nickname("Chappy")
                .dogOwner(owner)
                .build();
        dogRepository.save(dog2);

        //3. Update Dog Owner
//        owner.setDogs(Arrays.asList(dog1, dog2));

//        dogOwnerRepository.save(owner);

        List<Dog> ralphsDogs = dogRepository.findAllByDogOwner(owner);
        System.out.println(ralphsDogs);
    }
}
