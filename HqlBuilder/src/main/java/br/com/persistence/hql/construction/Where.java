package br.com.persistence.hql.construction;

import br.com.persistence.hql.AbstractHQLBuilder;
import br.com.persistence.hql.CustomStringBuilder;
import br.com.persistence.hql.interfaces.*;

import static br.com.persistence.hql.AbstractHQLBuilder.Operators.*;


public final class Where extends AbstractHQLBuilder implements IWhere {

    public Where(CustomStringBuilder builder) {
        super(builder);
    }

    @Override
    public IGroupBy where(IClausule clausule) {
        builder.appendBackSpace(WHERE).appendBackSpace(TRUE_CONDITION).appendBackSpace(AND).append(clausule.getClausule());
        return new GroupBy(builder);
    }

    @Override
    public IHaving groupBy(String... groupBy) {
        return null;
    }

    @Override
    public String orderBy(IOrderByClausule orderBy) {
        return new OrderBy(builder).orderBy(orderBy);
    }

    @Override
    public String getClausule() {
        return super.getQuery();
    }

}
