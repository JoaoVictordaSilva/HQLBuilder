package br.com.persistence.hql.construction;

import br.com.persistence.hql.AbstractHQLBuilder;
import br.com.persistence.hql.CustomStringBuilder;
import br.com.persistence.hql.interfaces.*;

public final class Join extends AbstractHQLBuilder implements IJoin {

    public Join(CustomStringBuilder builder) {
        super(builder);
    }

    @Override
    public IJoin join(String field) {
        appendJoin(JoinType.INNER).appendBackSpace(field);
        return this;
    }

    @Override
    public IJoin leftJoin(String field) {
        appendJoin(JoinType.LEFT).appendBackSpace(field);
        return this;
    }

    @Override
    public IJoin rightJoin(String field) {
        appendJoin(JoinType.RIGHT).appendBackSpace(field);
        return this;
    }

    @Override
    public IJoin joinFetch(String field) {
        appendJoin(JoinType.JOIN_FETCH).appendBackSpace(field);
        return this;
    }

    @Override
    public IJoin alias(String alias) {
        builder.appendBackSpace(alias);
        return this;
    }

    private CustomStringBuilder appendJoin(JoinType joinType) {
        switch (joinType) {
            case LEFT:
                builder.appendBackSpace(JoinType.LEFT.getJoin());
                break;
            case RIGHT:
                builder.appendBackSpace(JoinType.RIGHT.getJoin());
                break;
            case JOIN_FETCH:
                builder.appendBackSpace(JoinType.JOIN_FETCH.getJoin());
                break;
            default:
                builder.appendBackSpace(JoinType.INNER.getJoin());
                break;
        }
        return builder;
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

}
