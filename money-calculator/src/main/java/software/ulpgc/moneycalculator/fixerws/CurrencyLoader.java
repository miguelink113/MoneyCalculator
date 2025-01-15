package software.ulpgc.moneycalculator.fixerws;

import software.ulpgc.moneycalculator.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
