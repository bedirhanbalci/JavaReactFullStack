package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Category;
import com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Generic
// Generic Type'lar reference type olarak belirtilmelidir.
public interface CategoryRepository extends JpaRepository<Category, Integer> {


    // Derived Query Metotlar sadece veritabanı entity türüyle çalışır.

    // Tablo ismi değil, entity ismi kullanılacak
    // Entity'e her zaman alias verilecek "Categories c"
    // Dinamik alanlarda fonksiyon parametresi okumak için :parametreAdi kalıbı kullanılacak.
    // JPQL içerisinde obje new'lenebilir.
    // NEW'lenen objeler tam yoluyla belirtilmelidir.

    // SQL DEĞİL JPQL

    // Select c.name FROM Category c WHERE c.name = Sedan
    // Select c.name FROM Category c WHERE c.name = SUV

    // Derived Query Methods => Fonksiyon isimlendirme kuralları
    List<Category> findByNameStartingWith(String name);


    // Custom Query

    @Query("Select new com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse (c.id, c.name) " +
            "FROM Category c WHERE c.name = :name")
    List<GetListCategoryResponse> findByName(String name);

}
