package ru.bocharova.tm.service;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.DTO.UserDTO;
import ru.bocharova.tm.api.service.IUserService;
import ru.bocharova.tm.exception.AuthenticationSecurityException;
import ru.bocharova.tm.api.repository.IUserRepository;
import ru.bocharova.tm.entity.User;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.repository.UserRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
public final class UserService implements IUserService {

    @NotNull
    final EntityManagerFactory entityManagerFactory;

    @Override
    public void create(@NotNull final UserDTO userDTO) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IUserRepository userRepository = new UserRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @NotNull final User user = convertDTOtoUser(userDTO, entityManager);
            userRepository
                    .persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private User convertDTOtoUser(@NotNull final UserDTO userDTO, @NotNull final EntityManager entityManager)
            throws DataValidateException {
        @NotNull final User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setDescription(userDTO.getDescription());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }

    @Override
    public void edit(@NotNull final UserDTO userDTO)  throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IUserRepository userRepository = new UserRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final User user = userRepository.findOne(userDTO.getId());
            if (user == null) throw new DataValidateException("User not found!");
            user.setName(userDTO.getName());
            user.setDescription(userDTO.getDescription());
            user.setLogin(userDTO.getLogin());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole());
            userRepository
                    .merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }


    @Override
    public UserDTO findByLogin(@NotNull final String login)  throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IUserRepository userRepository = new UserRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final User user = userRepository
                    .findByLogin(login);
            if (user == null) throw new DataValidateException("User not found");
            entityManager.getTransaction().commit();
            return user.getDTO();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void clear() throws DataValidateException {
        @Nullable final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IUserRepository userRepository = new UserRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            userRepository
                    .removeAll();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public UserDTO findOne(@NotNull String id) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IUserRepository userRepository = new UserRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final User user = userRepository
                    .findOne(id);
            if (user == null) throw new DataValidateException("User not found!");
            entityManager.getTransaction().commit();
            return user.getDTO();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void remove(@NotNull String id) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IUserRepository userRepository = new UserRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final User user = userRepository
                    .findOne(id);
            if (user == null) throw new DataValidateException("Task not found!");
            userRepository
                    .remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Collection<UserDTO> findAll() throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IUserRepository userRepository = new UserRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Collection<User> users = userRepository
                    .findAll();
            if (users == null) throw new DataValidateException("TAsks not found!");
            entityManager.getTransaction().commit();
            return users
                    .stream()
                    .map(User::getDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public UserDTO authenticationUser(@NotNull final String login, @NotNull final String password) throws AuthenticationSecurityException, DataValidateException {
            @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
            @NotNull final IUserRepository userRepository = new UserRepository(entityManager);
            try {
                entityManager.getTransaction().begin();
                @Nullable final User user = userRepository
                        .findByLogin(login);
                if (user == null) throw new AuthenticationSecurityException("Wrong user name!");
                if (!user.getPassword().equals(password)) throw new AuthenticationSecurityException("Wrong password!");
                entityManager.getTransaction().commit();
                return user.getDTO();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                System.out.println("Transaction rollback!");
                throw new AuthenticationSecurityException(e.getMessage());
            } finally {
                entityManager.close();
            }
        }
   }