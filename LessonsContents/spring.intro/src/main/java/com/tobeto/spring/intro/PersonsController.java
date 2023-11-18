package com.tobeto.spring.intro;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/persons")
public class PersonsController {
    // In-Memory DB
    private List<Person> personList = new ArrayList<>();

    @GetMapping
    public List<Person> getAll() {
        return personList;
    }

    @GetMapping("{id}")
    public Person getById(@PathVariable int id) {
        // Araştırma konusu
        // lambda expression
        // stream API
        Person person = personList
                .stream()
                .filter(p -> p.id == id)
                .findFirst()
                .orElseThrow();
        return person;


    }

    @PostMapping
    public String add(@RequestBody Person person) {
        personList.add(person);
        return "Eklendi";

    }

    @PutMapping
    public String update(@RequestBody Person person) {
        // Veritabanındaki veriyi bul
        // Veritabanında ilgili veri bulunmak zorunda
        // Güncellenmek istenen alanı güncelle

        Person personToUpdate = personList
                .stream()
                .filter(p -> p.id == person.id)
                .findFirst()
                .orElseThrow();

        // aradığın değer varsa bu satırlar çalışacak
        personToUpdate.name = person.name;
        personToUpdate.surname = person.surname;
        return "Güncellendi";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id) {
        Person personToDelete = personList.stream().filter(p -> p.id == id)
                .findFirst()
                .orElseThrow();
        personList.remove(personToDelete);
        return "Silindi";

    }
}
