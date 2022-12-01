package com.epam.microservices.storage.service.storage.infrastructure.rest;

import com.epam.microservices.storage.service.api.exception.dto.Storage;
import com.epam.microservices.storage.service.storage.api.StorageOperations;
import com.epam.microservices.storage.service.storage.api.dto.DeleteStorageResponse;
import com.epam.microservices.storage.service.storage.api.dto.SaveStorageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping(path = "/storages")
@Validated
class StorageController {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  private final StorageOperations storageOperations;

  StorageController(StorageOperations storageOperations) {
    this.storageOperations = storageOperations;
  }

  @PostMapping
  public Storage saveStorage(@RequestBody SaveStorageRequest saveStorageRequest) {
    logger.info("Trying to save new storage {}", saveStorageRequest);
    return storageOperations.saveStorage(saveStorageRequest);
  }

  @GetMapping
  public List<Storage> getStorages() {
    logger.info("Retrieving all");
    return storageOperations.getStorages();
  }

  @DeleteMapping
  public DeleteStorageResponse deleteStorages(@RequestParam("id") @Size(max = 200) List<Integer> storageIds) {
    logger.info("Deleting storages with ids: {}", storageIds);
    return storageOperations.deleteStorages(new HashSet<>(storageIds));
  }
}
