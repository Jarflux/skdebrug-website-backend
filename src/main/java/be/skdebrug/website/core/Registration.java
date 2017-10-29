package be.skdebrug.website.core;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 21/10/2016
 */
public class Registration {

    private static final String QUIZ_DATUM = "17 Maart 2017";

    private String recipient;
    private String name;
    private String team;

    public Registration() {
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
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
        if(StringUtils.isBlank(team)){
            errors.add("Team moet ingevuld zijn");
        }
        return errors;
    }

    public String getBody() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("<title>Quiz SK De Brug</title>\n");
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
        sb.append("    Quiz SK De Brug: we hebben je inschrijving goed ontvangen.\n");
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
        sb.append("                                <td align=\"center\" style=\"font-size: 32px; font-family: Helvetica, Arial, sans-serif; font-weight: bold; color: #0089d0; padding-top: 15px;\" class=\"padding-copy\">Quiz SK De Brug</td>\n");
        sb.append("                            </tr>\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td align=\"center\" style=\"font-size: 16px; line-height: 20px; font-family: Helvetica, Arial, sans-serif; font-style: italic; color: #333333; padding-top: 15px;\" class=\"padding-copy\">" + QUIZ_DATUM + " <br/>Zaal Ars, Boomsesteenweg 333, Wilrijk</td>\n");
        sb.append("                            </tr>\n");
        sb.append("                            <tr>\n");
        sb.append("                                <td align=\"center\" style=\"font-size: 16px; line-height: 20px; font-family: Helvetica, Arial, sans-serif; color: #333333; padding-top: 15px;\" class=\"padding-copy\">Bevestiging inschrijving ploeg " + team + "\n");
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
        sb.append("                                            <td align=\"center\" style=\"padding: 0 0 0 0; font-size: 14px; line-height: 18px; font-family: Helvetica, Arial, sans-serif; color: #333333; font-style: italic;\" class=\"padding-copy\">Inschrijving op naam van " + name + " (" + recipient + ")</td>\n");
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
