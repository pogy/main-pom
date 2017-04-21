package tinytoes;

/**
 * @类编号
 * @类名称：ESConfig
 * @文件路径：tinytoes.ESConfig
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：17/3/25 19:33
 * @version: domwiki
 * @since: domwiki
 * @commonents:
 */
public class ESConfig {

    private String esUrl;//访问路径
    private String esPort;//端口
    private String clusterName;//
    private String applic;
    private String goodsKU;

    public void setEsUrl (String esUrl) {
        this.esUrl = esUrl;
    }

    public void setEsPort (String esPort) {
        this.esPort = esPort;
    }

    public void setClusterName (String clusterName) {
        this.clusterName = clusterName;
    }

    public void setApplic (String applic) {
        this.applic = applic;
    }

    public void setGoodsKU (String goodsKU) {
        this.goodsKU = goodsKU;
    }

    public String getEsUrl () {
        return esUrl;
    }

    public String getEsPort () {
        return esPort;
    }

    public String getClusterName () {
        return clusterName;
    }

    public String getApplic () {
        return applic;
    }

    public String getGoodsKU () {
        return goodsKU;
    }
}
