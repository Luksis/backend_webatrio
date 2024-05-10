package com.project.backend.controller;

import com.project.backend.dto.EmploiDTO;
import com.project.backend.service.EmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emplois")
public class EmploiController {

    @Autowired
    private EmploiService emploiService;

    @PostMapping
    public ResponseEntity<EmploiDTO> createEmploi(@RequestBody EmploiDTO emploiDTO) {
        return ResponseEntity.ok(emploiService.createEmploi(emploiDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploiDTO> getEmploi(@PathVariable Long id) {
        return ResponseEntity.ok(emploiService.getEmploi(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploiDTO> updateEmploi(@PathVariable Long id, @RequestBody EmploiDTO emploiDTO) {
        return ResponseEntity.ok(emploiService.updateEmploi(id, emploiDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploi(@PathVariable Long id) {
        emploiService.deleteEmploi(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmploiDTO>> getAllEmplois() {
        return ResponseEntity.ok(emploiService.getAllEmplois());
    }
}