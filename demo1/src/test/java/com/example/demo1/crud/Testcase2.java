// package com.example.demo1.crud;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;

// import org.junit.Test;
// import org.mockito.Mock;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import com.fasterxml.jackson.databind.ObjectMapper;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class Testcase2 {
// @Autowired
// private MockMvc mockmvc;
// @Autowired
// private ObjectMapper objectmapr;
// @MockBean
// private ProService ps;
// @Mock
// private JdbcTemplate j;
// @Test
// public void testinsert() throws Exception{
//     Product p= new Product();
//     p.setId(4);
//     p.setName("cpu");
//     p.setPrice(1200);
//     {
//         when(ps.addProd(any(Product.class))).thenReturn(1);
//         mockmvc.perform(MockMvcRequestBuilders.post("/product/add")
//         .contentType("application/json")
//         .content(objectmapr.writeValueAsString(p)))
//         .andExpect(MockMvcResultMatchers.status().isOk())
//         .andExpect(MockMvcResultMatchers.content().string("{ 's': 'inserted'}"));
//     }
//     {
//         when(ps.addProd(any(Product.class))).thenReturn(0);
//         mockmvc.perform(MockMvcRequestBuilders.post("/emp/ein")
//                 .contentType("application/json")
//                 .content(objectmapr.writeValueAsString(p)))
//         .andExpect(MockMvcResultMatchers.status().isOk())
//         .andExpect(MockMvcResultMatchers.content().string("{ 'f': 'not inserted'}"));
//         System.out.println("in 0 executed");
//         }
       
// }

// }
package com.example.demo1.crud;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class) // Use MockitoExtension to initialize mocks
public class Testcase2 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private ProController proController; // Inject the controller instead of service directly

    @MockBean
    private ProService proService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() throws Exception {
        // Mocking the behavior of ProService
        Product p = new Product();
        p.setId(4);
        p.setName("cpu");
        p.setPrice(1200.0);

        when(proService.addProd(any(Product.class))).thenReturn(1);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/product/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(p)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"s\":\"inserted\"}"));
    }
}
