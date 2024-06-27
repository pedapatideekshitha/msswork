package com.example.demo1.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service 
public class ProService {
    @Autowired
    JdbcTemplate j;
    public int addProd(Product p){
        int id=p.getId();
        String name=p.getName();
        double price= p.getPrice();
        String sql="insert into Product values(?,?,?)";
        int i=j.update(sql,id,name,price) ;
                return i;                                                                                                                 
    }
   
    public int updateProd(Product p) {
        String sql = "update Product set name=?, price=? where id=?";
        return j.update(sql, p.getName(), p.getPrice(), p.getId());
    }

    
    // public List<Map<String, Object>> getProd(Product p) {
    //     int id = p.getId();
    //     String name = p.getName();
    //     double price = p.getPrice();

    //     String sql = "select * from Product where 1=1";
    //     if (id != 0) {
    //         sql = sql + " and id=?";
    //     }
    //     if (name != null && !name.isEmpty()) {
    //         sql = sql + " and name=?";
    //     }
    //     if (price != 0) {
    //         sql = sql + " and price=?";
    //     }

    //     return j.queryForList(sql, id, name, price);
    // }

    public List<Map<String, Object>> getProd(Product p) {
        int id = p.getId();
        String name = p.getName();
        double price = p.getPrice();

        String sql = "select * from Product where 1=1";
        List<Object> params = new ArrayList<>();

        if (id != 0) {
            sql = sql + " and id=?";
            params.add(id);
        }
        if (name != null && !name.isEmpty()) {
            sql = sql + " and name=?";
            params.add(name);
        }
        if (price != 0) {
            sql = sql + " and price=?";
            params.add(price);
        }
        return j.queryForList(sql, params.toArray());
    }

    public int deleteProd(int id){
        String sql= "delete from Product where id=?";
        int i=j.update(sql, id);
        return i;
    }
}
