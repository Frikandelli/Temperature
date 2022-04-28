package nl.utwente.di.bookQuote;

//import org.junit.Assert;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TestQuoter {


    private class Quoter {
        HashMap<String, Double> priceList = new HashMap<String, Double>();
        public Quoter() {
            priceList.put("1", 10.0);
            priceList.put("2", 45.0);
            priceList.put("3", 20.0);
            priceList.put("4", 35.0);
            priceList.put("5", 50.0);
        }
        public double getBookPrice(String str) {

            double ret = priceList.get(str);
            return ret;
        }
    }
    @Test
    public void testBook1() throws Exception {
        Quoter quoter = new Quoter();
        double price = quoter.getBookPrice("1");
        assertEquals(10.0 , price);
//        assertEquals(price, 0.0);
//        assertEquals("Price of book 1" , 10.0, price, 0.0);
    }
}