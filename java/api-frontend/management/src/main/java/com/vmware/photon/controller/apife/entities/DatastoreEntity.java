/*
 * Copyright 2015 VMware, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, without warranties or
 * conditions of any kind, EITHER EXPRESS OR IMPLIED.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.vmware.photon.controller.apife.entities;

import com.vmware.photon.controller.api.DatastoreCreateSpec;
import com.vmware.photon.controller.api.common.entities.base.BaseEntity;
import com.vmware.photon.controller.api.constraints.URI;

import static com.google.common.base.Objects.ToStringHelper;

import javax.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Datastore entity.
 */
public class DatastoreEntity extends BaseEntity {

  public static final String KIND = "datastore";

  @URI
  private String name;

  @NotNull
  private String esxId;

  @NotNull
  private String hostIps;

  @NotNull
  private String tags;

  public static DatastoreEntity create(DatastoreCreateSpec createSpec) {
    DatastoreEntity datastoreEntity = new DatastoreEntity();

    datastoreEntity.setName(createSpec.getName());
    if (createSpec.getTags() != null) {
      datastoreEntity.setTags(createSpec.getTags().toString());
    }
    datastoreEntity.setHostIps("");

    return datastoreEntity;
  }

  @Override
  public String getKind() {
    return KIND;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * The JSON serialized string that represents a set of usage tags.
   */
  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  /**
   * The JSON serialized string that represents a set of ip addresses.
   */
  public String getHostIps() {
    return hostIps;
  }

  public void setHostIps(String hostIps) {
    this.hostIps = hostIps;
  }

  /**
   * The UUID generated by Agent to uniquely identify this entity.
   */
  public String getEsxId() {
    return esxId;
  }

  public void setEsxId(String esxId) {
    this.esxId = esxId;
  }

  @Override
  protected ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("name", name)
        .add("tags", tags)
        .add("hostIps", hostIps);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DatastoreEntity)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    DatastoreEntity other = (DatastoreEntity) o;

    return Objects.equals(getId(), other.getId()) &&
        Objects.equals(getKind(), other.getKind()) &&
        Objects.equals(name, other.name) &&
        Objects.equals(tags, other.tags) &&
        Objects.equals(hostIps, other.hostIps);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(
        super.hashCode(),
        name,
        tags,
        hostIps);
  }
}
