package hw_18.utils;

import hw_18.utils.interfaces.ShufflingStrPipe;
import hw_18.utils.interfaces.UpperStrPipe;

public class ShufflingUpperStrPipe implements ShufflingStrPipe, UpperStrPipe {
    private String str;

    public ShufflingUpperStrPipe() {}

    public ShufflingUpperStrPipe(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String get(String str) {
        return UpperStrPipe.super.get(ShufflingStrPipe.getShuffledOptional(str).orElse(""));
    }

    @Override
    public String getUpperString() {
        return UpperStrPipe.getUpperOptional(str).orElse("");
    }

    @Override
    public boolean getUpperBoolean() {
        return !(str == null || str.isEmpty());
    }

    @Override
    public String getShuffledString() {
        return ShufflingStrPipe.getShuffledOptional(str).orElse("");
    }

    @Override
    public boolean getShuffledBoolean() {
        return getUpperBoolean();
    }
}
