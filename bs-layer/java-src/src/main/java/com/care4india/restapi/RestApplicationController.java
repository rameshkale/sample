package com.care4india.restapi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
public class RestApplicationController {
    @Autowired
    private DataSource ds;

    @PostMapping(path="/authenticate", consumes = "application/json", produces = "application/json")
    public ApplicationToken authenticate(@RequestBody Credentials credentials) throws SQLException {

        //DataSource ds = (DataSource)appContext.getBean ("dataSource");
        Connection c = ds.getConnection();
        Statement statement = c.createStatement();


        boolean state = statement.execute("select * from auth");

        if(state){
            ResultSet rs = statement.getResultSet();

            while(!rs.isLast()){
                System.out.println("public_key :" + rs.getString("public_key"));
                System.out.println("hashed_password :" + rs.getString("hashed_password"));
                System.out.println("encrypted_private_key :" + rs.getString("encrypted_private_key"));
                rs.next();
            }
        }

        System.out.println(credentials);

        if(credentials.getUserName().equals("Ramesh") && credentials.getPassword().equals("Kale")) {
            return new ApplicationToken("alsjhdtelkseiouyfsgfderrtfg user name" + credentials.getUserName() + " Password " + credentials.getPassword());
        }else{
            System.out.println("Invalid user");
        }
        return null;
    }
}