package com.inditex.storeapp.domain.repo;

import com.inditex.storeapp.domain.dto.ProductPriceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPriceDTO, Long> {


    @Query("SELECT p " +
            "FROM  ProductPriceDTO p " +
            "WHERE :applicationDate BETWEEN p.startDate AND p.endDate " +
            "AND p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "ORDER BY p.priority DESC")
    List<ProductPriceDTO> findFirstPrices(@Param("applicationDate") LocalDateTime applicationDate,
                                          @Param("productId") Long productId,
                                          @Param("brandId") Long brandId);
}