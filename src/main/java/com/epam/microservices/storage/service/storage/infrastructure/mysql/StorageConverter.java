package com.epam.microservices.storage.service.storage.infrastructure.mysql;

import com.epam.microservices.storage.service.api.exception.dto.Storage;
import org.springframework.stereotype.Component;

@Component
class StorageConverter {

  public Storage toStorage(StorageEntity storageEntity) {
    return new Storage(
      storageEntity.getId(),
      storageEntity.getStorageType(),
      storageEntity.getBucketName(),
      storageEntity.getPath());
  }

  public StorageEntity toStorageEntity(Storage storage) {
    return new StorageEntity(storage.getStorageType(), storage.getBucketName(), storage.getPath());
  }
}
