package com.star.springboot.bmp.activiti.constant;

public class CoreCodeConsts{
    public static final int REQUEST_SUCCESS_CODE = 0;
    public static final int REQUEST_ERROR_PARAMS = -1;
    public static final int REQUEST_PROGRAM_ERROR_CODE = -100;
    public static final int REQUEST_ERROR_AUTHENTICATION = -200;
    public static final int REQUEST_ERROR_AUTHORIZE = -201;
    public static final int REQUEST_ERROR_ILLEGALLY = -202;
    public static final int REQUEST_REFUSE_IP_ERROR_CODE = -60;
    private static final int INVALID_REQUEST = 400;
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int NOT_ACCEPTABLE = 406;
    private static final int GONE = 410;
    private static final int UNPROCESABLE = 422;
    private static final int INTERNAL_SERVER_ERROR = 500;

    public CoreCodeConsts() {
    }
}