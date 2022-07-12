package ru.kata.PP_3_1_3_Spring_Security_Bootstrap.dao;

import org.springframework.stereotype.Repository;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("SELECT role FROM Role role", Role.class)
                .getResultList();
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role findRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role findRoleByName(String name) {
        return entityManager.createQuery("SELECT role FROM Role role WHERE role.name=:name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
