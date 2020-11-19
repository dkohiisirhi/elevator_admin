package com.yuyun.elevatoradmin.enums;

public enum ResultEnum {
    //Layui表格码
    LAYUI_SUCCESS(0,"成功"),
    //系统状态码(用户不能处理)
    SUCCESS(2000, "成功"),
    ADD_FAIL(5001,"添加失败,请联系管理员!"),
    DEL_FAIL(5002,"删除失败,请联系管理员!"),
    UPDATE_FAIL(5003,"修改失败,请联系管理员!"),
    DATA_EXCEPTION(5004,"数据异常,请联系管理员!"),
    USER_NOT_EXIST(5005,"用户不存在,请联系管理员!"),
    USER_PASSWORD_NOT_EXIST(5008,"用户名密码错误，请核实后登录!"),
    USER_DATA_ERROR(5006,"用户数据异常，请联系管理员！"),
    USER_ROLE_DATA_ERROR(5007,"用户角色数据异常,请联系管理员!"),
    //系统状态码(用户可以尝试处理)
    ELEVATOR_DATA_NULL(3001,"电梯数据为空，请确认是否被分配电梯！"),
    EMP_NULL(3002,"员工数据为空，请添加新员工！"),
    //param状态码
    PARAM_EXCEPTION(4000,"参数异常!"),
    IDENTITY_IMG(4001,"请上传身份证照片!"),
    IMG_NOT_CLEAR(4002,"图片不清晰或身份证正反面颠倒,请重新上传！"),
    IDENTITY_NOT_MATCH(4003,"信息与身份证不匹配,请确认！"),
    PASSWORD_FORMAT_NOT_MATCH(4004,"密码格式不正确,请输入4-16位（字母，数字，下划线）"),
    PHONE_FORMAT_NOT_MATCH(4005,"手机号格式不正确，请输入以1开头的11位手机号码"),
    PHONE_EXIST(4006,"手机号已存在，请确认是否使用过该手机号！"),
    ROLE_DATA_ERROR(4007,"角色数据异常，请确认是否选择角色!"),
    USERNAME_NOT_NULL(4008,"用户名不能为空!"),
    PASSWORD_NOT_NULL(4009,"密码不能为空！"),
    PHONE_NOT_NULL(4010,"手机不能为空！"),
    USERNAME_FORMAT_NOT_MATCH(4011,"用户名格式不正确,请输入4-16位（字母，数字，下划线）"),
    USERNAME_EXIST(4012,"用户名已存在!"),
    COMPANY_NOT_EXIST(4013,"公司不存在"),
    PROJECT_NOT_EXIST(4014,"项目不存在"),
    BUILDING_NOT_EXIST(4015,"楼栋未找到"),
    Unit_NOT_EXIST(4016,"单元未找到"),
    PARAM_NOT_NULL(4017,"参数不能为空"),
    ELEVATOR_NO_EXIST(4018,"电梯设备号已存在"),
    ACCOUNT_DATA_NULL(4019,"对不起！您账户下的数据为空！"),
    ROLE_EXIST(4020,"角色已存在！"),
    ROLE_EXIST_ERROR(4021,"角色已被使用，删除失败！"),
    COMPANY_EXIST(4022,"公司已存在！"),
    ADD_COMPANY_EXIST(4023,"您添加的公司名已存在！请核对或选用该格式：公司名( 地区 )"),
    DENIED_PERMISSION(4024,"权限不足！"),
    FILE_NOT_EXIST(4025,"文件不存在!"),
    ADD_FORMAT_NOT_MATCH(4026,"EXCEL表格式不正确"),
    ADD_PROJECT_NOT_EXIST(4027,"请正确填写楼盘地址"),
    PROJECT_EXIST(4028,"楼盘已存在，请以下格式添加:楼盘名(城市名),例:鸿禧花园(苏州)"),
    PROJECT_NOT_NULL(4029,"请选择楼盘"),
    OLD_PASSWORD_ERROR(4030,"原密码不正确"),
    FILE_SAVE_FAILED(4031,"文件保存失败"),
    SERVER_ERROR(4032,"哎呀！服务器开了个小差！"),
    NOT_LOGIN(10001,"您未登录，请登录后访问!"),
    PROJECT_NULL(4033,"电梯账户下无楼盘"),
    PROJECT_DEL_FAIL(4034,"楼盘已存在电梯,删除失败! ")
    ;

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
