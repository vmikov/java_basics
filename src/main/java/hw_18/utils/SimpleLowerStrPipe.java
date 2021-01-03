package hw_18.utils;

import hw_18.utils.interfaces.LowerStrPipe;
import hw_18.utils.interfaces.SimpleStrPipe;

public class SimpleLowerStrPipe implements SimpleStrPipe, LowerStrPipe {
    private String str;

    public SimpleLowerStrPipe () {}

    public SimpleLowerStrPipe(String str) {
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
        return LowerStrPipe.super.get(SimpleStrPipe.getSimpleOptional(str).orElse(""));
    }

    @Override
    public String getSimpleString() {
        return SimpleStrPipe.getSimpleOptional(str).orElse("");
    }

    @Override
    public String getLowerString() {
        return LowerStrPipe.getLowerOptional(str).orElse("");
    }

    @Override
    public boolean getLowerBoolean() {
        return getSimpleBoolean();
    }

    @Override
    public boolean getSimpleBoolean() {
        return !(str == null || str.isEmpty());
    }
}
