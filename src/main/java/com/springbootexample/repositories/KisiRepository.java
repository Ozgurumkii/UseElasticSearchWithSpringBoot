package com.springbootexample.repositories;

import com.springbootexample.entity.Kisi;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KisiRepository extends ElasticsearchRepository<Kisi, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": {\"query\": \"?0\"}}}]}}")
    List<Kisi> getByCustomQuery(String ad);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"soyad\": {\"query\": \"?0\"}}}]}}")
    List<Kisi> getWithQuery(String soyad);

    List<Kisi> findByAdLikeOrSoyadLike(String ad, String soyad);

}
