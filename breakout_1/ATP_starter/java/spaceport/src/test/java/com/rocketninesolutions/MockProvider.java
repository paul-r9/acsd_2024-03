package com.rocketninesolutions;

import java.util.ArrayList;
import java.util.List;

public class MockProvider implements ISpacelineLaunchInfoProvider {
    List<LaunchInfo> list = new ArrayList<>();

    @Override
    public List<LaunchInfo> getCurrentLaunches() {
        return list;
    }

    public void addDestination(String destination) {
        LaunchInfo launchInfo = new LaunchInfo(null);
        launchInfo.setDestination(destination);

        list.add(launchInfo);
    }
}
