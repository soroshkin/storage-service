package com.epam.microservices.storage.service.storage;

import com.epam.microservices.storage.service.api.exception.StorageNotFoundException;
import com.epam.microservices.storage.service.api.exception.dto.Storage;
import com.epam.microservices.storage.service.storage.api.StorageOperations;
import com.epam.microservices.storage.service.storage.api.StorageStoreOperations;
import com.epam.microservices.storage.service.storage.api.dto.DeleteStorageResponse;
import com.epam.microservices.storage.service.storage.api.dto.SaveStorageRequest;
import com.epam.microservices.storage.service.storage.api.dto.StorageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class StorageService implements StorageOperations {

  private final StorageStoreOperations storageStoreOperations;

  private final Logger logger = LoggerFactory.getLogger(getClass());

  public StorageService(StorageStoreOperations storageStoreOperations) {
    this.storageStoreOperations = storageStoreOperations;
  }

  @PostConstruct
  private void init() {
    Arrays.stream(StorageType.values())
      .forEach(storageType ->
      {
        if (hasStorageOfType(storageType)) {
          storageStoreOperations.save(new Storage(storageType, storageType.name().toLowerCase(), "/files"));
        }
      });
  }

  @Override
  public Storage saveStorage(SaveStorageRequest saveStorageRequest) {
    Storage storage = convertToStorage(saveStorageRequest);
    if (hasStorageOfType(saveStorageRequest.getStorageType())) {
      return storageStoreOperations.save(storage);
    } else {
      return storageStoreOperations.getAll().stream()
        .filter(storageFromDB -> storageFromDB.getStorageType() == saveStorageRequest.getStorageType())
        .findFirst()
        .orElseThrow(() -> new StorageNotFoundException(String.format("Storage with type %s not found", saveStorageRequest.getStorageType())));
    }
  }

  @Override
  public List<Storage> getStorages() {
    return storageStoreOperations.getAll();
  }

  @Override
  public DeleteStorageResponse deleteStorages(Set<Integer> storageIds) {
    return new DeleteStorageResponse(storageStoreOperations.deleteByIds(storageIds));
  }

  private Storage convertToStorage(SaveStorageRequest saveStorageRequest) {
    return new Storage(saveStorageRequest.getStorageType(), saveStorageRequest.getBucketName(), saveStorageRequest.getPath());
  }

  private boolean hasStorageOfType(StorageType storageType) {
    return storageStoreOperations.getAll().stream()
      .noneMatch(storage -> storage.getStorageType() == storageType);
  }
}
