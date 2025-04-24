package com.company.serviceapp.screen.region;

import com.company.serviceapp.entity.Region;
import io.jmix.ui.screen.LookupComponent;
import io.jmix.ui.screen.StandardLookup;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Region.browse")
@UiDescriptor("region-browse.xml")
@LookupComponent("regionsTable")
public class RegionBrowse extends StandardLookup<Region> {
}