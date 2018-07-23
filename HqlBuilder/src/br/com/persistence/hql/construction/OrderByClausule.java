package br.com.persistence.hql.construction;

import br.com.persistence.hql.CustomStringBuilder;
import br.com.persistence.hql.interfaces.IOrderByClausule;
import br.com.util.Utils;

import java.util.ArrayList;
import java.util.List;

public final class OrderByClausule implements IOrderByClausule {

    private String field;

    private Direction direction;

    private List<String> clausuleList = new ArrayList<>();
    private transient CustomStringBuilder builder;

    @Override
    public IOrderByClausule orderBy(String field) {
        this.field = field;
        this.direction = Direction.ASC;
        clausuleList.add(returnClausule());
        appendComma();
        return this;
    }

    @Override
    public IOrderByClausule orderBy(String field, Direction direction) {
        this.field = field;
        this.direction = direction;
        clausuleList.add(returnClausule());
        appendComma();
        return this;
    }

    private void appendComma() {
        builder = new CustomStringBuilder();
        for (int i = 0; i < clausuleList.size(); i++) {
            if (i == 0) {
                builder.append(clausuleList.get(i));
                continue;
            }
            builder.append(Utils.COMMA).append(clausuleList.get(i));
        }
    }

    private String returnClausule() {
        return new CustomStringBuilder().appendBackSpace(field).appendBackSpace(direction).toString();
    }

    @Override
    public String getClausule() {
        return builder.toString();
    }
}
