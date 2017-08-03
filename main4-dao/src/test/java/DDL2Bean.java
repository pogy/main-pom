import com.zhb.examples.CreateUtil;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Created by wxc on 2017/2/21.
 *
 * 把DDL语句快速生成Bean 、Example 、Mapper
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class DDL2Bean {
    /*
    CREATE TABLE IF NOT EXISTS `shigu_mall`.`item_order_logistics` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `company_id` BIGINT(11) NOT NULL COMMENT '物流公司ID',
  `courier_number` VARCHAR(45) NOT NULL COMMENT '快递单号',
  `money` BIGINT(11) NOT NULL COMMENT '费用',
  `prov_id` BIGINT(11) NOT NULL,
  `city_id` BIGINT(11) NOT NULL,
  `town_id` BIGINT(11) NULL,
  `address` VARCHAR(400) NOT NULL COMMENT '详细地址',
  `telephone` VARCHAR(20) NOT NULL COMMENT '手机号',
  `zip_code` VARCHAR(10) NULL COMMENT '邮编',
  `oid` BIGINT(11) NOT NULL COMMENT '订单ID',
  PRIMARY KEY (`id`),
  INDEX `fk_item_order_logistics_item_order1_idx` (`oid` ASC),
  CONSTRAINT `fk_item_order_logistics_item_order1`
    FOREIGN KEY (`oid`)
    REFERENCES `shigu_mall`.`item_order` (`oid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '物流'
     */

    public static void main(String[] args) throws IOException {
        DDL2Bean ddl2Bean = new DDL2Bean();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("请粘贴表创建语句(英文分号结束输入)：\n");
            StringBuilder sb = new StringBuilder();
            String tmp;
            while (!(tmp = scanner.nextLine()).endsWith(";")) {
                sb.append(tmp);
            }
            ddl2Bean.getBean(sb.toString());
            System.out.println("是否退出？（Y/N）");
        } while (!"y".equalsIgnoreCase(scanner.nextLine()));
    }

    public void getBean(String ddl) throws IOException {
        Map<String, String[]> fields = new LinkedHashMap<>();
        Map<String, String> dataFields = new HashMap<>();
        String beanName = "unknown";
        boolean typeHasDate = false;
        for (String s : ddl.split(",")) {
            if (s.contains("PRIMARY KEY")) {
                break;
            }
            if (s.contains("CREATE TABLE")) {
                if (s.contains(".")){
                    s = s.substring(s.indexOf(".") + 1);
                }
                int beanStart = s.indexOf("`");
                int beanEnd = s.indexOf("`", beanStart + 1);
                beanName = dataToField(s.substring(beanStart + 1, beanEnd), true);
                s = s.substring(beanEnd + 1);
            }
            int dataFieldStart = s.indexOf("`");
            if (dataFieldStart == -1) {
                continue;
            }
            int dataFieldEnd = s.indexOf("`", dataFieldStart + 1);
            String dataField = s.substring(dataFieldStart + 1, dataFieldEnd);

            int commentStart = s.indexOf("'", s.indexOf("COMMENT"));
            int commentEnd = s.indexOf("'", commentStart + 1);
            String comment = "";
            if (commentStart > 0 && commentEnd > commentStart)
                comment = s.substring(commentStart + 1, commentEnd);
            String type = "String";
            if (s.contains("bigint") || s.contains("BIGINT"))
                type = "Long";
            else if (s.contains("int") || s.contains("INT"))
                type = "Integer";
            else if (s.contains("varchar") || s.contains("VARCHAR"))
                type = "String";
            else if (s.contains("timestamp") || s.contains("date") || s.contains("TIMESTAMP") || s.contains("DATE")) {
                type = "Date";
                typeHasDate = true;
            } else if (s.contains("bit") || s.contains("BIT"))
                type = "Boolean";
            fields.put(dataToField(dataField, false), new String[]{comment, type});
            dataFields.put(dataField, type);
        }

        int i=0;
        String path = System.getProperty("user.dir") + "\\web-server\\src\\main\\java\\com\\opentae\\data\\mall\\beans\\".replace("\\", File.separator) + beanName + ".java";
        PrintWriter out = new PrintWriter(path);
        out.println(String.format("package com.opentae.data.mall.beans;\n\nimport javax.persistence.GeneratedValue;\nimport javax.persistence.Id;\n" + (typeHasDate ? "import java.util.Date;\n" : "") + "import java.io.Serializable;\n\npublic class %s implements Serializable {", beanName));
        for (Map.Entry<String, String[]> entry : fields.entrySet()) {
            String[] value = entry.getValue();
            out.println("    /**\n" +
                    "     * " + value[0] +
                    "\n     */");
            if (i++==0)
                out.println("    @Id\n" +
                        "    @GeneratedValue(generator = \"JDBC\")");
            out.println("\tprivate " + value[1] + " " + entry.getKey() + ";\n");
        }

        for (Map.Entry<String, String[]> entry : fields.entrySet()) {
            String[] value = entry.getValue();
            String key = entry.getKey();
            out.println(String.format("\tpublic void set%s(%s %s) {", dataToField(key, true), value[1], key));
            out.println(String.format("\t\tthis.%s = %s;\n\t}\n", key, key));
            out.println(String.format("\tpublic %s get%s() {", value[1], dataToField(key, true)));
            out.println(String.format("\t\treturn this.%s;\n\t}\n", key));
        }
        out.print('}');
        out.flush();
        out.close();
        System.out.println("Bean类生成成功！！");
        createExample(path, dataFields);
    }

    private String dataToField(String dataField, boolean upper) {
        int i = dataField.indexOf("_");
        if (upper) {
            char[] chars = dataField.toCharArray();
            chars[0] -= 32;
            dataField = String.valueOf(chars);
        }
        if (i != -1) {
            String head = dataField.substring(0, i);
            dataField = head + dataField.substring(i + 1, i + 2).toUpperCase() + dataField.substring(i + 2);
        } else return dataField;
        return dataToField(dataField, false);
    }

    public void createExample(String path, Map<String, String> fields){
        String sprit = File.separator;
        String dir = path.substring(0, path.lastIndexOf(sprit));
        String parentdir = dir.substring(0, dir.lastIndexOf(sprit));
        String fileName = path.replace(dir + sprit, "");
        String packageName, interfacePackage, beanClassName;
        String flag = "src" + sprit + "main" + sprit + "java";
        if(path.contains(flag)) {
            packageName = path.substring(path.indexOf(flag)).replace(flag + sprit, "").replace(sprit + fileName, "");
            beanClassName = packageName.replace(sprit, ".") + "." + fileName.replace(".java", "");
            packageName = packageName.substring(0, packageName.lastIndexOf(sprit)) + sprit;
            interfacePackage = packageName + "interfaces";
            interfacePackage = interfacePackage.replace(sprit, ".");
            packageName = packageName + "examples";
            packageName = packageName.replace(sprit, ".");
            String beanName = fileName.replace(".java", "");

            try {
                String code = exampleString(packageName, fields, beanName);
                File examdir = new File(parentdir + sprit + "examples");
                examdir.mkdir();
                FileOutputStream fos = new FileOutputStream(parentdir + sprit + "examples" + sprit + beanName + "Example.java");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                OutputStreamWriter osw = new OutputStreamWriter(bos);
                BufferedWriter fw = new BufferedWriter(osw);
                fw.write(code);
                fw.close();
                osw.close();
                bos.close();
                fos.close();
                System.out.println("Example类生成成功！！");
                String interfaceCode = CreateUtil.interfaceString(beanName, interfacePackage, beanClassName);
                examdir = new File(parentdir + sprit + "interfaces");
                examdir.mkdir();
                fos = new FileOutputStream(parentdir + sprit + "interfaces" + sprit + beanName + "Mapper.java");
                bos = new BufferedOutputStream(fos);
                osw = new OutputStreamWriter(bos);
                fw = new BufferedWriter(osw);
                fw.write(interfaceCode);
                fw.close();
                osw.close();
                bos.close();
                fos.close();
                System.out.println("接口类生成成功！！");
            } catch (Exception var19) {
                var19.printStackTrace();
            }
        } else {
            System.out.println("没有找到src/main/java目录");
        }

    }

    private  String mkPackage(String packageStr) {
        return "package " + packageStr + ";\n" + "\n" + "import java.util.ArrayList;\n" + "import java.util.Date;\n" + "import java.util.List;\n" + "import com.opentae.core.mybatis.SgExample;\n" + "\n";
    }

    private  String mkOther(String beanName) {
        String code = "public class " + beanName + "Example implements SgExample{\n" + "    protected String orderByClause;\n" + "    protected boolean distinct;\n" + "    protected List<" + beanName + "Example.Criteria> oredCriteria = new ArrayList();\n" + "\n" + "    public " + beanName + "Example() {\n" + "    }\n" + "\n" + myAddField() + "    public void setOrderByClause(String orderByClause) {\n" + "        this.orderByClause = orderByClause;\n" + "    }\n" + "\n" + "    public String getOrderByClause() {\n" + "        return this.orderByClause;\n" + "    }\n" + "\n" + "    public void setDistinct(boolean distinct) {\n" + "        this.distinct = distinct;\n" + "    }\n" + "\n" + "    public boolean isDistinct() {\n" + "        return this.distinct;\n" + "    }\n" + "\n" + "    public List<" + beanName + "Example.Criteria> getOredCriteria() {\n" + "        return this.oredCriteria;\n" + "    }\n" + "\n" + "    public void or(" + beanName + "Example.Criteria criteria) {\n" + "        this.oredCriteria.add(criteria);\n" + "    }\n" + "\n" + "    public " + beanName + "Example.Criteria or() {\n" + "        " + beanName + "Example.Criteria criteria = this.createCriteriaInternal();\n" + "        this.oredCriteria.add(criteria);\n" + "        return criteria;\n" + "    }\n" + "\n" + "    public " + beanName + "Example.Criteria createCriteria() {\n" + "        " + beanName + "Example.Criteria criteria = this.createCriteriaInternal();\n" + "        if(this.oredCriteria.size() == 0) {\n" + "            this.oredCriteria.add(criteria);\n" + "        }\n" + "\n" + "        return criteria;\n" + "    }\n" + "\n" + "    protected " + beanName + "Example.Criteria createCriteriaInternal() {\n" + "        " + beanName + "Example.Criteria criteria = new " + beanName + "Example.Criteria();\n" + "        return criteria;\n" + "    }\n" + "\n" + "    public void clear() {\n" + "        this.oredCriteria.clear();\n" + "        this.orderByClause = null;\n" + "        this.distinct = false;\n" + "    }\n" + "\n" + "    public static class Criterion {\n" + "        private String condition;\n" + "        private Object value;\n" + "        private Object secondValue;\n" + "        private boolean noValue;\n" + "        private boolean singleValue;\n" + "        private boolean betweenValue;\n" + "        private boolean listValue;\n" + "        private String typeHandler;\n" + "\n" + "        public String getCondition() {\n" + "            return this.condition;\n" + "        }\n" + "\n" + "        public Object getValue() {\n" + "            return this.value;\n" + "        }\n" + "\n" + "        public Object getSecondValue() {\n" + "            return this.secondValue;\n" + "        }\n" + "\n" + "        public boolean isNoValue() {\n" + "            return this.noValue;\n" + "        }\n" + "\n" + "        public boolean isSingleValue() {\n" + "            return this.singleValue;\n" + "        }\n" + "\n" + "        public boolean isBetweenValue() {\n" + "            return this.betweenValue;\n" + "        }\n" + "\n" + "        public boolean isListValue() {\n" + "            return this.listValue;\n" + "        }\n" + "\n" + "        public String getTypeHandler() {\n" + "            return this.typeHandler;\n" + "        }\n" + "\n" + "        protected Criterion(String condition) {\n" + "            this.condition = condition;\n" + "            this.typeHandler = null;\n" + "            this.noValue = true;\n" + "        }\n" + "\n" + "        protected Criterion(String condition, Object value, String typeHandler) {\n" + "            this.condition = condition;\n" + "            this.value = value;\n" + "            this.typeHandler = typeHandler;\n" + "            if(value instanceof List) {\n" + "                this.listValue = true;\n" + "            } else {\n" + "                this.singleValue = true;\n" + "            }\n" + "\n" + "        }\n" + "\n" + "        protected Criterion(String condition, Object value) {\n" + "            this(condition, value, (String)null);\n" + "        }\n" + "\n" + "        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {\n" + "            this.condition = condition;\n" + "            this.value = value;\n" + "            this.secondValue = secondValue;\n" + "            this.typeHandler = typeHandler;\n" + "            this.betweenValue = true;\n" + "        }\n" + "\n" + "        protected Criterion(String condition, Object value, Object secondValue) {\n" + "            this(condition, value, secondValue, (String)null);\n" + "        }\n" + "    }\n" + "\n" + "    public static class Criteria extends " + beanName + "Example.GeneratedCriteria {\n" + "        protected Criteria() {\n" + "        }\n" + "    }\n" + "\n" + "    protected abstract static class GeneratedCriteria {\n" + "        protected List<" + beanName + "Example.Criterion> criteria = new ArrayList();\n" + "\n" + "        protected GeneratedCriteria() {\n" + "        }\n" + "\n" + "        public boolean isValid() {\n" + "            return this.criteria.size() > 0;\n" + "        }\n" + "\n" + "        public List<" + beanName + "Example.Criterion> getAllCriteria() {\n" + "            return this.criteria;\n" + "        }\n" + "\n" + "        public List<" + beanName + "Example.Criterion> getCriteria() {\n" + "            return this.criteria;\n" + "        }\n" + "\n" + "        protected void addCriterion(String condition) {\n" + "            if(condition == null) {\n" + "                throw new RuntimeException(\"Value for condition cannot be null\");\n" + "            } else {\n" + "                this.criteria.add(new " + beanName + "Example.Criterion(condition));\n" + "            }\n" + "        }\n" + "\n" + "        protected void addCriterion(String condition, Object value, String property) {\n" + "            if(value == null) {\n" + "                throw new RuntimeException(\"Value for \" + property + \" cannot be null\");\n" + "            } else {\n" + "                this.criteria.add(new " + beanName + "Example.Criterion(condition, value));\n" + "            }\n" + "        }\n" + "\n" + "        protected void addCriterion(String condition, Object value1, Object value2, String property) {\n" + "            if(value1 != null && value2 != null) {\n" + "                this.criteria.add(new " + beanName + "Example.Criterion(condition, value1, value2));\n" + "            } else {\n" + "                throw new RuntimeException(\"Between values for \" + property + \" cannot be null\");\n" + "            }\n" + "        }\n";
        return code;
    }


    private  String createFields(Map<String, String> fields, String beanName) throws ClassNotFoundException {
        String code = "";
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            String baseField = entry.getKey();
            String type = entry.getValue();
            String upname = dataToField(baseField, true);
            String lowname = dataToField(baseField, false);
            code = code + "\n        public " + beanName + "Example.Criteria and" + upname + "IsNull() {\n" + "            this.addCriterion(\"" + baseField + " is null\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "IsNotNull() {\n" + "            this.addCriterion(\"" + baseField + " is not null\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "EqualTo(" + type + " value) {\n" + "            this.addCriterion(\"" + baseField + " =\", value, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "NotEqualTo(" + type + " value) {\n" + "            this.addCriterion(\"" + baseField + " <>\", value, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "GreaterThan(" + type + " value) {\n" + "            this.addCriterion(\"" + baseField + " >\", value, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "GreaterThanOrEqualTo(" + type + " value) {\n" + "            this.addCriterion(\"" + baseField + " >=\", value, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "LessThan(" + type + " value) {\n" + "            this.addCriterion(\"" + baseField + " <\", value, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "LessThanOrEqualTo(" + type + " value) {\n" + "            this.addCriterion(\"" + baseField + " <=\", value, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "Like(String value) {\n" + "            this.addCriterion(\"" + baseField + " like\", value, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "NotLike(String value) {\n" + "            this.addCriterion(\"" + baseField + " not like\", value, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }" + "        public " + beanName + "Example.Criteria and" + upname + "In(List<" + type + "> values) {\n" + "            this.addCriterion(\"" + baseField + " in\", values, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "NotIn(List<" + type + "> values) {\n" + "            this.addCriterion(\"" + baseField + " not in\", values, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "Between(" + type + " value1, " + type + " value2) {\n" + "            this.addCriterion(\"" + baseField + " between\", value1, value2, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n" + "\n" + "        public " + beanName + "Example.Criteria and" + upname + "NotBetween(" + type + " value1, " + type + " value2) {\n" + "            this.addCriterion(\"" + baseField + " not between\", value1, value2, \"" + lowname + "\");\n" + "            return (" + beanName + "Example.Criteria)this;\n" + "        }\n";
        }
        return code;
    }

    public String exampleString(String packageStr, Map<String, String> fields, String beanName) throws ClassNotFoundException {
        String code = mkPackage(packageStr);
        code = code + mkOther(beanName);
        code = code + createFields(fields, beanName);
        code = code + "    }\n}\n";
        return code;
    }
    private String myAddField() {
        return "    private Integer startIndex;\n    private Integer endIndex;\n    private String fields;\n    protected String sqlStirng;\n    private String webSite;\n\n    public String getWebSite() {\n        return this.webSite;\n    }\n\n    public void setWebSite(String webSite) {\n        this.webSite = webSite;\n    }\n\n    public String getSqlStirng() {\n        return this.sqlStirng;\n    }\n\n    public void setSqlStirng(String sqlStirng) {\n        this.sqlStirng = sqlStirng;\n    }\n\n    public Integer getStartIndex() {\n        return this.startIndex;\n    }\n\n    public void setStartIndex(Integer startIndex) {\n        this.startIndex = startIndex;\n    }\n\n    public Integer getEndIndex() {\n        return this.endIndex;\n    }\n\n    public void setEndIndex(Integer endIndex) {\n        this.endIndex = endIndex;\n    }\n\n    public String getFields() {\n        return this.fields;\n    }\n\n    public void setFields(String fields) {\n        this.fields = fields;\n    }\n";
    }
}