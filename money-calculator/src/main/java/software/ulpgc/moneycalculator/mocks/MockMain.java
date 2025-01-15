package software.ulpgc.moneycalculator.mocks;

import software.ulpgc.moneycalculator.controller.Command;
import software.ulpgc.moneycalculator.controller.ExchangeMoneyCommand;
import software.ulpgc.moneycalculator.fixerws.ExchangeRateLoader;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.view.CurrencyDialog;
import software.ulpgc.moneycalculator.view.MoneyDialog;
import software.ulpgc.moneycalculator.view.MoneyDisplay;

import java.util.List;

public class MockMain {
    public static void main(String[] args) {
        List<Currency> currencies = new MockCurrencyLoader().load();
        MoneyDialog moneyDialog = new MockMoneyDialog().define(currencies);
        CurrencyDialog currencyDialog = new MockCurrencyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        ExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader();
        Command command = new ExchangeMoneyCommand(moneyDialog, currencyDialog, exchangeRateLoader, moneyDisplay);
        command.execute();
    }
}
