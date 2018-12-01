package com.whx.bus.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoryExample() {
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

        public Criteria andBusidIsNull() {
            addCriterion("busId is null");
            return (Criteria) this;
        }

        public Criteria andBusidIsNotNull() {
            addCriterion("busId is not null");
            return (Criteria) this;
        }

        public Criteria andBusidEqualTo(Integer value) {
            addCriterion("busId =", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidNotEqualTo(Integer value) {
            addCriterion("busId <>", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidGreaterThan(Integer value) {
            addCriterion("busId >", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidGreaterThanOrEqualTo(Integer value) {
            addCriterion("busId >=", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidLessThan(Integer value) {
            addCriterion("busId <", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidLessThanOrEqualTo(Integer value) {
            addCriterion("busId <=", value, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidIn(List<Integer> values) {
            addCriterion("busId in", values, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidNotIn(List<Integer> values) {
            addCriterion("busId not in", values, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidBetween(Integer value1, Integer value2) {
            addCriterion("busId between", value1, value2, "busid");
            return (Criteria) this;
        }

        public Criteria andBusidNotBetween(Integer value1, Integer value2) {
            addCriterion("busId not between", value1, value2, "busid");
            return (Criteria) this;
        }

        public Criteria andWayidIsNull() {
            addCriterion("wayId is null");
            return (Criteria) this;
        }

        public Criteria andWayidIsNotNull() {
            addCriterion("wayId is not null");
            return (Criteria) this;
        }

        public Criteria andWayidEqualTo(Integer value) {
            addCriterion("wayId =", value, "wayid");
            return (Criteria) this;
        }

        public Criteria andWayidNotEqualTo(Integer value) {
            addCriterion("wayId <>", value, "wayid");
            return (Criteria) this;
        }

        public Criteria andWayidGreaterThan(Integer value) {
            addCriterion("wayId >", value, "wayid");
            return (Criteria) this;
        }

        public Criteria andWayidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wayId >=", value, "wayid");
            return (Criteria) this;
        }

        public Criteria andWayidLessThan(Integer value) {
            addCriterion("wayId <", value, "wayid");
            return (Criteria) this;
        }

        public Criteria andWayidLessThanOrEqualTo(Integer value) {
            addCriterion("wayId <=", value, "wayid");
            return (Criteria) this;
        }

        public Criteria andWayidIn(List<Integer> values) {
            addCriterion("wayId in", values, "wayid");
            return (Criteria) this;
        }

        public Criteria andWayidNotIn(List<Integer> values) {
            addCriterion("wayId not in", values, "wayid");
            return (Criteria) this;
        }

        public Criteria andWayidBetween(Integer value1, Integer value2) {
            addCriterion("wayId between", value1, value2, "wayid");
            return (Criteria) this;
        }

        public Criteria andWayidNotBetween(Integer value1, Integer value2) {
            addCriterion("wayId not between", value1, value2, "wayid");
            return (Criteria) this;
        }

        public Criteria andDriveridIsNull() {
            addCriterion("driverId is null");
            return (Criteria) this;
        }

        public Criteria andDriveridIsNotNull() {
            addCriterion("driverId is not null");
            return (Criteria) this;
        }

        public Criteria andDriveridEqualTo(Integer value) {
            addCriterion("driverId =", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridNotEqualTo(Integer value) {
            addCriterion("driverId <>", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridGreaterThan(Integer value) {
            addCriterion("driverId >", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridGreaterThanOrEqualTo(Integer value) {
            addCriterion("driverId >=", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridLessThan(Integer value) {
            addCriterion("driverId <", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridLessThanOrEqualTo(Integer value) {
            addCriterion("driverId <=", value, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridIn(List<Integer> values) {
            addCriterion("driverId in", values, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridNotIn(List<Integer> values) {
            addCriterion("driverId not in", values, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridBetween(Integer value1, Integer value2) {
            addCriterion("driverId between", value1, value2, "driverid");
            return (Criteria) this;
        }

        public Criteria andDriveridNotBetween(Integer value1, Integer value2) {
            addCriterion("driverId not between", value1, value2, "driverid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTgoIsNull() {
            addCriterion("tgo is null");
            return (Criteria) this;
        }

        public Criteria andTgoIsNotNull() {
            addCriterion("tgo is not null");
            return (Criteria) this;
        }

        public Criteria andTgoEqualTo(Date value) {
            addCriterion("tgo =", value, "tgo");
            return (Criteria) this;
        }

        public Criteria andTgoNotEqualTo(Date value) {
            addCriterion("tgo <>", value, "tgo");
            return (Criteria) this;
        }

        public Criteria andTgoGreaterThan(Date value) {
            addCriterion("tgo >", value, "tgo");
            return (Criteria) this;
        }

        public Criteria andTgoGreaterThanOrEqualTo(Date value) {
            addCriterion("tgo >=", value, "tgo");
            return (Criteria) this;
        }

        public Criteria andTgoLessThan(Date value) {
            addCriterion("tgo <", value, "tgo");
            return (Criteria) this;
        }

        public Criteria andTgoLessThanOrEqualTo(Date value) {
            addCriterion("tgo <=", value, "tgo");
            return (Criteria) this;
        }

        public Criteria andTgoIn(List<Date> values) {
            addCriterion("tgo in", values, "tgo");
            return (Criteria) this;
        }

        public Criteria andTgoNotIn(List<Date> values) {
            addCriterion("tgo not in", values, "tgo");
            return (Criteria) this;
        }

        public Criteria andTgoBetween(Date value1, Date value2) {
            addCriterion("tgo between", value1, value2, "tgo");
            return (Criteria) this;
        }

        public Criteria andTgoNotBetween(Date value1, Date value2) {
            addCriterion("tgo not between", value1, value2, "tgo");
            return (Criteria) this;
        }

        public Criteria andTendIsNull() {
            addCriterion("tend is null");
            return (Criteria) this;
        }

        public Criteria andTendIsNotNull() {
            addCriterion("tend is not null");
            return (Criteria) this;
        }

        public Criteria andTendEqualTo(Date value) {
            addCriterion("tend =", value, "tend");
            return (Criteria) this;
        }

        public Criteria andTendNotEqualTo(Date value) {
            addCriterion("tend <>", value, "tend");
            return (Criteria) this;
        }

        public Criteria andTendGreaterThan(Date value) {
            addCriterion("tend >", value, "tend");
            return (Criteria) this;
        }

        public Criteria andTendGreaterThanOrEqualTo(Date value) {
            addCriterion("tend >=", value, "tend");
            return (Criteria) this;
        }

        public Criteria andTendLessThan(Date value) {
            addCriterion("tend <", value, "tend");
            return (Criteria) this;
        }

        public Criteria andTendLessThanOrEqualTo(Date value) {
            addCriterion("tend <=", value, "tend");
            return (Criteria) this;
        }

        public Criteria andTendIn(List<Date> values) {
            addCriterion("tend in", values, "tend");
            return (Criteria) this;
        }

        public Criteria andTendNotIn(List<Date> values) {
            addCriterion("tend not in", values, "tend");
            return (Criteria) this;
        }

        public Criteria andTendBetween(Date value1, Date value2) {
            addCriterion("tend between", value1, value2, "tend");
            return (Criteria) this;
        }

        public Criteria andTendNotBetween(Date value1, Date value2) {
            addCriterion("tend not between", value1, value2, "tend");
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