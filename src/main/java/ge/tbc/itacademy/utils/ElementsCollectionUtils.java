package ge.tbc.itacademy.utils;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.Random;

public class ElementsCollectionUtils {
    public static SelenideElement getRandomElement(ElementsCollection elements) {
        if (elements.isEmpty()) {
            throw new IllegalArgumentException("The elements collection is empty.");
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(elements.size());
        return elements.get(randomIndex);
    }
    //conflict1
}
