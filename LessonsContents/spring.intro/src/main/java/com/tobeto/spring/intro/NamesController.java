package com.tobeto.spring.intro;


import org.springframework.web.bind.annotation.*;

// Kullanım Şekilleri
// EntitiesController
// ProductsController
// CategoriesController
@RestController //Controller bölümünde RestController'ı ve RequestMapping'i çağırmak zorundayız!
// tobeto.com/api/names
// tobeto.com/api/names/getById
// tobeto.com/api/names/getByFirstLetter
@RequestMapping("api/names")
public class NamesController {

    // Mapping'lerin aynı metot'a sahip olanları, endpoint olarak spesifik bir alan ile
    // birbirinden ayrılmak zorundadır.

    // RequestParam => Parametreden bilgi okuma
    // Query String de denir
    @GetMapping
    public String get(@RequestParam String name, @RequestParam(required = false) String surname) {
        return "Merhaba " + name + " " + surname;
    }

    // PathVariable, QueryParam

    // /get2/bedir

    // Tek parametrelerde path, çoklu parametrelerde RequestParam kullanılabilir
    @GetMapping("{name}")
    public String get2(@PathVariable String name)
    {
        return "Merhaba " + name;
    }

    // JSON
    @PostMapping
    public String post(@RequestBody Person person)
    {
        return "Merhaba Tobeto, POST";
    }

}
