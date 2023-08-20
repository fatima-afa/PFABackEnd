package adria.internship.usersserivce.services;

import adria.internship.usersserivce.dto.RoleDto;
import adria.internship.usersserivce.entities.Role;
import adria.internship.usersserivce.mappers.RoleMapper;
import adria.internship.usersserivce.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {
    private RoleMapper roleMapper;
    private RoleRepository roleRepository;
    @Override
    public RoleDto saveRole(RoleDto roleDto) {
        Role role=roleRepository.save(roleMapper.dtoToRole(roleDto));
        return roleMapper.roleToDto(role);
    }
}
