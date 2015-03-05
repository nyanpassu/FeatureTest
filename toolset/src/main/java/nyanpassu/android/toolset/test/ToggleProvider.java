package nyanpassu.android.toolset.test;

/**
 * Created by 丢猫 on 2015/3/5.
 */
public interface ToggleProvider {

    public int getCount();

    public String getLabel(int index);

    public boolean isChecked(int index);

    /**
     * 使设置生效
     * @param index
     * @return
     */
    public boolean check(int index);

    public boolean uncheck(int index);
}
