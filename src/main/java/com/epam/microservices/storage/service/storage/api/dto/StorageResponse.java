package com.epam.microservices.storage.service.storage.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class StorageResponse {

  private final Integer id;

  private final StorageType storageType;

  private final String bucketName;

  private final String path;

  @JsonCreator
  public StorageResponse(Integer id, StorageType storageType, String bucketName, String path) {
    this.id = id;
    this.storageType = storageType;
    this.bucketName = bucketName;
    this.path = path;
  }

  public Integer getId() {
    return id;
  }

  public StorageType getStorageType() {
    return storageType;
  }

  public String getBucketName() {
    return bucketName;
  }

  public String getPath() {
    return path;
  }

  @Override
  public String toString() {
    return "StorageResponse{" +
      "id=" + id +
      ", storageType=" + storageType +
      ", bucketName='" + bucketName + '\'' +
      ", path='" + path + '\'' +
      '}';
  }
}
