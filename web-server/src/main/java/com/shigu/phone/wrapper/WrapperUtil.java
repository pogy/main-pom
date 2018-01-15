package com.shigu.phone.wrapper;/**
 * Created by pc on 2017-09-30.
 *
 * @author pc
 * @description
 * @version 3.0.0-SNAPSHOT
 * @since 3.0.0-SNAPSHOT
 */

import com.openJar.exceptions.OpenException;
import com.openJar.responses.Response;
import net.sf.json.JSONObject;

/**
 *Created By pc on 2017-09-30/14:08
 *
 */
public class WrapperUtil {

    public static JSONObject wrapperOpenException(String errMsg, Response response){
        OpenException openException = new OpenException();
        openException.setErrMsg(errMsg);
        response.setException(openException);
        response.setSuccess(false);
        return JSONObject.fromObject(response);
    }

}
