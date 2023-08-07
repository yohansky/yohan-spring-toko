package com.programmingdarinol.app.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.programmingdarinol.app.DTO.StoreDTO;
import com.programmingdarinol.app.model.Merchant;
import com.programmingdarinol.app.model.Store;
import com.programmingdarinol.app.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class StoreServiceimpl implements StoreService {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MerchantService merchantService;

    @Autowired
    StoreRepository storeRepository;

    @Override
    public Store addStore(Long merchantID, Store store) {
        Merchant merchant = merchantService.findById(merchantID);
        if (merchant != null) {
            //add store to database
            store = storeRepository.save(store);
            if (merchant.getStores() != null){
                List<Store> stores = merchant.getStores();
                stores.add(store);
                merchant.setStores(stores);
            } else {
                merchant.setStores(Collections.singletonList(store));
            }
            merchantService.create(merchant); //update data merchant
        }
        return null;
    }
    @Override
    public Store mapToEntitiy(StoreDTO storeDTO) {
        return mapper.convertValue(storeDTO, Store.class);
    }

    @Override
    public StoreDTO mapToDTO(Store store) {
        return mapper.convertValue(store, StoreDTO.class);
    }
}
