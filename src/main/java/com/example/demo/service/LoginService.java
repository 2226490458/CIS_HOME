package com.example.demo.service;



import com.example.demo.common.CommonResult;
import com.example.demo.entity.Cusers;
import com.example.demo.mapper.CusersMapper;
import com.example.demo.utils.FaceClient;
import com.example.demo.utils.FileUtil;
import com.example.demo.vos.FaceVO;
import com.example.demo.vos.login.LoginFaceVO;
import com.example.demo.vos.login.LoginVO;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;


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
        List<Cusers> userList = loginMapper.listUserInfo();
        FaceClient client = FaceClient.getInstance();
        for (Cusers user: userList) {
            if (user.getFacePath() != null && !"".equals(user.getFacePath())) {
                String base1 = FileUtil.getImageStr(user.getFacePath());
                System.out.println(base1);
                boolean isMatch = client.faceCompare(faceVO.getBase64Image(), base1);
                if (isMatch) {
                    return CommonResult.success(user);
                }
            }
        }
        return CommonResult.fail("无法识别");
    }


    private File multipartFileToFile(MultipartFile file) throws IOException {
        Object empty = "";
        File toFile = null;
        if (file.equals(empty) || file.getSize() <= 0) {
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


    public CommonResult<Object> registerFace(FaceVO faceVO) {
        String staticPath = "D:\\20210616\\face_images";
        MultipartFile file = faceVO.getFile();


        String fileName = file.getOriginalFilename();

        // 图片存储目录及图片名称
        String urlPath = "images" + File.separator + "cis_face-" + faceVO.getUserId() + "_" + fileName;
        //图片保存路径
        String savePath = staticPath + File.separator + urlPath;
        System.out.println("图片保存地址："+savePath);
        // 访问路径=静态资源路径+文件目录路径
        String visitPath ="static\\" + urlPath;
        System.out.println("图片访问uri："+visitPath);

        File saveFile = new File(savePath);
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }
        try {
            // 将临时存储的文件移动到真实存储路径下
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.fail("服务端错误");
        }
        Cusers user = new Cusers();
        user.setUserId(faceVO.getUserId());
        user.setFacePath(savePath);
        user.setFaceUrl(visitPath);
        int code = loginMapper.updateByPrimaryKeySelective(user);
        if (code == 0) {
            return CommonResult.fail("人脸注册失败");
        }
        return CommonResult.success("人脸注册成功");
    }
}
