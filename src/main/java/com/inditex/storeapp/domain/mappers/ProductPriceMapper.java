package com.inditex.storeapp.domain.mappers;

import com.inditex.storeapp.domain.dto.ProductPriceDTO;
import com.inditex.storeapp.infra.api.res.ProductPriceRes;
import org.springframework.stereotype.Component;

@Component
public class ProductPriceMapper {
  public ProductPriceRes mapToRes(ProductPriceDTO dto) {
    return new ProductPriceRes(
            dto.getProductId(),
            dto.getBrandId(),
            dto.getPriceList(),
            dto.getStartDate(),
            dto.getEndDate(),
            dto.getPrice()
    );
  }
}
