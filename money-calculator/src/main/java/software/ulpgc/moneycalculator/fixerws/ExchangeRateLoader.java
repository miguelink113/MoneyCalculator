package software.ulpgc.moneycalculator.fixerws;

import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
