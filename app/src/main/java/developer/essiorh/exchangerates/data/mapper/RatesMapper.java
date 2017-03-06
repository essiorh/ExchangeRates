package developer.essiorh.exchangerates.data.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Map;

import developer.essiorh.exchangerates.data.db.Rate;
import developer.essiorh.exchangerates.data.db.RatesRealm;
import developer.essiorh.exchangerates.data.rest.RatesResponse;
import developer.essiorh.exchangerates.presentation.rates.RatesContainer;
import io.realm.RealmList;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

@Mapper
public abstract class RatesMapper {

    @AfterMapping
    void helpForMapRestToRealm(RatesResponse ratesResponse,
                                   @MappingTarget RatesRealm ratesRealm) {
        Map<String, Float> ratesMap = ratesResponse.getRates();
        RealmList<Rate> listRate = new RealmList<>();
        for (String key : ratesMap.keySet()) {
            Rate rate = new Rate();
            rate.setCurrency(key);
            float value = ratesMap.get(key);
            rate.setValue(value);
            listRate.add(rate);
        }
        ratesRealm.setRatesList(listRate);
    }

    @AfterMapping
    void helpForMapRealmRates(RatesRealm ratesRealm,
                             @MappingTarget RatesContainer ratesContainer) {
        RealmList<Rate> ratesList = ratesRealm.getRatesList();
        StringBuilder preview = new StringBuilder();
        for (Rate rate : ratesList) {
            append(preview, rate.getCurrency(), rate.getValue());
        }
        ratesContainer.setRatesPreview(preview.toString());
    }

    @AfterMapping
    void helpForMapResponseRates(RatesResponse ratesResponse,
                             @MappingTarget RatesContainer ratesContainer) {
        Map<String, Float> ratesMap = ratesResponse.getRates();
        StringBuilder preview = new StringBuilder();
        for (String key : ratesMap.keySet()) {
            append(preview, key, ratesMap.get(key));
        }
        ratesContainer.setRatesPreview(preview.toString());
    }

    public abstract RatesRealm ratesResponseToRatesRealm(RatesResponse ratesResponse);

    public abstract RatesContainer ratesRealmToRatesContainer(RatesRealm ratesRealm);

    public abstract RatesContainer ratesResponseToRatesContainer(RatesResponse ratesResponse);

    public abstract List<RatesRealm> ratesResponsesToRatesRealms(
            List<RatesResponse> ratesResponseList);

    public abstract List<RatesContainer> ratesResponsesToRatesContainers(
            List<RatesResponse> ratesResponseList);

    public abstract List<RatesContainer> ratesRealmsToRatesContainers(
            List<RatesRealm> ratesRealmList);


    private void append(StringBuilder preview, String currency, float value) {
        preview.append(currency);
        preview.append(" = ");
        preview.append(String.valueOf(value));
        preview.append("\n");
    }
}
