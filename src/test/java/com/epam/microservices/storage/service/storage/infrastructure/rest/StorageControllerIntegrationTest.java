package com.epam.microservices.storage.service.storage.infrastructure.rest;

import com.epam.microservices.storage.service.IntegrationTest;
import com.epam.microservices.storage.service.api.exception.dto.Storage;
import com.epam.microservices.storage.service.storage.api.StorageStoreOperations;
import com.epam.microservices.storage.service.storage.api.dto.SaveStorageRequest;
import com.epam.microservices.storage.service.storage.api.dto.StorageResponse;
import com.epam.microservices.storage.service.storage.api.dto.StorageType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StorageControllerIntegrationTest extends IntegrationTest {

  private static final String STORAGE_URL = "/storages";

  @Autowired
  private StorageStoreOperations storageStoreOperations;

  @Test
  void shouldSaveStorage() {
    // given
    StorageResponse givenStorageResponse = new StorageResponse(1, StorageType.STAGING, StorageType.STAGING.name(), "/files");
    SaveStorageRequest givenStorageRequest = new SaveStorageRequest(StorageType.STAGING, StorageType.STAGING.name(), "/files");

    // when
    ResponseEntity<StorageResponse> response = testRestTemplate.postForEntity(STORAGE_URL, givenStorageRequest, StorageResponse.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isNotNull().usingRecursiveComparison().ignoringFields("id").isEqualTo(givenStorageResponse);
  }

  @Test
  void shouldGetStorages() {
    // given
    Storage givenStorage = new Storage(StorageType.STAGING, StorageType.STAGING.name(), "/files");

    // when
    ResponseEntity<List<Storage>> response = testRestTemplate.exchange(STORAGE_URL, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<>() {
    });

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isNotNull()
      .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
      .contains(new Storage(givenStorage.getStorageType(), givenStorage.getBucketName(), givenStorage.getPath()));
  }
}

