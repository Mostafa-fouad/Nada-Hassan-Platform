package com.example.nadahassanplatform.orders.service.impl;

import com.example.nadahassanplatform.core.exception.NotFoundException;
import com.example.nadahassanplatform.orders.dto.ShippingDto;
import com.example.nadahassanplatform.orders.model.Shipping;
import com.example.nadahassanplatform.orders.repository.ShippingRepository;
import com.example.nadahassanplatform.orders.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<String> getAllShippingGovernments() {
        return shippingRepository.getAllShippingGovernments();
    }

    @Override
    @Transactional
    public void addShipping(final ShippingDto shippingDto) {
        shippingRepository.save(modelMapper.map(shippingDto, Shipping.class));
    }

    @Override
    @Transactional
    public void editShippingFees(final ShippingDto shippingDto) {
        final Shipping shipping = shippingRepository.findByGovernmentName(shippingDto.getGovernmentName())
                .orElseThrow(() -> new NotFoundException(String.format("Government %s is not found", shippingDto.getGovernmentName())));

        shipping.setFees(shippingDto.getFees());

        shippingRepository.save(shipping);
    }

    @Override
    @Transactional
    public void deleteGovernment(String governmentName) {
        shippingRepository.deleteByGovernmentName(governmentName);
    }

    @Override
    public Double getFeesByGovernment(String governmentName) {
        return shippingRepository.findByGovernmentName(governmentName).get().getFees();
    }

}