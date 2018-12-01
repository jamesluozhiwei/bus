package com.whx.bus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WayExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTopenIsNull() {
            addCriterion("topen is null");
            return (Criteria) this;
        }

        public Criteria andTopenIsNotNull() {
            addCriterion("topen is not null");
            return (Criteria) this;
        }

        public Criteria andTopenEqualTo(Date value) {
            addCriterion("topen =", value, "topen");
            return (Criteria) this;
        }

        public Criteria andTopenNotEqualTo(Date value) {
            addCriterion("topen <>", value, "topen");
            return (Criteria) this;
        }

        public Criteria andTopenGreaterThan(Date value) {
            addCriterion("topen >", value, "topen");
            return (Criteria) this;
        }

        public Criteria andTopenGreaterThanOrEqualTo(Date value) {
            addCriterion("topen >=", value, "topen");
            return (Criteria) this;
        }

        public Criteria andTopenLessThan(Date value) {
            addCriterion("topen <", value, "topen");
            return (Criteria) this;
        }

        public Criteria andTopenLessThanOrEqualTo(Date value) {
            addCriterion("topen <=", value, "topen");
            return (Criteria) this;
        }

        public Criteria andTopenIn(List<Date> values) {
            addCriterion("topen in", values, "topen");
            return (Criteria) this;
        }

        public Criteria andTopenNotIn(List<Date> values) {
            addCriterion("topen not in", values, "topen");
            return (Criteria) this;
        }

        public Criteria andTopenBetween(Date value1, Date value2) {
            addCriterion("topen between", value1, value2, "topen");
            return (Criteria) this;
        }

        public Criteria andTopenNotBetween(Date value1, Date value2) {
            addCriterion("topen not between", value1, value2, "topen");
            return (Criteria) this;
        }

        public Criteria andTcloseIsNull() {
            addCriterion("tclose is null");
            return (Criteria) this;
        }

        public Criteria andTcloseIsNotNull() {
            addCriterion("tclose is not null");
            return (Criteria) this;
        }

        public Criteria andTcloseEqualTo(Date value) {
            addCriterion("tclose =", value, "tclose");
            return (Criteria) this;
        }

        public Criteria andTcloseNotEqualTo(Date value) {
            addCriterion("tclose <>", value, "tclose");
            return (Criteria) this;
        }

        public Criteria andTcloseGreaterThan(Date value) {
            addCriterion("tclose >", value, "tclose");
            return (Criteria) this;
        }

        public Criteria andTcloseGreaterThanOrEqualTo(Date value) {
            addCriterion("tclose >=", value, "tclose");
            return (Criteria) this;
        }

        public Criteria andTcloseLessThan(Date value) {
            addCriterion("tclose <", value, "tclose");
            return (Criteria) this;
        }

        public Criteria andTcloseLessThanOrEqualTo(Date value) {
            addCriterion("tclose <=", value, "tclose");
            return (Criteria) this;
        }

        public Criteria andTcloseIn(List<Date> values) {
            addCriterion("tclose in", values, "tclose");
            return (Criteria) this;
        }

        public Criteria andTcloseNotIn(List<Date> values) {
            addCriterion("tclose not in", values, "tclose");
            return (Criteria) this;
        }

        public Criteria andTcloseBetween(Date value1, Date value2) {
            addCriterion("tclose between", value1, value2, "tclose");
            return (Criteria) this;
        }

        public Criteria andTcloseNotBetween(Date value1, Date value2) {
            addCriterion("tclose not between", value1, value2, "tclose");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}