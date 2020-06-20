package com.iplab.xwq.fblog.controller.common;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @Author xwq
 * @Description 
 * @Date 上午11:35 2020/6/18
 */

@Controller
public class KaptchaController {

    @Autowired
    private DefaultKaptcha kaptchaProducer;

    @GetMapping("/common/kaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] kaptchaOutputStream;
        ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
        try {
            String verifyCode = kaptchaProducer.createText();
            httpServletRequest.getSession().setAttribute("verifyCode",verifyCode);  //将生成的验证码保存在session中，便于后续验证
            BufferedImage challenge = kaptchaProducer.createImage(verifyCode);
            ImageIO.write(challenge,"jpg",imgOutputStream);
        }catch (IllegalArgumentException e){
            httpServletResponse.sendError(httpServletResponse.SC_NOT_FOUND);
            return;
        }
        kaptchaOutputStream = imgOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control","no-store");
        httpServletResponse.setHeader("Pragma","no-cache");
        httpServletResponse.setDateHeader("Expires",0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(kaptchaOutputStream);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
