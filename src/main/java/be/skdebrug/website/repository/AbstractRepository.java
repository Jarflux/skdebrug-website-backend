package be.skdebrug.website.repository;

import org.apache.commons.lang3.StringUtils;

/**
 * Developer: Ben Oeyen
 * Date: 02/08/15
 */
abstract class AbstractRepository {

    public static boolean dropDatabaseOnInjection = false;

    public String escapeSingleQuotes(String unescaped){
        return StringUtils.replace(unescaped, "'", "''");
    }
}
