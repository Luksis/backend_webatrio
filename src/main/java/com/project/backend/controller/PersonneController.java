package com.project.backend.controller;

import com.project.backend.dto.PersonneDTO;
import com.project.backend.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personnes")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @PostMapping
    public ResponseEntity<PersonneDTO> createPersonne(@RequestBody PersonneDTO personneDTO) {
        return ResponseEntity.ok(personneService.createPersonne(personneDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonneDTO> getPersonne(@PathVariable Long id) {
        return ResponseEntity.ok(personneService.getPersonne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonneDTO> updatePersonne(@PathVariable Long id, @RequestBody PersonneDTO personneDTO) {
        return ResponseEntity.ok(personneService.updatePersonne(id, personneDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonne(@PathVariable Long id) {
        personneService.deletePersonne(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonneDTO>> getAllPersonnes() {
        return ResponseEntity.ok(personneService.getAllPersonnes());
    }
}