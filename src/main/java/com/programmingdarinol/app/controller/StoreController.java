package com.programmingdarinol.app.controller;

import com.programmingdarinol.app.DTO.StoreDTO;
import com.programmingdarinol.app.model.Store;
import com.programmingdarinol.app.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")

public class StoreController {

    @Autowired
    StoreService storeService; //pemanggilan store service dari storeservice.java

    @PostMapping("/add/{merchantId}")
    public StoreDTO addStoreToMerchant(@PathVariable Long merchantId, @RequestBody StoreDTO request){
        Store store = storeService.mapToEntitiy(request);
        Store result = storeService.addStore(merchantId, store);
        return storeService.mapToDTO(result);
    }
}
