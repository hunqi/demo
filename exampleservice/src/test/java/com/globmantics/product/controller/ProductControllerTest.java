package com.globmantics.product.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globmantics.product.service.Product;
import com.globmantics.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @MockBean
    private ProductService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /product/1 - Found")
    void testGetProductByIdFound() throws Exception {
        Product mockProduct = new Product(1, "Product Name", 10, 1);
        doReturn(Optional.of(mockProduct)).when(service).findById(1);

        mockMvc.perform(get("/product/{id}", 1))

                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the headers
                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
                .andExpect(header().string(HttpHeaders.LOCATION, "/product/1"))

                // Validate the returned fields
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Product Name")))
                .andExpect(jsonPath("$.quantity", is(10)))
                .andExpect(jsonPath("$.version", is(1)));

    }

    @Test
    @DisplayName("GET /product/1 - Not Found")
    void testGetProductByIdNotFound() throws Exception {
        doReturn(Optional.empty()).when(service).findById(1);

        mockMvc.perform(get("/product/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST /product - Success")
    void testCreateProduct() throws Exception {
        Product postProduct = new Product("Product Name", 10);
        Product mockProduct = new Product(1, "Product Name", 10, 1);
        doReturn(mockProduct).when(service).save(any());

        mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(postProduct)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string(HttpHeaders.ETAG, "\"1\""))
                .andExpect(header().string(HttpHeaders.LOCATION, "/product/1"))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Product Name")))
                .andExpect(jsonPath("$.quantity", is(10)))
                .andExpect(jsonPath("$.version", is(1)));
    }

    @Test
    @DisplayName("PUT /product/1 - Success")
    void testProductPutSuccess() throws Exception {
        Product putProduct = new Product("Product Name", 10);
        Product mockProduct = new Product(1, "Product Name", 10, 1);
        doReturn(Optional.of(mockProduct)).when(service).findById(1);
        doReturn(true).when(service).update(any());

        mockMvc.perform(put("/product/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.IF_MATCH, 1)
                .content(asJsonString(putProduct)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string(HttpHeaders.ETAG, "\"2\""))
                .andExpect(header().string(HttpHeaders.LOCATION, "/product/1"))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Product Name")))
                .andExpect(jsonPath("$.quantity", is(10)))
                .andExpect(jsonPath("$.version", is(2)));
    }

    @Test
    @DisplayName("PUT /product/1 - Version Mismatch")
    void testProductPutVersionMismatch() throws Exception {
        Product putProduct = new Product("Product Name", 10);
        Product mockProduct = new Product(1, "Product Name", 10, 2);
        doReturn(Optional.of(mockProduct)).when(service).findById(1);
        doReturn(true).when(service).update(any());

        mockMvc.perform(put("/product/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.IF_MATCH, 1)
                .content(asJsonString(putProduct)))
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("PUT /product/1 - Not Found")
    void testProductPutNotFound() throws Exception {
        Product putProduct = new Product("Product Name", 10);
        doReturn(Optional.empty()).when(service).findById(1);

        mockMvc.perform(put("/product/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.IF_MATCH, 1)
                .content(asJsonString(putProduct)))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /product/1 - Success")
    void testProductDeleteSuccess() throws Exception {
        Product mockProduct = new Product(1, "Product Name", 10, 1);

        doReturn(Optional.of(mockProduct)).when(service).findById(1);
        doReturn(true).when(service).delete(1);

        mockMvc.perform(delete("/product/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("DELETE /product/1 - Not Found")
    void testProductDeleteNotFound() throws Exception {
        doReturn(Optional.empty()).when(service).findById(1);
        mockMvc.perform(delete("/product/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("DELETE /product/1 - Failure")
    void testProductDeleteFailure() throws Exception {
        Product mockProduct = new Product(1, "Product Name", 10, 1);

        doReturn(Optional.of(mockProduct)).when(service).findById(1);
        doReturn(false).when(service).delete(1);

        mockMvc.perform(delete("/product/{id}", 1))
                .andExpect(status().isInternalServerError());
    }

    private String asJsonString(Product postProduct) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(postProduct);
    }
}
