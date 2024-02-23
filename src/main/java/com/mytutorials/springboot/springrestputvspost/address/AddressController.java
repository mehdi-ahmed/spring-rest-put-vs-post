package com.mytutorials.springboot.springrestputvspost.address;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressRepository repository;

    public AddressController(AddressRepository addressRepository) {
        this.repository = addressRepository;
    }

    @GetMapping
    List<Address> getAllAddress() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Address getAddress(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, String.format("Address with id %d not found", id)));
    }

    @PostMapping
    Address createNewAddress(@RequestBody Address newAddress) {
        return repository.save(newAddress);
    }

    @PutMapping("/{id}")
    Address replaceAddress(@RequestBody Address address, @PathVariable Long id) {

        return repository.findById(id)
                .map(adr -> {
                    adr.setCity(address.getCity());
                    adr.setName(address.getName());
                    adr.setPostalCode(address.getPostalCode());
                    return repository.save(address);
                })
                .orElseGet(() -> repository.save(address));
    }
}
