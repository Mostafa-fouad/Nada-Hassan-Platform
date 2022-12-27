package com.example.nadahassanplatform.orders.service.impl;

import com.example.nadahassanplatform.orders.dto.ShippingDto;
import com.example.nadahassanplatform.orders.repository.ShippingRepository;
import com.example.nadahassanplatform.orders.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    private final ShippingRepository shippingRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ShippingDto> getAllShippings() {
        return shippingRepository.findAll().stream()
                .map(shipping -> modelMapper.map(shipping, ShippingDto.class))
                .toList();
    }
}