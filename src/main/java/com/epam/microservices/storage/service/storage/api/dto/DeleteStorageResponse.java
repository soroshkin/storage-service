package com.epam.microservices.storage.service.storage.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class DeleteStorageResponse {

  private final List<Integer> deletedStorages;

  @JsonCreator
  public DeleteStorageResponse(List<Integer> deletedStorages) {
    this.deletedStorages = deletedStorages;
  }

  public List<Integer> getDeletedStorages() {
    return deletedStorages;
  }

  @Override
  public String toString() {
    return "DeleteSongResponse{" +
      "deletedSongs=" + deletedStorages +
      '}';
  }
}
