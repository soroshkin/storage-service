package com.epam.microservices.storage.service.api.exception.dto;

import com.epam.microservices.storage.service.storage.api.dto.StorageType;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Storage {

  private final Integer id;

  private final StorageType storageType;

  private final String bucketName;

  private final String path;

  @JsonCreator
  public Storage(Integer id, StorageType storageType, String bucketName, String path) {
    this.id = id;
    this.storageType = storageType;
    this.bucketName = bucketName;
    this.path = path;
  }

  public Storage(StorageType storageType, String bucketName, String path) {
    this(null, storageType, bucketName, path);
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
    return "Storage{" +
      "id=" + id +
      ", storageType=" + storageType +
      ", bucketName='" + bucketName + '\'' +
      ", path='" + path + '\'' +
      '}';
  }
}
