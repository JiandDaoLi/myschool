package com.school.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TForumArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TForumArticleExample() {
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyIsNull() {
            addCriterion("fk_forum_type_key is null");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyIsNotNull() {
            addCriterion("fk_forum_type_key is not null");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyEqualTo(Integer value) {
            addCriterion("fk_forum_type_key =", value, "fkForumTypeKey");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyNotEqualTo(Integer value) {
            addCriterion("fk_forum_type_key <>", value, "fkForumTypeKey");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyGreaterThan(Integer value) {
            addCriterion("fk_forum_type_key >", value, "fkForumTypeKey");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_forum_type_key >=", value, "fkForumTypeKey");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyLessThan(Integer value) {
            addCriterion("fk_forum_type_key <", value, "fkForumTypeKey");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyLessThanOrEqualTo(Integer value) {
            addCriterion("fk_forum_type_key <=", value, "fkForumTypeKey");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyIn(List<Integer> values) {
            addCriterion("fk_forum_type_key in", values, "fkForumTypeKey");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyNotIn(List<Integer> values) {
            addCriterion("fk_forum_type_key not in", values, "fkForumTypeKey");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyBetween(Integer value1, Integer value2) {
            addCriterion("fk_forum_type_key between", value1, value2, "fkForumTypeKey");
            return (Criteria) this;
        }

        public Criteria andFkForumTypeKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_forum_type_key not between", value1, value2, "fkForumTypeKey");
            return (Criteria) this;
        }

        public Criteria andContentTextIsNull() {
            addCriterion("content_text is null");
            return (Criteria) this;
        }

        public Criteria andContentTextIsNotNull() {
            addCriterion("content_text is not null");
            return (Criteria) this;
        }

        public Criteria andContentTextEqualTo(String value) {
            addCriterion("content_text =", value, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextNotEqualTo(String value) {
            addCriterion("content_text <>", value, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextGreaterThan(String value) {
            addCriterion("content_text >", value, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextGreaterThanOrEqualTo(String value) {
            addCriterion("content_text >=", value, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextLessThan(String value) {
            addCriterion("content_text <", value, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextLessThanOrEqualTo(String value) {
            addCriterion("content_text <=", value, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextLike(String value) {
            addCriterion("content_text like", value, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextNotLike(String value) {
            addCriterion("content_text not like", value, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextIn(List<String> values) {
            addCriterion("content_text in", values, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextNotIn(List<String> values) {
            addCriterion("content_text not in", values, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextBetween(String value1, String value2) {
            addCriterion("content_text between", value1, value2, "contentText");
            return (Criteria) this;
        }

        public Criteria andContentTextNotBetween(String value1, String value2) {
            addCriterion("content_text not between", value1, value2, "contentText");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
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

        public Criteria andViolationCountIsNull() {
            addCriterion("violation_count is null");
            return (Criteria) this;
        }

        public Criteria andViolationCountIsNotNull() {
            addCriterion("violation_count is not null");
            return (Criteria) this;
        }

        public Criteria andViolationCountEqualTo(Integer value) {
            addCriterion("violation_count =", value, "violationCount");
            return (Criteria) this;
        }

        public Criteria andViolationCountNotEqualTo(Integer value) {
            addCriterion("violation_count <>", value, "violationCount");
            return (Criteria) this;
        }

        public Criteria andViolationCountGreaterThan(Integer value) {
            addCriterion("violation_count >", value, "violationCount");
            return (Criteria) this;
        }

        public Criteria andViolationCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("violation_count >=", value, "violationCount");
            return (Criteria) this;
        }

        public Criteria andViolationCountLessThan(Integer value) {
            addCriterion("violation_count <", value, "violationCount");
            return (Criteria) this;
        }

        public Criteria andViolationCountLessThanOrEqualTo(Integer value) {
            addCriterion("violation_count <=", value, "violationCount");
            return (Criteria) this;
        }

        public Criteria andViolationCountIn(List<Integer> values) {
            addCriterion("violation_count in", values, "violationCount");
            return (Criteria) this;
        }

        public Criteria andViolationCountNotIn(List<Integer> values) {
            addCriterion("violation_count not in", values, "violationCount");
            return (Criteria) this;
        }

        public Criteria andViolationCountBetween(Integer value1, Integer value2) {
            addCriterion("violation_count between", value1, value2, "violationCount");
            return (Criteria) this;
        }

        public Criteria andViolationCountNotBetween(Integer value1, Integer value2) {
            addCriterion("violation_count not between", value1, value2, "violationCount");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusIsNull() {
            addCriterion("fk_applaud_status is null");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusIsNotNull() {
            addCriterion("fk_applaud_status is not null");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusEqualTo(Integer value) {
            addCriterion("fk_applaud_status =", value, "fkApplaudStatus");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusNotEqualTo(Integer value) {
            addCriterion("fk_applaud_status <>", value, "fkApplaudStatus");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusGreaterThan(Integer value) {
            addCriterion("fk_applaud_status >", value, "fkApplaudStatus");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_applaud_status >=", value, "fkApplaudStatus");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusLessThan(Integer value) {
            addCriterion("fk_applaud_status <", value, "fkApplaudStatus");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusLessThanOrEqualTo(Integer value) {
            addCriterion("fk_applaud_status <=", value, "fkApplaudStatus");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusIn(List<Integer> values) {
            addCriterion("fk_applaud_status in", values, "fkApplaudStatus");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusNotIn(List<Integer> values) {
            addCriterion("fk_applaud_status not in", values, "fkApplaudStatus");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusBetween(Integer value1, Integer value2) {
            addCriterion("fk_applaud_status between", value1, value2, "fkApplaudStatus");
            return (Criteria) this;
        }

        public Criteria andFkApplaudStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_applaud_status not between", value1, value2, "fkApplaudStatus");
            return (Criteria) this;
        }

        public Criteria andBrowseConutIsNull() {
            addCriterion("browse_conut is null");
            return (Criteria) this;
        }

        public Criteria andBrowseConutIsNotNull() {
            addCriterion("browse_conut is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseConutEqualTo(Integer value) {
            addCriterion("browse_conut =", value, "browseConut");
            return (Criteria) this;
        }

        public Criteria andBrowseConutNotEqualTo(Integer value) {
            addCriterion("browse_conut <>", value, "browseConut");
            return (Criteria) this;
        }

        public Criteria andBrowseConutGreaterThan(Integer value) {
            addCriterion("browse_conut >", value, "browseConut");
            return (Criteria) this;
        }

        public Criteria andBrowseConutGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_conut >=", value, "browseConut");
            return (Criteria) this;
        }

        public Criteria andBrowseConutLessThan(Integer value) {
            addCriterion("browse_conut <", value, "browseConut");
            return (Criteria) this;
        }

        public Criteria andBrowseConutLessThanOrEqualTo(Integer value) {
            addCriterion("browse_conut <=", value, "browseConut");
            return (Criteria) this;
        }

        public Criteria andBrowseConutIn(List<Integer> values) {
            addCriterion("browse_conut in", values, "browseConut");
            return (Criteria) this;
        }

        public Criteria andBrowseConutNotIn(List<Integer> values) {
            addCriterion("browse_conut not in", values, "browseConut");
            return (Criteria) this;
        }

        public Criteria andBrowseConutBetween(Integer value1, Integer value2) {
            addCriterion("browse_conut between", value1, value2, "browseConut");
            return (Criteria) this;
        }

        public Criteria andBrowseConutNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_conut not between", value1, value2, "browseConut");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
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