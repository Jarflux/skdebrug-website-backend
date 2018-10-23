package be.skdebrug.website.core;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;
import java.util.List;

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
    private static final String PASTA_DATUM = "15 december 2018";

    private String recipient;
    private String name;
    private String time;
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

    private double getTotal() {
        return lookbrood * lookbroodPrice + pasta * pastaPrice + veggie * veggiePrice + child * childPrice + dessert * dessertPrice;
    }

    public List<String> validate(){
        List<String> errors = new ArrayList<>();
        if(StringUtils.isBlank(recipient)){
            errors.add("Email moet ingevuld zijn");
        }else{
            if(!EmailValidator.getInstance().isValid(recipient)){
                errors.add("Email is niet correct");
            }
        }
        if(StringUtils.isBlank(name)){
            errors.add("Naam moet ingevuld zijn");
        }
        if(!("18u - 19u".equals(time) || "19u - 20u".equals(time) || "20u - 21u".equals(time))){
            errors.add("Tijdstip moet gekozen zijn.");
        }
        if(lookbrood < 0){
           errors.add("Lookbrood aantal moet groter of gelijk aan 0 zijn");
        }
        if(pasta < 0){
            errors.add("Pasta aantal moet groter of gelijk aan 0 zijn");
        }
        if(veggie < 0){
            errors.add("Veggie aantal moet groter of gelijk aan 0 zijn");
        }
        if(child < 0){
            errors.add("Kinder aantal moet groter of gelijk aan 0 zijn");
        }
        if(dessert < 0) {
            errors.add("Dessert aantal moet groter of gelijk aan 0 zijn");
        }
        if(getTotal() <= 0){
            errors.add("Totaal moet groter dan 0 zijn");
        }
        return errors;
    }

    public String getBody() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("<title>Pasta Catenaccio</title>\n");
        sb.append("<!--\n");
        sb.append("\n");
        sb.append("    An email present from your friends at Litmus (@litmusapp)\n");
        sb.append("\n");
        sb.append("    Email is surprisingly hard. While this has been thoroughly tested, your mileage may vary.\n");
        sb.append("    It's highly recommended that you test using a service like Litmus (http://litmus.com) and your own devices.\n");
        sb.append("\n");
        sb.append("    Enjoy!\n");
        sb.append("\n");
        sb.append(" -->\n");
        sb.append("<meta charset=\"utf-8\">\n");
        sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
        sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
        sb.append("<style type=\"text/css\">\n");
        sb.append("    /* CLIENT-SPECIFIC STYLES */\n");
        sb.append("    body, table, td, a{-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;} /* Prevent WebKit and Windows mobile changing default text sizes */\n");
        sb.append("    table, td{mso-table-lspace: 0pt; mso-table-rspace: 0pt;} /* Remove spacing between tables in Outlook 2007 and up */\n");
        sb.append("    img{-ms-interpolation-mode: bicubic;} /* Allow smoother rendering of resized image in Internet Explorer */\n");
        sb.append("\n");
        sb.append("    /* RESET STYLES */\n");
        sb.append("    img{border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none;}\n");
        sb.append("    table{border-collapse: collapse !important;}\n");
        sb.append("    body{height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important;}\n");
        sb.append("\n");
        sb.append("    /* iOS BLUE LINKS */\n");
        sb.append("    a[x-apple-data-detectors] {\n");
        sb.append("        color: inherit !important;\n");
        sb.append("        text-decoration: none !important;\n");
        sb.append("        font-size: inherit !important;\n");
        sb.append("        font-family: inherit !important;\n");
        sb.append("        font-weight: inherit !important;\n");
        sb.append("        line-height: inherit !important;\n");
        sb.append("    }\n");
        sb.append("\n");
        sb.append("    /* MOBILE STYLES */\n");
        sb.append("    @media screen and (max-width: 525px) {\n");
        sb.append("\n");
        sb.append("        /* ALLOWS FOR FLUID TABLES */\n");
        sb.append("        .wrapper {\n");
        sb.append("          width: 100% !important;\n");
        sb.append("            max-width: 100% !important;\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("        /* ADJUSTS LAYOUT OF LOGO IMAGE */\n");
        sb.append("        .logo img {\n");
        sb.append("          margin: 0 auto !important;\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("        /* USE THESE CLASSES TO HIDE CONTENT ON MOBILE */\n");
        sb.append("        .mobile-hide {\n");
        sb.append("          display: none !important;\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("        .img-max {\n");
        sb.append("          max-width: 100% !important;\n");
        sb.append("          width: 100% !important;\n");
        sb.append("          height: auto !important;\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("        /* FULL-WIDTH TABLES */\n");
        sb.append("        .responsive-table {\n");
        sb.append("          width: 100% !important;\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("        /* UTILITY CLASSES FOR ADJUSTING PADDING ON MOBILE */\n");
        sb.append("        .padding {\n");
        sb.append("          padding: 10px 5% 15px 5% !important;\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("        .padding-meta {\n");
        sb.append("          padding: 30px 5% 0px 5% !important;\n");
        sb.append("          text-align: center;\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("        .padding-copy {\n");
        sb.append("             padding: 10px 5% 10px 5% !important;\n");
        sb.append("          text-align: center;\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("        .no-padding {\n");
        sb.append("          padding: 0 !important;\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("        .section-padding {\n");
        sb.append("          padding: 50px 15px 50px 15px !important;\n");
        sb.append("        }\n");
        sb.append("\n");
        sb.append("    }\n");
        sb.append("\n");
        sb.append("    /* ANDROID CENTER FIX */\n");
        sb.append("    div[style*=\"margin: 16px 0;\"] { margin: 0 !important; }\n");
        sb.append("</style>\n");
        sb.append("</head>\n");
        sb.append("<body style=\"margin: 0 !important; padding: 0 !important;\">\n");
        sb.append("\n");
        sb.append("<!-- HIDDEN PREHEADER TEXT -->\n");
        sb.append("<div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\n");
        sb.append("    Pasta Catenaccio: we hebben je reservatie goed ontvangen.\n");
        sb.append("</div>\n");
        sb.append("\n");
        sb.append("<!-- HEADER -->\n");
        sb.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n");
        sb.append("    <tr>\n");
        sb.append("        <td bgcolor=\"#ffffff\" align=\"center\">\n");
        sb.append("            <!--[if (gte mso 9)|(IE)]>\n");
        sb.append("            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"500\">\n");
        sb.append("            <tr>\n");
        sb.append("            <td align=\"center\" valign=\"top\" width=\"500\">\n");
        sb.append("            <![endif]-->\n");
        sb.append("            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 500px;\" class=\"wrapper\">\n");
        sb.append("                <tr>\n");
        sb.append("                    <td align=\"center\" valign=\"top\" style=\"padding: 15px 0; border-bottom: 1px solid #f5f5f5\" class=\"logo\">\n");
        sb.append("                        <a href=\"http://skdebrug.be\" target=\"_blank\">\n");
        sb.append("                            <img alt=\"SK De Brug\" src=\"http://skdebrug.be/images/logo.png\" width=\"60\" height=\"60\" style=\"display: block; font-family: Helvetica, Arial, sans-serif; color: #ffffff; font-size: 16px;\" border=\"0\">\n");
        sb.append("                        </a>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("            </table>\n");
        sb.append("            <!--[if (gte mso 9)|(IE)]>\n");
        sb.append("            </td>\n");
        sb.append("            </tr>\n");
        sb.append("            </table>\n");
        sb.append("            <![endif]-->\n");
        sb.append("        </td>\n");
        sb.append("    </tr>\n");
        sb.append("    <tr>\n");
        sb.append("        <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px;\">\n");
        sb.append("            <!--[if (gte mso 9)|(IE)]>\n");
        sb.append("            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"500\">\n");
        sb.append("            <tr>\n");
        sb.append("            <td align=\"center\" valign=\"top\" width=\"500\">\n");
        sb.append("            <![endif]-->\n");
        sb.append("            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 500px;\" class=\"responsive-table\">\n");
        sb.append("                <tr>\n");
        sb.append("                    <td>\n");
        sb.append("                        <!-- COPY -->\n");
        sb.append("                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td align=\"center\" style=\"font-size: 32px; font-family: Helvetica, Arial, sans-serif; font-weight: bold; color: #0089d0; padding-top: 15px;\" class=\"padding-copy\">Pasta Catenaccio</td>\n");
        sb.append("                            </tr>\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td align=\"center\" style=\"font-size: 16px; line-height: 20px; font-family: Helvetica, Arial, sans-serif; font-style: italic; color: #333333; padding-top: 15px;\" class=\"padding-copy\">" + PASTA_DATUM + ", " + time + "<br/>Zaal Ars, Boomsesteenweg 333, Wilrijk</td>\n");
        sb.append("                            </tr>\n");
        sb.append("                        </table>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("            </table>\n");
        sb.append("            <!--[if (gte mso 9)|(IE)]>\n");
        sb.append("            </td>\n");
        sb.append("            </tr>\n");
        sb.append("            </table>\n");
        sb.append("            <![endif]-->\n");
        sb.append("        </td>\n");
        sb.append("    </tr>\n");
        sb.append("    <tr>\n");
        sb.append("        <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px;\" class=\"padding\">\n");
        sb.append("            <!--[if (gte mso 9)|(IE)]>\n");
        sb.append("            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"500\">\n");
        sb.append("            <tr>\n");
        sb.append("            <td align=\"center\" valign=\"top\" width=\"500\">\n");
        sb.append("            <![endif]-->\n");
        sb.append("            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 500px;\" class=\"responsive-table\">\n");
        sb.append("                <tr>\n");
        sb.append("                    <td style=\"padding: 10px 0 0 0; border-top: 1px dashed #0089d0;\">\n");
        sb.append("                        <!-- TWO COLUMNS -->\n");
        sb.append("                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td valign=\"top\" class=\"mobile-wrapper\">\n");
        sb.append("                                    <!-- LEFT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">Lookbroodjes</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                    <!-- RIGHT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">" + lookbrood + " x &euro; " + lookbroodPrice + "</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px;\">&euro; " + lookbrood * lookbroodPrice + "</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                </td>\n");
        sb.append("                            </tr>\n");
        sb.append("                        </table>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("                <tr>\n");
        sb.append("                    <td style=\"padding: 0 0 0 0;\">\n");
        sb.append("                        <!-- TWO COLUMNS -->\n");
        sb.append("                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td valign=\"top\" class=\"mobile-wrapper\">\n");
        sb.append("                                    <!-- LEFT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">Spaghetti Bolognese</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                    <!-- RIGHT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">" + pasta + " x &euro; " + pastaPrice + "</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px;\">&euro; " + pasta * pastaPrice + "</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                </td>\n");
        sb.append("                            </tr>\n");
        sb.append("                        </table>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("                <tr>\n");
        sb.append("                    <td style=\"padding: 0 0 0 0;\">\n");
        sb.append("                        <!-- TWO COLUMNS -->\n");
        sb.append("                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td valign=\"top\" class=\"mobile-wrapper\">\n");
        sb.append("                                    <!-- LEFT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">Spaghetti Veggie</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                    <!-- RIGHT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">" + veggie + " x &euro; " + veggiePrice + "</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px;\">&euro; " + veggie * veggiePrice + "</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                </td>\n");
        sb.append("                            </tr>\n");
        sb.append("                        </table>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("                <tr>\n");
        sb.append("                    <td style=\"padding: 0 0 0 0;\">\n");
        sb.append("                        <!-- TWO COLUMNS -->\n");
        sb.append("                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td valign=\"top\" class=\"mobile-wrapper\">\n");
        sb.append("                                    <!-- LEFT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">Kinder Spaghetti</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                    <!-- RIGHT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">" + child + " x &euro; " + childPrice + "</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px;\">&euro; " + child * childPrice + "</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                </td>\n");
        sb.append("                            </tr>\n");
        sb.append("                        </table>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("                <tr>\n");
        sb.append("                    <td style=\"padding: 0 0 0 0;\">\n");
        sb.append("                        <!-- TWO COLUMNS -->\n");
        sb.append("                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td valign=\"top\" class=\"mobile-wrapper\">\n");
        sb.append("                                    <!-- LEFT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">Dessertenbuffet</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                    <!-- RIGHT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">" + dessert + " x &euro; " + dessertPrice + "</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px;\">&euro; " + dessert * dessertPrice + "</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                </td>\n");
        sb.append("                            </tr>\n");
        sb.append("                        </table>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("                <tr>\n");
        sb.append("                    <td style=\"padding: 10px 0 0px 0; border-top: 1px solid #f5f5f5; border-bottom: 1px dashed #0089d0;\">\n");
        sb.append("                        <!-- TWO COLUMNS -->\n");
        sb.append("                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td valign=\"top\" class=\"mobile-wrapper\">\n");
        sb.append("                                    <!-- LEFT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td style=\"padding: 0 0 10px 0;\">\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px; font-weight: bold;\">Totaal</td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                    <!-- RIGHT COLUMN -->\n");
        sb.append("                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td>\n");
        sb.append("                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n");
        sb.append("                                                    <tr>\n");
        sb.append("                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px; font-weight: bold;\">&euro; " + getTotal() + " </td>\n");
        sb.append("                                                    </tr>\n");
        sb.append("                                                </table>\n");
        sb.append("                                            </td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                </td>\n");
        sb.append("                            </tr>\n");
        sb.append("                        </table>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("            </table>\n");
        sb.append("            <!--[if (gte mso 9)|(IE)]>\n");
        sb.append("            </td>\n");
        sb.append("            </tr>\n");
        sb.append("            </table>\n");
        sb.append("            <![endif]-->\n");
        sb.append("        </td>\n");
        sb.append("    </tr>\n");
        sb.append("    <tr>\n");
        sb.append("        <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px;\">\n");
        sb.append("            <!--[if (gte mso 9)|(IE)]>\n");
        sb.append("            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"500\">\n");
        sb.append("            <tr>\n");
        sb.append("            <td align=\"center\" valign=\"top\" width=\"500\">\n");
        sb.append("            <![endif]-->\n");
        sb.append("            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 500px;\" class=\"responsive-table\">\n");
        sb.append("                <tr>\n");
        sb.append("                    <td>\n");
        sb.append("                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td>\n");
        sb.append("                                    <!-- COPY -->\n");
        sb.append("                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("                                        <tr>\n");
        sb.append("                                            <td align=\"center\" style=\"padding: 0 0 0 0; font-size: 14px; line-height: 18px; font-family: Helvetica, Arial, sans-serif; color: #333333; font-style: italic;\" class=\"padding-copy\">Reservatie op naam van " + name + " (" + recipient + ")</td>\n");
        sb.append("                                        </tr>\n");
        sb.append("                                    </table>\n");
        sb.append("                                </td>\n");
        sb.append("                            </tr>\n");
        sb.append("                        </table>\n");
        sb.append("                    </td>\n");
        sb.append("                </tr>\n");
        sb.append("            </table>\n");
        sb.append("            <!--[if (gte mso 9)|(IE)]>\n");
        sb.append("            </td>\n");
        sb.append("            </tr>\n");
        sb.append("            </table>\n");
        sb.append("            <![endif]-->\n");
        sb.append("        </td>\n");
        sb.append("    </tr>\n");
        sb.append("</table>\n");
        sb.append("\n");
        sb.append("</body>\n");
        sb.append("</html>");
        return sb.toString();
    }
}
