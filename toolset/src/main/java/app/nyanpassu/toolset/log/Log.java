package app.nyanpassu.toolset.log;

/**
 * Created by 丢猫 on 2015/3/2.
 */
public interface Log {

    public void d(String tag, String message);
    public void i(String tag, String message);
    public void v(String tag, String message);
    public void w(String tag, String message);
    public void e(String tag, String message);
}
