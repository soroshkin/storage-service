package com.epam.microservices.storage.service.storage.api;

import com.epam.microservices.storage.service.api.exception.dto.Storage;
import com.epam.microservices.storage.service.storage.api.dto.DeleteStorageResponse;
import com.epam.microservices.storage.service.storage.api.dto.SaveStorageRequest;

import java.util.List;
import java.util.Set;

public interface StorageOperations {

  Storage saveStorage(SaveStorageRequest saveStorageRequest);

  List<Storage> getStorages();

  DeleteStorageResponse deleteStorages(Set<Integer> storageIds);
}
