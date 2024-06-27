package com.example.demo1.crud;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/product")
public class ProController {
    @Autowired
    ProService ps;
    @GetMapping("/gethello")
    public String Hello(){
    	return "welcome";
    }
    
    @PostMapping("/add")
    public Map addProd(@RequestBody Product p){
HashMap<String, String> hm= new HashMap<>();
int add= ps.addProd(p);
if(add>0){
    hm.put("s","inserted");}
    else{
        hm.put("f", "not inserted");
    }
    return hm;
}

@PutMapping("/update")
    public Map<String, String> updateProd(@RequestBody Product p) {
        HashMap<String, String> response = new HashMap<>();
        int update = ps.updateProd(p);
        if (update > 0) {
            response.put("status", "updated");
        } else {
            response.put("status", "not updated");
        }
        return response;
    }

// @GetMapping("/get")
//     public List<Map<String, Object>> getProd(@RequestParam Product p) {
//         List<Map<String, Object>> getvalues = ps.getProd(p);
//         if (getvalues.size() > 0) {
//             System.out.println("success");
//         } else {
//             System.out.println("fail");
//         }
//         return getvalues;
//     }

@GetMapping("/get")
public List<Map<String, Object>> getProd(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
                                         @RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "price", required = false, defaultValue = "0.0") double price) {
    Product p = new Product();
    p.setId(id);
    p.setName(name);
    p.setPrice(price);

    List<Map<String, Object>> getvalues = ps.getProd(p);
    if (!getvalues.isEmpty()) {
        System.out.println("success");
    } else {
        System.out.println("fail");
    }
    return getvalues;
}

@DeleteMapping("/delete")
public Map<String,String> deleteProd(@RequestParam int id){
    HashMap <String,String> hm= new HashMap<>();
    int update = ps.deleteProd(id);
    if (update > 0) {
        hm.put("s", "deleted");
    } else {
        hm.put("f", "not deleted");
    }
    return hm;
}
  }