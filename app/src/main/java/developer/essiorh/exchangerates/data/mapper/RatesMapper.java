package developer.essiorh.exchangerates.data.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

import developer.essiorh.exchangerates.data.db.Rate;
import developer.essiorh.exchangerates.data.db.RatesRealm;
import developer.essiorh.exchangerates.data.rest.RateRest;
import developer.essiorh.exchangerates.data.rest.RatesResponse;
import developer.essiorh.exchangerates.presentation.rates.RatesContainer;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

@Mapper
public abstract class RatesMapper {

    RatesRealm ratesResponseToRatesRealm(RatesResponse ratesResponse) {
        RatesRealm ratesRealm = new RatesRealm();
        ratesRealm.setDate(ratesResponse.getDate());
        ratesRealm.setBase(ratesResponse.getBase());
        ratesRealm.setRates(rateRestToRate(ratesResponse.getRates()));
        return ratesRealm;
    }

    @AfterMapping
    void helpForMapRealmRates(RatesRealm ratesRealm,
                                     @MappingTarget RatesContainer ratesContainer) {
        Rate rates = ratesRealm.getRates();
        ratesContainer.setRatesPreview(getRateHumanReadable(rates.getAud(), rates.getBgn(),
                rates.getBrl(), rates.getCad(), rates.getChf(), rates.getCny(), rates.getCzk(),
                rates.getDkk(), rates.getGbp(), rates.getHkd(), rates.getHrk(), rates.getHuf(),
                rates.getIdr(), rates.getIls(), rates.getInr(), rates.getJpy(), rates.getKrw(),
                rates.getMxn(), rates.getMyr(), rates.getNok(), rates.getNzd(), rates.getPhp(),
                rates.getPln(), rates.getRon(), rates.getRub(), rates.getSek(), rates.getSgd(),
                rates.getThb(), rates.getTryRate(), rates.getUsd(), rates.getZar()));
    }

    @AfterMapping
    void helpForMapRestRates(RatesResponse ratesResponse,
                                    @MappingTarget RatesContainer ratesContainer) {
        RateRest rates = ratesResponse.getRates();
        ratesContainer.setRatesPreview(getRateHumanReadable(rates.getAud(), rates.getBgn(),
                rates.getBrl(), rates.getCad(), rates.getChf(), rates.getCny(), rates.getCzk(),
                rates.getDkk(), rates.getGbp(), rates.getHkd(), rates.getHrk(), rates.getHuf(),
                rates.getIdr(), rates.getIls(), rates.getInr(), rates.getJpy(), rates.getKrw(),
                rates.getMxn(), rates.getMyr(), rates.getNok(), rates.getNzd(), rates.getPhp(),
                rates.getPln(), rates.getRon(), rates.getRub(), rates.getSek(), rates.getSgd(),
                rates.getThb(), rates.getTryRate(), rates.getUsd(), rates.getZar()));
    }

    public abstract RatesContainer ratesRealmToRatesContainer(RatesRealm ratesRealm);

    public abstract RatesContainer ratesResponseToRatesContainer(RatesResponse ratesResponse);

    public abstract Rate rateRestToRate(RateRest rateRest);

    public abstract List<RatesRealm> ratesResponsesToRatesRealms(
            List<RatesResponse> ratesResponseList);

    public abstract List<RatesContainer> ratesResponsesToRatesContainers(
            List<RatesResponse> ratesResponseList);

    public abstract List<RatesContainer> ratesRealmsToRatesContainers(
            List<RatesRealm> ratesRealmList);

    private String getRateHumanReadable(float aud, float bgn, float brl, float cad, float chf,
                                        float cny, float czk, float dkk, float gbp, float hkd,
                                        float hrk, float huf, float idr, float ils, float inr,
                                        float jpy, float krw, float mxn, float myr, float nok,
                                        float nzd, float php, float pln, float ron, float rub,
                                        float sek, float sgd, float thb, float tryRate,
                                        float usd, float zar) {

        return String.format("AUD = %s, BGN = %s\nBRL = %s, CAD = %s\nCHF = %s, CNY = %s\n" +
                        "CZK = %s, DKK = %s\nGBP = %s, HKD = %s\nHRK = %s, HUF = %s\nIDR = %s," +
                        " ILS = %s\nINR = %s, JPY = %s\nKRW = %s, MXN = %s\nMYR = %s, NOK = %s" +
                        "\nNZD = %s, PHP = %s\nPLN = %s, RON = %s\nRUB = %s, SEK = %s\n" +
                        "SGD = %s, THB = %s\nTRY = %s, USD = %s\nZAR = %s",
                aud, bgn, brl, cad, chf, cny, czk, dkk, gbp, hkd, hrk, huf, idr, ils, inr, jpy, krw,
                mxn, myr, nok, nzd, php, pln, ron, rub, sek, sgd, thb, tryRate, usd, zar);
    }
}
