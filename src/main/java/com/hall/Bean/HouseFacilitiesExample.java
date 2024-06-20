package com.hall.Bean;

import java.util.ArrayList;
import java.util.List;

public class HouseFacilitiesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseFacilitiesExample() {
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

        public Criteria andFacilitiesidIsNull() {
            addCriterion("facilitiesId is null");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidIsNotNull() {
            addCriterion("facilitiesId is not null");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidEqualTo(Integer value) {
            addCriterion("facilitiesId =", value, "facilitiesid");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidNotEqualTo(Integer value) {
            addCriterion("facilitiesId <>", value, "facilitiesid");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidGreaterThan(Integer value) {
            addCriterion("facilitiesId >", value, "facilitiesid");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidGreaterThanOrEqualTo(Integer value) {
            addCriterion("facilitiesId >=", value, "facilitiesid");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidLessThan(Integer value) {
            addCriterion("facilitiesId <", value, "facilitiesid");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidLessThanOrEqualTo(Integer value) {
            addCriterion("facilitiesId <=", value, "facilitiesid");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidIn(List<Integer> values) {
            addCriterion("facilitiesId in", values, "facilitiesid");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidNotIn(List<Integer> values) {
            addCriterion("facilitiesId not in", values, "facilitiesid");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidBetween(Integer value1, Integer value2) {
            addCriterion("facilitiesId between", value1, value2, "facilitiesid");
            return (Criteria) this;
        }

        public Criteria andFacilitiesidNotBetween(Integer value1, Integer value2) {
            addCriterion("facilitiesId not between", value1, value2, "facilitiesid");
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

        public Criteria andServiceIsNull() {
            addCriterion("service is null");
            return (Criteria) this;
        }

        public Criteria andServiceIsNotNull() {
            addCriterion("service is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEqualTo(String value) {
            addCriterion("service =", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotEqualTo(String value) {
            addCriterion("service <>", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThan(String value) {
            addCriterion("service >", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThanOrEqualTo(String value) {
            addCriterion("service >=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThan(String value) {
            addCriterion("service <", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThanOrEqualTo(String value) {
            addCriterion("service <=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLike(String value) {
            addCriterion("service like", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotLike(String value) {
            addCriterion("service not like", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceIn(List<String> values) {
            addCriterion("service in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotIn(List<String> values) {
            addCriterion("service not in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceBetween(String value1, String value2) {
            addCriterion("service between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotBetween(String value1, String value2) {
            addCriterion("service not between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andBasicIsNull() {
            addCriterion("basic is null");
            return (Criteria) this;
        }

        public Criteria andBasicIsNotNull() {
            addCriterion("basic is not null");
            return (Criteria) this;
        }

        public Criteria andBasicEqualTo(String value) {
            addCriterion("basic =", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotEqualTo(String value) {
            addCriterion("basic <>", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicGreaterThan(String value) {
            addCriterion("basic >", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicGreaterThanOrEqualTo(String value) {
            addCriterion("basic >=", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicLessThan(String value) {
            addCriterion("basic <", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicLessThanOrEqualTo(String value) {
            addCriterion("basic <=", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicLike(String value) {
            addCriterion("basic like", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotLike(String value) {
            addCriterion("basic not like", value, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicIn(List<String> values) {
            addCriterion("basic in", values, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotIn(List<String> values) {
            addCriterion("basic not in", values, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicBetween(String value1, String value2) {
            addCriterion("basic between", value1, value2, "basic");
            return (Criteria) this;
        }

        public Criteria andBasicNotBetween(String value1, String value2) {
            addCriterion("basic not between", value1, value2, "basic");
            return (Criteria) this;
        }

        public Criteria andBathroomIsNull() {
            addCriterion("bathroom is null");
            return (Criteria) this;
        }

        public Criteria andBathroomIsNotNull() {
            addCriterion("bathroom is not null");
            return (Criteria) this;
        }

        public Criteria andBathroomEqualTo(String value) {
            addCriterion("bathroom =", value, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomNotEqualTo(String value) {
            addCriterion("bathroom <>", value, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomGreaterThan(String value) {
            addCriterion("bathroom >", value, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomGreaterThanOrEqualTo(String value) {
            addCriterion("bathroom >=", value, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomLessThan(String value) {
            addCriterion("bathroom <", value, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomLessThanOrEqualTo(String value) {
            addCriterion("bathroom <=", value, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomLike(String value) {
            addCriterion("bathroom like", value, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomNotLike(String value) {
            addCriterion("bathroom not like", value, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomIn(List<String> values) {
            addCriterion("bathroom in", values, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomNotIn(List<String> values) {
            addCriterion("bathroom not in", values, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomBetween(String value1, String value2) {
            addCriterion("bathroom between", value1, value2, "bathroom");
            return (Criteria) this;
        }

        public Criteria andBathroomNotBetween(String value1, String value2) {
            addCriterion("bathroom not between", value1, value2, "bathroom");
            return (Criteria) this;
        }

        public Criteria andKitchenIsNull() {
            addCriterion("kitchen is null");
            return (Criteria) this;
        }

        public Criteria andKitchenIsNotNull() {
            addCriterion("kitchen is not null");
            return (Criteria) this;
        }

        public Criteria andKitchenEqualTo(String value) {
            addCriterion("kitchen =", value, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenNotEqualTo(String value) {
            addCriterion("kitchen <>", value, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenGreaterThan(String value) {
            addCriterion("kitchen >", value, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenGreaterThanOrEqualTo(String value) {
            addCriterion("kitchen >=", value, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenLessThan(String value) {
            addCriterion("kitchen <", value, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenLessThanOrEqualTo(String value) {
            addCriterion("kitchen <=", value, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenLike(String value) {
            addCriterion("kitchen like", value, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenNotLike(String value) {
            addCriterion("kitchen not like", value, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenIn(List<String> values) {
            addCriterion("kitchen in", values, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenNotIn(List<String> values) {
            addCriterion("kitchen not in", values, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenBetween(String value1, String value2) {
            addCriterion("kitchen between", value1, value2, "kitchen");
            return (Criteria) this;
        }

        public Criteria andKitchenNotBetween(String value1, String value2) {
            addCriterion("kitchen not between", value1, value2, "kitchen");
            return (Criteria) this;
        }

        public Criteria andSurroundingIsNull() {
            addCriterion("surrounding is null");
            return (Criteria) this;
        }

        public Criteria andSurroundingIsNotNull() {
            addCriterion("surrounding is not null");
            return (Criteria) this;
        }

        public Criteria andSurroundingEqualTo(String value) {
            addCriterion("surrounding =", value, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingNotEqualTo(String value) {
            addCriterion("surrounding <>", value, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingGreaterThan(String value) {
            addCriterion("surrounding >", value, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingGreaterThanOrEqualTo(String value) {
            addCriterion("surrounding >=", value, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingLessThan(String value) {
            addCriterion("surrounding <", value, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingLessThanOrEqualTo(String value) {
            addCriterion("surrounding <=", value, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingLike(String value) {
            addCriterion("surrounding like", value, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingNotLike(String value) {
            addCriterion("surrounding not like", value, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingIn(List<String> values) {
            addCriterion("surrounding in", values, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingNotIn(List<String> values) {
            addCriterion("surrounding not in", values, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingBetween(String value1, String value2) {
            addCriterion("surrounding between", value1, value2, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSurroundingNotBetween(String value1, String value2) {
            addCriterion("surrounding not between", value1, value2, "surrounding");
            return (Criteria) this;
        }

        public Criteria andSafetyIsNull() {
            addCriterion("safety is null");
            return (Criteria) this;
        }

        public Criteria andSafetyIsNotNull() {
            addCriterion("safety is not null");
            return (Criteria) this;
        }

        public Criteria andSafetyEqualTo(String value) {
            addCriterion("safety =", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyNotEqualTo(String value) {
            addCriterion("safety <>", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyGreaterThan(String value) {
            addCriterion("safety >", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyGreaterThanOrEqualTo(String value) {
            addCriterion("safety >=", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyLessThan(String value) {
            addCriterion("safety <", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyLessThanOrEqualTo(String value) {
            addCriterion("safety <=", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyLike(String value) {
            addCriterion("safety like", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyNotLike(String value) {
            addCriterion("safety not like", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyIn(List<String> values) {
            addCriterion("safety in", values, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyNotIn(List<String> values) {
            addCriterion("safety not in", values, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyBetween(String value1, String value2) {
            addCriterion("safety between", value1, value2, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyNotBetween(String value1, String value2) {
            addCriterion("safety not between", value1, value2, "safety");
            return (Criteria) this;
        }

        public Criteria andEntertainmentIsNull() {
            addCriterion("entertainment is null");
            return (Criteria) this;
        }

        public Criteria andEntertainmentIsNotNull() {
            addCriterion("entertainment is not null");
            return (Criteria) this;
        }

        public Criteria andEntertainmentEqualTo(String value) {
            addCriterion("entertainment =", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentNotEqualTo(String value) {
            addCriterion("entertainment <>", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentGreaterThan(String value) {
            addCriterion("entertainment >", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentGreaterThanOrEqualTo(String value) {
            addCriterion("entertainment >=", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentLessThan(String value) {
            addCriterion("entertainment <", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentLessThanOrEqualTo(String value) {
            addCriterion("entertainment <=", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentLike(String value) {
            addCriterion("entertainment like", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentNotLike(String value) {
            addCriterion("entertainment not like", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentIn(List<String> values) {
            addCriterion("entertainment in", values, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentNotIn(List<String> values) {
            addCriterion("entertainment not in", values, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentBetween(String value1, String value2) {
            addCriterion("entertainment between", value1, value2, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentNotBetween(String value1, String value2) {
            addCriterion("entertainment not between", value1, value2, "entertainment");
            return (Criteria) this;
        }

        public Criteria andLeisureIsNull() {
            addCriterion("leisure is null");
            return (Criteria) this;
        }

        public Criteria andLeisureIsNotNull() {
            addCriterion("leisure is not null");
            return (Criteria) this;
        }

        public Criteria andLeisureEqualTo(String value) {
            addCriterion("leisure =", value, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureNotEqualTo(String value) {
            addCriterion("leisure <>", value, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureGreaterThan(String value) {
            addCriterion("leisure >", value, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureGreaterThanOrEqualTo(String value) {
            addCriterion("leisure >=", value, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureLessThan(String value) {
            addCriterion("leisure <", value, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureLessThanOrEqualTo(String value) {
            addCriterion("leisure <=", value, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureLike(String value) {
            addCriterion("leisure like", value, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureNotLike(String value) {
            addCriterion("leisure not like", value, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureIn(List<String> values) {
            addCriterion("leisure in", values, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureNotIn(List<String> values) {
            addCriterion("leisure not in", values, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureBetween(String value1, String value2) {
            addCriterion("leisure between", value1, value2, "leisure");
            return (Criteria) this;
        }

        public Criteria andLeisureNotBetween(String value1, String value2) {
            addCriterion("leisure not between", value1, value2, "leisure");
            return (Criteria) this;
        }

        public Criteria andChildrenIsNull() {
            addCriterion("children is null");
            return (Criteria) this;
        }

        public Criteria andChildrenIsNotNull() {
            addCriterion("children is not null");
            return (Criteria) this;
        }

        public Criteria andChildrenEqualTo(String value) {
            addCriterion("children =", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotEqualTo(String value) {
            addCriterion("children <>", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenGreaterThan(String value) {
            addCriterion("children >", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenGreaterThanOrEqualTo(String value) {
            addCriterion("children >=", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenLessThan(String value) {
            addCriterion("children <", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenLessThanOrEqualTo(String value) {
            addCriterion("children <=", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenLike(String value) {
            addCriterion("children like", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotLike(String value) {
            addCriterion("children not like", value, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenIn(List<String> values) {
            addCriterion("children in", values, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotIn(List<String> values) {
            addCriterion("children not in", values, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenBetween(String value1, String value2) {
            addCriterion("children between", value1, value2, "children");
            return (Criteria) this;
        }

        public Criteria andChildrenNotBetween(String value1, String value2) {
            addCriterion("children not between", value1, value2, "children");
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