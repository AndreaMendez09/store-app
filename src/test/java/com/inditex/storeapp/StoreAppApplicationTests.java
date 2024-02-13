package com.inditex.storeapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StoreAppApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Test
    void contextLoads() {
    }

    @Test
    void test1() throws Exception {
        String test1Url = "/api/prices?applicationDate=2020-06-14 10:00:00&brandId=1&productId=35455";
        mockMvc.perform(get(test1Url))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").exists());
    }

    @Test
    void test2() throws Exception {
        String test2Url = "/api/prices?applicationDate=2020-06-14 16:00:00&brandId=1&productId=35455";
        mockMvc.perform(get(test2Url))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").exists());
    }

    @Test
    void test3() throws Exception {
        String test3Url = "/api/prices?applicationDate=2020-06-14 21:00:00&brandId=1&productId=35455";
        mockMvc.perform(get(test3Url))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").exists());
    }

    @Test
    void test4() throws Exception {
        String test4Url = "/api/prices?applicationDate=2020-06-15 10:00:00&brandId=1&productId=35455";
        mockMvc.perform(get(test4Url))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").exists());
    }

    @Test
    void test5() throws Exception {
        String test5Url = "/api/prices?applicationDate=2020-06-16 21:00:00&brandId=1&productId=35455";
        mockMvc.perform(get(test5Url))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.brandId").exists());
    }

    @Test
    void testMissingParameter() throws Exception {
        String url = "/api/prices?brandId=1&productId=35455";
        mockMvc.perform(get(url))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void testPriceForNonExistingProduct() throws Exception {
        String url = "/api/prices?applicationDate=2020-06-14 10:00:00&brandId=1&productId=99999";
        mockMvc.perform(get(url))
                .andExpect(status().isNotFound());
    }

    @Test
    void testInvalidDateFormat() throws Exception {
        String url = "/api/prices?applicationDate=14-06-2020 10:00:00&brandId=1&productId=35455";
        mockMvc.perform(get(url))
                .andExpect(status().isBadRequest());
    }

}
