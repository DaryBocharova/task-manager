package ru.bocharova.tm.service;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bocharova.tm.model.dto.TaskDTO;
import ru.bocharova.tm.api.repository.IProjectRepository;
import ru.bocharova.tm.api.repository.ITaskRepository;
import ru.bocharova.tm.api.repository.IUserRepository;
import ru.bocharova.tm.api.service.ITaskService;
import ru.bocharova.tm.model.entity.*;
import ru.bocharova.tm.exception.DataValidateException;
import ru.bocharova.tm.repository.ProjectRepository;
import ru.bocharova.tm.repository.TaskRepository;
import ru.bocharova.tm.repository.UserRepository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public final class TaskService implements ITaskService {

    @NotNull
    final EntityManagerFactory entityManagerFactory;

    @Override
    public void create(@NotNull final TaskDTO taskDTO) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final IProjectRepository projectRepository = new ProjectRepository(entityManager);
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @NotNull final Task task = convertDTOtoTask(taskDTO, entityManager);
            taskRepository
                    .persist(task);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void edit(@NotNull final TaskDTO taskDTO) {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Task task = taskRepository.findOne(taskDTO.getId());
            if (task == null) throw new DataValidateException("Project not found!");
            task.setName(taskDTO.getName());
            task.setDescription(taskDTO.getDescription());
            task.setStatus(taskDTO.getStatus());
            task.setDateBegin(taskDTO.getDateBegin());
            task.setDateEnd(taskDTO.getDateEnd());
            taskRepository
                    .merge(task);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public ru.bocharova.tm.model.dto.TaskDTO findOne(@Nullable final String id,
                                                     @Nullable final String userId)
            throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Task task = taskRepository
                    .findOneByUserId(id, getUser(userId, entityManager));
            if (task == null) throw new DataValidateException("Task not found!");
            entityManager.getTransaction().commit();
            return task.getDTO();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void remove(@Nullable final String id,
                       @Nullable final String userId)
            throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Task task = taskRepository
                    .findOneByUserId(id, getUser(userId, entityManager));
            if (task == null) throw new DataValidateException("Task not found!");
            taskRepository
                    .remove(task);
            entityManager.getTransaction().commit();
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
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            taskRepository
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
    public TaskDTO findOne(@NotNull String id) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Task task = taskRepository
                    .findOne(id);
            if (task == null) throw new DataValidateException("Task not found!");
            entityManager.getTransaction().commit();
            return task.getDTO();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void remove(@Nullable final String id)
            throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Task task = taskRepository
                    .findOne(id);
            if (task == null) throw new DataValidateException("Task not found!");
            taskRepository
                    .remove(task);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Collection<TaskDTO> findAll() throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Collection<Task> tasks = taskRepository
                    .findAll();
            if (tasks == null) throw new DataValidateException("TAsks not found!");
            entityManager.getTransaction().commit();
            return tasks
                    .stream()
                    .map(Task::getDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void removeAllByProjectId(@NotNull final String id, @NotNull final String userId) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            taskRepository
                    .removeAllByProjectAndUserId(getProject(id, entityManager), getUser(userId, entityManager));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private Project getProject(@NotNull final String id, @NotNull final EntityManager entityManager) throws DataValidateException {
        @NotNull final IProjectRepository projectRepository = new ProjectRepository(entityManager);
        @NotNull final Project project = projectRepository.findOne(id);
        if (project == null) throw new DataValidateException("Project not found!");
        return project;
    }

    @Override
    public void removeAllByUserId(@NotNull final String id) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            taskRepository
                    .removeAllByUserId(getUser(id, entityManager));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Collection<TaskDTO> sortAllByUserId(@NotNull String id, @NotNull String parameter) throws DataValidateException {
        if ("order".equals(parameter)) return findAllByUserId(id);
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Collection<Task> tasks = taskRepository
                    .sortAllByUserId(getUser(id, entityManager), parameter);
            if (tasks == null) throw new DataValidateException("Projects not found!");
            entityManager.getTransaction().commit();
            return tasks
                    .stream()
                    .map(Task::getDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }


    @Override
    public Collection<TaskDTO> findAllByPartOfNameOrDescription(@NotNull String name, @NotNull String
            description, @NotNull String userId) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Collection<Task> tasks = taskRepository
                    .findAllByPartOfNameOrDescription(name, description, getUser(userId, entityManager));
            if (tasks == null) throw new DataValidateException("Projects not found!");
            entityManager.getTransaction().commit();
            return tasks
                    .stream()
                    .map(Task::getDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Collection<TaskDTO> findAllByProjectId(@NotNull final String id, @NotNull final String userId) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Collection<Task> tasks = taskRepository
                    .findAll();
            if (tasks == null) throw new DataValidateException("Tasks not found!");
            entityManager.getTransaction().commit();
            return tasks
                    .stream()
                    .map(Task::getDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Collection<TaskDTO> findAllByUserId(@NotNull final String id) throws DataValidateException {
        @NotNull final EntityManager entityManager = entityManagerFactory.createEntityManager();
        @NotNull final ITaskRepository taskRepository = new TaskRepository(entityManager);
        try {
            entityManager.getTransaction().begin();
            @Nullable final Collection<Task> tasks = taskRepository
                    .findAllByUserId(getUser(id, entityManager));
            if (tasks == null) throw new DataValidateException("Tasks not found!");
            entityManager.getTransaction().commit();
            return tasks
                    .stream()
                    .map(Task::getDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new DataValidateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    private Task convertDTOtoTask(
            @NotNull final TaskDTO taskDTO,
            @NotNull final EntityManager entityManager)
            throws DataValidateException {
        @NotNull final Task task = new Task();
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setDateBegin(taskDTO.getDateBegin());
        task.setDateEnd(taskDTO.getDateEnd());
        try {
            task.setUser(getUser(taskDTO.getUserId(), entityManager));
        } catch (DataValidateException e) {
            e.printStackTrace();
        }
        task.setStatus(taskDTO.getStatus());
        return task;
    }

    private User getUser(@NotNull final String userId, @NotNull final EntityManager entityManager) throws DataValidateException {
        @NotNull final IUserRepository userRepository = new UserRepository(entityManager);
        @Nullable final User user = userRepository.findOne(userId);
        if (user == null) throw new DataValidateException("User not found!");
        return user;
    }
}
