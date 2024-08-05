package com.larcangeli.monolith;

import org.junit.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModularityTest {
    static ApplicationModules modules = ApplicationModules.of(ModularMonolithApp.class);

    @Test
    public void verifyModularStructure(){
        modules.verify();
    }
}
