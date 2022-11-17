package com.epam.microservices.storage.service.storage.infrastructure.mysql;

import com.epam.microservices.storage.service.storage.api.dto.StorageType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storageEntity")
class StorageEntity {

  @Id
  @GeneratedValue
  private Integer id;

  private StorageType storageType;

  private String bucketName;

  private String path;

  private StorageEntity() {
  }

  StorageEntity(StorageType storageType, String bucketName, String path) {
    this.storageType = storageType;
    this.bucketName = bucketName;
    this.path = path;
  }

  Integer getId() {
    return id;
  }

  StorageType getStorageType() {
    return storageType;
  }

  String getBucketName() {
    return bucketName;
  }

  String getPath() {
    return path;
  }

  @Override
  public String toString() {
    return "SongMetadataEntity{" +
      "id=" + id +
      ", storageType=" + storageType +
      ", bucketName='" + bucketName + '\'' +
      ", path='" + path + '\'' +
      '}';
  }
}
