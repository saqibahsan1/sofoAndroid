package com.twixttechnologies.sofo.utils.contracts;

import com.google.maps.android.clustering.ClusterItem;


/**
 * @author Sony Raj on 8/1/18.
 */
public interface ClusterItemBase extends ClusterItem {

    String getImage();

    String getTitle();

    String getId();

    String[] createParts();

    int zIndex();

    void setZIndex(int zIndex);

}