package com.company.serviceapp.screen.region;

import com.company.serviceapp.entity.Region;
import io.jmix.ui.screen.EditedEntityContainer;
import io.jmix.ui.screen.StandardEditor;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;

@UiController("Region.edit")
@UiDescriptor("region-edit.xml")
@EditedEntityContainer("regionDc")
public class RegionEdit extends StandardEditor<Region> {
}