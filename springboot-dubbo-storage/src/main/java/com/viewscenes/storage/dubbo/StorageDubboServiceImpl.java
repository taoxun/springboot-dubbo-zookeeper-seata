package com.viewscenes.storage.dubbo;

import com.viewscenes.common.dto.StorageDTO;
import com.viewscenes.common.dubbo.StorageDubboService;
import com.viewscenes.storage.service.StorageService;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StorageDubboServiceImpl implements StorageDubboService {

    @Autowired
    StorageService storageService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public int decreaseStorage(StorageDTO storage) {
        logger.info("全局事务XID：{}",RootContext.getXID());
        return storageService.decreaseStorage(storage);
    }
}
