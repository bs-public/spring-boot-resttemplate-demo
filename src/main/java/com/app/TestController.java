package com.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
  private final TestService service;

  public TestController(TestService service) {
    this.service = service;
  }

  @GetMapping("/get")
  public ResponseEntity<String> testGet() {
    return ResponseEntity.ok(service.callGet());
  }

  @PostMapping("/post")
  public ResponseEntity<String> testPost() {
    return ResponseEntity.ok(service.callPost());
  }

  @PutMapping("/put")
  public ResponseEntity<String> testPut() {
    return ResponseEntity.ok(service.callPut());
  }

  @DeleteMapping("/delete")
  public ResponseEntity<String> testDelete() {
    return ResponseEntity.ok(service.callDelete());
  }

  @GetMapping("/simulate/server-error")
  public ResponseEntity<String> simulateServerError() {
    return ResponseEntity.ok(service.simulateServerError());
  }

  @GetMapping("/simulate/client-error")
  public ResponseEntity<String> simulateClientError() {
    return ResponseEntity.ok(service.simulateClientError());
  }

  @GetMapping("/simulate/timeout")
  public ResponseEntity<String> simulateTimeout() {
    return ResponseEntity.ok(service.simulateTimeout());
  }

  @GetMapping("/simulate/socket-exception")
  public ResponseEntity<String> simulateSocketError() {
    return ResponseEntity.ok(service.simulateConnectionRefused());
  }
}
