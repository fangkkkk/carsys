package com.qf.user.oss.service.impl;

import com.qf.user.common.vo.R;
import com.qf.user.oss.dao.OssUrlDao;
import com.qf.user.oss.entity.OssUrl;
import com.qf.user.oss.service.OssUrlService;
import com.qf.user.util.AliOssUtil;
import com.qf.user.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;
@Service
public class OssUrlServiceimpl implements OssUrlService {
    @Autowired
   private OssUrlDao urlDao;
    private String rename(String fn){
        if(fn.length()>40){
            fn=fn.substring(fn.length()-40);
        }
        return UUID.randomUUID().toString()+"_"+fn;
    }
    @Override
    public R upload(MultipartFile file) {
        //校验文件是否为空
        if(!file.isEmpty()){
            //2.获取上传文件名称
            String fn=file.getOriginalFilename();
            //重命名
            fn=rename(fn);
            Date date= DateUtil.addYear(3);
            try {
                String u= AliOssUtil.upload(fn,file.getBytes(),date);
                OssUrl ossUrl=new OssUrl();
                ossUrl.setUrl(u);
                ossUrl.setObjname(fn);
                ossUrl.setEndtime(date);
                urlDao.insert(ossUrl);
               R.Ok(ossUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return R.fail();
    }

    @Override
    public R queryAll() {

        return R.Ok(urlDao.selectAll());
    }

    @Override
    public R queryOssAll() {
        return R.Ok(AliOssUtil.list());
    }

    @Override
    public R del(String objName) {
        if(AliOssUtil.del(objName)){
            urlDao.del(objName);
            return R.Ok();
        }else {
            return R.fail();
        }
    }
}



