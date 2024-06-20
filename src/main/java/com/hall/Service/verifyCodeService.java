package com.hall.Service;

import com.hall.Bean.verifyCodeStatus;

public interface verifyCodeService {

    public boolean insertCode(String phoneNumber,String code);

    public boolean recordIsExist(String phoneNumber);

    public verifyCodeStatus codeIsVaild(String phoneNumber, String code);

    public boolean deleteByphone(String number);
}
