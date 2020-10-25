package com.travelbot.telegram.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class DataController {

    private final DataInterface dataService;

    @Autowired
    public DataController(DataInterface dataService) {
        this.dataService = dataService;
    }

    @PostMapping(value = "/countries")
    public ResponseEntity<?> create(@RequestBody City cityToCreate) {
        dataService.create(cityToCreate);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/country/{name}")
    public ResponseEntity<String> read(@PathVariable(name = "name") String name) {
        String countryInfo = dataService.read(name);
        return countryInfo != null
                ? new ResponseEntity<>(countryInfo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/countries/{name}")
    public ResponseEntity<?> update(@PathVariable(name = "name") String name,
                                    @RequestBody City cityToUpdate) {
        final boolean updated = dataService.update(name, cityToUpdate);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/countries/{name}")
    public ResponseEntity<?> delete(@PathVariable(name = "name") String name) {
        final boolean deleted = dataService.delete(name);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}