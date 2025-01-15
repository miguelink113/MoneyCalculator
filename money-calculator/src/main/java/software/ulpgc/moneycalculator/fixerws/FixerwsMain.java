package software.ulpgc.moneycalculator.fixerws;

import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.ExchangeRate;

import java.util.List;

public class FixerwsMain {
    public static void main(String[] args) {

        System.out.println("Currencies:");
        CurrencyLoader currencyLoader = new FixerCurrencyLoader();
        List<Currency> currencies = currencyLoader.load();
        for (Currency currency : currencies) {
            System.out.println(currency);
        }
        System.out.println();
        System.out.println("Exchange rate for USD to JPY:");
        Currency fromCurrency = null;
        Currency toCurrency = null;

        for (Currency currency : currencies) {
            if (currency.code().equals("USD")) {
                fromCurrency = currency;
            } else if (currency.code().equals("JPY")) {
                toCurrency = currency;
            }
        }

        if (fromCurrency != null && toCurrency != null) {
            ExchangeRateLoader exchangeRateLoader = new FixerExchangeRateLoader();
            ExchangeRate exchangeRate = exchangeRateLoader.load(fromCurrency, toCurrency);
            System.out.println("Exchange Rate from " + fromCurrency + " to " + toCurrency + ": " + exchangeRate);
        } else {
            System.out.println("One or both currencies not found.");
        }
    }
}
