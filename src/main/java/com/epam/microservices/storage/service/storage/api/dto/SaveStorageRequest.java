package com.epam.microservices.storage.service.storage.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SaveStorageRequest {

  private final StorageType storageType;

  private final String bucketName;

  private final String path;

  @JsonCreator
  public SaveStorageRequest(StorageType storageType, String bucketName, String path) {
    this.storageType = storageType;
    this.bucketName = bucketName;
    this.path = path;
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
    return "SaveStorageRequest{" +
      "storageType=" + storageType +
      ", bucketName='" + bucketName + '\'' +
      ", path='" + path + '\'' +
      '}';
  }
}
