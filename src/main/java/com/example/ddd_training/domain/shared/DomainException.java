package com.example.ddd_training.domain.shared;

public class DomainException extends RuntimeException {
  public DomainException(String message) {
    super(message);
  }
}
