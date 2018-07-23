package br.com.persistence.hql.construction;

import br.com.persistence.hql.AbstractHQLBuilder;
import br.com.persistence.hql.CustomStringBuilder;
import br.com.persistence.hql.interfaces.IGroupBy;
import br.com.persistence.hql.interfaces.IHaving;
import br.com.persistence.hql.interfaces.IOrderByClausule;

public final class GroupBy extends AbstractHQLBuilder implements IGroupBy {

    private static final String GROUP_BY = "GROUP BY";

    public GroupBy(CustomStringBuilder builder) {
        super(builder);
    }

    @Override
    public IHaving groupBy(String... groupBy) {
        builder.appendSpace(GROUP_BY);
        appendGroupBy(groupBy);
        return new Having(builder);
    }

    private void appendGroupBy(String... groupBy) {
        iterateAndAddFields(groupBy);
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
