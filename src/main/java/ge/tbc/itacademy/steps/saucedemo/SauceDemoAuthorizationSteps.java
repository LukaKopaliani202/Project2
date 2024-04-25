package ge.tbc.itacademy.steps.saucedemo;

import com.codeborne.selenide.conditions.AttributeWithValue;
import ge.tbc.itacademy.data.database.MSSQLConnection;
import ge.tbc.itacademy.pages.saucedemo.SauceDemoAuthorizationPage;
import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.codeborne.selenide.Condition.visible;
import static ge.tbc.itacademy.data.saucedemo.Constants.*;

public class SauceDemoAuthorizationSteps extends SauceDemoAuthorizationPage {
    Connection connection;
    Statement statement;

    public SauceDemoAuthorizationSteps() throws SQLException {
        Connection connection = MSSQLConnection.connect();
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    @Step("Enter username: {0}")
    public SauceDemoAuthorizationSteps enterUserName(String userName){
        userNameField.setValue(userName);
        return this;
    }

    @Step("Enter password for username: {0}")
    public SauceDemoAuthorizationSteps enterPassword(String userName) throws SQLException {
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM users WHERE username = '%s'", userName));

        while (resultSet.next()) {
            passwordField.setValue(resultSet.getString("password"));
        }
        return this;
    }

    @Step("Submit the form")
    public SauceDemoAuthorizationSteps submitForm(){
        submitButton.click();
        return this;
    }

    @Step("Check if error appeared")
    public SauceDemoAuthorizationSteps checkErrorAppeared(){
        errorMessage.shouldBe(visible);
        return this;
    }
    public SauceDemoAuthorizationSteps checkRedXAppeared(){
        redXButton.shouldBe(visible);
        return this;
    }

    @Step("Validate username field text: {0}")
    public SauceDemoAuthorizationSteps validateUserNameFieldText(String text){
        userNameField.shouldHave(new AttributeWithValue(attributeValue, text));
        return this;
    }

    @Step("Validate password field text: {0}")
    public SauceDemoAuthorizationSteps validatePasswordFieldText(String text){
        passwordField.shouldHave(new AttributeWithValue(attributeValue, text));
        return this;
    }
}
