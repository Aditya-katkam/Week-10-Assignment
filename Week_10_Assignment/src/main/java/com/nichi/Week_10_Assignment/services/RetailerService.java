package com.nichi.Week_10_Assignment.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nichi.Week_10_Assignment.Retailer;
import com.nichi.Week_10_Assignment.repositories.RetailerRepository;



@Service
public class RetailerService {

    @Autowired
    RetailerRepository retailerRepositry;

    public List<Retailer> getAllRetailers() {
        List<Retailer> RetailersList = new ArrayList<Retailer>();

        retailerRepositry
                .findAll()
                .forEach(Retailer -> RetailersList.add(Retailer));

        return RetailersList;
    }

    public Retailer updateRetailer(Retailer Retailer) {
        return retailerRepositry.save(Retailer);
    }

    public Retailer addRetailer(Retailer Retailer) {
        return retailerRepositry.save(Retailer);
    }

    public void deleteRetailer(int RetailerId) {
       
        List<Retailer> RetailerList = getAllRetailers();

        for (Retailer Retailer : RetailerList) {
            if (Retailer.getRetailer_id() == RetailerId)
                retailerRepositry.deleteById(RetailerId);
        }
    }

    

}
