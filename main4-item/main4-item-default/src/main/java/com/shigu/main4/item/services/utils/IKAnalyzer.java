package com.shigu.main4.item.services.utils;

import org.elasticsearch.action.admin.indices.analyze.AnalyzeAction;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxc on 2017/4/10.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class IKAnalyzer {

    private static IndicesAdminClient indicesAdminClient;
    private static final String url = "122.224.105.246";
    private static final String port = "9213";

    static {
        Settings settings = Settings.settingsBuilder().put("cluster.name", "xz571-application").build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(url), Integer.valueOf(port)));
            indicesAdminClient = client.admin().indices();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static List<String> analyzer(String text) {
        AnalyzeRequestBuilder request = new AnalyzeRequestBuilder(indicesAdminClient, AnalyzeAction.INSTANCE, "goods", text);
        request.setTokenizer("ik");
        List<AnalyzeResponse.AnalyzeToken> listAnalysis = request.execute().actionGet().getTokens();
        List<String> strs = new ArrayList<>();
        for(AnalyzeResponse.AnalyzeToken token:listAnalysis){
            strs.add(token.getTerm());
        }
        return strs;
    }

    public static void main(String[] args) {
        for (String 摆拍 : analyzer("阔型")) {
            System.out.println(摆拍);
        }
    }
}
