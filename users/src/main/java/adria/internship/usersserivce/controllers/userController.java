package adria.internship.usersserivce.controllers;

import adria.internship.usersserivce.dto.AdminDto;
import adria.internship.usersserivce.dto.BODto;
import adria.internship.usersserivce.entities.Admin;
import adria.internship.usersserivce.exceptions.AdminNotFound;
import adria.internship.usersserivce.exceptions.BONotFound;
import adria.internship.usersserivce.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Builder
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class userController {
    private UserServiceImpl userService;
    @GetMapping("/admins")
    public ResponseEntity<List<AdminDto>> getAllAdmin() {
        List<AdminDto> adminDtos = userService.allAdmins();
        return new ResponseEntity<>(adminDtos, HttpStatus.OK);
    }
    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable Long id) {
        try {
            AdminDto adminDto = userService.getAdmin(id);
            return new ResponseEntity<>(adminDto, HttpStatus.OK);
        } catch (AdminNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/admin")
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto) {
        AdminDto createdAdmin = userService.saveAdmin(adminDto);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable Long id, @RequestBody AdminDto adminDto) {
        try {
            adminDto.setId(id);
            AdminDto updatedAdmin = userService.updateAdmin(adminDto);
            return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
        } catch (AdminNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        userService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/admins/byCin")
    public ResponseEntity<List<AdminDto>> getAllAdminsByCin(@RequestParam String cin) {
        List<AdminDto> adminDtos = userService.allAdminsByCin(cin);
        return new ResponseEntity<>(adminDtos, HttpStatus.OK);
    }

    @GetMapping("/admins/byName")
    public ResponseEntity<List<AdminDto>> getAllAdminsByName(@RequestParam String name) {
        List<AdminDto> adminDtos = userService.allAdminsByName(name);
        return new ResponseEntity<>(adminDtos, HttpStatus.OK);
    }

    @GetMapping("/admins/byLastName")
    public ResponseEntity<List<AdminDto>> getAllAdminsByLastName(@RequestParam String lastName) {
        List<AdminDto> adminDtos = userService.allAdminsByLastName(lastName);
        return new ResponseEntity<>(adminDtos, HttpStatus.OK);
    }

    @GetMapping("/admins/byEmail")
    public ResponseEntity<List<AdminDto>> getAllAdminsByEmail(@RequestParam String email) {
        List<AdminDto> adminDtos = userService.allAdminsByEmail(email);
        return new ResponseEntity<>(adminDtos, HttpStatus.OK);
    }

    @GetMapping("/admins/byUsername")
    public ResponseEntity<List<AdminDto>> getAllAdminsByUsername(@RequestParam String username) {
        List<AdminDto> adminDtos = userService.allAdminsByUsername(username);
        return new ResponseEntity<>(adminDtos, HttpStatus.OK);
    }

    //----------------------------------------------------
    @PostMapping("/bos")
    public ResponseEntity<BODto> createBO(@RequestBody BODto boDto) {
        BODto createdBO = userService.saveBO(boDto);
        return new ResponseEntity<>(createdBO, HttpStatus.CREATED);
    }

    @GetMapping("/bos/{id}")
    public ResponseEntity<BODto> getBOById(@PathVariable Long id) {
        try {
            BODto boDto = userService.getBO(id);
            return new ResponseEntity<>(boDto, HttpStatus.OK);
        } catch (BONotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/bos/{id}")
    public ResponseEntity<BODto> updateBO(@PathVariable Long id, @RequestBody BODto boDto) {
        try {
            boDto.setId(id);
            BODto updatedBO = userService.updateBO(boDto);
            return new ResponseEntity<>(updatedBO, HttpStatus.OK);
        } catch (BONotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/bos/{id}")
    public ResponseEntity<Void> deleteBO(@PathVariable Long id) {
        userService.deleteBO(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/bos")
    public ResponseEntity<List<BODto>> getAllBOs() {
        List<BODto> boDtos = userService.allBOs();
        return new ResponseEntity<>(boDtos, HttpStatus.OK);
    }

    @GetMapping("/bos/byName")
    public ResponseEntity<List<BODto>> getAllBOsByName(@RequestParam String name) {
        List<BODto> boDtos = userService.allBOsByName(name);
        return new ResponseEntity<>(boDtos, HttpStatus.OK);
    }

    @GetMapping("/bos/byLastName")
    public ResponseEntity<List<BODto>> getAllBOsByLastName(@RequestParam String lastName) {
        List<BODto> boDtos = userService.allBOsByLastName(lastName);
        return new ResponseEntity<>(boDtos, HttpStatus.OK);
    }

    @GetMapping("/bos/byEmail")
    public ResponseEntity<List<BODto>> getAllBOsByEmail(@RequestParam String email) {
        List<BODto> boDtos = userService.allBOsByEmail(email);
        return new ResponseEntity<>(boDtos, HttpStatus.OK);
    }

    @GetMapping("/bos/byUsername")
    public ResponseEntity<List<BODto>> getAllBOsByUsername(@RequestParam String username) {
        List<BODto> boDtos = userService.allBOsByUsername(username);
        return new ResponseEntity<>(boDtos, HttpStatus.OK);
    }

    @GetMapping("/bos/byCin")
    public ResponseEntity<List<BODto>> getAllBOsByCin(@RequestParam String cin) {
        List<BODto> boDtos = userService.allBOsByCin(cin);
        return new ResponseEntity<>(boDtos, HttpStatus.OK);
    }


}
