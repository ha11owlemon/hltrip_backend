package com.hall.Bean;

import java.util.ArrayList;
import java.util.List;

public class HouseOverviewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HouseOverviewExample() {
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

        public Criteria andCoverurlIsNull() {
            addCriterion("coverUrl is null");
            return (Criteria) this;
        }

        public Criteria andCoverurlIsNotNull() {
            addCriterion("coverUrl is not null");
            return (Criteria) this;
        }

        public Criteria andCoverurlEqualTo(String value) {
            addCriterion("coverUrl =", value, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlNotEqualTo(String value) {
            addCriterion("coverUrl <>", value, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlGreaterThan(String value) {
            addCriterion("coverUrl >", value, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlGreaterThanOrEqualTo(String value) {
            addCriterion("coverUrl >=", value, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlLessThan(String value) {
            addCriterion("coverUrl <", value, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlLessThanOrEqualTo(String value) {
            addCriterion("coverUrl <=", value, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlLike(String value) {
            addCriterion("coverUrl like", value, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlNotLike(String value) {
            addCriterion("coverUrl not like", value, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlIn(List<String> values) {
            addCriterion("coverUrl in", values, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlNotIn(List<String> values) {
            addCriterion("coverUrl not in", values, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlBetween(String value1, String value2) {
            addCriterion("coverUrl between", value1, value2, "coverurl");
            return (Criteria) this;
        }

        public Criteria andCoverurlNotBetween(String value1, String value2) {
            addCriterion("coverUrl not between", value1, value2, "coverurl");
            return (Criteria) this;
        }

        public Criteria andBedcountIsNull() {
            addCriterion("bedCount is null");
            return (Criteria) this;
        }

        public Criteria andBedcountIsNotNull() {
            addCriterion("bedCount is not null");
            return (Criteria) this;
        }

        public Criteria andBedcountEqualTo(Integer value) {
            addCriterion("bedCount =", value, "bedcount");
            return (Criteria) this;
        }

        public Criteria andBedcountNotEqualTo(Integer value) {
            addCriterion("bedCount <>", value, "bedcount");
            return (Criteria) this;
        }

        public Criteria andBedcountGreaterThan(Integer value) {
            addCriterion("bedCount >", value, "bedcount");
            return (Criteria) this;
        }

        public Criteria andBedcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bedCount >=", value, "bedcount");
            return (Criteria) this;
        }

        public Criteria andBedcountLessThan(Integer value) {
            addCriterion("bedCount <", value, "bedcount");
            return (Criteria) this;
        }

        public Criteria andBedcountLessThanOrEqualTo(Integer value) {
            addCriterion("bedCount <=", value, "bedcount");
            return (Criteria) this;
        }

        public Criteria andBedcountIn(List<Integer> values) {
            addCriterion("bedCount in", values, "bedcount");
            return (Criteria) this;
        }

        public Criteria andBedcountNotIn(List<Integer> values) {
            addCriterion("bedCount not in", values, "bedcount");
            return (Criteria) this;
        }

        public Criteria andBedcountBetween(Integer value1, Integer value2) {
            addCriterion("bedCount between", value1, value2, "bedcount");
            return (Criteria) this;
        }

        public Criteria andBedcountNotBetween(Integer value1, Integer value2) {
            addCriterion("bedCount not between", value1, value2, "bedcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountIsNull() {
            addCriterion("roomCount is null");
            return (Criteria) this;
        }

        public Criteria andRoomcountIsNotNull() {
            addCriterion("roomCount is not null");
            return (Criteria) this;
        }

        public Criteria andRoomcountEqualTo(Integer value) {
            addCriterion("roomCount =", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountNotEqualTo(Integer value) {
            addCriterion("roomCount <>", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountGreaterThan(Integer value) {
            addCriterion("roomCount >", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomCount >=", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountLessThan(Integer value) {
            addCriterion("roomCount <", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountLessThanOrEqualTo(Integer value) {
            addCriterion("roomCount <=", value, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountIn(List<Integer> values) {
            addCriterion("roomCount in", values, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountNotIn(List<Integer> values) {
            addCriterion("roomCount not in", values, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountBetween(Integer value1, Integer value2) {
            addCriterion("roomCount between", value1, value2, "roomcount");
            return (Criteria) this;
        }

        public Criteria andRoomcountNotBetween(Integer value1, Integer value2) {
            addCriterion("roomCount not between", value1, value2, "roomcount");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceIsNull() {
            addCriterion("discountPrice is null");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceIsNotNull() {
            addCriterion("discountPrice is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceEqualTo(Double value) {
            addCriterion("discountPrice =", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceNotEqualTo(Double value) {
            addCriterion("discountPrice <>", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceGreaterThan(Double value) {
            addCriterion("discountPrice >", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("discountPrice >=", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceLessThan(Double value) {
            addCriterion("discountPrice <", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceLessThanOrEqualTo(Double value) {
            addCriterion("discountPrice <=", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceIn(List<Double> values) {
            addCriterion("discountPrice in", values, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceNotIn(List<Double> values) {
            addCriterion("discountPrice not in", values, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceBetween(Double value1, Double value2) {
            addCriterion("discountPrice between", value1, value2, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceNotBetween(Double value1, Double value2) {
            addCriterion("discountPrice not between", value1, value2, "discountprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceIsNull() {
            addCriterion("originalPrice is null");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceIsNotNull() {
            addCriterion("originalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceEqualTo(Double value) {
            addCriterion("originalPrice =", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceNotEqualTo(Double value) {
            addCriterion("originalPrice <>", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceGreaterThan(Double value) {
            addCriterion("originalPrice >", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("originalPrice >=", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceLessThan(Double value) {
            addCriterion("originalPrice <", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceLessThanOrEqualTo(Double value) {
            addCriterion("originalPrice <=", value, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceIn(List<Double> values) {
            addCriterion("originalPrice in", values, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceNotIn(List<Double> values) {
            addCriterion("originalPrice not in", values, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceBetween(Double value1, Double value2) {
            addCriterion("originalPrice between", value1, value2, "originalprice");
            return (Criteria) this;
        }

        public Criteria andOriginalpriceNotBetween(Double value1, Double value2) {
            addCriterion("originalPrice not between", value1, value2, "originalprice");
            return (Criteria) this;
        }

        public Criteria andViewcountIsNull() {
            addCriterion("viewCount is null");
            return (Criteria) this;
        }

        public Criteria andViewcountIsNotNull() {
            addCriterion("viewCount is not null");
            return (Criteria) this;
        }

        public Criteria andViewcountEqualTo(Integer value) {
            addCriterion("viewCount =", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotEqualTo(Integer value) {
            addCriterion("viewCount <>", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountGreaterThan(Integer value) {
            addCriterion("viewCount >", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("viewCount >=", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountLessThan(Integer value) {
            addCriterion("viewCount <", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountLessThanOrEqualTo(Integer value) {
            addCriterion("viewCount <=", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountIn(List<Integer> values) {
            addCriterion("viewCount in", values, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotIn(List<Integer> values) {
            addCriterion("viewCount not in", values, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountBetween(Integer value1, Integer value2) {
            addCriterion("viewCount between", value1, value2, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotBetween(Integer value1, Integer value2) {
            addCriterion("viewCount not between", value1, value2, "viewcount");
            return (Criteria) this;
        }

        public Criteria andFavoritecountIsNull() {
            addCriterion("favoriteCount is null");
            return (Criteria) this;
        }

        public Criteria andFavoritecountIsNotNull() {
            addCriterion("favoriteCount is not null");
            return (Criteria) this;
        }

        public Criteria andFavoritecountEqualTo(Integer value) {
            addCriterion("favoriteCount =", value, "favoritecount");
            return (Criteria) this;
        }

        public Criteria andFavoritecountNotEqualTo(Integer value) {
            addCriterion("favoriteCount <>", value, "favoritecount");
            return (Criteria) this;
        }

        public Criteria andFavoritecountGreaterThan(Integer value) {
            addCriterion("favoriteCount >", value, "favoritecount");
            return (Criteria) this;
        }

        public Criteria andFavoritecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("favoriteCount >=", value, "favoritecount");
            return (Criteria) this;
        }

        public Criteria andFavoritecountLessThan(Integer value) {
            addCriterion("favoriteCount <", value, "favoritecount");
            return (Criteria) this;
        }

        public Criteria andFavoritecountLessThanOrEqualTo(Integer value) {
            addCriterion("favoriteCount <=", value, "favoritecount");
            return (Criteria) this;
        }

        public Criteria andFavoritecountIn(List<Integer> values) {
            addCriterion("favoriteCount in", values, "favoritecount");
            return (Criteria) this;
        }

        public Criteria andFavoritecountNotIn(List<Integer> values) {
            addCriterion("favoriteCount not in", values, "favoritecount");
            return (Criteria) this;
        }

        public Criteria andFavoritecountBetween(Integer value1, Integer value2) {
            addCriterion("favoriteCount between", value1, value2, "favoritecount");
            return (Criteria) this;
        }

        public Criteria andFavoritecountNotBetween(Integer value1, Integer value2) {
            addCriterion("favoriteCount not between", value1, value2, "favoritecount");
            return (Criteria) this;
        }

        public Criteria andDealcountIsNull() {
            addCriterion("dealCount is null");
            return (Criteria) this;
        }

        public Criteria andDealcountIsNotNull() {
            addCriterion("dealCount is not null");
            return (Criteria) this;
        }

        public Criteria andDealcountEqualTo(Integer value) {
            addCriterion("dealCount =", value, "dealcount");
            return (Criteria) this;
        }

        public Criteria andDealcountNotEqualTo(Integer value) {
            addCriterion("dealCount <>", value, "dealcount");
            return (Criteria) this;
        }

        public Criteria andDealcountGreaterThan(Integer value) {
            addCriterion("dealCount >", value, "dealcount");
            return (Criteria) this;
        }

        public Criteria andDealcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("dealCount >=", value, "dealcount");
            return (Criteria) this;
        }

        public Criteria andDealcountLessThan(Integer value) {
            addCriterion("dealCount <", value, "dealcount");
            return (Criteria) this;
        }

        public Criteria andDealcountLessThanOrEqualTo(Integer value) {
            addCriterion("dealCount <=", value, "dealcount");
            return (Criteria) this;
        }

        public Criteria andDealcountIn(List<Integer> values) {
            addCriterion("dealCount in", values, "dealcount");
            return (Criteria) this;
        }

        public Criteria andDealcountNotIn(List<Integer> values) {
            addCriterion("dealCount not in", values, "dealcount");
            return (Criteria) this;
        }

        public Criteria andDealcountBetween(Integer value1, Integer value2) {
            addCriterion("dealCount between", value1, value2, "dealcount");
            return (Criteria) this;
        }

        public Criteria andDealcountNotBetween(Integer value1, Integer value2) {
            addCriterion("dealCount not between", value1, value2, "dealcount");
            return (Criteria) this;
        }

        public Criteria andHousenameIsNull() {
            addCriterion("houseName is null");
            return (Criteria) this;
        }

        public Criteria andHousenameIsNotNull() {
            addCriterion("houseName is not null");
            return (Criteria) this;
        }

        public Criteria andHousenameEqualTo(String value) {
            addCriterion("houseName =", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameNotEqualTo(String value) {
            addCriterion("houseName <>", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameGreaterThan(String value) {
            addCriterion("houseName >", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameGreaterThanOrEqualTo(String value) {
            addCriterion("houseName >=", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameLessThan(String value) {
            addCriterion("houseName <", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameLessThanOrEqualTo(String value) {
            addCriterion("houseName <=", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameLike(String value) {
            addCriterion("houseName like", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameNotLike(String value) {
            addCriterion("houseName not like", value, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameIn(List<String> values) {
            addCriterion("houseName in", values, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameNotIn(List<String> values) {
            addCriterion("houseName not in", values, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameBetween(String value1, String value2) {
            addCriterion("houseName between", value1, value2, "housename");
            return (Criteria) this;
        }

        public Criteria andHousenameNotBetween(String value1, String value2) {
            addCriterion("houseName not between", value1, value2, "housename");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andRentaltypeIsNull() {
            addCriterion("rentalType is null");
            return (Criteria) this;
        }

        public Criteria andRentaltypeIsNotNull() {
            addCriterion("rentalType is not null");
            return (Criteria) this;
        }

        public Criteria andRentaltypeEqualTo(String value) {
            addCriterion("rentalType =", value, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeNotEqualTo(String value) {
            addCriterion("rentalType <>", value, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeGreaterThan(String value) {
            addCriterion("rentalType >", value, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeGreaterThanOrEqualTo(String value) {
            addCriterion("rentalType >=", value, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeLessThan(String value) {
            addCriterion("rentalType <", value, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeLessThanOrEqualTo(String value) {
            addCriterion("rentalType <=", value, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeLike(String value) {
            addCriterion("rentalType like", value, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeNotLike(String value) {
            addCriterion("rentalType not like", value, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeIn(List<String> values) {
            addCriterion("rentalType in", values, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeNotIn(List<String> values) {
            addCriterion("rentalType not in", values, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeBetween(String value1, String value2) {
            addCriterion("rentalType between", value1, value2, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andRentaltypeNotBetween(String value1, String value2) {
            addCriterion("rentalType not between", value1, value2, "rentaltype");
            return (Criteria) this;
        }

        public Criteria andBathroomcountIsNull() {
            addCriterion("bathroomCount is null");
            return (Criteria) this;
        }

        public Criteria andBathroomcountIsNotNull() {
            addCriterion("bathroomCount is not null");
            return (Criteria) this;
        }

        public Criteria andBathroomcountEqualTo(Integer value) {
            addCriterion("bathroomCount =", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountNotEqualTo(Integer value) {
            addCriterion("bathroomCount <>", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountGreaterThan(Integer value) {
            addCriterion("bathroomCount >", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("bathroomCount >=", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountLessThan(Integer value) {
            addCriterion("bathroomCount <", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountLessThanOrEqualTo(Integer value) {
            addCriterion("bathroomCount <=", value, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountIn(List<Integer> values) {
            addCriterion("bathroomCount in", values, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountNotIn(List<Integer> values) {
            addCriterion("bathroomCount not in", values, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountBetween(Integer value1, Integer value2) {
            addCriterion("bathroomCount between", value1, value2, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andBathroomcountNotBetween(Integer value1, Integer value2) {
            addCriterion("bathroomCount not between", value1, value2, "bathroomcount");
            return (Criteria) this;
        }

        public Criteria andKitchencountIsNull() {
            addCriterion("kitchenCount is null");
            return (Criteria) this;
        }

        public Criteria andKitchencountIsNotNull() {
            addCriterion("kitchenCount is not null");
            return (Criteria) this;
        }

        public Criteria andKitchencountEqualTo(Integer value) {
            addCriterion("kitchenCount =", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountNotEqualTo(Integer value) {
            addCriterion("kitchenCount <>", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountGreaterThan(Integer value) {
            addCriterion("kitchenCount >", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountGreaterThanOrEqualTo(Integer value) {
            addCriterion("kitchenCount >=", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountLessThan(Integer value) {
            addCriterion("kitchenCount <", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountLessThanOrEqualTo(Integer value) {
            addCriterion("kitchenCount <=", value, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountIn(List<Integer> values) {
            addCriterion("kitchenCount in", values, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountNotIn(List<Integer> values) {
            addCriterion("kitchenCount not in", values, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountBetween(Integer value1, Integer value2) {
            addCriterion("kitchenCount between", value1, value2, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andKitchencountNotBetween(Integer value1, Integer value2) {
            addCriterion("kitchenCount not between", value1, value2, "kitchencount");
            return (Criteria) this;
        }

        public Criteria andMaxguestsIsNull() {
            addCriterion("maxGuests is null");
            return (Criteria) this;
        }

        public Criteria andMaxguestsIsNotNull() {
            addCriterion("maxGuests is not null");
            return (Criteria) this;
        }

        public Criteria andMaxguestsEqualTo(Integer value) {
            addCriterion("maxGuests =", value, "maxguests");
            return (Criteria) this;
        }

        public Criteria andMaxguestsNotEqualTo(Integer value) {
            addCriterion("maxGuests <>", value, "maxguests");
            return (Criteria) this;
        }

        public Criteria andMaxguestsGreaterThan(Integer value) {
            addCriterion("maxGuests >", value, "maxguests");
            return (Criteria) this;
        }

        public Criteria andMaxguestsGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxGuests >=", value, "maxguests");
            return (Criteria) this;
        }

        public Criteria andMaxguestsLessThan(Integer value) {
            addCriterion("maxGuests <", value, "maxguests");
            return (Criteria) this;
        }

        public Criteria andMaxguestsLessThanOrEqualTo(Integer value) {
            addCriterion("maxGuests <=", value, "maxguests");
            return (Criteria) this;
        }

        public Criteria andMaxguestsIn(List<Integer> values) {
            addCriterion("maxGuests in", values, "maxguests");
            return (Criteria) this;
        }

        public Criteria andMaxguestsNotIn(List<Integer> values) {
            addCriterion("maxGuests not in", values, "maxguests");
            return (Criteria) this;
        }

        public Criteria andMaxguestsBetween(Integer value1, Integer value2) {
            addCriterion("maxGuests between", value1, value2, "maxguests");
            return (Criteria) this;
        }

        public Criteria andMaxguestsNotBetween(Integer value1, Integer value2) {
            addCriterion("maxGuests not between", value1, value2, "maxguests");
            return (Criteria) this;
        }

        public Criteria andHousetypeIsNull() {
            addCriterion("houseType is null");
            return (Criteria) this;
        }

        public Criteria andHousetypeIsNotNull() {
            addCriterion("houseType is not null");
            return (Criteria) this;
        }

        public Criteria andHousetypeEqualTo(String value) {
            addCriterion("houseType =", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeNotEqualTo(String value) {
            addCriterion("houseType <>", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeGreaterThan(String value) {
            addCriterion("houseType >", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeGreaterThanOrEqualTo(String value) {
            addCriterion("houseType >=", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeLessThan(String value) {
            addCriterion("houseType <", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeLessThanOrEqualTo(String value) {
            addCriterion("houseType <=", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeLike(String value) {
            addCriterion("houseType like", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeNotLike(String value) {
            addCriterion("houseType not like", value, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeIn(List<String> values) {
            addCriterion("houseType in", values, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeNotIn(List<String> values) {
            addCriterion("houseType not in", values, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeBetween(String value1, String value2) {
            addCriterion("houseType between", value1, value2, "housetype");
            return (Criteria) this;
        }

        public Criteria andHousetypeNotBetween(String value1, String value2) {
            addCriterion("houseType not between", value1, value2, "housetype");
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

        public Criteria andLandlordnicknameIsNull() {
            addCriterion("landlordNickname is null");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameIsNotNull() {
            addCriterion("landlordNickname is not null");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameEqualTo(String value) {
            addCriterion("landlordNickname =", value, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameNotEqualTo(String value) {
            addCriterion("landlordNickname <>", value, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameGreaterThan(String value) {
            addCriterion("landlordNickname >", value, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameGreaterThanOrEqualTo(String value) {
            addCriterion("landlordNickname >=", value, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameLessThan(String value) {
            addCriterion("landlordNickname <", value, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameLessThanOrEqualTo(String value) {
            addCriterion("landlordNickname <=", value, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameLike(String value) {
            addCriterion("landlordNickname like", value, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameNotLike(String value) {
            addCriterion("landlordNickname not like", value, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameIn(List<String> values) {
            addCriterion("landlordNickname in", values, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameNotIn(List<String> values) {
            addCriterion("landlordNickname not in", values, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameBetween(String value1, String value2) {
            addCriterion("landlordNickname between", value1, value2, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andLandlordnicknameNotBetween(String value1, String value2) {
            addCriterion("landlordNickname not between", value1, value2, "landlordnickname");
            return (Criteria) this;
        }

        public Criteria andBed218IsNull() {
            addCriterion("bed218 is null");
            return (Criteria) this;
        }

        public Criteria andBed218IsNotNull() {
            addCriterion("bed218 is not null");
            return (Criteria) this;
        }

        public Criteria andBed218EqualTo(Integer value) {
            addCriterion("bed218 =", value, "bed218");
            return (Criteria) this;
        }

        public Criteria andBed218NotEqualTo(Integer value) {
            addCriterion("bed218 <>", value, "bed218");
            return (Criteria) this;
        }

        public Criteria andBed218GreaterThan(Integer value) {
            addCriterion("bed218 >", value, "bed218");
            return (Criteria) this;
        }

        public Criteria andBed218GreaterThanOrEqualTo(Integer value) {
            addCriterion("bed218 >=", value, "bed218");
            return (Criteria) this;
        }

        public Criteria andBed218LessThan(Integer value) {
            addCriterion("bed218 <", value, "bed218");
            return (Criteria) this;
        }

        public Criteria andBed218LessThanOrEqualTo(Integer value) {
            addCriterion("bed218 <=", value, "bed218");
            return (Criteria) this;
        }

        public Criteria andBed218In(List<Integer> values) {
            addCriterion("bed218 in", values, "bed218");
            return (Criteria) this;
        }

        public Criteria andBed218NotIn(List<Integer> values) {
            addCriterion("bed218 not in", values, "bed218");
            return (Criteria) this;
        }

        public Criteria andBed218Between(Integer value1, Integer value2) {
            addCriterion("bed218 between", value1, value2, "bed218");
            return (Criteria) this;
        }

        public Criteria andBed218NotBetween(Integer value1, Integer value2) {
            addCriterion("bed218 not between", value1, value2, "bed218");
            return (Criteria) this;
        }

        public Criteria andBed215IsNull() {
            addCriterion("bed215 is null");
            return (Criteria) this;
        }

        public Criteria andBed215IsNotNull() {
            addCriterion("bed215 is not null");
            return (Criteria) this;
        }

        public Criteria andBed215EqualTo(Integer value) {
            addCriterion("bed215 =", value, "bed215");
            return (Criteria) this;
        }

        public Criteria andBed215NotEqualTo(Integer value) {
            addCriterion("bed215 <>", value, "bed215");
            return (Criteria) this;
        }

        public Criteria andBed215GreaterThan(Integer value) {
            addCriterion("bed215 >", value, "bed215");
            return (Criteria) this;
        }

        public Criteria andBed215GreaterThanOrEqualTo(Integer value) {
            addCriterion("bed215 >=", value, "bed215");
            return (Criteria) this;
        }

        public Criteria andBed215LessThan(Integer value) {
            addCriterion("bed215 <", value, "bed215");
            return (Criteria) this;
        }

        public Criteria andBed215LessThanOrEqualTo(Integer value) {
            addCriterion("bed215 <=", value, "bed215");
            return (Criteria) this;
        }

        public Criteria andBed215In(List<Integer> values) {
            addCriterion("bed215 in", values, "bed215");
            return (Criteria) this;
        }

        public Criteria andBed215NotIn(List<Integer> values) {
            addCriterion("bed215 not in", values, "bed215");
            return (Criteria) this;
        }

        public Criteria andBed215Between(Integer value1, Integer value2) {
            addCriterion("bed215 between", value1, value2, "bed215");
            return (Criteria) this;
        }

        public Criteria andBed215NotBetween(Integer value1, Integer value2) {
            addCriterion("bed215 not between", value1, value2, "bed215");
            return (Criteria) this;
        }

        public Criteria andBed212IsNull() {
            addCriterion("bed212 is null");
            return (Criteria) this;
        }

        public Criteria andBed212IsNotNull() {
            addCriterion("bed212 is not null");
            return (Criteria) this;
        }

        public Criteria andBed212EqualTo(Integer value) {
            addCriterion("bed212 =", value, "bed212");
            return (Criteria) this;
        }

        public Criteria andBed212NotEqualTo(Integer value) {
            addCriterion("bed212 <>", value, "bed212");
            return (Criteria) this;
        }

        public Criteria andBed212GreaterThan(Integer value) {
            addCriterion("bed212 >", value, "bed212");
            return (Criteria) this;
        }

        public Criteria andBed212GreaterThanOrEqualTo(Integer value) {
            addCriterion("bed212 >=", value, "bed212");
            return (Criteria) this;
        }

        public Criteria andBed212LessThan(Integer value) {
            addCriterion("bed212 <", value, "bed212");
            return (Criteria) this;
        }

        public Criteria andBed212LessThanOrEqualTo(Integer value) {
            addCriterion("bed212 <=", value, "bed212");
            return (Criteria) this;
        }

        public Criteria andBed212In(List<Integer> values) {
            addCriterion("bed212 in", values, "bed212");
            return (Criteria) this;
        }

        public Criteria andBed212NotIn(List<Integer> values) {
            addCriterion("bed212 not in", values, "bed212");
            return (Criteria) this;
        }

        public Criteria andBed212Between(Integer value1, Integer value2) {
            addCriterion("bed212 between", value1, value2, "bed212");
            return (Criteria) this;
        }

        public Criteria andBed212NotBetween(Integer value1, Integer value2) {
            addCriterion("bed212 not between", value1, value2, "bed212");
            return (Criteria) this;
        }

        public Criteria andTatamiIsNull() {
            addCriterion("tatami is null");
            return (Criteria) this;
        }

        public Criteria andTatamiIsNotNull() {
            addCriterion("tatami is not null");
            return (Criteria) this;
        }

        public Criteria andTatamiEqualTo(String value) {
            addCriterion("tatami =", value, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiNotEqualTo(String value) {
            addCriterion("tatami <>", value, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiGreaterThan(String value) {
            addCriterion("tatami >", value, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiGreaterThanOrEqualTo(String value) {
            addCriterion("tatami >=", value, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiLessThan(String value) {
            addCriterion("tatami <", value, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiLessThanOrEqualTo(String value) {
            addCriterion("tatami <=", value, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiLike(String value) {
            addCriterion("tatami like", value, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiNotLike(String value) {
            addCriterion("tatami not like", value, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiIn(List<String> values) {
            addCriterion("tatami in", values, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiNotIn(List<String> values) {
            addCriterion("tatami not in", values, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiBetween(String value1, String value2) {
            addCriterion("tatami between", value1, value2, "tatami");
            return (Criteria) this;
        }

        public Criteria andTatamiNotBetween(String value1, String value2) {
            addCriterion("tatami not between", value1, value2, "tatami");
            return (Criteria) this;
        }

        public Criteria andCommentcountIsNull() {
            addCriterion("commentCount is null");
            return (Criteria) this;
        }

        public Criteria andCommentcountIsNotNull() {
            addCriterion("commentCount is not null");
            return (Criteria) this;
        }

        public Criteria andCommentcountEqualTo(Integer value) {
            addCriterion("commentCount =", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountNotEqualTo(Integer value) {
            addCriterion("commentCount <>", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountGreaterThan(Integer value) {
            addCriterion("commentCount >", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentCount >=", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountLessThan(Integer value) {
            addCriterion("commentCount <", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountLessThanOrEqualTo(Integer value) {
            addCriterion("commentCount <=", value, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountIn(List<Integer> values) {
            addCriterion("commentCount in", values, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountNotIn(List<Integer> values) {
            addCriterion("commentCount not in", values, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountBetween(Integer value1, Integer value2) {
            addCriterion("commentCount between", value1, value2, "commentcount");
            return (Criteria) this;
        }

        public Criteria andCommentcountNotBetween(Integer value1, Integer value2) {
            addCriterion("commentCount not between", value1, value2, "commentcount");
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

        public Criteria andVstatusIsNull() {
            addCriterion("vStatus is null");
            return (Criteria) this;
        }

        public Criteria andVstatusIsNotNull() {
            addCriterion("vStatus is not null");
            return (Criteria) this;
        }

        public Criteria andVstatusEqualTo(String value) {
            addCriterion("vStatus =", value, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusNotEqualTo(String value) {
            addCriterion("vStatus <>", value, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusGreaterThan(String value) {
            addCriterion("vStatus >", value, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusGreaterThanOrEqualTo(String value) {
            addCriterion("vStatus >=", value, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusLessThan(String value) {
            addCriterion("vStatus <", value, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusLessThanOrEqualTo(String value) {
            addCriterion("vStatus <=", value, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusLike(String value) {
            addCriterion("vStatus like", value, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusNotLike(String value) {
            addCriterion("vStatus not like", value, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusIn(List<String> values) {
            addCriterion("vStatus in", values, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusNotIn(List<String> values) {
            addCriterion("vStatus not in", values, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusBetween(String value1, String value2) {
            addCriterion("vStatus between", value1, value2, "vstatus");
            return (Criteria) this;
        }

        public Criteria andVstatusNotBetween(String value1, String value2) {
            addCriterion("vStatus not between", value1, value2, "vstatus");
            return (Criteria) this;
        }

        public Criteria andHotvalueIsNull() {
            addCriterion("hotValue is null");
            return (Criteria) this;
        }

        public Criteria andHotvalueIsNotNull() {
            addCriterion("hotValue is not null");
            return (Criteria) this;
        }

        public Criteria andHotvalueEqualTo(Integer value) {
            addCriterion("hotValue =", value, "hotvalue");
            return (Criteria) this;
        }

        public Criteria andHotvalueNotEqualTo(Integer value) {
            addCriterion("hotValue <>", value, "hotvalue");
            return (Criteria) this;
        }

        public Criteria andHotvalueGreaterThan(Integer value) {
            addCriterion("hotValue >", value, "hotvalue");
            return (Criteria) this;
        }

        public Criteria andHotvalueGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotValue >=", value, "hotvalue");
            return (Criteria) this;
        }

        public Criteria andHotvalueLessThan(Integer value) {
            addCriterion("hotValue <", value, "hotvalue");
            return (Criteria) this;
        }

        public Criteria andHotvalueLessThanOrEqualTo(Integer value) {
            addCriterion("hotValue <=", value, "hotvalue");
            return (Criteria) this;
        }

        public Criteria andHotvalueIn(List<Integer> values) {
            addCriterion("hotValue in", values, "hotvalue");
            return (Criteria) this;
        }

        public Criteria andHotvalueNotIn(List<Integer> values) {
            addCriterion("hotValue not in", values, "hotvalue");
            return (Criteria) this;
        }

        public Criteria andHotvalueBetween(Integer value1, Integer value2) {
            addCriterion("hotValue between", value1, value2, "hotvalue");
            return (Criteria) this;
        }

        public Criteria andHotvalueNotBetween(Integer value1, Integer value2) {
            addCriterion("hotValue not between", value1, value2, "hotvalue");
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