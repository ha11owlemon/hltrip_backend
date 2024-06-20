package com.hall.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookingsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andBookingidIsNull() {
            addCriterion("bookingId is null");
            return (Criteria) this;
        }

        public Criteria andBookingidIsNotNull() {
            addCriterion("bookingId is not null");
            return (Criteria) this;
        }

        public Criteria andBookingidEqualTo(Integer value) {
            addCriterion("bookingId =", value, "bookingid");
            return (Criteria) this;
        }

        public Criteria andBookingidNotEqualTo(Integer value) {
            addCriterion("bookingId <>", value, "bookingid");
            return (Criteria) this;
        }

        public Criteria andBookingidGreaterThan(Integer value) {
            addCriterion("bookingId >", value, "bookingid");
            return (Criteria) this;
        }

        public Criteria andBookingidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookingId >=", value, "bookingid");
            return (Criteria) this;
        }

        public Criteria andBookingidLessThan(Integer value) {
            addCriterion("bookingId <", value, "bookingid");
            return (Criteria) this;
        }

        public Criteria andBookingidLessThanOrEqualTo(Integer value) {
            addCriterion("bookingId <=", value, "bookingid");
            return (Criteria) this;
        }

        public Criteria andBookingidIn(List<Integer> values) {
            addCriterion("bookingId in", values, "bookingid");
            return (Criteria) this;
        }

        public Criteria andBookingidNotIn(List<Integer> values) {
            addCriterion("bookingId not in", values, "bookingid");
            return (Criteria) this;
        }

        public Criteria andBookingidBetween(Integer value1, Integer value2) {
            addCriterion("bookingId between", value1, value2, "bookingid");
            return (Criteria) this;
        }

        public Criteria andBookingidNotBetween(Integer value1, Integer value2) {
            addCriterion("bookingId not between", value1, value2, "bookingid");
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

        public Criteria andSdateIsNull() {
            addCriterion("sdate is null");
            return (Criteria) this;
        }

        public Criteria andSdateIsNotNull() {
            addCriterion("sdate is not null");
            return (Criteria) this;
        }

        public Criteria andSdateEqualTo(Date value) {
            addCriterionForJDBCDate("sdate =", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("sdate <>", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThan(Date value) {
            addCriterionForJDBCDate("sdate >", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sdate >=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThan(Date value) {
            addCriterionForJDBCDate("sdate <", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sdate <=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateIn(List<Date> values) {
            addCriterionForJDBCDate("sdate in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("sdate not in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sdate between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sdate not between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andEdateIsNull() {
            addCriterion("edate is null");
            return (Criteria) this;
        }

        public Criteria andEdateIsNotNull() {
            addCriterion("edate is not null");
            return (Criteria) this;
        }

        public Criteria andEdateEqualTo(Date value) {
            addCriterionForJDBCDate("edate =", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("edate <>", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateGreaterThan(Date value) {
            addCriterionForJDBCDate("edate >", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("edate >=", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateLessThan(Date value) {
            addCriterionForJDBCDate("edate <", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("edate <=", value, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateIn(List<Date> values) {
            addCriterionForJDBCDate("edate in", values, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("edate not in", values, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("edate between", value1, value2, "edate");
            return (Criteria) this;
        }

        public Criteria andEdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("edate not between", value1, value2, "edate");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andBstatusIsNull() {
            addCriterion("bstatus is null");
            return (Criteria) this;
        }

        public Criteria andBstatusIsNotNull() {
            addCriterion("bstatus is not null");
            return (Criteria) this;
        }

        public Criteria andBstatusEqualTo(String value) {
            addCriterion("bstatus =", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusNotEqualTo(String value) {
            addCriterion("bstatus <>", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusGreaterThan(String value) {
            addCriterion("bstatus >", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusGreaterThanOrEqualTo(String value) {
            addCriterion("bstatus >=", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusLessThan(String value) {
            addCriterion("bstatus <", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusLessThanOrEqualTo(String value) {
            addCriterion("bstatus <=", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusLike(String value) {
            addCriterion("bstatus like", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusNotLike(String value) {
            addCriterion("bstatus not like", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusIn(List<String> values) {
            addCriterion("bstatus in", values, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusNotIn(List<String> values) {
            addCriterion("bstatus not in", values, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusBetween(String value1, String value2) {
            addCriterion("bstatus between", value1, value2, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusNotBetween(String value1, String value2) {
            addCriterion("bstatus not between", value1, value2, "bstatus");
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