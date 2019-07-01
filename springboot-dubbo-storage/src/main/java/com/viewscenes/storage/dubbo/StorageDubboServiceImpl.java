package com.viewscenes.storage.dubbo;

import com.viewscenes.common.dto.StorageDTO;
import com.viewscenes.common.dubbo.StorageDubboService;
import com.viewscenes.storage.service.StorageService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StorageDubboServiceImpl implements StorageDubboService {

    @Autowired
    StorageService storageService;

    @Override
    public int decreaseStorage(StorageDTO storage) {
        System.out.println("全局事务XID："+ RootContext.getXID());
        return storageService.decreaseStorage(storage);
    }
}
