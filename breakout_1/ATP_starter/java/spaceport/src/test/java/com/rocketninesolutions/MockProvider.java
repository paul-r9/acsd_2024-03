package com.rocketninesolutions;

import java.util.ArrayList;
import java.util.List;

public class MockProvider implements ISpacelineLaunchInfoProvider {
    List<LaunchInfo> list;

    @Override
    public List<LaunchInfo> getCurrentLaunches() {
        return list;
    }
}
