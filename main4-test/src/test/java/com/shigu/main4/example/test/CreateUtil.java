package com.shigu.main4.example.test;

import java.lang.reflect.Field;

/**
 * Created by sean on 2017-02-13-0013.
 */
public class CreateUtil {
    public CreateUtil() {
    }

    public static String interfaceString(String beanName, String intpackageName, String beanPackage) {
        String repositoryName = beanPackage.replace("top.latfat.", "").replace(".data.beans." + beanName, "");
        String code = "package " + intpackageName + ";\n" + "\n" + "import com.opentae.core.mybatis.core.config.MyBatisRepository;\n" + "import com.opentae.core.mybatis.mapper.Mapper;\n" + "import " + beanPackage + ";\n" + "import org.springframework.context.annotation.Lazy;\n" + "import org.springframework.context.annotation.Scope;\n" + "\n" + "/**\n" + " * \n" + " * Created by exampleCreater.\n" + " */\n" + "@MyBatisRepository(\"tae_" + repositoryName + "_" + lowfirst(beanName) + "Mapper\")\n" + "@Scope(\"singleton\")\n" + "@Lazy(true)\n" + "public interface " + beanName + "Mapper extends Mapper<" + beanName + "> {\n" + "}\n";
        return code;
    }

    private static String mkPackage(String packageStr) {
        return "package " + packageStr + ";\n" + "\n" + "import java.util.ArrayList;\n" + "import java.util.Date;\n" + "import java.util.List;\n" + "import com.opentae.core.mybatis.SgExample;\n" + "\n";
    }

    private static String createFields(String beanClassName, String beanName) throws ClassNotFoundException {
        String code = "";
        Class bean = Class.forName(beanClassName);
        Field[] fields = bean.getDeclaredFields();
        Field[] var8 = fields;
        int var7 = fields.length;

        for (int var6 = 0; var6 < var7; ++var6) {
            Field f = var8[var6];
            if (f.getModifiers() == 2) {
                String upname = upfirst(f.getName());
                String fname = f.getName();
                String dname = dataField(f.getName());
                code = code + "\n        public " + beanName + "Example.Criteria and" + upname + "IsNull() {\n" + "            this.addCriterion(\"" + dname + " is null\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "IsNotNull() {\n" + "            this.addCriterion(\"" + dname + " is not null\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "EqualTo(" + f.getType().getSimpleName() + " value) {\n" + "            this.addCriterion(\"" + dname + " =\", value, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "NotEqualTo(" + f.getType().getSimpleName() + " value) {\n" + "            this.addCriterion(\"" + dname + " <>\", value, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "GreaterThan(" + f.getType().getSimpleName() + " value) {\n" + "            this.addCriterion(\"" + dname + " >\", value, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "GreaterThanOrEqualTo(" + f.getType().getSimpleName() + " value) {\n" + "            this.addCriterion(\"" + dname + " >=\", value, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "LessThan(" + f.getType().getSimpleName() + " value) {\n" + "            this.addCriterion(\"" + dname + " <\", value, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "LessThanOrEqualTo(" + f.getType().getSimpleName() + " value) {\n" + "            this.addCriterion(\"" + dname + " <=\", value, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "Like(String value) {\n" + "            this.addCriterion(\"" + dname + " like\", value, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "NotLike(String value) {\n" + "            this.addCriterion(\"" + dname + " not like\", value, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }" + "        public " + beanName + "Example.Criteria and" + upname + "In(List<" + f.getType().getSimpleName() + "> values) {\n" + "            this.addCriterion(\"" + dname + " in\", values, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "NotIn(List<" + f.getType().getSimpleName() + "> values) {\n" + "            this.addCriterion(\"" + dname + " not in\", values, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "Between(" + f.getType().getSimpleName() + " value1, " + f.getType().getSimpleName() + " value2) {\n" + "            this.addCriterion(\"" + dname + " between\", value1, value2, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "NotBetween(" + f.getType().getSimpleName() + " value1, " + f.getType().getSimpleName() + " value2) {\n" + "            this.addCriterion(\"" + dname + " not between\", value1, value2, \"" + fname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n";
            }
        }

        return code;
    }

    private static String upfirst(String field) {
        char c = field.charAt(0);
        String upname = field;
        if (c > 96 && c < 123) {
            c = (char) (c - 32);
            upname = c + field.substring(1);
        }

        return upname;
    }

    private static String lowfirst(String field) {
        char c = field.charAt(0);
        String upname = field;
        if (c > 64 && c < 91) {
            c = (char) (c + 32);
            upname = c + field.substring(1);
        }

        return upname;
    }

    private static String dataField(String field) {
        String dname = field.substring(0, 1);

        for (int i = 1; i < field.length(); ++i) {
            char c = field.charAt(i);
            if (c > 64 && c < 91) {
                String tempStr = "_" + c;
                dname = dname + tempStr.toLowerCase();
            } else {
                dname = dname + c;
            }
        }

        return dname;
    }

    private static String myAddField() {
        return "    private Integer startIndex;\n    private Integer endIndex;\n    private String fields;\n    protected String sqlStirng;\n    private String webSite;\n\n    public String getWebSite() {\n        return this.webSite;\n    }\n\n    public void setWebSite(String webSite) {\n        this.webSite = webSite;\n    }\n\n    public String getSqlStirng() {\n        return this.sqlStirng;\n    }\n\n    public void setSqlStirng(String sqlStirng) {\n        this.sqlStirng = sqlStirng;\n    }\n\n    public Integer getStartIndex() {\n        return this.startIndex;\n    }\n\n    public void setStartIndex(Integer startIndex) {\n        this.startIndex = startIndex;\n    }\n\n    public Integer getEndIndex() {\n        return this.endIndex;\n    }\n\n    public void setEndIndex(Integer endIndex) {\n        this.endIndex = endIndex;\n    }\n\n    public String getFields() {\n        return this.fields;\n    }\n\n    public void setFields(String fields) {\n        this.fields = fields;\n    }\n";
    }

    private static String mkOther(String beanName) {
        String code = "public class " + beanName + "Example {\n" + "    protected String orderByClause;\n" + "    protected boolean distinct;\n" + "    protected List<" + beanName + "Example.Criteria> oredCriteria = new ArrayList<>();\n" + "\n" + myAddField() + "    public void setOrderByClause(String orderByClause) {\n" + "        this.orderByClause = orderByClause;\n" + "    }\n" + "\n" + "    public String getOrderByClause() {\n" + "        return this.orderByClause;\n" + "    }\n" + "\n" + "    public void setDistinct(boolean distinct) {\n" + "        this.distinct = distinct;\n" + "    }\n" + "\n" + "    public boolean isDistinct() {\n" + "        return this.distinct;\n" + "    }\n" + "\n" + "    public List<" + beanName + "Example.Criteria> getOredCriteria() {\n" + "        return this.oredCriteria;\n" + "    }\n" + "\n" + "    public void or(" + beanName + "Example.Criteria criteria) {\n" + "        this.oredCriteria.add(criteria);\n" + "    }\n" + "\n" + "    public " + beanName + "Example.Criteria or() {\n" + "        " + beanName + "Example.Criteria criteria = this.createCriteriaInternal();\n" + "        this.oredCriteria.add(criteria);\n" + "        return criteria;\n" + "    }\n" + "\n" + "    public " + beanName + "Example.Criteria createCriteria() {\n" + "        " + beanName + "Example.Criteria criteria = this.createCriteriaInternal();\n" + "        if(this.oredCriteria.size() == 0) {\n" + "            this.oredCriteria.add(criteria);\n" + "        }\n" + "        return criteria;\n" + "    }\n" + "\n" + "    protected " + beanName + "Example.Criteria createCriteriaInternal() {\n" + "        " + beanName + "Example.Criteria criteria = new " + beanName + "Example.Criteria();\n" + "        return criteria;\n" + "    }\n" + "\n" + "    public void clear() {\n" + "        this.oredCriteria.clear();\n" + "        this.orderByClause = null;\n" + "        this.distinct = false;\n" + "    }\n" + "\n" + "    public static class Criterion {\n" + "        private String condition;\n" + "        private Object value;\n" + "        private Object secondValue;\n" + "        private boolean noValue;\n" + "        private boolean singleValue;\n" + "        private boolean betweenValue;\n" + "        private boolean listValue;\n" + "        private String typeHandler;\n" + "\n" + "        public String getCondition() {\n" + "            return this.condition;\n" + "        }\n" + "\n" + "        public Object getValue() {\n" + "            return this.value;\n" + "        }\n" + "\n" + "        public Object getSecondValue() {\n" + "            return this.secondValue;\n" + "        }\n" + "\n" + "        public boolean isNoValue() {\n" + "            return this.noValue;\n" + "        }\n" + "\n" + "        public boolean isSingleValue() {\n" + "            return this.singleValue;\n" + "        }\n" + "\n" + "        public boolean isBetweenValue() {\n" + "            return this.betweenValue;\n" + "        }\n" + "\n" + "        public boolean isListValue() {\n" + "            return this.listValue;\n" + "        }\n" + "\n" + "        public String getTypeHandler() {\n" + "            return this.typeHandler;\n" + "        }\n" + "\n" + "        protected Criterion(String condition) {\n" + "            this.condition = condition;\n" + "            this.typeHandler = null;\n" + "            this.noValue = true;\n" + "        }\n" + "\n" + "        protected Criterion(String condition, Object value, String typeHandler) {\n" + "            this.condition = condition;\n" + "            this.value = value;\n" + "            this.typeHandler = typeHandler;\n" + "            if(value instanceof List) {\n" + "                this.listValue = true;\n" + "            } else {\n" + "                this.singleValue = true;\n" + "            }\n" + "\n" + "        }\n" + "\n" + "        protected Criterion(String condition, Object value) {\n" + "            this(condition, value, (String)null);\n" + "        }\n" + "\n" + "        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {\n" + "            this.condition = condition;\n" + "            this.value = value;\n" + "            this.secondValue = secondValue;\n" + "            this.typeHandler = typeHandler;\n" + "            this.betweenValue = true;\n" + "        }\n" + "\n" + "        protected Criterion(String condition, Object value, Object secondValue) {\n" + "            this(condition, value, secondValue, (String)null);\n" + "        }\n" + "    }\n" + "\n" + "    public static class Criteria extends " + beanName + "Example.GeneratedCriteria {\n" + "        protected Criteria() {\n" + "        }\n" + "    }\n" + "\n" + "    protected abstract static class GeneratedCriteria {\n" + "        protected List<" + beanName + "Example.Criterion> criteria = new ArrayList();\n" + "\n" + "        protected GeneratedCriteria() {\n" + "        }\n" + "\n" + "        public boolean isValid() {\n" + "            return this.criteria.size() > 0;\n" + "        }\n" + "\n" + "        public List<" + beanName + "Example.Criterion> getAllCriteria() {\n" + "            return this.criteria;\n" + "        }\n" + "\n" + "        public List<" + beanName + "Example.Criterion> getCriteria() {\n" + "            return this.criteria;\n" + "        }\n" + "\n" + "        protected void addCriterion(String condition) {\n" + "            if(condition == null) {\n" + "                throw new RuntimeException(\"Value for condition cannot be null\");\n" + "            } else {\n" + "                this.criteria.add(new " + beanName + "Example.Criterion(condition));\n" + "            }\n" + "        }\n" + "\n" + "        protected void addCriterion(String condition, Object value, String property) {\n" + "            if(value == null) {\n" + "                throw new RuntimeException(\"Value for \" + property + \" cannot be null\");\n" + "            } else {\n" + "                this.criteria.add(new " + beanName + "Example.Criterion(condition, value));\n" + "            }\n" + "        }\n" + "\n" + "        protected void addCriterion(String condition, Object value1, Object value2, String property) {\n" + "            if(value1 != null && value2 != null) {\n" + "                this.criteria.add(new " + beanName + "Example.Criterion(condition, value1, value2));\n" + "            } else {\n" + "                throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");\n" + "            }\n" + "        }\n";
        return code;
    }

    public static String exampleString(String packageStr, String beanClassName, String beanName) throws ClassNotFoundException {
        String code = mkPackage(packageStr);
        code = code + mkOther(beanName);
        code = code + createFields(beanClassName, beanName);
        code = code + "    }\n}\n";
        return code;
    }
}
