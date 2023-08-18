package adria.internship.usersserivce.services;

import adria.internship.usersserivce.dto.AdminDto;
import adria.internship.usersserivce.dto.BODto;
import adria.internship.usersserivce.exceptions.AdminNotFound;
import adria.internship.usersserivce.exceptions.BONotFound;

import java.util.List;

public interface UserService {
    AdminDto saveAdmin(AdminDto adminDto);
    AdminDto getAdmin(Long id) throws AdminNotFound;
    AdminDto updateAdmin(AdminDto adminDto) throws AdminNotFound;
    void deleteAdmin(Long id);
    List<AdminDto> allAdmins();
    List<AdminDto> allAdminsByName(String name);
    List<AdminDto> allAdminsByLastName(String Lastname);
    List<AdminDto> allAdminsByEmail(String email);
    List<AdminDto> allAdminsByUsername(String username);
    List<AdminDto> allAdminsByCin(String cin);

    BODto saveBO(BODto boDto);
    BODto getBO(Long id) throws BONotFound;
    BODto updateBO(BODto boDto)throws BONotFound;
    void deleteBO(Long id);
    List<BODto> allBOs();
    List<BODto> allBOsByName(String name);
    List<BODto> allBOsByLastName(String Lastname);
    List<BODto> allBOsByEmail(String email);
    List<BODto> allBOsByUsername(String username);
    List<BODto> allBOsByCin(String cin);




}
