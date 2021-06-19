package com.example.demo.service;


import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.example.demo.common.BaiduAIPCommon;
import com.example.demo.common.CommonResult;
import com.example.demo.entity.Cusers;
import com.example.demo.mapper.CusersMapper;
import com.example.demo.vos.login.LoginFaceVO;
import com.example.demo.vos.login.LoginVO;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;

/**
 * @author 青菜白玉堂
 * @create 2021-06-17
 */
@Service
public class LoginService {
    @Resource
    private CusersMapper loginMapper;

    public CommonResult<Object> loginWithNameAndPsw(LoginVO loginVO) {
        Cusers user = loginMapper.selectByUsername(loginVO.getUsername());
        if (user == null) {
            return CommonResult.fail("用户或密码错误");
        }
        if (!user.getUserPwd().equals(loginVO.getPassword())) {
            return CommonResult.fail("用户名或密码错误");
        }
        return CommonResult.success(user);
    }

    public CommonResult<Object> loginWidthFace(LoginFaceVO faceVO) {
        // 初始化一个AipFace
        AipFace client = new AipFace(BaiduAIPCommon.APP_FACE_ID, BaiduAIPCommon.API_FACE_KEY, BaiduAIPCommon.SECRET_FACE_KEY);
        try {
            File localFace = new File("D:\\20210616\\face.png");
            byte[] buf2 = FileUtils.readFileToByteArray(localFace);

            //BASE64编码
            String image1 = faceVO.getBase64Image();
            String image2 = Base64.getEncoder().encodeToString(buf2);

            //将编码后的字符串放入MatchRequest
            MatchRequest req1 = new MatchRequest(image1, "BASE64");
            MatchRequest req2 = new MatchRequest(image2, "BASE64");

            //两个request放入一个集合ArrayList中
            ArrayList<MatchRequest> reqs = new ArrayList<>();
            reqs.add(req1);
            reqs.add(req2);

            //AIP客户端做人脸对比
            JSONObject res = client.match(reqs);
            System.out.println(res);
            return CommonResult.success(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.fail("无法识别");
    }


    private File multipartFileToFile(MultipartFile file) throws IOException {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    private void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
