package com.hall.Bean;

import java.util.ArrayList;
import java.util.List;

public class houseFeaturesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public houseFeaturesExample() {
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

        public Criteria andFeatureidIsNull() {
            addCriterion("featureId is null");
            return (Criteria) this;
        }

        public Criteria andFeatureidIsNotNull() {
            addCriterion("featureId is not null");
            return (Criteria) this;
        }

        public Criteria andFeatureidEqualTo(Integer value) {
            addCriterion("featureId =", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidNotEqualTo(Integer value) {
            addCriterion("featureId <>", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidGreaterThan(Integer value) {
            addCriterion("featureId >", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidGreaterThanOrEqualTo(Integer value) {
            addCriterion("featureId >=", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidLessThan(Integer value) {
            addCriterion("featureId <", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidLessThanOrEqualTo(Integer value) {
            addCriterion("featureId <=", value, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidIn(List<Integer> values) {
            addCriterion("featureId in", values, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidNotIn(List<Integer> values) {
            addCriterion("featureId not in", values, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidBetween(Integer value1, Integer value2) {
            addCriterion("featureId between", value1, value2, "featureid");
            return (Criteria) this;
        }

        public Criteria andFeatureidNotBetween(Integer value1, Integer value2) {
            addCriterion("featureId not between", value1, value2, "featureid");
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

        public Criteria andFeaturetypeIsNull() {
            addCriterion("featureType is null");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeIsNotNull() {
            addCriterion("featureType is not null");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeEqualTo(String value) {
            addCriterion("featureType =", value, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeNotEqualTo(String value) {
            addCriterion("featureType <>", value, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeGreaterThan(String value) {
            addCriterion("featureType >", value, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeGreaterThanOrEqualTo(String value) {
            addCriterion("featureType >=", value, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeLessThan(String value) {
            addCriterion("featureType <", value, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeLessThanOrEqualTo(String value) {
            addCriterion("featureType <=", value, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeLike(String value) {
            addCriterion("featureType like", value, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeNotLike(String value) {
            addCriterion("featureType not like", value, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeIn(List<String> values) {
            addCriterion("featureType in", values, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeNotIn(List<String> values) {
            addCriterion("featureType not in", values, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeBetween(String value1, String value2) {
            addCriterion("featureType between", value1, value2, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturetypeNotBetween(String value1, String value2) {
            addCriterion("featureType not between", value1, value2, "featuretype");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentIsNull() {
            addCriterion("featureContent is null");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentIsNotNull() {
            addCriterion("featureContent is not null");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentEqualTo(String value) {
            addCriterion("featureContent =", value, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentNotEqualTo(String value) {
            addCriterion("featureContent <>", value, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentGreaterThan(String value) {
            addCriterion("featureContent >", value, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentGreaterThanOrEqualTo(String value) {
            addCriterion("featureContent >=", value, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentLessThan(String value) {
            addCriterion("featureContent <", value, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentLessThanOrEqualTo(String value) {
            addCriterion("featureContent <=", value, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentLike(String value) {
            addCriterion("featureContent like", value, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentNotLike(String value) {
            addCriterion("featureContent not like", value, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentIn(List<String> values) {
            addCriterion("featureContent in", values, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentNotIn(List<String> values) {
            addCriterion("featureContent not in", values, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentBetween(String value1, String value2) {
            addCriterion("featureContent between", value1, value2, "featurecontent");
            return (Criteria) this;
        }

        public Criteria andFeaturecontentNotBetween(String value1, String value2) {
            addCriterion("featureContent not between", value1, value2, "featurecontent");
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