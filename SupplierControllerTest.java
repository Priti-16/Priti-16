package com.ty.maker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SupplierControllerTest<MockMvc> {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void querySuppliers() throws Exception {
        mockMvc.perform(post("/api/supplier/query")
                .param("location", "India")
                .param("natureOfBusiness", "SMALL_SCALE")
                .param("manufacturingProcess", "PRINTING_3D")
                .param("page", "0")
                .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray());
    }
}
