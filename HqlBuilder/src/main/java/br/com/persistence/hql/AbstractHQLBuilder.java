package br.com.persistence.hql;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.util.Utils;

public abstract class AbstractHQLBuilder {

    public static Logger LOGGER;

    protected transient CustomStringBuilder builder = new CustomStringBuilder();

    public AbstractHQLBuilder(CustomStringBuilder builder) {
        this.builder = builder;
    }

    protected AbstractHQLBuilder() {
    }

    public final void appendArgs(String... args) {
        iterateAndAddFields(args);
    }

    public final void iterateAndAddFields(String... args) {
        for (int index = 0; index < args.length; index++) {
            if (index == 0) {
                builder.appendBackSpace(args[index]);
                continue;
            }
            builder.append(Utils.COMMA).appendBackSpace(args[index]);
        }

    }

    public String getQuery() {
        String query = builder.toString();
        LOGGER.info(query);
        return query;
    }

    public interface Operators {

        String SELECT = "SELECT";
        String NEW = "new";
        String FROM = "FROM";
        String ORDER_BY = "ORDER BY";
        String HAVING = "HAVING";
        String AND = "AND";
        String OR = "OR";
        String WHERE = "WHERE";
        String TRUE_CONDITION = "1=1";
        String EQUALS = "=";
        String GE = ">=";
        String LE = "<=";
        String IN = "IN";
        String LIKE = "LIKE";
        String LIKE_OPERATOR = "%";
        String HQL_OPERATOR = ":";
        String ASTERISC_OPERATOR = "*";
        String COUNT = "COUNT";
        String SUM = "SUM";
        String MAX = "MAX";
        String MIN = "MIN";
        String AVERAGE = "AVERAGE";

    }

}
