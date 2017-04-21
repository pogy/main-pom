package com.shigu.main4.ucenter.exceptions;

import com.shigu.main4.common.exceptions.Main4Exception;

/**
 * Created by wxc on 2017/4/13.
 *
 * @author wxc
 * @version main_site4.0 4.0.0
 * @since main_site4.0 4.0.0
 */
public class MemberLicenseException extends Main4Exception {
    private static final long serialVersionUID = 9063661007804106901L;

    public MemberLicenseException() {
    }

    public MemberLicenseException(String message) {
        super(message);
    }
}
