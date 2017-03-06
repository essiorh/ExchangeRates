package developer.essiorh.exchangerates.data.rest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class RateRest {

    //FIXME need to change this structure to a HashMap in the future
    @SerializedName(RestConst.ResponseFields.AUD)
    private float aud;
    @SerializedName(RestConst.ResponseFields.BGN)
    private float bgn;
    @SerializedName(RestConst.ResponseFields.BRL)
    private float brl;
    @SerializedName(RestConst.ResponseFields.CAD)
    private float cad;
    @SerializedName(RestConst.ResponseFields.CHF)
    private float chf;
    @SerializedName(RestConst.ResponseFields.CNY)
    private float cny;
    @SerializedName(RestConst.ResponseFields.CZK)
    private float czk;
    @SerializedName(RestConst.ResponseFields.DKK)
    private float dkk;
    @SerializedName(RestConst.ResponseFields.GBP)
    private float gbp;
    @SerializedName(RestConst.ResponseFields.HKD)
    private float hkd;
    @SerializedName(RestConst.ResponseFields.HRK)
    private float hrk;
    @SerializedName(RestConst.ResponseFields.HUF)
    private float huf;
    @SerializedName(RestConst.ResponseFields.IDR)
    private float idr;
    @SerializedName(RestConst.ResponseFields.ILS)
    private float ils;
    @SerializedName(RestConst.ResponseFields.INR)
    private float inr;
    @SerializedName(RestConst.ResponseFields.JPY)
    private float jpy;
    @SerializedName(RestConst.ResponseFields.KRW)
    private float krw;
    @SerializedName(RestConst.ResponseFields.MXN)
    private float mxn;
    @SerializedName(RestConst.ResponseFields.MYR)
    private float myr;
    @SerializedName(RestConst.ResponseFields.NOK)
    private float nok;
    @SerializedName(RestConst.ResponseFields.NZD)
    private float nzd;
    @SerializedName(RestConst.ResponseFields.PHP)
    private float php;
    @SerializedName(RestConst.ResponseFields.PLN)
    private float pln;
    @SerializedName(RestConst.ResponseFields.RON)
    private float ron;
    @SerializedName(RestConst.ResponseFields.RUB)
    private float rub;
    @SerializedName(RestConst.ResponseFields.SEK)
    private float sek;
    @SerializedName(RestConst.ResponseFields.SGD)
    private float sgd;
    @SerializedName(RestConst.ResponseFields.THB)
    private float thb;
    @SerializedName(RestConst.ResponseFields.TRY)
    private float tryRate;
    @SerializedName(RestConst.ResponseFields.USD)
    private float usd;
    @SerializedName(RestConst.ResponseFields.ZAR)
    private float zar;

    public float getAud() {
        return aud;
    }

    public void setAud(float aud) {
        this.aud = aud;
    }

    public float getBgn() {
        return bgn;
    }

    public void setBgn(float bgn) {
        this.bgn = bgn;
    }

    public float getBrl() {
        return brl;
    }

    public void setBrl(float brl) {
        this.brl = brl;
    }

    public float getCad() {
        return cad;
    }

    public void setCad(float cad) {
        this.cad = cad;
    }

    public float getChf() {
        return chf;
    }

    public void setChf(float chf) {
        this.chf = chf;
    }

    public float getCny() {
        return cny;
    }

    public void setCny(float cny) {
        this.cny = cny;
    }

    public float getCzk() {
        return czk;
    }

    public void setCzk(float czk) {
        this.czk = czk;
    }

    public float getDkk() {
        return dkk;
    }

    public void setDkk(float dkk) {
        this.dkk = dkk;
    }

    public float getGbp() {
        return gbp;
    }

    public void setGbp(float gbp) {
        this.gbp = gbp;
    }

    public float getHkd() {
        return hkd;
    }

    public void setHkd(float hkd) {
        this.hkd = hkd;
    }

    public float getHrk() {
        return hrk;
    }

    public void setHrk(float hrk) {
        this.hrk = hrk;
    }

    public float getHuf() {
        return huf;
    }

    public void setHuf(float huf) {
        this.huf = huf;
    }

    public float getIdr() {
        return idr;
    }

    public void setIdr(float idr) {
        this.idr = idr;
    }

    public float getIls() {
        return ils;
    }

    public void setIls(float ils) {
        this.ils = ils;
    }

    public float getInr() {
        return inr;
    }

    public void setInr(float inr) {
        this.inr = inr;
    }

    public float getJpy() {
        return jpy;
    }

    public void setJpy(float jpy) {
        this.jpy = jpy;
    }

    public float getKrw() {
        return krw;
    }

    public void setKrw(float krw) {
        this.krw = krw;
    }

    public float getMxn() {
        return mxn;
    }

    public void setMxn(float mxn) {
        this.mxn = mxn;
    }

    public float getMyr() {
        return myr;
    }

    public void setMyr(float myr) {
        this.myr = myr;
    }

    public float getNok() {
        return nok;
    }

    public void setNok(float nok) {
        this.nok = nok;
    }

    public float getNzd() {
        return nzd;
    }

    public void setNzd(float nzd) {
        this.nzd = nzd;
    }

    public float getPhp() {
        return php;
    }

    public void setPhp(float php) {
        this.php = php;
    }

    public float getPln() {
        return pln;
    }

    public void setPln(float pln) {
        this.pln = pln;
    }

    public float getRon() {
        return ron;
    }

    public void setRon(float ron) {
        this.ron = ron;
    }

    public float getRub() {
        return rub;
    }

    public void setRub(float rub) {
        this.rub = rub;
    }

    public float getSek() {
        return sek;
    }

    public void setSek(float sek) {
        this.sek = sek;
    }

    public float getSgd() {
        return sgd;
    }

    public void setSgd(float sgd) {
        this.sgd = sgd;
    }

    public float getThb() {
        return thb;
    }

    public void setThb(float thb) {
        this.thb = thb;
    }

    public float getTryRate() {
        return tryRate;
    }

    public void setTryRate(float tryRate) {
        this.tryRate = tryRate;
    }

    public float getUsd() {
        return usd;
    }

    public void setUsd(float usd) {
        this.usd = usd;
    }

    public float getZar() {
        return zar;
    }

    public void setZar(float zar) {
        this.zar = zar;
    }
}
