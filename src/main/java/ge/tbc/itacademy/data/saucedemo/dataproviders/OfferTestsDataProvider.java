package ge.tbc.itacademy.data.saucedemo.dataproviders;

import org.testng.annotations.DataProvider;

public class OfferTestsDataProvider {
    @DataProvider
    public Object[][] priceRangeProvider(){
        return new Object[][]{
                {10, 100},
                {50, 500},
                {0, 1000},
                {30, 700},
                {200, 5000}
        };
    }
}
