package com.programmingdarinol.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.programmingdarinol.app.DTO.MerchantDTO;
import com.programmingdarinol.app.model.Merchant;

import com.programmingdarinol.app.repository.MerchantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MerchantServiceimpl implements MerchantService{

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant create(Merchant merchant) {
        merchantRepository.save(merchant);
        Merchant result = merchantRepository.save(merchant);
        return result;
    }

    @Override
    public Merchant update(Long id, Merchant merchant) {
        Merchant result = findById(id);
        if (result != null){
            result.setName(merchant.getName());
            return merchantRepository.save(result);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        Merchant result = findById(id);
        if (result != null){
            merchantRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Merchant> findAll() {
        return merchantRepository.findAll();
    }

    @Override
    public Page<Merchant> findAll(Pageable pageable) {
        return merchantRepository.findAll(pageable);
    }

    @Override
    public Merchant findById(Long id) {
        Optional<Merchant> result = merchantRepository.findById(id);
        if (result.isPresent()) {
            return result.get();//jika result ada maka ambil
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();
    @Override
    public MerchantDTO mapToDto(Merchant merchant) {
        return mapper.convertValue(merchant, MerchantDTO.class);
    }

    @Override
    public Merchant mapToEntitiy(MerchantDTO merchantDTO) {
        return mapper.convertValue(merchantDTO, Merchant.class);
    }
}
