package com.hall.Bean;

import java.util.ArrayList;
import java.util.List;

public class PoliciesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PoliciesExample() {
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

        public Criteria andPolicyidIsNull() {
            addCriterion("policyId is null");
            return (Criteria) this;
        }

        public Criteria andPolicyidIsNotNull() {
            addCriterion("policyId is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyidEqualTo(Integer value) {
            addCriterion("policyId =", value, "policyid");
            return (Criteria) this;
        }

        public Criteria andPolicyidNotEqualTo(Integer value) {
            addCriterion("policyId <>", value, "policyid");
            return (Criteria) this;
        }

        public Criteria andPolicyidGreaterThan(Integer value) {
            addCriterion("policyId >", value, "policyid");
            return (Criteria) this;
        }

        public Criteria andPolicyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("policyId >=", value, "policyid");
            return (Criteria) this;
        }

        public Criteria andPolicyidLessThan(Integer value) {
            addCriterion("policyId <", value, "policyid");
            return (Criteria) this;
        }

        public Criteria andPolicyidLessThanOrEqualTo(Integer value) {
            addCriterion("policyId <=", value, "policyid");
            return (Criteria) this;
        }

        public Criteria andPolicyidIn(List<Integer> values) {
            addCriterion("policyId in", values, "policyid");
            return (Criteria) this;
        }

        public Criteria andPolicyidNotIn(List<Integer> values) {
            addCriterion("policyId not in", values, "policyid");
            return (Criteria) this;
        }

        public Criteria andPolicyidBetween(Integer value1, Integer value2) {
            addCriterion("policyId between", value1, value2, "policyid");
            return (Criteria) this;
        }

        public Criteria andPolicyidNotBetween(Integer value1, Integer value2) {
            addCriterion("policyId not between", value1, value2, "policyid");
            return (Criteria) this;
        }

        public Criteria andHouseidIsNull() {
            addCriterion("houseId is null");
            return (Criteria) this;
        }

        public Criteria andHouseidIsNotNull() {
            addCriterion("houseId is not null");
            return (Criteria) this;
        }

        public Criteria andHouseidEqualTo(Integer value) {
            addCriterion("houseId =", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotEqualTo(Integer value) {
            addCriterion("houseId <>", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThan(Integer value) {
            addCriterion("houseId >", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("houseId >=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThan(Integer value) {
            addCriterion("houseId <", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidLessThanOrEqualTo(Integer value) {
            addCriterion("houseId <=", value, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidIn(List<Integer> values) {
            addCriterion("houseId in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotIn(List<Integer> values) {
            addCriterion("houseId not in", values, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidBetween(Integer value1, Integer value2) {
            addCriterion("houseId between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andHouseidNotBetween(Integer value1, Integer value2) {
            addCriterion("houseId not between", value1, value2, "houseid");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyIsNull() {
            addCriterion("cancelPolicy is null");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyIsNotNull() {
            addCriterion("cancelPolicy is not null");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyEqualTo(String value) {
            addCriterion("cancelPolicy =", value, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyNotEqualTo(String value) {
            addCriterion("cancelPolicy <>", value, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyGreaterThan(String value) {
            addCriterion("cancelPolicy >", value, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyGreaterThanOrEqualTo(String value) {
            addCriterion("cancelPolicy >=", value, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyLessThan(String value) {
            addCriterion("cancelPolicy <", value, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyLessThanOrEqualTo(String value) {
            addCriterion("cancelPolicy <=", value, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyLike(String value) {
            addCriterion("cancelPolicy like", value, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyNotLike(String value) {
            addCriterion("cancelPolicy not like", value, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyIn(List<String> values) {
            addCriterion("cancelPolicy in", values, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyNotIn(List<String> values) {
            addCriterion("cancelPolicy not in", values, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyBetween(String value1, String value2) {
            addCriterion("cancelPolicy between", value1, value2, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andCancelpolicyNotBetween(String value1, String value2) {
            addCriterion("cancelPolicy not between", value1, value2, "cancelpolicy");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsIsNull() {
            addCriterion("allowAddGuests is null");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsIsNotNull() {
            addCriterion("allowAddGuests is not null");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsEqualTo(Double value) {
            addCriterion("allowAddGuests =", value, "allowaddguests");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsNotEqualTo(Double value) {
            addCriterion("allowAddGuests <>", value, "allowaddguests");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsGreaterThan(Double value) {
            addCriterion("allowAddGuests >", value, "allowaddguests");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsGreaterThanOrEqualTo(Double value) {
            addCriterion("allowAddGuests >=", value, "allowaddguests");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsLessThan(Double value) {
            addCriterion("allowAddGuests <", value, "allowaddguests");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsLessThanOrEqualTo(Double value) {
            addCriterion("allowAddGuests <=", value, "allowaddguests");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsIn(List<Double> values) {
            addCriterion("allowAddGuests in", values, "allowaddguests");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsNotIn(List<Double> values) {
            addCriterion("allowAddGuests not in", values, "allowaddguests");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsBetween(Double value1, Double value2) {
            addCriterion("allowAddGuests between", value1, value2, "allowaddguests");
            return (Criteria) this;
        }

        public Criteria andAllowaddguestsNotBetween(Double value1, Double value2) {
            addCriterion("allowAddGuests not between", value1, value2, "allowaddguests");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(Double value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(Double value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(Double value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(Double value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(Double value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(Double value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<Double> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<Double> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(Double value1, Double value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(Double value1, Double value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowIsNull() {
            addCriterion("needToKnow is null");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowIsNotNull() {
            addCriterion("needToKnow is not null");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowEqualTo(String value) {
            addCriterion("needToKnow =", value, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowNotEqualTo(String value) {
            addCriterion("needToKnow <>", value, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowGreaterThan(String value) {
            addCriterion("needToKnow >", value, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowGreaterThanOrEqualTo(String value) {
            addCriterion("needToKnow >=", value, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowLessThan(String value) {
            addCriterion("needToKnow <", value, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowLessThanOrEqualTo(String value) {
            addCriterion("needToKnow <=", value, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowLike(String value) {
            addCriterion("needToKnow like", value, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowNotLike(String value) {
            addCriterion("needToKnow not like", value, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowIn(List<String> values) {
            addCriterion("needToKnow in", values, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowNotIn(List<String> values) {
            addCriterion("needToKnow not in", values, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowBetween(String value1, String value2) {
            addCriterion("needToKnow between", value1, value2, "needtoknow");
            return (Criteria) this;
        }

        public Criteria andNeedtoknowNotBetween(String value1, String value2) {
            addCriterion("needToKnow not between", value1, value2, "needtoknow");
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