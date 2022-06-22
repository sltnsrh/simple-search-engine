package com.intern.util;

import com.intern.strategy.AllSearch;
import com.intern.strategy.AnySearch;
import com.intern.strategy.NoneSearch;
import com.intern.strategy.Searchable;

import java.util.HashMap;
import java.util.Map;

public final class Strategy {
    public static final Map<String, Searchable> searchStrategyStore = new HashMap<>();

    static {
        searchStrategyStore.put("ALL", new AllSearch());
        searchStrategyStore.put("ANY", new AnySearch());
        searchStrategyStore.put("NONE", new NoneSearch());
    }

    private Strategy(){
    }
}
