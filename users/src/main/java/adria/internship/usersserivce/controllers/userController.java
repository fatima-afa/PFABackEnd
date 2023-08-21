package adria.internship.usersserivce.controllers;

import adria.internship.usersserivce.dto.AdminDto;
import adria.internship.usersserivce.entities.Admin;
import adria.internship.usersserivce.exceptions.AdminNotFound;
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


}
