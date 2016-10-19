package com.nitghowl.test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rizvan on 18/10/16.
 */

public class RestaurantDataModel {

    @SerializedName("restaurants")
    @Expose
    private List<Restaurant> restaurants = new ArrayList<Restaurant>();

    /**
     *
     * @return
     * The restaurants
     */
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    /**
     *
     * @param restaurants
     * The restaurants
     */
    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public class Restaurant {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("area")
        @Expose
        private String area;
        @SerializedName("avg_rating")
        @Expose
        private String avgRating;
        @SerializedName("cid")
        @Expose
        private String cid;
        @SerializedName("cuisine")
        @Expose
        private List<String> cuisine = new ArrayList<String>();
        @SerializedName("costForTwo")
        @Expose
        private String costForTwo;
        @SerializedName("deliveryTime")
        @Expose
        private Integer deliveryTime;
        @SerializedName("chain")
        @Expose
        private List<Chain> chain = new ArrayList<Chain>();
        @SerializedName("closed")
        @Expose
        private Boolean closed;

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The city
         */
        public String getCity() {
            return city;
        }

        /**
         *
         * @param city
         * The city
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         *
         * @return
         * The area
         */
        public String getArea() {
            return area;
        }

        /**
         *
         * @param area
         * The area
         */
        public void setArea(String area) {
            this.area = area;
        }

        /**
         *
         * @return
         * The avgRating
         */
        public String getAvgRating() {
            return avgRating;
        }

        /**
         *
         * @param avgRating
         * The avg_rating
         */
        public void setAvgRating(String avgRating) {
            this.avgRating = avgRating;
        }

        /**
         *
         * @return
         * The cid
         */
        public String getCid() {
            return cid;
        }

        /**
         *
         * @param cid
         * The cid
         */
        public void setCid(String cid) {
            this.cid = cid;
        }

        /**
         *
         * @return
         * The cuisine
         */
        public List<String> getCuisine() {
            return cuisine;
        }

        /**
         *
         * @param cuisine
         * The cuisine
         */
        public void setCuisine(List<String> cuisine) {
            this.cuisine = cuisine;
        }

        /**
         *
         * @return
         * The costForTwo
         */
        public String getCostForTwo() {
            return costForTwo;
        }

        /**
         *
         * @param costForTwo
         * The costForTwo
         */
        public void setCostForTwo(String costForTwo) {
            this.costForTwo = costForTwo;
        }

        /**
         *
         * @return
         * The deliveryTime
         */
        public Integer getDeliveryTime() {
            return deliveryTime;
        }

        /**
         *
         * @param deliveryTime
         * The deliveryTime
         */
        public void setDeliveryTime(Integer deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        /**
         *
         * @return
         * The chain
         */
        public List<Chain> getChain() {
            return chain;
        }

        /**
         *
         * @param chain
         * The chain
         */
        public void setChain(List<Chain> chain) {
            this.chain = chain;
        }

        /**
         *
         * @return
         * The closed
         */
        public Boolean getClosed() {
            return closed;
        }

        /**
         *
         * @param closed
         * The closed
         */
        public void setClosed(Boolean closed) {
            this.closed = closed;
        }

    }


    public class Chain {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("area")
        @Expose
        private String area;
        @SerializedName("avg_rating")
        @Expose
        private String avgRating;
        @SerializedName("cid")
        @Expose
        private String cid;
        @SerializedName("cuisine")
        @Expose
        private List<String> cuisine = new ArrayList<String>();
        @SerializedName("costForTwo")
        @Expose
        private String costForTwo;
        @SerializedName("deliveryTime")
        @Expose
        private Integer deliveryTime;
        @SerializedName("closed")
        @Expose
        private Boolean closed;

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The city
         */
        public String getCity() {
            return city;
        }

        /**
         *
         * @param city
         * The city
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         *
         * @return
         * The area
         */
        public String getArea() {
            return area;
        }

        /**
         *
         * @param area
         * The area
         */
        public void setArea(String area) {
            this.area = area;
        }

        /**
         *
         * @return
         * The avgRating
         */
        public String getAvgRating() {
            return avgRating;
        }

        /**
         *
         * @param avgRating
         * The avg_rating
         */
        public void setAvgRating(String avgRating) {
            this.avgRating = avgRating;
        }

        /**
         *
         * @return
         * The cid
         */
        public String getCid() {
            return cid;
        }

        /**
         *
         * @param cid
         * The cid
         */
        public void setCid(String cid) {
            this.cid = cid;
        }

        /**
         *
         * @return
         * The cuisine
         */
        public List<String> getCuisine() {
            return cuisine;
        }

        /**
         *
         * @param cuisine
         * The cuisine
         */
        public void setCuisine(List<String> cuisine) {
            this.cuisine = cuisine;
        }

        /**
         *
         * @return
         * The costForTwo
         */
        public String getCostForTwo() {
            return costForTwo;
        }

        /**
         *
         * @param costForTwo
         * The costForTwo
         */
        public void setCostForTwo(String costForTwo) {
            this.costForTwo = costForTwo;
        }

        /**
         *
         * @return
         * The deliveryTime
         */
        public Integer getDeliveryTime() {
            return deliveryTime;
        }

        /**
         *
         * @param deliveryTime
         * The deliveryTime
         */
        public void setDeliveryTime(Integer deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        /**
         *
         * @return
         * The closed
         */
        public Boolean getClosed() {
            return closed;
        }

        /**
         *
         * @param closed
         * The closed
         */
        public void setClosed(Boolean closed) {
            this.closed = closed;
        }

    }

}
