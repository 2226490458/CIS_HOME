package com.example.demo.utils;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.example.demo.common.BaiduAIPCommon;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author 青菜白玉堂
 * @create 2021-06-20
 */
public class FaceClient {
    private static volatile FaceClient faceClient;
    private AipFace client;
    /**
     * 构造方法私有化，提供百度face api
     * @param APP_ID
     * @param APP_KEY
     * @param SECRET_KEY
     */
    private FaceClient(String APP_ID,String APP_KEY,String SECRET_KEY){
        client = new AipFace(APP_ID, APP_KEY, SECRET_KEY);
    }
    /**
     * 唯一获取该类实例的静态方法
     * @return
     */
    public static FaceClient getInstance(){
        if(faceClient == null){
            synchronized (FaceClient.class) {
                if(faceClient == null){
                    faceClient = new FaceClient(BaiduAIPCommon.APP_FACE_ID,BaiduAIPCommon.API_FACE_KEY,BaiduAIPCommon.SECRET_FACE_KEY);
                }
            }
        }
        return faceClient;
    }

    /**
     * 人脸对比的方法
     * @param image1 Base64编码之后的图像字符串
     * @param image2 Base64编码之后的图像字符串
     * @return true：成功，false：失败
     */
    public boolean faceCompare(String image1,String image2){
        //将编码后的字符串放入MatchRequest
        MatchRequest req1 = new MatchRequest(image1, "BASE64");
        MatchRequest req2 = new MatchRequest(image2, "BASE64");

        //两个request放入一个集合ArrayList中
        ArrayList<MatchRequest> reqs = new ArrayList<>();
        reqs.add(req1);
        reqs.add(req2);

        //获得返回的json中的score值，阈值设置为90
        JSONObject res = client.match(reqs);
        System.out.println(res);
        if(res != null && !res.toString().equals("")){
            if(res.get("result") != null && !(res.get("result").toString().equals("") || res.get("result").toString().equals("null"))){
                JSONObject result = (JSONObject) res.get("result");
                double score = result.getDouble("score");
                return score >= 90;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(FaceClient.getInstance());
        System.out.println(FaceClient.getInstance());
    }
}
