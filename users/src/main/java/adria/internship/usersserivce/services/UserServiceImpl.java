package adria.internship.usersserivce.services;

import adria.internship.usersserivce.dto.AdminDto;
import adria.internship.usersserivce.dto.BODto;
import adria.internship.usersserivce.entities.Admin;
import adria.internship.usersserivce.entities.BO;
import adria.internship.usersserivce.exceptions.AdminNotFound;
import adria.internship.usersserivce.exceptions.BONotFound;
import adria.internship.usersserivce.mappers.AdminMapper;
import adria.internship.usersserivce.mappers.AgenceMapper;
import adria.internship.usersserivce.mappers.BOMapper;
import adria.internship.usersserivce.mappers.ProfileMapper;
import adria.internship.usersserivce.repositories.AdminRepository;
import adria.internship.usersserivce.repositories.BORepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
@Slf4j

public class UserServiceImpl implements UserService {
    private AdminRepository adminRepository;
    private BORepository boRepository;
    private AdminMapper adminMapper;
    private BOMapper boMapper;
    private AgenceMapper agenceMapper;
    private ProfileMapper profileMapper;
    @Override
    public AdminDto saveAdmin(AdminDto adminDto) {
        Admin admin=adminMapper.adminDtoToAdmin(adminDto);
        //admin.setAgence(agenceMapper.agenceDtoToAgence(adminDto.getAgenceDto()));
        //admin.setProfile(profileMapper.profileDtoToProfile(adminDto.getProfileDto()));
        admin.setAgence(null);
        admin.setProfile(null);
        Admin savedAdmin=adminRepository.save(admin);
        log.info("admin = "+savedAdmin);
        return adminMapper.adminToDto(savedAdmin);
    }

    @Override
    public AdminDto getAdmin(Long id) throws AdminNotFound {
        Admin admin=adminRepository.findById(id).orElse(null);
        if(admin==null)throw new AdminNotFound("admin not found");
        return adminMapper.adminToDto(admin);
    }

    @Override
    public AdminDto updateAdmin(AdminDto adminDto) throws AdminNotFound {
        Admin existingAdmin = adminRepository.findById(adminDto.getId())
                .orElseThrow(() -> new AdminNotFound("Admin not found"));

        existingAdmin.setNom(adminDto.getNom());
        existingAdmin.setEmail(adminDto.getEmail());
        existingAdmin.setPrenom(adminDto.getPrenom());
        // idk what to update exactly ...
        adminRepository.save(existingAdmin);

        return adminMapper.adminToDto(existingAdmin);
    }

    @Override
    public void deleteAdmin(Long id) {

        adminRepository.deleteById(id);

    }

    @Override
    public List<AdminDto> allAdmins() {
        List<Admin> admins=adminRepository.findAll();
        List<AdminDto> adminDtos=admins
                .stream()
                .map(admin -> adminMapper.adminToDto(admin))
                .collect(Collectors.toList());
        adminDtos.forEach(candidatDto -> {
        });
        return adminDtos;
    }

    @Override
    public List<AdminDto> allAdminsByName(String name) {
        List<Admin> admins=adminRepository.findAllByNomContains(name);
        List<AdminDto> adminDtos=admins
                .stream()
                .map(admin -> adminMapper.adminToDto(admin))
                .collect(Collectors.toList());
        adminDtos.forEach(candidatDto -> {
        });
        return adminDtos;     }

    @Override
    public List<AdminDto> allAdminsByLastName(String Lastname) {
        List<Admin> admins=adminRepository.findAllByPrenomContains(Lastname);
        List<AdminDto> adminDtos=admins
                .stream()
                .map(admin -> adminMapper.adminToDto(admin))
                .collect(Collectors.toList());
        adminDtos.forEach(candidatDto -> {
        });
        return adminDtos;
    }

    @Override
    public List<AdminDto> allAdminsByEmail(String email) {
        List<Admin> admins=adminRepository.findAllByEmailContains(email);
        List<AdminDto> adminDtos=admins
                .stream()
                .map(admin -> adminMapper.adminToDto(admin))
                .collect(Collectors.toList());
        adminDtos.forEach(candidatDto -> {
        });
        return adminDtos;     }

    @Override
    public List<AdminDto> allAdminsByUsername(String username) {
        List<Admin> admins=adminRepository.findAllByNomUtilisateurContains(username);
        List<AdminDto> adminDtos=admins
                .stream()
                .map(admin -> adminMapper.adminToDto(admin))
                .collect(Collectors.toList());

        return adminDtos;       }

    @Override
    public List<AdminDto> allAdminsByCin(String cin) {
        List<Admin> admins=adminRepository.findAllByCINContains(cin);
        List<AdminDto> adminDtos=admins
                .stream()
                .map(admin -> adminMapper.adminToDto(admin))
                .collect(Collectors.toList());
        adminDtos.forEach(candidatDto -> {
        });
        return adminDtos;       }
//----------------------------------------------------------------------------------------
    @Override
    public BODto saveBO(BODto boDto) {
        BO bo=boMapper.boDtoTobo(boDto);
        BO savedBO=boRepository.save(bo);
        log.info("bo = "+savedBO);
        return boMapper.boToDto(savedBO);
    }

    @Override
    public BODto getBO(Long id) throws BONotFound {
        BO bo = boRepository.findById(id)
                .orElseThrow(() -> new BONotFound("BO not found"));
        return boMapper.boToDto(bo);    }

    @Override
        public BODto updateBO(BODto boDto) throws BONotFound {
            BO existingBO = boRepository.findById(boDto.getId())
                    .orElseThrow(() -> new BONotFound("Admin not found"));


            existingBO.setNom(boDto.getNom());
            existingBO.setEmail(boDto.getEmail());
            // Update other properties as needed

            boRepository.save(existingBO);

            return boMapper.boToDto(existingBO);
        }


    @Override
    public void deleteBO(Long id) {
        boRepository.deleteById(id);

    }

    @Override
    public List<BODto> allBOs() {
        List<BO> bos = boRepository.findAll();
        return bos.stream()
                .map(boMapper::boToDto)
                .collect(Collectors.toList());    }

    @Override
    public List<BODto> allBOsByName(String name) {
        List<BO> bos = boRepository.findAllByNomContains(name);
        return bos.stream()
                .map(boMapper::boToDto)
                .collect(Collectors.toList());    }

    @Override
    public List<BODto> allBOsByLastName(String Lastname) {
        List<BO> bos = boRepository.findAllByPrenomContains(Lastname);
        return bos.stream()
                .map(boMapper::boToDto)
                .collect(Collectors.toList());    }

    @Override
    public List<BODto> allBOsByEmail(String email) {
        List<BO> bos = boRepository.findAllByEmailContains(email);
        return bos.stream()
                .map(boMapper::boToDto)
                .collect(Collectors.toList());    }

    @Override
    public List<BODto> allBOsByUsername(String username) {
        List<BO> bos = boRepository.findAllByNomUtilisateurContains(username);
        return bos.stream()
                .map(boMapper::boToDto)
                .collect(Collectors.toList());    }

    @Override
    public List<BODto> allBOsByCin(String cin) {
        List<BO> bos = boRepository.findAllByCINContains(cin);
        return bos.stream()
                .map(boMapper::boToDto)
                .collect(Collectors.toList());    }
}
