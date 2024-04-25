package ge.tbc.itacademy.data.swoop;

public class Constants {
    public static final String minPriceFieldXpath = "(//input[@name=\"minprice\"])[2]";
    public static final String maxPriceFieldXpath = "(//input[@name=\"maxprice\"])[2]";
    public static final String submitPriceRangeXpath = "(//div[@class=\"submit-button\"])[2]";
    public static final String specialOfferPricesXpath = "//div[@class=\"discounted-prices\"]/p[1]";
    public static final String locationDropDownButtonXpath = "(//button[@class=\"ms-choice\"])[2]";
    public static final String locationDropDownElementsXpath = "(//div[@class=\"ms-drop bottom\"])[2]";
    public static final String paymentMethodOptionsXpath = "(//div[@class=\"location-type-filter\"])[2]";
    public static final String clearFilterButtonXpath = "(//div[@class=\"delete-search-button\"])[2]";
    public static final String loaderSelector = ".loader";
    public static final String allDealsSelector = ".special-offer";
    public static final String holidayButtonSelector = "li.MoreCategories a";
    public static final String categoriesButtonSelector = ".categoriesTitle";
    public static final String categoriesSelector = ".mainCategories";
    public static final String subCategoriesSelector = ".mobileSubCategories.subCategory-3 ul li a";
    public static final String shareButtonSelector = ".share";
    public static final String basketButtonSelector = ".deal-basket-wishlist";
    public static final String dealBarSelector = ".voucher-diagram div";
    public static final String attributeDataWidth = "data-width";
    public static final String soldAmountSelector = ".outs-and-shorts";
    public static final String paginationSelector = ".pagination__link--active";
    public static final String divType = "div";
    public static final String noSuchElementErrorMessage = "No offer with 0 sold amount found.";
    public static final String inputType = "input";
    public static final String holidayCategoryPageText = "დასვენება";
    public static final String foodCategoryPageText = "კვება";
    public static final String childrenCategoryPageText = "კვება";
    public static final String locationAllOptionText = "ყველა";
    public static final String fullPaymentOptionText = "სრული გადახდა";
    public static final String swoopPageUrl = "https://www.swoop.ge/";
}
