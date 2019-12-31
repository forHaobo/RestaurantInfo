package daomain;

/**
 * @outhor li
 * @create 2019-12-30 14:23
 * 用于后端返回前端的响应信息
 */
public class ResultInfo {
    private boolean flag; //后端返回结果否正常
    private Object data;//后端返回结果数据对象
    private String errorMsg; //发生异常的错误处理信息
    //构造方法
    public ResultInfo(){
    }
    public ResultInfo(boolean flag){
        this.flag = false;
    }
    public ResultInfo(boolean flag, Object data){
        this.flag = false;
        this.data = data;
    }
    public ResultInfo(boolean flag, Object data, String errorMsg){
        this.data = data;
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
