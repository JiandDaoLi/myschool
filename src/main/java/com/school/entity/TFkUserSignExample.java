package com.school.entity;

import java.util.ArrayList;
import java.util.List;

public class TFkUserSignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TFkUserSignExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andFkUserKeyIsNull() {
            addCriterion("fk_user_key is null");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyIsNotNull() {
            addCriterion("fk_user_key is not null");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyEqualTo(Integer value) {
            addCriterion("fk_user_key =", value, "fkUserKey");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyNotEqualTo(Integer value) {
            addCriterion("fk_user_key <>", value, "fkUserKey");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyGreaterThan(Integer value) {
            addCriterion("fk_user_key >", value, "fkUserKey");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_user_key >=", value, "fkUserKey");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyLessThan(Integer value) {
            addCriterion("fk_user_key <", value, "fkUserKey");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyLessThanOrEqualTo(Integer value) {
            addCriterion("fk_user_key <=", value, "fkUserKey");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyIn(List<Integer> values) {
            addCriterion("fk_user_key in", values, "fkUserKey");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyNotIn(List<Integer> values) {
            addCriterion("fk_user_key not in", values, "fkUserKey");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyBetween(Integer value1, Integer value2) {
            addCriterion("fk_user_key between", value1, value2, "fkUserKey");
            return (Criteria) this;
        }

        public Criteria andFkUserKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_user_key not between", value1, value2, "fkUserKey");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyIsNull() {
            addCriterion("fk_article_key is null");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyIsNotNull() {
            addCriterion("fk_article_key is not null");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyEqualTo(Integer value) {
            addCriterion("fk_article_key =", value, "fkArticleKey");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyNotEqualTo(Integer value) {
            addCriterion("fk_article_key <>", value, "fkArticleKey");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyGreaterThan(Integer value) {
            addCriterion("fk_article_key >", value, "fkArticleKey");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_article_key >=", value, "fkArticleKey");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyLessThan(Integer value) {
            addCriterion("fk_article_key <", value, "fkArticleKey");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyLessThanOrEqualTo(Integer value) {
            addCriterion("fk_article_key <=", value, "fkArticleKey");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyIn(List<Integer> values) {
            addCriterion("fk_article_key in", values, "fkArticleKey");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyNotIn(List<Integer> values) {
            addCriterion("fk_article_key not in", values, "fkArticleKey");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyBetween(Integer value1, Integer value2) {
            addCriterion("fk_article_key between", value1, value2, "fkArticleKey");
            return (Criteria) this;
        }

        public Criteria andFkArticleKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_article_key not between", value1, value2, "fkArticleKey");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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