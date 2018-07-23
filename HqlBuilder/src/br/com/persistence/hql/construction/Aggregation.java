package br.com.persistence.hql.construction;

import br.com.persistence.hql.AbstractHQLBuilder;
import br.com.persistence.hql.interfaces.IAggregation;

import static br.com.persistence.hql.AbstractHQLBuilder.Operators.*;
import static br.com.util.Utils.*;


public class Aggregation extends AbstractHQLBuilder implements IAggregation {

    @Override
    public IAggregation sum(String field) {
        appendParentheses(SUM, field);
        return this;
    }

    @Override
    public IAggregation count() {
        appendParentheses(COUNT, ASTERISC_OPERATOR);
        return this;
    }

    @Override
    public IAggregation count(String field) {
        appendParentheses(COUNT, field);
        return this;
    }

    @Override
    public IAggregation min(String field) {
        appendParentheses(MIN, field);
        return this;
    }

    @Override
    public IAggregation max(String field) {
        appendParentheses(MAX, field);
        return this;
    }

    @Override
    public IAggregation average(String field) {
        appendParentheses(AVERAGE, field);
        return this;
    }

    @Override
    public String getClausule() {
        return builder.toString();
    }

    private void appendParentheses(String operator, String field) {
        builder.appendBackSpace(operator).append(OPEN_PARENTHESES).append(field).append(CLOSE_PARENTHESES);
    }

}
