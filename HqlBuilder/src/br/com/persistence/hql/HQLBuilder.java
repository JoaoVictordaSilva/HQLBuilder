package br.com.persistence.hql;

import br.com.persistence.hql.construction.GroupBy;
import br.com.persistence.hql.construction.Join;
import br.com.persistence.hql.construction.OrderBy;
import br.com.persistence.hql.construction.Where;
import br.com.persistence.hql.interfaces.*;
import br.com.util.Utils;

import java.util.logging.Logger;

import static br.com.util.Utils.COMMA;
import static br.com.util.Utils.verifyFieldsToBeReturned;

public final class HQLBuilder extends AbstractHQLBuilder implements ISelect {

    private final Class<?> clazz;

    public HQLBuilder(Class<?> clazz) {
        builder.append(Operators.SELECT);
        this.clazz = clazz;
        LOGGER = Logger.getLogger(this.clazz.getCanonicalName());
    }

    @Override
    public IJoin select() {
        builder.appendBackSpace("obj");
        appendFrom(clazz.getSimpleName());
        builder.appendBackSpace("obj");
        return new Join(builder);
    }

    @Override
    public IJoin select(IAggregation agregation) {
        builder.append(agregation.getClausule());
        appendFrom(clazz.getSimpleName());
        return new Join(builder);
    }

    @Override
    public IJoin select(IAggregation agregation, String... fields) {
        verifyFieldsToBeReturned(fields);
        builder.append(agregation.getClausule()).append(COMMA);
        appendArgs(fields);
        appendFrom(clazz.getSimpleName());
        return new Join(builder);
    }

    @Override
    public IJoin selectNew(String... fields) {
        selectNew(clazz, fields);
        return new Join(builder);
    }

    @Override
    public IJoin selectNew(Class<?> aClazz, String... fields) {
        appendSelectNew(aClazz, fields);
        return new Join(builder);
    }

    @Override
    public IJoin join(String field) {
        return new Join(builder).join(field);
    }

    @Override
    public IJoin leftJoin(String field) {
        return new Join(builder).leftJoin(field);
    }

    @Override
    public IJoin rightJoin(String field) {
        return new Join(builder).rightJoin(field);
    }

    @Override
    public IJoin joinFetch(String field) {
        return new Join(builder).joinFetch(field);
    }

    @Override
    public IJoin alias(String alias) {
        return new Join(builder).alias(alias);
    }

    @Override
    public IGroupBy where(IClausule clausule) {
        return new Where(builder).where(clausule);
    }

    @Override
    public IHaving groupBy(String... groupBy) {
        return new GroupBy(builder).groupBy(groupBy);
    }


    @Override
    public String orderBy(IOrderByClausule orderBy) {
        return new OrderBy(builder).orderBy(orderBy);
    }

    @Override
    public String getClausule() {
        return super.getQuery();
    }

    private void appendSelectNew(Class<?> aClazz, String... fields) {
        verifyFieldsToBeReturned(fields);
        builder.appendBackSpace(Operators.NEW).appendBackSpace(aClazz.getCanonicalName()).append(Utils.OPEN_PARENTHESES);
        appendArgs(fields);
        builder.append(Utils.CLOSE_PARENTHESES);
        appendFrom(clazz.getSimpleName());
    }

    private void appendFrom(String from) {
        builder.appendBackSpace(Operators.FROM).appendBackSpace(from);
    }

}
