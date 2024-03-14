package com.rocketninesolutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LaunchOrderListingTest {

    //TODO - Use the Stub Recipe to test that launches are sorted correctly
    @Test
    public void LaunchesAre_SortedByDestination_DestinationsAreUnique() {
        // Step 1. Create LaunchInfoProviderStub (that implements ISpacelineLaunchInfoProvider)
        ISpacelineLaunchInfoProvider mock = new MockProvider();
        ((MockProvider)mock).addDestination("Venus");
        ((MockProvider)mock).addDestination("Mars");

        // Step 2 & 3 & 4. Create SUT - SpaceportDepartureBoard, using Constructor Injection
        // Exercising this behavior happens during construction of the System Under Test
        SpaceportDepartureBoard sut = new SpaceportDepartureBoard(mock);

        // Step 5. Verify the results are sorted correct
        List<LaunchInfo> actualList = sut.getLaunchList();
        Assertions.assertAll(
                () -> Assertions.assertFalse(actualList.isEmpty()),
                () -> Assertions.assertEquals("Mars", actualList.get(0).getDestination()),
                () -> Assertions.assertEquals("Venus", actualList.get(1).getDestination())
        );
    }
}
