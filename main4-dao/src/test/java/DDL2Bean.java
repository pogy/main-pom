import org.junit.Test;

import java.util.*;

/**
 * Created by wxc on 2017/2/21.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
public class DDL2Bean {

    private String ddl = "`page_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',\n" +
            "  `name` varchar(45) NOT NULL COMMENT '页面名称',\n" +
            "  `shop_id` bigint(11) NOT NULL COMMENT '店铺ID',";

    @Test
    public void getBean() {
        Map<String, String[]> fields = new LinkedHashMap<>();
        for (String s : ddl.split(",\n")) {
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
            fields.put(dataToField(dataField), new String[]{comment, type});
        }

        int i=0;
        for (Map.Entry<String, String[]> entry : fields.entrySet()) {
            String[] value = entry.getValue();
            System.out.println("    /**\n" +
                    "     * " + value[0] +
                    "\n     */");
            if (i++==0)
                System.out.println("    @Id\n" +
                        "    @GeneratedValue(generator = \"JDBC\")");
            System.out.println("\tprivate " + value[1] + " " + entry.getKey() + ";\n");
        }
    }

    private String dataToField(String dataField) {
        int i = dataField.indexOf("_");
        if (i != -1) {
            dataField = dataField.substring(0, i) + dataField.substring(i + 1, i + 2).toUpperCase() + dataField.substring(i + 2);
        } else return dataField;
        return dataToField(dataField);
    }
}
