package com.hall.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class verifyCodeStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public verifyCodeStatusExample() {
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

        public Criteria andPhonenumberIsNull() {
            addCriterion("phoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phoneNumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phoneNumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phoneNumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phoneNumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phoneNumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phoneNumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phoneNumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phoneNumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phoneNumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phoneNumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phoneNumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andVerifycodeIsNull() {
            addCriterion("verifyCode is null");
            return (Criteria) this;
        }

        public Criteria andVerifycodeIsNotNull() {
            addCriterion("verifyCode is not null");
            return (Criteria) this;
        }

        public Criteria andVerifycodeEqualTo(String value) {
            addCriterion("verifyCode =", value, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeNotEqualTo(String value) {
            addCriterion("verifyCode <>", value, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeGreaterThan(String value) {
            addCriterion("verifyCode >", value, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeGreaterThanOrEqualTo(String value) {
            addCriterion("verifyCode >=", value, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeLessThan(String value) {
            addCriterion("verifyCode <", value, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeLessThanOrEqualTo(String value) {
            addCriterion("verifyCode <=", value, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeLike(String value) {
            addCriterion("verifyCode like", value, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeNotLike(String value) {
            addCriterion("verifyCode not like", value, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeIn(List<String> values) {
            addCriterion("verifyCode in", values, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeNotIn(List<String> values) {
            addCriterion("verifyCode not in", values, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeBetween(String value1, String value2) {
            addCriterion("verifyCode between", value1, value2, "verifycode");
            return (Criteria) this;
        }

        public Criteria andVerifycodeNotBetween(String value1, String value2) {
            addCriterion("verifyCode not between", value1, value2, "verifycode");
            return (Criteria) this;
        }

        public Criteria andCodegentimeIsNull() {
            addCriterion("codeGenTime is null");
            return (Criteria) this;
        }

        public Criteria andCodegentimeIsNotNull() {
            addCriterion("codeGenTime is not null");
            return (Criteria) this;
        }

        public Criteria andCodegentimeEqualTo(Date value) {
            addCriterion("codeGenTime =", value, "codegentime");
            return (Criteria) this;
        }

        public Criteria andCodegentimeNotEqualTo(Date value) {
            addCriterion("codeGenTime <>", value, "codegentime");
            return (Criteria) this;
        }

        public Criteria andCodegentimeGreaterThan(Date value) {
            addCriterion("codeGenTime >", value, "codegentime");
            return (Criteria) this;
        }

        public Criteria andCodegentimeGreaterThanOrEqualTo(Date value) {
            addCriterion("codeGenTime >=", value, "codegentime");
            return (Criteria) this;
        }

        public Criteria andCodegentimeLessThan(Date value) {
            addCriterion("codeGenTime <", value, "codegentime");
            return (Criteria) this;
        }

        public Criteria andCodegentimeLessThanOrEqualTo(Date value) {
            addCriterion("codeGenTime <=", value, "codegentime");
            return (Criteria) this;
        }

        public Criteria andCodegentimeIn(List<Date> values) {
            addCriterion("codeGenTime in", values, "codegentime");
            return (Criteria) this;
        }

        public Criteria andCodegentimeNotIn(List<Date> values) {
            addCriterion("codeGenTime not in", values, "codegentime");
            return (Criteria) this;
        }

        public Criteria andCodegentimeBetween(Date value1, Date value2) {
            addCriterion("codeGenTime between", value1, value2, "codegentime");
            return (Criteria) this;
        }

        public Criteria andCodegentimeNotBetween(Date value1, Date value2) {
            addCriterion("codeGenTime not between", value1, value2, "codegentime");
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