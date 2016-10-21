package be.skdebrug.website.core;

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

    public double getTotal(){
        return lookbrood*lookbroodPrice + pasta*pastaPrice + veggie*veggiePrice + child*childPrice + dessert*dessertPrice;
    }

    public String getBody() {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Pasta Catenaccio</title>\n" +
                "<!--\n" +
                "\n" +
                "    An email present from your friends at Litmus (@litmusapp)\n" +
                "\n" +
                "    Email is surprisingly hard. While this has been thoroughly tested, your mileage may vary.\n" +
                "    It's highly recommended that you test using a service like Litmus (http://litmus.com) and your own devices.\n" +
                "\n" +
                "    Enjoy!\n" +
                "\n" +
                " -->\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "<style type=\"text/css\">\n" +
                "    /* CLIENT-SPECIFIC STYLES */\n" +
                "    body, table, td, a{-webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%;} /* Prevent WebKit and Windows mobile changing default text sizes */\n" +
                "    table, td{mso-table-lspace: 0pt; mso-table-rspace: 0pt;} /* Remove spacing between tables in Outlook 2007 and up */\n" +
                "    img{-ms-interpolation-mode: bicubic;} /* Allow smoother rendering of resized image in Internet Explorer */\n" +
                "\n" +
                "    /* RESET STYLES */\n" +
                "    img{border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none;}\n" +
                "    table{border-collapse: collapse !important;}\n" +
                "    body{height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important;}\n" +
                "\n" +
                "    /* iOS BLUE LINKS */\n" +
                "    a[x-apple-data-detectors] {\n" +
                "        color: inherit !important;\n" +
                "        text-decoration: none !important;\n" +
                "        font-size: inherit !important;\n" +
                "        font-family: inherit !important;\n" +
                "        font-weight: inherit !important;\n" +
                "        line-height: inherit !important;\n" +
                "    }\n" +
                "\n" +
                "    /* MOBILE STYLES */\n" +
                "    @media screen and (max-width: 525px) {\n" +
                "\n" +
                "        /* ALLOWS FOR FLUID TABLES */\n" +
                "        .wrapper {\n" +
                "          width: 100% !important;\n" +
                "            max-width: 100% !important;\n" +
                "        }\n" +
                "\n" +
                "        /* ADJUSTS LAYOUT OF LOGO IMAGE */\n" +
                "        .logo img {\n" +
                "          margin: 0 auto !important;\n" +
                "        }\n" +
                "\n" +
                "        /* USE THESE CLASSES TO HIDE CONTENT ON MOBILE */\n" +
                "        .mobile-hide {\n" +
                "          display: none !important;\n" +
                "        }\n" +
                "\n" +
                "        .img-max {\n" +
                "          max-width: 100% !important;\n" +
                "          width: 100% !important;\n" +
                "          height: auto !important;\n" +
                "        }\n" +
                "\n" +
                "        /* FULL-WIDTH TABLES */\n" +
                "        .responsive-table {\n" +
                "          width: 100% !important;\n" +
                "        }\n" +
                "\n" +
                "        /* UTILITY CLASSES FOR ADJUSTING PADDING ON MOBILE */\n" +
                "        .padding {\n" +
                "          padding: 10px 5% 15px 5% !important;\n" +
                "        }\n" +
                "\n" +
                "        .padding-meta {\n" +
                "          padding: 30px 5% 0px 5% !important;\n" +
                "          text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .padding-copy {\n" +
                "             padding: 10px 5% 10px 5% !important;\n" +
                "          text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        .no-padding {\n" +
                "          padding: 0 !important;\n" +
                "        }\n" +
                "\n" +
                "        .section-padding {\n" +
                "          padding: 50px 15px 50px 15px !important;\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    /* ANDROID CENTER FIX */\n" +
                "    div[style*=\"margin: 16px 0;\"] { margin: 0 !important; }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body style=\"margin: 0 !important; padding: 0 !important;\">\n" +
                "\n" +
                "<!-- HIDDEN PREHEADER TEXT -->\n" +
                "<div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\n" +
                "    Pasta Catenaccio: we hebben je reservatie goed ontvangen.\n" +
                "</div>\n" +
                "\n" +
                "<!-- HEADER -->\n" +
                "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "    <tr>\n" +
                "        <td bgcolor=\"#ffffff\" align=\"center\">\n" +
                "            <!--[if (gte mso 9)|(IE)]>\n" +
                "            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"500\">\n" +
                "            <tr>\n" +
                "            <td align=\"center\" valign=\"top\" width=\"500\">\n" +
                "            <![endif]-->\n" +
                "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 500px;\" class=\"wrapper\">\n" +
                "                <tr>\n" +
                "                    <td align=\"center\" valign=\"top\" style=\"padding: 15px 0; border-bottom: 1px solid #f5f5f5\" class=\"logo\">\n" +
                "                        <a href=\"http://skdebrug.be\" target=\"_blank\">\n" +
                "                            <img alt=\"SK De Brug\" src=\"http://skdebrug.be/images/logo.png\" width=\"60\" height=\"60\" style=\"display: block; font-family: Helvetica, Arial, sans-serif; color: #ffffff; font-size: 16px;\" border=\"0\">\n" +
                "                        </a>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "            <!--[if (gte mso 9)|(IE)]>\n" +
                "            </td>\n" +
                "            </tr>\n" +
                "            </table>\n" +
                "            <![endif]-->\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px;\">\n" +
                "            <!--[if (gte mso 9)|(IE)]>\n" +
                "            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"500\">\n" +
                "            <tr>\n" +
                "            <td align=\"center\" valign=\"top\" width=\"500\">\n" +
                "            <![endif]-->\n" +
                "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 500px;\" class=\"responsive-table\">\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <!-- COPY -->\n" +
                "                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                            <tr>\n" +
                "                                <td align=\"center\" style=\"font-size: 32px; font-family: Helvetica, Arial, sans-serif; font-weight: bold; color: #0089d0; padding-top: 15px;\" class=\"padding-copy\">Pasta Catenaccio</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td align=\"center\" style=\"font-size: 16px; line-height: 20px; font-family: Helvetica, Arial, sans-serif; font-style: italic; color: #333333; padding-top: 15px;\" class=\"padding-copy\">19 November 2016, " + time + "<br/>Zaal Ars, Boomsesteenweg 333, Wilrijk</td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "            <!--[if (gte mso 9)|(IE)]>\n" +
                "            </td>\n" +
                "            </tr>\n" +
                "            </table>\n" +
                "            <![endif]-->\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px;\" class=\"padding\">\n" +
                "            <!--[if (gte mso 9)|(IE)]>\n" +
                "            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"500\">\n" +
                "            <tr>\n" +
                "            <td align=\"center\" valign=\"top\" width=\"500\">\n" +
                "            <![endif]-->\n" +
                "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 500px;\" class=\"responsive-table\">\n" +
                "                <tr>\n" +
                "                    <td style=\"padding: 10px 0 0 0; border-top: 1px dashed #0089d0;\">\n" +
                "                        <!-- TWO COLUMNS -->\n" +
                "                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
                "                            <tr>\n" +
                "                                <td valign=\"top\" class=\"mobile-wrapper\">\n" +
                "                                    <!-- LEFT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">Lookbroodjes</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <!-- RIGHT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">"+lookbrood+" x &euro; "+lookbroodPrice+"</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px;\">&euro; "+lookbrood*lookbroodPrice+"</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"padding: 0 0 0 0;\">\n" +
                "                        <!-- TWO COLUMNS -->\n" +
                "                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
                "                            <tr>\n" +
                "                                <td valign=\"top\" class=\"mobile-wrapper\">\n" +
                "                                    <!-- LEFT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">Spaghetti Bolognese</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <!-- RIGHT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">"+pasta+" x &euro; "+pastaPrice+"</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px;\">&euro; "+pasta*pastaPrice+"</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"padding: 0 0 0 0;\">\n" +
                "                        <!-- TWO COLUMNS -->\n" +
                "                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
                "                            <tr>\n" +
                "                                <td valign=\"top\" class=\"mobile-wrapper\">\n" +
                "                                    <!-- LEFT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">Spaghetti Veggie</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <!-- RIGHT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">"+veggie+" x &euro; "+veggiePrice+"</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px;\">&euro; " + veggie*veggiePrice + "</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"padding: 0 0 0 0;\">\n" +
                "                        <!-- TWO COLUMNS -->\n" +
                "                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
                "                            <tr>\n" +
                "                                <td valign=\"top\" class=\"mobile-wrapper\">\n" +
                "                                    <!-- LEFT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">Kinder Spaghetti Bolognese</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <!-- RIGHT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">" + child + " x &euro; "+ childPrice +"</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px;\">&euro; " + child*childPrice + "</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"padding: 0 0 0 0;\">\n" +
                "                        <!-- TWO COLUMNS -->\n" +
                "                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
                "                            <tr>\n" +
                "                                <td valign=\"top\" class=\"mobile-wrapper\">\n" +
                "                                    <!-- LEFT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">Dessertenbuffet</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <!-- RIGHT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px;\">" + dessert + " x &euro; " + dessertPrice + "</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px;\">&euro; " + dessert * dessertPrice + "</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td style=\"padding: 10px 0 0px 0; border-top: 1px solid #f5f5f5; border-bottom: 1px dashed #0089d0;\">\n" +
                "                        <!-- TWO COLUMNS -->\n" +
                "                        <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">\n" +
                "                            <tr>\n" +
                "                                <td valign=\"top\" class=\"mobile-wrapper\">\n" +
                "                                    <!-- LEFT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"left\">\n" +
                "                                        <tr>\n" +
                "                                            <td style=\"padding: 0 0 10px 0;\">\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"left\" style=\"font-family: Arial, sans-serif; color: #333333; font-size: 16px; font-weight: bold;\">Totaal</td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                    <!-- RIGHT COLUMN -->\n" +
                "                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"47%\" style=\"width: 47%;\" align=\"right\">\n" +
                "                                        <tr>\n" +
                "                                            <td>\n" +
                "                                                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
                "                                                    <tr>\n" +
                "                                                        <td align=\"right\" style=\"font-family: Arial, sans-serif; color: #0089d0; font-size: 16px; font-weight: bold;\">&euro; " + getTotal() + " </td>\n" +
                "                                                    </tr>\n" +
                "                                                </table>\n" +
                "                                            </td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "            <!--[if (gte mso 9)|(IE)]>\n" +
                "            </td>\n" +
                "            </tr>\n" +
                "            </table>\n" +
                "            <![endif]-->\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 15px;\">\n" +
                "            <!--[if (gte mso 9)|(IE)]>\n" +
                "            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"500\">\n" +
                "            <tr>\n" +
                "            <td align=\"center\" valign=\"top\" width=\"500\">\n" +
                "            <![endif]-->\n" +
                "            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 500px;\" class=\"responsive-table\">\n" +
                "                <tr>\n" +
                "                    <td>\n" +
                "                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                            <tr>\n" +
                "                                <td>\n" +
                "                                    <!-- COPY -->\n" +
                "                                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                        <tr>\n" +
                "                                            <td align=\"center\" style=\"padding: 0 0 0 0; font-size: 14px; line-height: 18px; font-family: Helvetica, Arial, sans-serif; color: #333333; font-style: italic;\" class=\"padding-copy\">Reservatie op naam van " + name + " (" + recipient + ")</td>\n" +
                "                                        </tr>\n" +
                "                                    </table>\n" +
                "                                </td>\n" +
                "                            </tr>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "            <!--[if (gte mso 9)|(IE)]>\n" +
                "            </td>\n" +
                "            </tr>\n" +
                "            </table>\n" +
                "            <![endif]-->\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}
