package be.skdebrug.website.core;

import org.joda.time.DateTime;

/**
 * Developer: Ben Oeyen
 * Date: 21/10/2016
 */
public class Reservation {

    private static final double pastaPrice = 9.0;
    private static final double veggiePrice = 9.0;
    private static final double childPrice = 5.0;
    private static final double dessertPrice = 3.5;
    private static final double lookbroodPrice = 2.5;

    private String recipient;
    private String name;
    private String time; // ["18u - 19u", "19u - 20u","20u - 21u"]
    private int pasta;
    private int veggie;
    private int child;
    private int dessert;
    private int lookbrood;

    public Reservation() {
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPasta() {
        return pasta;
    }

    public void setPasta(int pasta) {
        this.pasta = pasta;
    }

    public int getVeggie() {
        return veggie;
    }

    public void setVeggie(int veggie) {
        this.veggie = veggie;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public int getDessert() {
        return dessert;
    }

    public void setDessert(int dessert) {
        this.dessert = dessert;
    }

    public int getLookbrood() {
        return lookbrood;
    }

    public void setLookbrood(int lookbrood) {
        this.lookbrood = lookbrood;
    }

    public String getBody() {
        return "<html><body>" +
                "<h2>Pasta Catenaccio Reservatie op naam " + name + "</h2>" +
                "<ul><li>Lookbrood "  + pasta +  " x " + pastaPrice + " &euro; = " + pasta*pastaPrice + " &euro;</li></ul>"+
                "<p> Totaal " + 23 + "&euro;</p>" +
                "</body></html>";
    }
}
