public enum FlightsEnum {

    KABUL("KBL"),
    SYDNEY("SYD"),
    AMSTERDAM("AMS"),
    PORTO("OPO"),
    NEW_YORK("EWR");

    // KABUL (KBL), KBL1524; DURATION 17H, PRICE £634,
    // SYDNEY (SYD), SYD5743; DURATION 26H, PRICE £829
    // AMSTERDAM (AMS), AMS6667, DURATION 1H, PRICE £85
    // PORTO (OPO), OPO3324, DURATION 14H, PRICE £29
    // NEW YORK (EWR), EWR7877, DURATION 12H, PRICE £415

    private final String flightIDCode;


    FlightsEnum(String flightIDCode) {
        this.flightIDCode = flightIDCode;
    }

    public String getFlightIDCode() {
        return this.flightIDCode;
    }



}
