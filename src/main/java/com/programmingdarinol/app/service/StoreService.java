package com.programmingdarinol.app.service;

import com.programmingdarinol.app.DTO.StoreDTO;
import com.programmingdarinol.app.model.Store;

public interface StoreService {

    Store addStore(Long merchantID, Store store);

    Store mapToEntitiy(StoreDTO storeDTO);
    StoreDTO mapToDTO(Store store);
}
