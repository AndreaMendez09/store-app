package com.inditex.storeapp.app;


import com.inditex.storeapp.domain.dto.ProductPriceDTO;
import com.inditex.storeapp.domain.exceptions.InvalidInputParametersException;
import com.inditex.storeapp.domain.exceptions.ProductNotFound;
import com.inditex.storeapp.domain.mappers.ProductPriceMapper;
import com.inditex.storeapp.domain.repo.ProductPriceRepository;
import com.inditex.storeapp.infra.api.res.ProductPriceRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class RetrieveProductPrice implements RetrieveProductPriceAction {

    private final ProductPriceRepository priceRepository;

    private final ProductPriceMapper productPriceMapper;

    @Autowired
    public RetrieveProductPrice(ProductPriceRepository priceRepository, ProductPriceMapper productPriceMapper) {
        this.priceRepository = priceRepository;
        this.productPriceMapper = productPriceMapper;
    }

    @Override
    public ProductPriceRes retrievePrices(String applicationDate, Long productId, Long brandId) {
        LocalDateTime formatApplicationDate;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            formatApplicationDate = LocalDateTime.parse(applicationDate, formatter);
        } catch (Exception e) {
            throw new InvalidInputParametersException("Invalid input parameters", e);
        }

        ProductPriceDTO productPriceDTO = priceRepository.findFirstPrices(formatApplicationDate, productId, brandId)
                .stream().findFirst()
                .orElseThrow(ProductNotFound::new);

        return productPriceMapper.mapToRes(productPriceDTO);
    }
}
