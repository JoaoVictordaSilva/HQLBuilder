package br.com.persistence.hql.construction;

import br.com.persistence.hql.AbstractHQLBuilder;
import br.com.persistence.hql.CustomStringBuilder;
import br.com.persistence.hql.interfaces.IOrderBy;
import br.com.persistence.hql.interfaces.IOrderByClausule;

public final class OrderBy extends AbstractHQLBuilder implements IOrderBy {


    public OrderBy(CustomStringBuilder builder) {
        super(builder);
    }

    @Override
    public String orderBy(IOrderByClausule orderBy) {
        builder.appendBackSpace(Operators.ORDER_BY).append(orderBy.getClausule());
        return this.getClausule();
    }

    @Override
    public String getClausule() {
        return super.getQuery();
    }

}
