package com.example.service.modules.people;

import com.example.service.kernel.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class PeopleController {
    private final PeopleService peopleService;

    @GetMapping("")
    public ResponseEntity<ApiResponse> findAll() {
        return peopleService.findAll();
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> savePerson(@RequestBody Person payload) {
        return peopleService.savePerson(payload);
    }
}
