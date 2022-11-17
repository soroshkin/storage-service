package com.epam.microservices.storage.service.storage.api;

import com.epam.microservices.storage.service.api.exception.dto.Storage;

import java.util.List;
import java.util.Set;

public interface StorageStoreOperations {

  Storage save(Storage storage);

  List<Storage> getAll();

  List<Integer> deleteByIds(Set<Integer> songIds);
}
