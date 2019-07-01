package com.viewscenes.storage.mapper;

import com.viewscenes.storage.entity.Storage;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageMapper {

    int decreaseStorage(Storage storage);
}
