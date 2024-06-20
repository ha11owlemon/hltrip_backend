package com.hall.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentsExample() {
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

        public Criteria andCommentidIsNull() {
            addCriterion("commentId is null");
            return (Criteria) this;
        }

        public Criteria andCommentidIsNotNull() {
            addCriterion("commentId is not null");
            return (Criteria) this;
        }

        public Criteria andCommentidEqualTo(Integer value) {
            addCriterion("commentId =", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotEqualTo(Integer value) {
            addCriterion("commentId <>", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidGreaterThan(Integer value) {
            addCriterion("commentId >", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentId >=", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLessThan(Integer value) {
            addCriterion("commentId <", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLessThanOrEqualTo(Integer value) {
            addCriterion("commentId <=", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidIn(List<Integer> values) {
            addCriterion("commentId in", values, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotIn(List<Integer> values) {
            addCriterion("commentId not in", values, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidBetween(Integer value1, Integer value2) {
            addCriterion("commentId between", value1, value2, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotBetween(Integer value1, Integer value2) {
            addCriterion("commentId not between", value1, value2, "commentid");
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andLandlordidIsNull() {
            addCriterion("landlordId is null");
            return (Criteria) this;
        }

        public Criteria andLandlordidIsNotNull() {
            addCriterion("landlordId is not null");
            return (Criteria) this;
        }

        public Criteria andLandlordidEqualTo(Integer value) {
            addCriterion("landlordId =", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidNotEqualTo(Integer value) {
            addCriterion("landlordId <>", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidGreaterThan(Integer value) {
            addCriterion("landlordId >", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("landlordId >=", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidLessThan(Integer value) {
            addCriterion("landlordId <", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidLessThanOrEqualTo(Integer value) {
            addCriterion("landlordId <=", value, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidIn(List<Integer> values) {
            addCriterion("landlordId in", values, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidNotIn(List<Integer> values) {
            addCriterion("landlordId not in", values, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidBetween(Integer value1, Integer value2) {
            addCriterion("landlordId between", value1, value2, "landlordid");
            return (Criteria) this;
        }

        public Criteria andLandlordidNotBetween(Integer value1, Integer value2) {
            addCriterion("landlordId not between", value1, value2, "landlordid");
            return (Criteria) this;
        }

        public Criteria andHasimageIsNull() {
            addCriterion("hasImage is null");
            return (Criteria) this;
        }

        public Criteria andHasimageIsNotNull() {
            addCriterion("hasImage is not null");
            return (Criteria) this;
        }

        public Criteria andHasimageEqualTo(Boolean value) {
            addCriterion("hasImage =", value, "hasimage");
            return (Criteria) this;
        }

        public Criteria andHasimageNotEqualTo(Boolean value) {
            addCriterion("hasImage <>", value, "hasimage");
            return (Criteria) this;
        }

        public Criteria andHasimageGreaterThan(Boolean value) {
            addCriterion("hasImage >", value, "hasimage");
            return (Criteria) this;
        }

        public Criteria andHasimageGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hasImage >=", value, "hasimage");
            return (Criteria) this;
        }

        public Criteria andHasimageLessThan(Boolean value) {
            addCriterion("hasImage <", value, "hasimage");
            return (Criteria) this;
        }

        public Criteria andHasimageLessThanOrEqualTo(Boolean value) {
            addCriterion("hasImage <=", value, "hasimage");
            return (Criteria) this;
        }

        public Criteria andHasimageIn(List<Boolean> values) {
            addCriterion("hasImage in", values, "hasimage");
            return (Criteria) this;
        }

        public Criteria andHasimageNotIn(List<Boolean> values) {
            addCriterion("hasImage not in", values, "hasimage");
            return (Criteria) this;
        }

        public Criteria andHasimageBetween(Boolean value1, Boolean value2) {
            addCriterion("hasImage between", value1, value2, "hasimage");
            return (Criteria) this;
        }

        public Criteria andHasimageNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hasImage not between", value1, value2, "hasimage");
            return (Criteria) this;
        }

        public Criteria andCleanlinessIsNull() {
            addCriterion("cleanliness is null");
            return (Criteria) this;
        }

        public Criteria andCleanlinessIsNotNull() {
            addCriterion("cleanliness is not null");
            return (Criteria) this;
        }

        public Criteria andCleanlinessEqualTo(Double value) {
            addCriterion("cleanliness =", value, "cleanliness");
            return (Criteria) this;
        }

        public Criteria andCleanlinessNotEqualTo(Double value) {
            addCriterion("cleanliness <>", value, "cleanliness");
            return (Criteria) this;
        }

        public Criteria andCleanlinessGreaterThan(Double value) {
            addCriterion("cleanliness >", value, "cleanliness");
            return (Criteria) this;
        }

        public Criteria andCleanlinessGreaterThanOrEqualTo(Double value) {
            addCriterion("cleanliness >=", value, "cleanliness");
            return (Criteria) this;
        }

        public Criteria andCleanlinessLessThan(Double value) {
            addCriterion("cleanliness <", value, "cleanliness");
            return (Criteria) this;
        }

        public Criteria andCleanlinessLessThanOrEqualTo(Double value) {
            addCriterion("cleanliness <=", value, "cleanliness");
            return (Criteria) this;
        }

        public Criteria andCleanlinessIn(List<Double> values) {
            addCriterion("cleanliness in", values, "cleanliness");
            return (Criteria) this;
        }

        public Criteria andCleanlinessNotIn(List<Double> values) {
            addCriterion("cleanliness not in", values, "cleanliness");
            return (Criteria) this;
        }

        public Criteria andCleanlinessBetween(Double value1, Double value2) {
            addCriterion("cleanliness between", value1, value2, "cleanliness");
            return (Criteria) this;
        }

        public Criteria andCleanlinessNotBetween(Double value1, Double value2) {
            addCriterion("cleanliness not between", value1, value2, "cleanliness");
            return (Criteria) this;
        }

        public Criteria andAccuracyIsNull() {
            addCriterion("accuracy is null");
            return (Criteria) this;
        }

        public Criteria andAccuracyIsNotNull() {
            addCriterion("accuracy is not null");
            return (Criteria) this;
        }

        public Criteria andAccuracyEqualTo(Double value) {
            addCriterion("accuracy =", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyNotEqualTo(Double value) {
            addCriterion("accuracy <>", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyGreaterThan(Double value) {
            addCriterion("accuracy >", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyGreaterThanOrEqualTo(Double value) {
            addCriterion("accuracy >=", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyLessThan(Double value) {
            addCriterion("accuracy <", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyLessThanOrEqualTo(Double value) {
            addCriterion("accuracy <=", value, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyIn(List<Double> values) {
            addCriterion("accuracy in", values, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyNotIn(List<Double> values) {
            addCriterion("accuracy not in", values, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyBetween(Double value1, Double value2) {
            addCriterion("accuracy between", value1, value2, "accuracy");
            return (Criteria) this;
        }

        public Criteria andAccuracyNotBetween(Double value1, Double value2) {
            addCriterion("accuracy not between", value1, value2, "accuracy");
            return (Criteria) this;
        }

        public Criteria andLocationtransportIsNull() {
            addCriterion("locationTransport is null");
            return (Criteria) this;
        }

        public Criteria andLocationtransportIsNotNull() {
            addCriterion("locationTransport is not null");
            return (Criteria) this;
        }

        public Criteria andLocationtransportEqualTo(Double value) {
            addCriterion("locationTransport =", value, "locationtransport");
            return (Criteria) this;
        }

        public Criteria andLocationtransportNotEqualTo(Double value) {
            addCriterion("locationTransport <>", value, "locationtransport");
            return (Criteria) this;
        }

        public Criteria andLocationtransportGreaterThan(Double value) {
            addCriterion("locationTransport >", value, "locationtransport");
            return (Criteria) this;
        }

        public Criteria andLocationtransportGreaterThanOrEqualTo(Double value) {
            addCriterion("locationTransport >=", value, "locationtransport");
            return (Criteria) this;
        }

        public Criteria andLocationtransportLessThan(Double value) {
            addCriterion("locationTransport <", value, "locationtransport");
            return (Criteria) this;
        }

        public Criteria andLocationtransportLessThanOrEqualTo(Double value) {
            addCriterion("locationTransport <=", value, "locationtransport");
            return (Criteria) this;
        }

        public Criteria andLocationtransportIn(List<Double> values) {
            addCriterion("locationTransport in", values, "locationtransport");
            return (Criteria) this;
        }

        public Criteria andLocationtransportNotIn(List<Double> values) {
            addCriterion("locationTransport not in", values, "locationtransport");
            return (Criteria) this;
        }

        public Criteria andLocationtransportBetween(Double value1, Double value2) {
            addCriterion("locationTransport between", value1, value2, "locationtransport");
            return (Criteria) this;
        }

        public Criteria andLocationtransportNotBetween(Double value1, Double value2) {
            addCriterion("locationTransport not between", value1, value2, "locationtransport");
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

        public Criteria andSafetyEqualTo(Double value) {
            addCriterion("safety =", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyNotEqualTo(Double value) {
            addCriterion("safety <>", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyGreaterThan(Double value) {
            addCriterion("safety >", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyGreaterThanOrEqualTo(Double value) {
            addCriterion("safety >=", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyLessThan(Double value) {
            addCriterion("safety <", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyLessThanOrEqualTo(Double value) {
            addCriterion("safety <=", value, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyIn(List<Double> values) {
            addCriterion("safety in", values, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyNotIn(List<Double> values) {
            addCriterion("safety not in", values, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyBetween(Double value1, Double value2) {
            addCriterion("safety between", value1, value2, "safety");
            return (Criteria) this;
        }

        public Criteria andSafetyNotBetween(Double value1, Double value2) {
            addCriterion("safety not between", value1, value2, "safety");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyIsNull() {
            addCriterion("valueForMmoney is null");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyIsNotNull() {
            addCriterion("valueForMmoney is not null");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyEqualTo(Double value) {
            addCriterion("valueForMmoney =", value, "valueformmoney");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyNotEqualTo(Double value) {
            addCriterion("valueForMmoney <>", value, "valueformmoney");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyGreaterThan(Double value) {
            addCriterion("valueForMmoney >", value, "valueformmoney");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("valueForMmoney >=", value, "valueformmoney");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyLessThan(Double value) {
            addCriterion("valueForMmoney <", value, "valueformmoney");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyLessThanOrEqualTo(Double value) {
            addCriterion("valueForMmoney <=", value, "valueformmoney");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyIn(List<Double> values) {
            addCriterion("valueForMmoney in", values, "valueformmoney");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyNotIn(List<Double> values) {
            addCriterion("valueForMmoney not in", values, "valueformmoney");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyBetween(Double value1, Double value2) {
            addCriterion("valueForMmoney between", value1, value2, "valueformmoney");
            return (Criteria) this;
        }

        public Criteria andValueformmoneyNotBetween(Double value1, Double value2) {
            addCriterion("valueForMmoney not between", value1, value2, "valueformmoney");
            return (Criteria) this;
        }

        public Criteria andRatingIsNull() {
            addCriterion("rating is null");
            return (Criteria) this;
        }

        public Criteria andRatingIsNotNull() {
            addCriterion("rating is not null");
            return (Criteria) this;
        }

        public Criteria andRatingEqualTo(Double value) {
            addCriterion("rating =", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotEqualTo(Double value) {
            addCriterion("rating <>", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThan(Double value) {
            addCriterion("rating >", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThanOrEqualTo(Double value) {
            addCriterion("rating >=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThan(Double value) {
            addCriterion("rating <", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThanOrEqualTo(Double value) {
            addCriterion("rating <=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingIn(List<Double> values) {
            addCriterion("rating in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotIn(List<Double> values) {
            addCriterion("rating not in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingBetween(Double value1, Double value2) {
            addCriterion("rating between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotBetween(Double value1, Double value2) {
            addCriterion("rating not between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNull() {
            addCriterion("commentTime is null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIsNotNull() {
            addCriterion("commentTime is not null");
            return (Criteria) this;
        }

        public Criteria andCommenttimeEqualTo(Date value) {
            addCriterion("commentTime =", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotEqualTo(Date value) {
            addCriterion("commentTime <>", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThan(Date value) {
            addCriterion("commentTime >", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commentTime >=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThan(Date value) {
            addCriterion("commentTime <", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeLessThanOrEqualTo(Date value) {
            addCriterion("commentTime <=", value, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeIn(List<Date> values) {
            addCriterion("commentTime in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotIn(List<Date> values) {
            addCriterion("commentTime not in", values, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeBetween(Date value1, Date value2) {
            addCriterion("commentTime between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andCommenttimeNotBetween(Date value1, Date value2) {
            addCriterion("commentTime not between", value1, value2, "commenttime");
            return (Criteria) this;
        }

        public Criteria andReplytimeIsNull() {
            addCriterion("replyTime is null");
            return (Criteria) this;
        }

        public Criteria andReplytimeIsNotNull() {
            addCriterion("replyTime is not null");
            return (Criteria) this;
        }

        public Criteria andReplytimeEqualTo(Date value) {
            addCriterion("replyTime =", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeNotEqualTo(Date value) {
            addCriterion("replyTime <>", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeGreaterThan(Date value) {
            addCriterion("replyTime >", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("replyTime >=", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeLessThan(Date value) {
            addCriterion("replyTime <", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeLessThanOrEqualTo(Date value) {
            addCriterion("replyTime <=", value, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeIn(List<Date> values) {
            addCriterion("replyTime in", values, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeNotIn(List<Date> values) {
            addCriterion("replyTime not in", values, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeBetween(Date value1, Date value2) {
            addCriterion("replyTime between", value1, value2, "replytime");
            return (Criteria) this;
        }

        public Criteria andReplytimeNotBetween(Date value1, Date value2) {
            addCriterion("replyTime not between", value1, value2, "replytime");
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