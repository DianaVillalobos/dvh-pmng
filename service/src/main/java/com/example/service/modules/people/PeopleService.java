package com.example.service.modules.people;


import com.example.service.kernel.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse> findAll() {
        ApiResponse response = new ApiResponse(
                "Operación exitosa",
                peopleRepository.findAll(),
                false,
                HttpStatus.OK
        );

        return new ResponseEntity<>(response, response.getStatus());
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public ResponseEntity<ApiResponse> savePerson(Person payload) {
        ApiResponse response = null;

        try {
            peopleRepository.save(payload);
            response = new ApiResponse("Operación exitosa", null, false, HttpStatus.CREATED);
        } catch (Exception ex) {
            response = new ApiResponse("Error al guardar", null, true, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(response, response.getStatus());
    }
}
