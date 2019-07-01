package com.viewscenes.storage.controller;

import com.viewscenes.common.dto.StorageDTO;
import com.viewscenes.common.dubbo.StorageDubboService;
import com.viewscenes.storage.entity.Storage;
import com.viewscenes.storage.service.StorageService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @Reference
    StorageDubboService storageDubboService;

    @PostMapping("dec_storage")
    public int decreaseStorage(@RequestBody StorageDTO storage){
        return storageDubboService.decreaseStorage(storage);
    }
}
