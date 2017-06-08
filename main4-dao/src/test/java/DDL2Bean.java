import com.zhb.examples.CreateUtil;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Created by wxc on 2017/2/21.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class DDL2Bean {

    private String ddl = "CREATE TABLE IF NOT EXISTS `shigu_mall`.`item_order_sub` (\n" +
            "  `soid` BIGINT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',\n" +
            "  `oid` BIGINT(11) NOT NULL COMMENT '订单号',\n" +
            "  `pid` BIGINT(11) NOT NULL COMMENT '产品ID',\n" +
            "  `sku_id` BIGINT(11) NOT NULL COMMENT 'sku信息',\n" +
            "  `num` INT(8) NOT NULL DEFAULT 1 COMMENT '件数',\n" +
            "  `distribution_num` INT(8) NOT NULL DEFAULT 0 COMMENT '到货数量',\n" +
            "  `should_pay_money` BIGINT(11) NOT NULL COMMENT '应付总额',\n" +
            "  `pay_money` BIGINT(11) NOT NULL COMMENT '实付',\n" +
            "  `refund_money` BIGINT(11) NOT NULL COMMENT '实退',\n" +
            "  `send` BIT(1) NOT NULL DEFAULT 0 COMMENT '是否已发',\n" +
            "  `refund` BIT(1) NOT NULL DEFAULT 0 COMMENT '是否退款',\n" +
            "  `mark` VARCHAR(50) NULL COMMENT '备注',\n" +
            "  `logistics_id` BIGINT(11) NOT NULL DEFAULT -1 COMMENT '交易信息ID',\n" +
            "  PRIMARY KEY (`soid`),\n" +
            "  INDEX `fk_item_order_sub_item_order1_idx` (`oid` ASC),\n" +
            "  CONSTRAINT `fk_item_order_sub_item_order1`\n" +
            "    FOREIGN KEY (`oid`)\n" +
            "    REFERENCES `shigu_mall`.`item_order` (`oid`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB\n" +
            "COMMENT = '订单子表'";

    @Test
    public void getBean() throws IOException {
        Map<String, String[]> fields = new LinkedHashMap<>();
        String beanName = "unknown";
        for (String s : ddl.split(",\n")) {
            if (s.contains("PRIMARY KEY"))
                break;
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
            int dataFieldEnd = s.indexOf("`", dataFieldStart + 1);
            String dataField = s.substring(dataFieldStart + 1, dataFieldEnd);

            int commentStart = s.indexOf("'", s.indexOf("COMMENT"));
            int commentEnd = s.indexOf("'", commentStart + 1);
            String comment = "";
            if (commentStart > 0 && commentEnd > commentStart)
                comment = s.substring(commentStart + 1, commentEnd);
            String type = "String";
            if (s.contains("bigint"))
                type = "Long";
            else if (s.contains("int"))
                type = "Integer";
            else if (s.contains("varchar"))
                type = "String";
            else if (s.contains("timestamp") || s.contains("date"))
                type = "Date";
            else if (s.contains("bit"))
                type = "Boolean";
            fields.put(dataToField(dataField, false), new String[]{comment, type});
        }

        int i=0;
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\opentae\\data\\mall\\beans\\" + beanName + ".java";
        PrintWriter out = new PrintWriter(path);
        out.println(String.format("package com.opentae.data.mall.beans;\n\nimport javax.persistence.GeneratedValue;\nimport javax.persistence.Id;\nimport java.io.Serializable;\n\npublic class %s implements Serializable {", beanName));
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

        createExample(path);
        Process process = Runtime.getRuntime().exec("git add -A");

        process.destroy();
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

    public void createExample(String path){
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
                String code = CreateUtil.exampleString(packageName, beanClassName, beanName);
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
}
