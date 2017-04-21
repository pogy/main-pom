package com.shigu.main4.example.test;

import java.lang.reflect.Field;

/**
 * Created by sean on 2017-02-13-0013.
 */
public class NewExampleCreate {

    public static String interfaceString(String beanName, String intpackageName, String beanPackage) {
        String repositoryName = beanPackage.replace("com.opentae.data.", "").replace(".beans." + beanName, "");
        String code = "package " + intpackageName + ";\n" + "\n" + "import com.opentae.core.mybatis.config.MyBatisRepository;\n" + "import com.opentae.core.mybatis.mapper.Mapper;\n" + "import " + beanPackage + ";\n" + "import org.springframework.context.annotation.Lazy;\n" + "import org.springframework.context.annotation.Scope;\n" + "\n" + "/**\n" + " * \n" + " * Created by exampleCreater.\n" + " */\n" + "@MyBatisRepository(\"tae_" + repositoryName + "_" + lowfirst(beanName) + "Mapper\")\n" + "@Scope(\"singleton\")\n" + "@Lazy(true)\n" + "public interface " + beanName + "Mapper extends Mapper<" + beanName + "> {\n" + "}\n";
        return code;
    }

    private static String mkPackage(String packageStr) {
        return "package " + packageStr + ";\n\nimport java.util.ArrayList;\nimport java.util.Date;\nimport java.util.List;\nimport com.opentae.core.mybatis.SgExample;\n\n";
    }

    private static String mkOther(String beanName) {
        String sb = "public class " +
                beanName +
                "Example extends SgExample<" +
                beanName +
                "Example.Criteria> {\n\n" +
                "    @Override\n    protected " +
                beanName +
                "Example.Criteria createCriteriaInternal() {\n        return new " +
                beanName +
                "Example.Criteria();\n    }\n\n" +
                "    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {\n";
        return sb;
    }

    private static String createFields(String beanClassName, String beanName) throws ClassNotFoundException {
        StringBuilder sb = new StringBuilder();
        Class bean = Class.forName(beanClassName);
        Field[] fields = bean.getDeclaredFields();
        final String methodHead = "        public " + beanName + "Example.Criteria and";
        for (Field f : fields) {
            if (f.getModifiers() == 2) {
                String head = methodHead + upfirst(f.getName());
                String dname = dataField(f.getName());
                String ftype = f.getType().getSimpleName();
                sb.append(head);
                sb.append("IsNull() {\n            return isNull(\"");
                sb.append(dname);
                sb.append("\");\n        }\n\n");

                sb.append(head);
                sb.append("IsNotNull() {\n            return isNotNull(\"");
                sb.append(dname);
                sb.append("\");\n        }\n\n");

                sb.append(head);
                sb.append("EqualTo(");
                sb.append(ftype);
                sb.append(" value) {\n            return equalTo(\"");
                sb.append(dname);
                sb.append("\", value);\n        }\n\n");

                sb.append(head);
                sb.append("NotEqualTo(");
                sb.append(ftype);
                sb.append(" value) {\n            return notEqualTo(\"");
                sb.append(dname);
                sb.append("\", value);\n        }\n\n");

                sb.append(head);
                sb.append("GreaterThan(");
                sb.append(ftype);
                sb.append(" value) {\n            return greaterThan(\"");
                sb.append(dname);
                sb.append("\", value);\n        }\n\n");

                sb.append(head);
                sb.append("GreaterThanOrEqualTo(");
                sb.append(ftype);
                sb.append(" value) {\n            return greaterThanOrEqualTo(\"");
                sb.append(dname);
                sb.append("\", value);\n        }\n\n");

                sb.append(head);
                sb.append("LessThan(");
                sb.append(ftype);
                sb.append(" value) {\n            return lessThan(\"");
                sb.append(dname);
                sb.append("\", value);\n        }\n\n");

                sb.append(head);
                sb.append("LessThanOrEqualTo(");
                sb.append(ftype);
                sb.append(" value) {\n            return lessThanOrEqualTo(\"");
                sb.append(dname);
                sb.append("\", value);\n        }\n\n");

                if (String.class == f.getType()) {
                    sb.append(head);
                    sb.append("Like(");
                    sb.append(ftype);
                    sb.append(" value) {\n            return like(\"");
                    sb.append(dname);
                    sb.append("\", value);\n        }\n\n");

                    sb.append(head);
                    sb.append("NotLike(");
                    sb.append(ftype);
                    sb.append(" value) {\n            return notLike(\"");
                    sb.append(dname);
                    sb.append("\", value);\n        }\n\n");
                }

                sb.append(head);
                sb.append("In(List<");
                sb.append(ftype);
                sb.append("> values) {\n            return in(\"");
                sb.append(dname);
                sb.append("\", values);\n        }\n\n");

                sb.append(head);
                sb.append("NotIn(List<");
                sb.append(ftype);
                sb.append("> values) {\n            return notIn(\"");
                sb.append(dname);
                sb.append("\", values);\n        }\n\n");

                sb.append(head);
                sb.append("Between(");
                sb.append(ftype);
                sb.append(" value1, ");
                sb.append(ftype);
                sb.append(" value2");
                sb.append(") {\n            return between(\"");
                sb.append(dname);
                sb.append("\", value1, value2);\n        }\n\n");

                sb.append(head);
                sb.append("NotBetween(");
                sb.append(ftype);
                sb.append(" value1, ");
                sb.append(ftype);
                sb.append(" value2");
                sb.append(") {\n            return notBetween(\"");
                sb.append(dname);
                sb.append("\", value1, value2);\n        }\n");
            }
        }
        return sb.toString();
    }
    private static String upfirst(String field) {
        char c = field.charAt(0);
        String upname = field;
        if(c > 96 && c < 123) {
            c = (char)(c - 32);
            upname = c + field.substring(1);
        }

        return upname;
    }

    private static String lowfirst(String field) {
        char c = field.charAt(0);
        String upname = field;
        if(c > 64 && c < 91) {
            c = (char)(c + 32);
            upname = c + field.substring(1);
        }

        return upname;
    }

    private static String dataField(String field) {
        String dname = field.substring(0, 1);

        for(int i = 1; i < field.length(); ++i) {
            char c = field.charAt(i);
            if(c > 64 && c < 91) {
                String tempStr = "_" + c;
                dname = dname + tempStr.toLowerCase();
            } else {
                dname = dname + c;
            }
        }
        return dname;
    }

    public static String exampleCreate(String pack, String beanClass, String beanName) throws ClassNotFoundException {
        String code = mkPackage(pack);
        code += mkOther(beanName);
        code += createFields(beanClass, beanName);
        code += "    }\n}";
        return code;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        String country = exampleCreate("com.opentae.data.mall.examples", "com.opentae.data.mall.beans.ShiguStoreIdGenerator", "ShiguStoreIdGenerator");
        System.out.println(country);
    }
}
