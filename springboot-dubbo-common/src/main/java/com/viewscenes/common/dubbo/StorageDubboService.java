package com.viewscenes.common.dubbo;

import com.viewscenes.common.dto.StorageDTO;

public interface StorageDubboService {

    int decreaseStorage(StorageDTO storage);
}
