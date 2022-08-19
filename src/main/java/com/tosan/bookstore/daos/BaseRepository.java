package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.BaseEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.util.Assert;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID> extends CrudRepository<T, ID> {
    public List<T> findAllByDeletedFalse();

    public List<T> findAllByDeletedTrue();

    public List<T> findByIdAndDeletedFalse(ID id);

    default void softDelete(T entity) {
        Assert.notNull(entity, "The entity must not be null!");

        entity.setDeleted(true);
        save(entity);
    }

    default void softDeleteById(ID id) {
        Assert.notNull(id, "The given id must not be null!");

        this.softDelete(findById(id).orElseThrow(() -> new EmptyResultDataAccessException(
                String.format("No %s entity with id %s exists!", "", id), 1)));
    }
}
