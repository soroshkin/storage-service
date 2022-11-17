package com.epam.microservices.storage.service.storage.infrastructure.mysql;

import com.epam.microservices.storage.service.api.exception.dto.Storage;
import com.epam.microservices.storage.service.storage.api.StorageStoreOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
class StorageStoreService implements StorageStoreOperations {

  private final StorageRepository storageRepository;

  private final StorageConverter storageConverter;

  StorageStoreService(StorageRepository storageRepository, StorageConverter storageConverter) {
    this.storageRepository = storageRepository;
    this.storageConverter = storageConverter;
  }

  @Override
  public Storage save(Storage storage) {
    StorageEntity storageEntity = storageRepository.save(storageConverter.toStorageEntity(storage));
    return storageConverter.toStorage(storageEntity);
  }

  @Override
  public List<Storage> getAll() {
    return storageRepository.findAll().stream()
      .map(storageConverter::toStorage)
      .collect(Collectors.toList());
  }

  @Override
  public List<Integer> deleteByIds(Set<Integer> storageIds) {
    return storageRepository.deleteByIdIn(storageIds);
  }
}
