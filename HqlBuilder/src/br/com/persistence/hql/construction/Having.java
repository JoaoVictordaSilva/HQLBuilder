package br.com.persistence.hql.construction;

import br.com.persistence.hql.AbstractHQLBuilder;
import br.com.persistence.hql.CustomStringBuilder;
import br.com.persistence.hql.interfaces.IClausule;
import br.com.persistence.hql.interfaces.IHaving;
import br.com.persistence.hql.interfaces.IOrderBy;
import br.com.persistence.hql.interfaces.IOrderByClausule;

public final class Having extends AbstractHQLBuilder implements IHaving {

    public Having(CustomStringBuilder builder) {
        super(builder);
    }

    @Override
    public String orderBy(IOrderByClausule orderBy) {
        return new OrderBy(builder).orderBy(orderBy);
    }

    @Override
    public IOrderBy having(IClausule clausule) {
        builder.appendBackSpace(Operators.HAVING).appendBackSpace(clausule.getClausule());
        return new OrderBy(builder);
    }

    @Override
    public String getClausule() {
        return super.getQuery();
    }
}
