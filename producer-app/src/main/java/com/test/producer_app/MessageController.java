package com.test.producer_app;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final StreamBridge streamBridge;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestParam String message) {
        streamBridge.send("send-out-0", message);
        return ResponseEntity.ok("Sent: " + message);
    }
}
