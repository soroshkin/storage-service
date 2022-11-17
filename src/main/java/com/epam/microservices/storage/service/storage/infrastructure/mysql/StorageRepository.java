package com.epam.microservices.storage.service.storage.infrastructure.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StorageRepository extends JpaRepository<StorageEntity, Integer> {

  List<Integer> deleteByIdIn(Set<Integer> id);
}
