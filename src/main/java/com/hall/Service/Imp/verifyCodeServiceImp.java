package com.hall.Service.Imp;

import com.hall.Bean.verifyCodeStatus;
import com.hall.DAO.verifyCodeStatusMapper;
import com.hall.Service.verifyCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class verifyCodeServiceImp implements verifyCodeService {
    @Resource
    verifyCodeStatusMapper verifyCodeStatusMapper;

    @Override
    public boolean insertCode(String phoneNumber, String code) {
        try{
//        1.查询该记录是否存在
        verifyCodeStatus verifyCodeStatus = verifyCodeStatusMapper.selectByPrimaryKey(phoneNumber);
        if(verifyCodeStatus!=null){
            //        2.如果存在，就执行更新
            verifyCodeStatus newVCS = new verifyCodeStatus();
            newVCS.setVerifycode(code);
            newVCS.setPhonenumber(phoneNumber);
            newVCS.setCodegentime(new Date());
            verifyCodeStatusMapper.updateByPrimaryKeySelective(newVCS);
            return true;
        }else{
            //        3.如果不存在，就执行插入
            verifyCodeStatus newVCS = new verifyCodeStatus(phoneNumber, code, null);
            verifyCodeStatusMapper.insert(newVCS);
            return true;
        }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean recordIsExist(String phoneNumber) {
        verifyCodeStatus vcs = verifyCodeStatusMapper.selectByPrimaryKey(phoneNumber);
        if(vcs==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public verifyCodeStatus codeIsVaild(String phoneNumber, String code) {
        return verifyCodeStatusMapper.verify(phoneNumber, code);
    }

    @Override
    public boolean deleteByphone(String number) {
        int i = verifyCodeStatusMapper.deleteByPrimaryKey(number);
        if(i==0){
            return false;
        }else {
            return true;
        }
    }


}
