package com.shigu.tools;

/**
 * @类编号
 * @类名称：TestAddrs
 * @文件路径：com.shigu.tools.TestAddrs
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/10/25 14:34
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class TestAddrs {

    public static void main(String args[]){


        String addrs="广西壮族自治区 河池市 金城江区 金城江街道 广西壮族自治区河池市金城江区翡翠花园枫丹苑 ";
        String prov="广西";//省
        String city="河池市";
        String town="金城江区";

        /*String addrs="大沥镇 广东省佛山市南海区黄岐风度公寓13栋 ";
        String prov="广东省";//省
        String city="佛山市";
        String town="南海区";*/

        if(prov!=null&&!"".equals (prov)){
            if(prov.endsWith ("省")||prov.endsWith ("市")||"香港".equals (prov)||"澳门".equals (prov)){
                addrs = addrs.replaceAll (prov, "");
            }else{
                if("广西".equals (prov)){
                    addrs = addrs.replaceAll ("广西壮族自治区", "");
                }else if("宁夏".equals (prov)){
                    addrs = addrs.replaceAll ("宁夏回族自治区", "");
                }else if("新疆".equals (prov)){
                    addrs = addrs.replaceAll ("新疆维吾尔自治区", "");
                }else if("西藏".equals (prov)){
                    addrs = addrs.replaceAll ("西藏自治区", "");
                }else if("内蒙古".equals (prov)){
                    addrs = addrs.replaceAll ("内蒙古自治区", "");
                }

            }
        }
        if(city!=null&&!"".equals (city)){
            addrs=addrs.replaceAll (city,"");
        }
        if(town!=null&&!"".equals (town)){
            addrs=addrs.replaceAll (town,"");
        }
        addrs=addrs.replaceAll ("null","");
        addrs=addrs.replaceAll (" ","");
        addrs=prov+" "+city+" "+town+" "+addrs.trim ();
        System.out.println(addrs);
    }
}
