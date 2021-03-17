package com.Storage.Webflux.Storage.repository;

import com.Storage.Webflux.Storage.document.Character;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MainRepository extends CrudRepository<Character, String> {
}
