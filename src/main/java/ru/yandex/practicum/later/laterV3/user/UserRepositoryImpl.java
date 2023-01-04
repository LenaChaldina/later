package ru.yandex.practicum.later.laterV3.user;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository{

    private EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> searchByEmailDomain(String domain) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root).where(cb.like(root.get("email"), "%"+domain));
        List<User> foundUsers = entityManager.createQuery(cr).getResultList();
        return foundUsers;
    }

    @Override
    public List<User> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root);
        List<User> foundUsers = entityManager.createQuery(cr).getResultList();
        return foundUsers;
    }

    @Override
    @Transactional
    public User save(User user){
        entityManager.persist(user);
        return user;
    }
}
