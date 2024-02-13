package com.inditex.storeapp.infra.api;

import com.inditex.storeapp.app.RetrieveProductPrice;
import com.inditex.storeapp.infra.api.res.ProductPriceRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RetrieveProductPriceController {

    private final RetrieveProductPrice priceService;

    @Autowired
    public RetrieveProductPriceController(RetrieveProductPrice priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/prices")
    public ProductPriceRes retrievePrice(@RequestParam String applicationDate,
                                         @RequestParam Long productId,
                                         @RequestParam Long brandId) {
        return priceService.retrievePrices(applicationDate, productId, brandId);
    }


}