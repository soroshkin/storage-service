package com.epam.microservices.storage.service.storage.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SongMetadata {

  private final Integer id;

  private final String url;

  private final SongStatus status;

  @JsonCreator
  public SongMetadata(Integer id, String url, SongStatus status) {
    this.id = id;
    this.url = url;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public SongStatus getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "SongMetadata{" +
      "id=" + id +
      ", url='" + url + '\'' +
      ", status=" + status +
      '}';
  }
}
