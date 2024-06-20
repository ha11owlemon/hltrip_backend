package com.hall.Bean;

import java.util.ArrayList;
import java.util.List;

public class LandlordIntroExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LandlordIntroExample() {
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

        public Criteria andIntrotitleIsNull() {
            addCriterion("introtitle is null");
            return (Criteria) this;
        }

        public Criteria andIntrotitleIsNotNull() {
            addCriterion("introtitle is not null");
            return (Criteria) this;
        }

        public Criteria andIntrotitleEqualTo(String value) {
            addCriterion("introtitle =", value, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleNotEqualTo(String value) {
            addCriterion("introtitle <>", value, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleGreaterThan(String value) {
            addCriterion("introtitle >", value, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleGreaterThanOrEqualTo(String value) {
            addCriterion("introtitle >=", value, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleLessThan(String value) {
            addCriterion("introtitle <", value, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleLessThanOrEqualTo(String value) {
            addCriterion("introtitle <=", value, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleLike(String value) {
            addCriterion("introtitle like", value, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleNotLike(String value) {
            addCriterion("introtitle not like", value, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleIn(List<String> values) {
            addCriterion("introtitle in", values, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleNotIn(List<String> values) {
            addCriterion("introtitle not in", values, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleBetween(String value1, String value2) {
            addCriterion("introtitle between", value1, value2, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrotitleNotBetween(String value1, String value2) {
            addCriterion("introtitle not between", value1, value2, "introtitle");
            return (Criteria) this;
        }

        public Criteria andIntrocontIsNull() {
            addCriterion("introcont is null");
            return (Criteria) this;
        }

        public Criteria andIntrocontIsNotNull() {
            addCriterion("introcont is not null");
            return (Criteria) this;
        }

        public Criteria andIntrocontEqualTo(String value) {
            addCriterion("introcont =", value, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontNotEqualTo(String value) {
            addCriterion("introcont <>", value, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontGreaterThan(String value) {
            addCriterion("introcont >", value, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontGreaterThanOrEqualTo(String value) {
            addCriterion("introcont >=", value, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontLessThan(String value) {
            addCriterion("introcont <", value, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontLessThanOrEqualTo(String value) {
            addCriterion("introcont <=", value, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontLike(String value) {
            addCriterion("introcont like", value, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontNotLike(String value) {
            addCriterion("introcont not like", value, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontIn(List<String> values) {
            addCriterion("introcont in", values, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontNotIn(List<String> values) {
            addCriterion("introcont not in", values, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontBetween(String value1, String value2) {
            addCriterion("introcont between", value1, value2, "introcont");
            return (Criteria) this;
        }

        public Criteria andIntrocontNotBetween(String value1, String value2) {
            addCriterion("introcont not between", value1, value2, "introcont");
            return (Criteria) this;
        }

        public Criteria andLandlordidIsNull() {
            addCriterion("landlordid is null");
            return (Criteria) this;
        }

        public Criteria andLandlordidIsNotNull() {
            addCriterion("landlordid is not null");
            return (Criteria) this;
        }

        public Criteria andLandlordidEqualTo(Integer value) {
            addCriterion("landlordid =", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidNotEqualTo(Integer value) {
            addCriterion("landlordid <>", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidGreaterThan(Integer value) {
            addCriterion("landlordid >", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("landlordid >=", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidLessThan(Integer value) {
            addCriterion("landlordid <", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidLessThanOrEqualTo(Integer value) {
            addCriterion("landlordid <=", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidIn(List<Integer> values) {
            addCriterion("landlordid in", values, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidNotIn(List<Integer> values) {
            addCriterion("landlordid not in", values, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidBetween(Integer value1, Integer value2) {
            addCriterion("landlordid between", value1, value2, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidNotBetween(Integer value1, Integer value2) {
            addCriterion("landlordid not between", value1, value2, "landlordid");
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