package com.hall.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithdrawalsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WithdrawalsExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andWithdrawalnumberIsNull() {
            addCriterion("withdrawalNumber is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberIsNotNull() {
            addCriterion("withdrawalNumber is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberEqualTo(String value) {
            addCriterion("withdrawalNumber =", value, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberNotEqualTo(String value) {
            addCriterion("withdrawalNumber <>", value, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberGreaterThan(String value) {
            addCriterion("withdrawalNumber >", value, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberGreaterThanOrEqualTo(String value) {
            addCriterion("withdrawalNumber >=", value, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberLessThan(String value) {
            addCriterion("withdrawalNumber <", value, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberLessThanOrEqualTo(String value) {
            addCriterion("withdrawalNumber <=", value, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberLike(String value) {
            addCriterion("withdrawalNumber like", value, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberNotLike(String value) {
            addCriterion("withdrawalNumber not like", value, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberIn(List<String> values) {
            addCriterion("withdrawalNumber in", values, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberNotIn(List<String> values) {
            addCriterion("withdrawalNumber not in", values, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberBetween(String value1, String value2) {
            addCriterion("withdrawalNumber between", value1, value2, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andWithdrawalnumberNotBetween(String value1, String value2) {
            addCriterion("withdrawalNumber not between", value1, value2, "withdrawalnumber");
            return (Criteria) this;
        }

        public Criteria andLidIsNull() {
            addCriterion("lid is null");
            return (Criteria) this;
        }

        public Criteria andLidIsNotNull() {
            addCriterion("lid is not null");
            return (Criteria) this;
        }

        public Criteria andLidEqualTo(Integer value) {
            addCriterion("lid =", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotEqualTo(Integer value) {
            addCriterion("lid <>", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThan(Integer value) {
            addCriterion("lid >", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lid >=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThan(Integer value) {
            addCriterion("lid <", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThanOrEqualTo(Integer value) {
            addCriterion("lid <=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidIn(List<Integer> values) {
            addCriterion("lid in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotIn(List<Integer> values) {
            addCriterion("lid not in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidBetween(Integer value1, Integer value2) {
            addCriterion("lid between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotBetween(Integer value1, Integer value2) {
            addCriterion("lid not between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andActualamountIsNull() {
            addCriterion("actualAmount is null");
            return (Criteria) this;
        }

        public Criteria andActualamountIsNotNull() {
            addCriterion("actualAmount is not null");
            return (Criteria) this;
        }

        public Criteria andActualamountEqualTo(BigDecimal value) {
            addCriterion("actualAmount =", value, "actualamount");
            return (Criteria) this;
        }

        public Criteria andActualamountNotEqualTo(BigDecimal value) {
            addCriterion("actualAmount <>", value, "actualamount");
            return (Criteria) this;
        }

        public Criteria andActualamountGreaterThan(BigDecimal value) {
            addCriterion("actualAmount >", value, "actualamount");
            return (Criteria) this;
        }

        public Criteria andActualamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actualAmount >=", value, "actualamount");
            return (Criteria) this;
        }

        public Criteria andActualamountLessThan(BigDecimal value) {
            addCriterion("actualAmount <", value, "actualamount");
            return (Criteria) this;
        }

        public Criteria andActualamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actualAmount <=", value, "actualamount");
            return (Criteria) this;
        }

        public Criteria andActualamountIn(List<BigDecimal> values) {
            addCriterion("actualAmount in", values, "actualamount");
            return (Criteria) this;
        }

        public Criteria andActualamountNotIn(List<BigDecimal> values) {
            addCriterion("actualAmount not in", values, "actualamount");
            return (Criteria) this;
        }

        public Criteria andActualamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actualAmount between", value1, value2, "actualamount");
            return (Criteria) this;
        }

        public Criteria andActualamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actualAmount not between", value1, value2, "actualamount");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeIsNull() {
            addCriterion("initiationTime is null");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeIsNotNull() {
            addCriterion("initiationTime is not null");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeEqualTo(Date value) {
            addCriterion("initiationTime =", value, "initiationtime");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeNotEqualTo(Date value) {
            addCriterion("initiationTime <>", value, "initiationtime");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeGreaterThan(Date value) {
            addCriterion("initiationTime >", value, "initiationtime");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("initiationTime >=", value, "initiationtime");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeLessThan(Date value) {
            addCriterion("initiationTime <", value, "initiationtime");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeLessThanOrEqualTo(Date value) {
            addCriterion("initiationTime <=", value, "initiationtime");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeIn(List<Date> values) {
            addCriterion("initiationTime in", values, "initiationtime");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeNotIn(List<Date> values) {
            addCriterion("initiationTime not in", values, "initiationtime");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeBetween(Date value1, Date value2) {
            addCriterion("initiationTime between", value1, value2, "initiationtime");
            return (Criteria) this;
        }

        public Criteria andInitiationtimeNotBetween(Date value1, Date value2) {
            addCriterion("initiationTime not between", value1, value2, "initiationtime");
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