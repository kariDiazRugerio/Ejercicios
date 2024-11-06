package com.soaint.demo.ejercicio1.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/services")
@Tag(name = "ejercicio1")
public class classController {

    //Endpoint 1: Recibe un dato por path parameter
    @Operation(summary = "primer GET")
    @GetMapping("endpoint1/path/{data}")
    public ResponseEntity<Map<String, String>> getPathParam(@PathVariable String data){
        Map<String, String> response = new HashMap<>();
        //response.put("message", "Received path parameter");
        response.put("data", data);
        return ResponseEntity.ok(response);
    }

    //Endpoint 2: Recibe un parametro por query parameter
    @Operation(summary = "segundo GET")
    @GetMapping("endpoint2/query")
    public ResponseEntity<Map<String, String>> getQueryParam(@RequestParam(required = false) String param){
        if (param == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "No query parameter provided"));
    }
    Map<String, String> response = new HashMap<>();
        //response.put("message", "Received query parameter");
        response.put("param", param);
        return ResponseEntity.ok(response);
}

//Endpoint 3: Recibe un jSON por POST
@Operation(summary = "POST")
@PostMapping("endpoint3/post")
public ResponseEntity<Map<String, Object>> postJson(@RequestBody Map<String, Object> data){
    if (data == null || data.isEmpty()){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", "No JSON data received"));
    }
    Map<String, Object> response = new HashMap<>();
    //response.put("message", "Received JSON data");
    response.put("data", data);
    return ResponseEntity.ok(response);
}
}
