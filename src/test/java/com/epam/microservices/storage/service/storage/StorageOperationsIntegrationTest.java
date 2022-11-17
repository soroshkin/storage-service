package com.epam.microservices.storage.service.storage;

import com.epam.microservices.storage.service.IntegrationTest;
import com.epam.microservices.storage.service.api.exception.dto.Storage;
import com.epam.microservices.storage.service.storage.api.StorageOperations;
import com.epam.microservices.storage.service.storage.api.dto.SaveStorageRequest;
import com.epam.microservices.storage.service.storage.api.dto.StorageType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StorageOperationsIntegrationTest extends IntegrationTest {

  @Autowired
  private StorageOperations storageOperations;

  @Test
  void shouldSaveStorageWithExistentType() {
    // when
    storageOperations.saveStorage(new SaveStorageRequest(StorageType.STAGING, StorageType.STAGING.name(), "/files"));

    // then
    List<Storage> storages = storageOperations.getStorages();
    assertThat(storages).hasSize(2)
      .extracting("id")
      .containsExactly(1, 2);
  }
}

