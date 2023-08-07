package com.programmingdarinol.app.DTO;

import java.util.List;

public record MerchantDTO(Long id, String name, List<StoreDTO> stores) {
}
