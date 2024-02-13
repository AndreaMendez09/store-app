package com.inditex.storeapp.app;

import com.inditex.storeapp.infra.api.res.ProductPriceRes;

public interface RetrieveProductPriceAction {
    ProductPriceRes retrievePrices(String applicationDate, Long productId, Long brandId);
}
