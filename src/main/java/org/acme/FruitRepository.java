package org.acme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.agroal.api.AgroalDataSource;

@ApplicationScoped
public class FruitRepository {

    String SQL = " select * from public.fruit order by name";

    @Inject
    AgroalDataSource dataSource;

    public List<Fruit> listAll(){
        PreparedStatement stm = null;
        ResultSet rs          = null;
        Connection conn       = null;

        try{

            conn = dataSource.getConnection();
            stm = conn.prepareStatement(SQL);
            rs = stm.executeQuery();

            List<Fruit> resultList = new ArrayList<>();
            while( rs.next() ){
                Fruit fruit = new Fruit();
                fruit.id = rs.getLong("id");
                fruit.name = rs.getString("name");

                resultList.add(fruit);
            }

            return resultList;

        }catch(Exception e){
            e.printStackTrace();
        } finally{

            try{
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            try{
                if(stm != null && !stm.isClosed()){
                    stm.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            try{
                if(conn != null && !conn.isClosed()){
                conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }

        return null;
    }
    
}
